package task_2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        //поиск не совершеннолетних
        long stream = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println(stream);

        //получение списка фамилий призывников
        List<String> stream_call = persons.stream()
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getAge() <= 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println(stream_call);

        //Получение отсортированного по фамилиям список потенциально работоспособных людей с высшим образованием в выборке
        List<String> stream_work = persons.stream()
                .filter(x -> x.getSex() == Sex.MAN ? x.getAge() <= 65 : x.getAge() <= 60)
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(stream_work);
    }
}