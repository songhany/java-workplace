package other;

public class Dog {
    private String dogType;
    private String dogName;
    private String dogColor;
    private Integer dogAge;

    public Dog (String dogType, String dogName, String dogColor, Integer dogAge) {
        this.dogType = dogType;
        this.dogName = dogName;
        this.dogColor = dogColor;
        this.dogAge = dogAge;
    }

    // Accessor Methods
    public String getDogType() {
        return dogType;
    }

    public String getDogName() {
        return dogName;
    }

    public String getDogColor() {
        return dogColor;
    }

    public Integer getDogAge() {
        return dogAge;
    }

    // Mutator Methods
    public void setDogType(String dogType) {
        this.dogType = dogType;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public void setDogColor(String dogColor) {
        this.dogColor = dogColor;
    }

    public void setDogAge(Integer dogAge) {
        this.dogAge = dogAge;
    }

    @Override
    public String toString() {
        return "Dog type:" + dogType + "Dog name:" + dogName + "Dog color:" + dogColor + "Dog age" + dogAge;
    }
}
