import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        Person person = null;
        try {
            person = new Person("Jan", 20);
        } catch (InvalidAgeException e) {
            System.out.println("zlapano wyjatek: " + e.getMessage());
        }

        try {
            person.setAge(-20);
        } catch (InvalidAgeException e) {
            System.out.println("zlapano wyjatek: " + e.getMessage());
        }


        System.out.println("Imie: " + person.getName() + " wiek: " + person.getAge());
        System.out.println("Osoba: " + person.toString());



        Person person2 = new Person("Zygmunt", 17);
        Person person3 = new Person("Maciek", 27);

        List<Person> immutablePersonList = List.of(person, person2, person3);

        System.out.println("Lista niemutowalna: " + immutablePersonList);

        List<Person> mutablePersonList = new ArrayList<>();

        mutablePersonList.add(person);
        mutablePersonList.add(person2);
        mutablePersonList.add(person3);

        System.out.println("Lista mutowalna: " + mutablePersonList);





        Set<Person> immutablePersonSet = Set.of(person, person2, person3);

        System.out.println("Set niemutowalny: " + immutablePersonSet);



        Set<Person> mutablePersonSet = new HashSet<>();

        mutablePersonSet.add(person);
        mutablePersonSet.add(person2);
        mutablePersonSet.add(person3);
        mutablePersonSet.add(person); // ominie

        System.out.println("Set mutowalny: " + immutablePersonSet);



        Map<Integer, Person> immutablePersonMap = Map.of(1, person, 2,person2);
        System.out.println("Mapa niemutowalna: " + immutablePersonMap);


        Map<String, Person> mutablePersonMap = new HashMap<>();
        mutablePersonMap.put("A",person);
        mutablePersonMap.put("B",person2);
        mutablePersonMap.put("A",person2);

        System.out.println("Mapa mutowalna: " + mutablePersonMap);




        //streamy

        List<Integer> ageList =  immutablePersonList.stream()
                .map(Person::getAge)
                .collect(Collectors.toList());

        Integer ageSum = ageList.stream()
                .reduce(0,(sum, value) -> sum + value);

        System.out.println("suma lat: " + ageSum);

        double averageAge = (double) ageSum / ageList.size();

        System.out.println("srednia wieku: " + averageAge);


        Integer agesum1 = immutablePersonList.stream()
                .map(p -> p.getAge())
                .reduce(0, (sum, value) -> sum + value);

        System.out.println("suma lat(chain): " + agesum1);



        // 4.2
        List<String> nameList = immutablePersonList.stream()
                .map(n -> n.getName())
                .toList();

        System.out.println("imiona: " + nameList);

        // 4.3
        List<Person> age25PlusList = immutablePersonList.stream()
                .filter(a -> a.getAge() > 25)
                .collect(Collectors.toList());


        System.out.println("Osoby starsze niz 25lat : " + age25PlusList);

        // 4.4

        List<Person> sortedList = immutablePersonList.stream()
                        .sorted(Comparator.comparing(Person::getName))
                        .collect(Collectors.toList());

        System.out.println("Posortowana lista : " + sortedList);




        // 4.5
        immutablePersonList.stream()
                .forEach(System.out::println);

        //4.6
        Person minAgePerson = immutablePersonList.stream()
                .min(Comparator.comparing(Person::getAge))
                .orElseThrow(NoSuchElementException::new);

        System.out.println("Najmlodsza osoba: " + minAgePerson);


        Person maxAgePerson = immutablePersonList.stream()
                .max(Comparator.comparing(Person::getAge))
                .orElseThrow(NoSuchElementException::new);

        System.out.println("Najstarsza osoba: " + maxAgePerson);

    }
}