package other.CS570.OOP;


//other.CS570.OOP is vital in reusing data and reducing complexity and can set its own behavior

// 4 principles of other.CS570.OOP:
// Inheritance 
// Encapsulation
// Polymorphism
// Abstraction

//Class defines the form of the object
public class Vehicle {
	
	//private can not be accessed outside of this class
	private String type;
	//protected means that the member can be accessed by any class in the same package 
	//and by subclasses even if they are in another packages.
	protected int numWheels;
	
	//Constructor is a method used to initialize the object
	public Vehicle(String vehicle_type, int numWheels) {
		this.type = vehicle_type;
		this.numWheels = numWheels;
	}
	
	
	//Encapsulation: package data and methods of an object and can be used to hide the internal workings
	//We achieve encapsulation: 
	//used getter and setter methods because we set the variables to private 
	//and there wouldnt be anyway to access the variables outside the class
	
	//getter method
	public String gettype() {
		return type;
	}
	
	//setter method
	public void settype(String newtype) {
		type = newtype;
	}
	
	//getter method
	public int getnumWheels() {
		return numWheels;
	}
		
	//setter method
	public void setnumWheels(int wheels) {
		numWheels = wheels;
	}
	
	public void honk() {                    
	    System.out.println("Tuut, tuut!");
	}
	
	public String toString() {
		return "Vehicle: " + type + "\n" + "number of wheels: " + Integer.toString(numWheels);
	}

}
