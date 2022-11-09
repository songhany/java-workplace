package laiCode.polymorphismP17;

public class Person {
    public final String name;
    public String getName() { return name; }
    public String getNameCard() {
        return name;
    }

    public Person(String name) {
        this.name = name;
    }
}

class Employee extends Person {
    public String company;

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public Employee(String name, String company) {
        super(name);  // this.name = name;
        this.company = company;
    }

    @Override
    public String getNameCard() {
        return name + ", employee in " + company;
    }
}

class Tester {
    public static void main(String[] args) {
        Person p = new Person("Jack");
        System.out.println(p.getNameCard());

        Person s = new Employee("Ricardo", "Google");
        System.out.println(s.getNameCard());

        Employee e = new Employee("Alice", "Amazon");
        System.out.println(e.getNameCard());
    }
}
