package task_1;

  /*  Raw data:
        0 - Harry
        0 - Harry
        1 - Harry
        2 - Harry
        3 - Emily
        4 - Jack
        4 - Jack
        5 - Amelia
        5 - Amelia
        6 - Amelia
        7 - Amelia
        8 - Amelia
        **************************************************
        Duplicate filtered, grouped by name, sorted by name and id:
        Amelia:
        1 - Amelia (5)
        2 - Amelia (6)
        3 - Amelia (7)
        4 - Amelia (8)
        Emily:
        1 - Emily (3)
        Harry:
        1 - Harry (0)
        2 - Harry (1)
        3 - Harry (2)
        Jack:
        1 - Jack (4)
     */

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

    public class ComplexExamples {

        static class Person {
            final int id;

            final String name;

            Person(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Person person)) return false;
                return getId() == person.getId() && getName().equals(person.getName());
            }

            @Override
            public int hashCode() {
                return Objects.hash(getId(), getName());
            }
        }

        private static Person[] RAW_DATA = new Person[]{
                new Person(0, "Harry"),
                new Person(0, "Harry"), // дубликат
                new Person(1, "Harry"), // тёзка
                new Person(2, "Harry"),
                new Person(3, "Emily"),
                new Person(4, "Jack"),
                new Person(4, "Jack"),
                new Person(5, "Amelia"),
                new Person(5, "Amelia"),
                new Person(6, "Amelia"),
                new Person(7, "Amelia"),
                new Person(8, "Amelia"),
        };

        public static void main(String[] args) {
            System.out.println("Raw data:");
            System.out.println();

            for (Person person : RAW_DATA) {
                System.out.println(person.id + " - " + person.name);
            }

            System.out.println();
            System.out.println("**************************************************");
            System.out.println();
            System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
            System.out.println();
            makeSortedListOfPersons(RAW_DATA);
                }

        public static void makeSortedListOfPersons (Person [] personList){
            Stream<Person> stream = Arrays.stream(RAW_DATA).distinct();
            ArrayList <Person> sortedList = (ArrayList<Person>) stream
                    .sorted(Comparator.comparing(Person::getName)
                            .thenComparing(Person::getId))
                    .collect(Collectors.toList());

            String prevousName = "";
            int count = 1;
            for (Person p : sortedList) {
                String currentName = p.getName();
                if (!prevousName.equals(currentName)){
                    System.out.println(currentName + ":");
                count = 1;
                }
                prevousName = currentName;
                System.out.println(count + " - " + currentName + " ("+ p.getId() +")");
                count++;
            }
        }
    }
