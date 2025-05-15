package ro.ulbs.paradigme.lab9;

import java.util.*;
import java.util.stream.*;


public class sumaelemente {
        public static void main(String[] args) {
//P1
            Random rand = new Random();
            List<Integer> numbers = IntStream.range(0, 10)
                    .map(i -> rand.nextInt(21)+1)
                    .boxed()
                    .collect(Collectors.toList());

            System.out.println(numbers);

//A
            int suma = numbers.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
//B
            Optional<Integer> max = numbers.stream()
                    .max(Integer::compareTo);
            Optional<Integer> min = numbers.stream()
                    .min(Integer::compareTo);
//C
            List<Integer> interval = numbers.stream()
                    .filter(n -> n >= 10 && n <= 20)
                    .collect(Collectors.toList());
//D
            List<Double> listadouble = numbers.stream()
                            .map(n-> n.doubleValue())
                            .collect(Collectors.toList());
//E
            boolean contine12 = numbers.stream()
                            .anyMatch(n-> n == 12);


            System.out.println("Suma: " + suma);
            System.out.println("Maxim: " + max);
            System.out.println("Minim: " + min);
            System.out.println("Interval: " + interval);
            System.out.println("Double: " + listadouble);
            System.out.println("Verificare 12: " + contine12);
        }
    }

