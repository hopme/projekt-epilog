package pl.epilog.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.epilog.model.Correlation;
import pl.epilog.model.DayLog;
import pl.epilog.model.Factor;
import pl.epilog.model.User;
import pl.epilog.repositories.CorrelationRepository;
import pl.epilog.repositories.DayLogRepository;
import pl.epilog.repositories.FactorRepository;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
public class CorrelationService {


    private DayLogRepository dayLogRepository;
    private FactorRepository factorRepository;
    private CorrelationRepository correlationRepository;

    public CorrelationService(DayLogRepository dayLogRepository, FactorRepository factorRepository, CorrelationRepository correlationRepository) {
        this.dayLogRepository = dayLogRepository;
        this.factorRepository = factorRepository;
        this.correlationRepository = correlationRepository;
    }

    public void update(User user) {

        List<DayLog> dayLogs = dayLogRepository.findAllByUser(user);
        List<Factor> allFactors = factorRepository.findAll();

        HashMap<Long, Integer> attackFactor = new HashMap<>();
        HashMap<Long, Integer> noAttackFactor = new HashMap<>();

        int totalNumberOfAttacks = 0;

        for (DayLog dayLog : dayLogs){
//            Compile Attack Factor hashmap for User - by counting occurences when factor was present and attack happend (as marked in DayLogs)
            for (Factor factor : dayLog.getFactors()) {
                if (dayLog.getAttack()) {
                    isFactorOnHashMap(attackFactor, factor);
                }
                else if (!dayLog.getAttack()){
                    isFactorOnHashMap(noAttackFactor, factor);
                }
            }

//           Count number of all attacks for User
            if (dayLog.getAttack()) {
                totalNumberOfAttacks++;
            }

        }

        for (Factor f : allFactors) {

//            Compile attacknoFactor hashmap for User - by counting occurences for each factor where it was not present when attack occured
            int numberOfAttacksWithoutFactor;
            int numberOfAttacksWithFactor = 0;

            if (attackFactor.containsKey(f.getId())){
                numberOfAttacksWithFactor = attackFactor.get(f.getId());
            }

//            Count number of Attack without Factor for User
            numberOfAttacksWithoutFactor = totalNumberOfAttacks - numberOfAttacksWithFactor;

//            Compile noAttacknoFactor hashmap for USer - by counting occurences where factor was not included
            int numberOfNoAttacknoFactor;
            int numberOfAllDaylogs = dayLogRepository.countAllByUser(user);
            int numberOfFactorsWithoutAttack = 0;
            if (noAttackFactor.containsKey(f.getId())) {
                numberOfFactorsWithoutAttack = noAttackFactor.get(f.getId());
            }

//            Count number of NoAttack NoFactor for User
            numberOfNoAttacknoFactor = numberOfAllDaylogs - numberOfAttacksWithFactor - numberOfAttacksWithoutFactor - numberOfFactorsWithoutAttack;

//            Count correlationMeasure for User
            System.out.println("TU SIE PATRZ");
            System.out.println("11: " + numberOfAttacksWithFactor);
            System.out.println("10: " + numberOfAttacksWithoutFactor);
            System.out.println("01: " + numberOfFactorsWithoutAttack);
            System.out.println("00: " + numberOfNoAttacknoFactor);


            Double correlationMeasure = phi(numberOfNoAttacknoFactor, numberOfFactorsWithoutAttack, numberOfAttacksWithoutFactor, numberOfAttacksWithFactor);
            System.out.println("corelation = " + correlationMeasure);
            System.out.println("wynik z rowniania = " + 0/2.5);

//            Create new correlation for User
            Correlation newCorrelation = new Correlation();
            newCorrelation.setFactor(f);
            if (correlationMeasure.isNaN()) {
                 correlationMeasure = 0d;
            }
            newCorrelation.setCorrelationMeasure(correlationMeasure);
            newCorrelation.setUser(user);
            newCorrelation.setCreated(LocalDateTime.now());

            Correlation previousCorrelationItem = correlationRepository.findFirstByFactorIdAndUserId(f.getId(), user.getId());

            int tendency = 0;
            if(previousCorrelationItem != null) {
                tendency =  checkPreviousCorrelationTendency(previousCorrelationItem, newCorrelation);
                deletePreviousCorrelation(previousCorrelationItem);
            }

            newCorrelation.setTendency(tendency);

            correlationRepository.save(newCorrelation);

        }

    }



    private void isFactorOnHashMap(HashMap<Long, Integer> attackFactor, Factor factor) {
        if (attackFactor.containsKey(factor.getId())) {
            Integer count = attackFactor.get(factor.getId());
            attackFactor.put(factor.getId(), count + 1);
        } else if (!(attackFactor.containsKey(factor.getId()))){
            attackFactor.put(factor.getId(), 1);
        }
    }

    private Double phi(Integer noAttackNoFactor, Integer noAttackFactor, Integer attackNoFactor, Integer attackFactor){
       return (attackFactor * noAttackNoFactor - attackNoFactor * noAttackFactor) /
                Math.sqrt((attackNoFactor + attackFactor) *
                        (noAttackNoFactor + noAttackFactor) *
                        (noAttackFactor + attackFactor) *
                        (noAttackNoFactor + attackNoFactor));
    }

    private void deletePreviousCorrelation(Correlation previousCorrelation) {
        long previousCorrelationItemId = previousCorrelation.getId();
        correlationRepository.delete(previousCorrelationItemId);
    }

    private int checkPreviousCorrelationTendency(Correlation previousCorrelationItem, Correlation newCorrelation) {
        Double previousCorrelationItemMeasure = previousCorrelationItem.getCorrelationMeasure();
        Double newCorrelationItemMeasure = newCorrelation.getCorrelationMeasure();
        if (newCorrelationItemMeasure > previousCorrelationItemMeasure) {
            return 1;
        } else if (newCorrelationItemMeasure < previousCorrelationItemMeasure) {
            return -1;
        } else return 0;
    }


}