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

            for (Factor factor : dayLog.getFactors()) {
                if (dayLog.getAttack()) {
                    isFactorOnHashMap(attackFactor, factor);
                }
                else if (!dayLog.getAttack()){
                    isFactorOnHashMap(noAttackFactor, factor);
                }
            }

           //number of all attacks
            if (dayLog.getAttack()) {
                totalNumberOfAttacks++;
            }

        }

        for (Factor f : allFactors) {

            //Compile attacknoFactor hashmap - by counting occurences for each factor where it was not present when attack occured
            int numberOfAttacksWithoutFactor;
            int numberOfAttacksWithFactor = 0;

            if (attackFactor.containsKey(f.getId())){
                numberOfAttacksWithFactor = attackFactor.get(f.getId());
            }

            numberOfAttacksWithoutFactor = totalNumberOfAttacks - numberOfAttacksWithFactor;

            //Compile noAttacknoFactor hashmap - by counting occurences where factor was not included
            int numberOfNoAttacknoFactor;
            int numberOfAllDaylogs = dayLogRepository.countAllByUser(user);
            int numberOfFactorsWithoutAttack = 0;
            if (noAttackFactor.containsKey(f.getId())) {
                numberOfFactorsWithoutAttack = noAttackFactor.get(f.getId());
            }

            numberOfNoAttacknoFactor = numberOfAllDaylogs - numberOfAttacksWithFactor - numberOfAttacksWithoutFactor - numberOfFactorsWithoutAttack;
            Double correlationMeasure = phi(numberOfNoAttacknoFactor, numberOfFactorsWithoutAttack, numberOfAttacksWithoutFactor, numberOfAttacksWithFactor);

            Correlation correlation = new Correlation();
            correlation.setFactor(f);
            correlation.setCorrelationMeasure(correlationMeasure);
            correlation.setUser(user);
            correlation.setCreated(LocalDateTime.now());
            correlationRepository.save(correlation);

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
                Math.sqrt((noAttackFactor + attackFactor) *
                        (noAttackNoFactor + noAttackFactor) *
                        (noAttackFactor + attackFactor) *
                        (noAttackNoFactor + attackNoFactor));

    }
}