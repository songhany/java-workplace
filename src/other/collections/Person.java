package other.collections;

class Person implements Comparable<Person> {
    public String name;
    public String address;

    public Person(String name) {
        this.name = name;
    }

    public int compareTo(Person person) {
        return this.name.compareTo(person.name);
    }
}
