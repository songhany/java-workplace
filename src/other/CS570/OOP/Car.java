package other.CS570.OOP;


//keyword: extends means the child class inherits all the properties of the parent class
public class Car extends Vehicle{
	
	private String brand;
	private String model;
	
	//super is used because the child must have all the variables from the parent
	public Car(String vehicle_type,int numWheels,String vehicle_brand, String vehicle_model) {
		super(vehicle_type, numWheels);
		this.brand = vehicle_brand;
		this.model = vehicle_model;
	}
	
	//method overloading occurs where methods in the same class share the same name but different parameters
	public Car(String vehicle_type,int numWheels,String vehicle_brand) {
		super(vehicle_type, numWheels);
		this.brand = vehicle_brand;
	}
	//getter method
	public String getBrand() {
		return brand;
	}
	
	//setter method
	public void setBrand(String newBrand) {
		brand = newBrand;
	}
	
	//getter method
	public String getModel() {
		return model;
	}
		
	//setter method
	public void setModel(String newModel) {
		model = newModel;
	}
	
	private void blinker() {
		System.out.println("Blinker is ON");
	}
	
	//method overriding occurs from a child class writing over a method inherited from its parent
	//overriding and overloading is an example of static polymorphism
	public String toString() {
		return "Vehicle: " + this.gettype() + "\n" + "number of wheels: " + Integer.toString(numWheels) 
		+ "\n" + "Brand: " + brand + "\n" + "Model: " + model;
	}


}
