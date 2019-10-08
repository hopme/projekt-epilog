//package pl.epilog.services;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import pl.epilog.model.DayLog;
//import pl.epilog.model.Factor;
//import pl.epilog.model.User;
//import pl.epilog.repositories.DayLogRepository;
//import pl.epilog.repositories.FactorRepository;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//@Transactional
//public class CorrelationServiceBackup {
//
//
//    DayLogRepository dayLogRepository;
//    FactorRepository factorRepository;
//
//    public CorrelationServiceBackup(DayLogRepository dayLogRepository, FactorRepository factorRepository) {
//        this.dayLogRepository = dayLogRepository;
//        this.factorRepository = factorRepository;
//    }
//
//    public void update(User user) {
//
//        List<DayLog> dayLogs = dayLogRepository.findAllByUser(user);
//        System.out.println("ILE JEST DAYLOGOW? TYLE " + dayLogs.size());
//
//        List<Factor> allFactors = factorRepository.findAll();
//
//        HashMap<Factor, Integer> attackFactor = new HashMap<>(); //11 - DONE
//        HashMap<Factor, Integer> noAttackFactor = new HashMap<>(); //01 - DONE
//        HashMap<Factor, Integer> attackNoFactor = new HashMap<>(); //10
//        HashMap<Factor, Integer> noAttacknoFactor = new HashMap<>(); //00
//
//        System.out.println("1. WIELKOSC attackFactor");
//        System.out.println(attackFactor.size());
//
//        int totalNumberOfAttacks = 0;
//
//        for (DayLog dayLog : dayLogs){
//
//            System.out.println("2. WIELKOSC attackFactor");
//            System.out.println(attackFactor.size());
//
//            System.out.println("TYLE JEST DAYLOGOW W SUMIE: " + dayLogs.size());
//            System.out.println("ID DAYLOGA: " + dayLog.getId());
//
//            for (Factor factor : dayLog.getFactors()) {
//                System.out.println("3. WIELKOSC attackFactor");
//                System.out.println(attackFactor.size());
//                System.out.println("Chodze po kazdym faktorze: " + factor.getName());
//                if (dayLog.getAttack()) {
//                    if (attackFactor.containsKey(factor)) {
//                        System.out.println("Czy ten factor jest juz w hashmapie?: " + attackFactor.containsKey(factor));
//                        Integer count = attackFactor.get(factor);
//                        System.out.println("Jestem wewnatrz pierwszego ifa: " + factor.getName());
//                        System.out.println("11: wskaznik count = " + count + " czyli tyle jest juz tych faktorow w hashmapie i do nich dodam jeden");
//                        attackFactor.put(factor, count + 1);
//                        System.out.println("Nowa wartosc dla faktora to " + count + 1);
//                    } else if (!(attackFactor.containsKey(factor))){
//                        System.out.println("Czy ten factor nie jest na hashmapie?" + !(attackFactor.containsKey(factor)));
//                        attackFactor.put(factor, 1);
//                        System.out.println("DODAJE do hashmapy 11");
//                    }
//                    System.out.println("4. WIELKOSC attackFactor");
//                    System.out.println(attackFactor.size());
//                }
//                else if (!dayLog.getAttack()){
//                    if (noAttackFactor.containsKey(factor)) {
//                        Integer count = noAttackFactor.get(factor);
//                        System.out.println(factor.getName());
//                        System.out.println("01: wskaznik count = " + count);
//                        noAttackFactor.put(factor, count + 1);
//                        System.out.println("Nowa wartosc dla faktora to " + count + 1);
//                    } else if (!(noAttackFactor.containsKey(factor))){
//                        noAttackFactor.put(factor, 1);
//                    }
//                }
//            }
//
//           //number of all attacks
//            if (dayLog.getAttack()) {
//                totalNumberOfAttacks++;
//            }
//
//        }
//
//        System.out.println("5. WIELKOSC attackFactor " + attackFactor.size());
//
//        for (Map.Entry<Factor, Integer> entry : attackFactor.entrySet()) {
//            System.out.println(entry.getKey().getName() + " - " + entry.getValue());
//            System.out.println();
//
//        }
//
//        for (Factor f : allFactors) {
//
//            System.out.println("6. WIELKOSC attackFactor " + attackFactor.size());
//            System.out.println("NAZWA FAKTORA: " + f);
//            System.out.println("ID w attackfactor " + f.getId());
//            System.out.println("NAZWy FAKTORow NA HASHMAPIE: ");
//            for ( Factor key : attackFactor.keySet() ) {
//                System.out.println( "NAZWA na hashmapie" + key );
//                System.out.println( "ID na hashmapie :" + key.getId() );
//            }
//            System.out.println("WARTOSC FAKTORA: " + attackFactor.get(f));
//
//            System.out.println("A tutaj jeszcze powtorka z gory:");
//            for (Map.Entry<Factor, Integer> entry : attackFactor.entrySet()) {
//                System.out.println(entry.getKey().getName() + " - " + entry.getValue());
//                System.out.println();
//
//            }
//
//            //Compile attacknoFactor hashmap - by counting occurences for each factor where it was not present when attack occured
//            int numberOfAttacksWithoutFactor;
//            int numberOfAttacksWithFactor = 0;
//
//            if (attackFactor.containsKey(f)){
//                System.out.println("hashmapa posiada juz taki faktor");
//                numberOfAttacksWithFactor = attackFactor.get(f);
//            }
//            numberOfAttacksWithoutFactor = totalNumberOfAttacks - numberOfAttacksWithFactor;
//            attackNoFactor.put(f, numberOfAttacksWithoutFactor);
//
//            //Compile noAttacknoFactor hashmap - by counting occurences where factor was not included
//            int numberOfNoAttacknoFactor = 0;
//            int numberOfAllDaylogs = dayLogRepository.countAllByUser(user);
//            int numberOfFactorsWithoutAttack = 0;
//            if (noAttackFactor.containsKey(f)) {
//                numberOfFactorsWithoutAttack = noAttackFactor.get(f);
//            }
//
//            numberOfNoAttacknoFactor = numberOfAllDaylogs - numberOfAttacksWithFactor - numberOfAttacksWithoutFactor - numberOfFactorsWithoutAttack;
//            System.out.println("SPRAWDZ TO");
//            System.out.println(numberOfAllDaylogs + " - " + numberOfAttacksWithFactor + " - " + numberOfAttacksWithoutFactor + " - " + numberOfFactorsWithoutAttack + " = " + numberOfNoAttacknoFactor);
//            noAttacknoFactor.put(f, numberOfNoAttacknoFactor);
//
//            System.out.println("----");
//            System.out.println("PODSUMOWANIE");
//            System.out.println("FACTOR");
//            System.out.println(f.getName());
//            System.out.println("00 " + noAttacknoFactor.get(f));
//            System.out.println("01 " + noAttackFactor.get(f));
//            System.out.println("10 " + attackNoFactor.get(f));
//            System.out.println("11 " + numberOfAttacksWithFactor);
//            System.out.println("----");
//
//            // z jkiegos powodu on jest jeden ruch do tylu - jak dodam piwo i atak to on dopiero to doda przy kolejnym nacisniecu, moze dlatego ze tego w bazie jeszcze nie ma w momencie dodania?
//
////            Double correlationMeasure = phi(noAttacknoFactor.get(f), noAttackFactor.get(f), attackNoFactor.get(f), attackFactor.get(f));
////            Correlation correlation = new Correlation();
////            correlation.setFactor(f);
////            correlation.setCorrelationMeasure(correlationMeasure);
////            correlation.setUser(user);
//
//        }
//
//    }
//
//    private Double phi(Integer noAttacknoFactor, Integer noAttackFactor, Integer attackNoFactor, Integer attackFactor){
//
//       return (attackFactor * noAttacknoFactor - attackNoFactor * noAttackFactor) /
//                Math.sqrt((noAttackFactor + attackFactor) *
//                        (noAttacknoFactor + noAttackFactor) *
//                        (noAttackFactor + attackFactor) *
//                        (noAttacknoFactor + attackNoFactor));
//
//    }
//}