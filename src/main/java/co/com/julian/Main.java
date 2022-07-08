package co.com.julian;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static co.com.julian.Main.Gender.MALE;
import static co.com.julian.Main.Gender.FEMALE;

public class Main {

    public static void main(String[] args){
        List<Student> students = List.of(
                new Student("Jorge", 28, MALE),
                new Student("Maria", 18, FEMALE),
                new Student("Francisco", 23, MALE),
                new Student("Katherine", 30, FEMALE),
                new Student("Pedro", 17, MALE),
                new Student("Lisa", 17, FEMALE)
        );

        //imperativa
        System.out.println("Programación imperativa");
        for(Student student : students){
            if(MALE.equals(student.gender)){
                System.out.println(student);
            }
        }

        List<Student> females = new ArrayList<>();
        for(Student student : students){
            if(FEMALE.equals(student.gender)){
                females.add(student);
            }
        }

        System.out.println("Estudiantes mujeres");
        for(Student student : females){
            System.out.println(student);
        }

        //declarativa
        System.out.println("Programación declarativa");

        students.stream()
                .filter( student -> MALE.equals(student.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("Estudiantes mujeres");

        students.stream()
                .filter(student -> FEMALE.equals(student.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println);


        //Imperativa
        System.out.println("Programación imperativa");
        List<Person> people = new ArrayList<>();
        for(Student student : students){
            people.add(new Person(student.name, student.age));
        }

        for(Person person : people){
            System.out.println(person);
        }

        //Declarativa
        System.out.println("Programación declarativa");
        students.stream()
                .map( student -> new Person(student.name, student.age))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    static class Person{
        private final String name;
        private final Integer age;

        Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    static class Student{
        private final String name;
        private final Integer age;
        private final Gender gender;

        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender{
        FEMALE,MALE
    }
}


