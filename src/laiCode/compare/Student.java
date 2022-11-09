package laiCode.compare;

import java.util.*;

// Method1：Comparable
public class Student implements Comparable<Student>{
    private String name;
    private int age;

//    public Student() {
//    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // standard getters/setters, equals and hashcode
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


    @Override
    public int compareTo(Student another) {
        if (this.getAge() == another.getAge()) {
            return 0;
        }
        return this.getAge() < another.getAge() ? -1 : 1;
    }
}

// Method2: Comparator
class MyComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getAge() == s2.getAge()) {
            return 0;
        }
        return s1.getAge() < s2.getAge() ? -1 : 1;
    }
}




