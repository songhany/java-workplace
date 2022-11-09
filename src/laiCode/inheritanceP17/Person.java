package laiCode.inheritanceP17;

public class Person {
    public final String name;
    private int age;
    public String getName() { return name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public Person(String name) {
        this.name = name;
    }
}


class Employee extends Person {
    // parent;s method is hide
    public String company;
    public void setCompany(String company) {this.company = company;}
    public String getCompany() {return company;}
    public Employee(String name) {
        super(name);
    }
}

class Tester {
    public static void main(String[] args) {
        Employee e = new Employee("Songhan");
        String name = e.name;
        //int a = e.age;                       // Wrong
        int a = e.getAge();
        String company = e.getCompany();
        Person p = new Employee("Songhan");
        //int a = p.age;                        // Wrong
        //String company = p.getCompany();      // Wrong.  p 能够访问的方法取决于前面 Person，而不是后面 Employee（后面只决定 method 的版本，同一个方法你父类里也有，子类里也有，他调用的是子类版本的方法。如果子类有，但父类没有，p 就根本 “点” 不出这个方法，访问不到）
    }
}

