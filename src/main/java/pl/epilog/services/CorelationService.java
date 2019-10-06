package pl.epilog.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.epilog.model.DayLog;
import pl.epilog.model.Factor;
import pl.epilog.model.User;
import pl.epilog.repositories.DayLogRepository;
import pl.epilog.repositories.FactorRepository;

import java.util.*;

@Service
@Transactional
public class CorelationService {


    DayLogRepository dayLogRepository;
    FactorRepository factorRepository;

    public CorelationService(DayLogRepository dayLogRepository, FactorRepository factorRepository) {
        this.dayLogRepository = dayLogRepository;
        this.factorRepository = factorRepository;
    }

    public void update(User user) {
        System.out.println("JESTES TAM");
        System.out.println(user);

        List<DayLog> dayLogs = dayLogRepository.findAllByUser(user);

        System.out.println("RAZ - " + dayLogs.toString());

        List<Factor> allFactors = factorRepository.findAll();

        HashMap<Factor, Integer> attackFactor = new HashMap<>();
        HashMap<Factor, Integer> noAttackFactor = new HashMap<>();
        HashMap<Factor, Integer> attackNoFactor = new HashMap<>();
        HashMap<Factor, Integer> noAttacknoFactor = new HashMap<>();

        int totalNumberOfAttacks = 0;


        for (DayLog dayLog : dayLogs){

            System.out.println("ID DAYLOGA: " + dayLog.getId());
            for (Factor factor : dayLog.getFactors()) {
                if (dayLog.getAttack()) {
                    if (attackFactor.containsKey(factor)) {
                        Integer count = attackFactor.get(factor);
                        attackFactor.put(factor, count + 1);
                    } else {
                        attackFactor.put(factor, 1);
                    }

                }
                if (!dayLog.getAttack()){
                    if (noAttackFactor.containsKey(factor)) {
                        Integer count = noAttackFactor.get(factor);
                        noAttackFactor.put(factor, count + 1);
                    } else {
                        noAttackFactor.put(factor, 1);
                    }
                }
            }

           //number of all attacks
            if (dayLog.getAttack()) {
                totalNumberOfAttacks++;
            }

        }

        for (Factor f : allFactors) {

            //Compile attacknoFactor hashmap - by counting occurences for each factor where it was not present when attack occured
            int numberOfAttacksWithoutFactor = 0;
            int numberOfAttacksWithFactor = 0;
            if (attackFactor.containsKey(f)){
                numberOfAttacksWithFactor = attackFactor.get(f);
            }
            numberOfAttacksWithoutFactor = totalNumberOfAttacks - numberOfAttacksWithFactor;
            attackNoFactor.put(f, numberOfAttacksWithoutFactor);

            //Compile noAttacknoFactor hashmap - by counting occurences where factor was not included
            int noAttacknoFactorCount = 0;
            int numberOfAllDaylogs = dayLogRepository.countAllByUser(user);
            int attackFactorCount = 0;
            if (attackFactor.containsKey(f)) {
                attackFactorCount = attackFactor.get(f);
                System.out.println("ATAKFACTORCOUNT: " + attackFactorCount);
            }
            int attackNoFactorCount = 0;
            if (attackNoFactor.containsKey(f)) {
                attackNoFactorCount = attackNoFactor.get(f);
                System.out.println("ATAKNOFACTORCOUNT: " + attackNoFactorCount);
            }
            int noAttackFactorCount = 0;
            if (noAttackFactor.containsKey(f)) {
                noAttackFactorCount = noAttackFactor.get(f);
            }


            noAttacknoFactorCount = numberOfAllDaylogs - attackFactorCount - attackNoFactorCount - noAttackFactorCount;
            System.out.println("PODSUMOWANIE: " + f.getName() + "=" + numberOfAllDaylogs + " - " + attackFactorCount + "-" + attackNoFactorCount + "-" + noAttackFactorCount + "=" + noAttacknoFactorCount);
            noAttacknoFactor.put(f, noAttacknoFactorCount);

        }

    }

    private Double phi(int[] table){

        return (table[3] * table[0] - table[2] * table[1]) /
                Math.sqrt((table[2] + table[3]) *
                        (table[0] + table[1]) *
                        (table[1] + table[3]) *
                        (table[0] + table[2]));

    }
}














//       for (Map.Entry<Factor, Integer> entry : attackFactor.entrySet()) {
//            System.out.println("Key = " + entry.getKey().getName() + ", Value = " + entry.getValue());
//        }
//
//        System.out.println("NoAttackFactor");
//        for (Map.Entry<Factor, Integer> entry : noAttackFactor.entrySet()) {
//            System.out.println("Key = " + entry.getKey().getName() + ", Value = " + entry.getValue());
//        }
//
//        System.out.println("AttackNoFactor");
//        for (Map.Entry<Factor, Integer> entry : attackNoFactor.entrySet()) {
//            System.out.println("Key = " + entry.getKey().getName() + ", Value = " + entry.getValue());
//        }
//
//        System.out.println("NoAttackNoFactor");
//        for (Map.Entry<Factor, Integer> entry : noAttacknoFactor.entrySet()) {
//            System.out.println("Key = " + entry.getKey().getName() + ", Value = " + entry.getValue());
//        }
//
//        System.out.println("UWAGA");