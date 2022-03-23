package other.CS570.OOP;

import java.util.ArrayList;
import java.util.HashMap;

public class main {

	public static void main(String[] args) {
		
		Vehicle v1 = new Vehicle("Car",4);
		System.out.println(v1.getnumWheels()); //returns 4
		//System.out.println(v1.type); // errors out because of private keyword
		System.out.println(v1.toString());
		
		
		
		Car c1 = new Car("Car",4,"BMW","SUV");
		c1.setBrand("Tesla");
		System.out.println(c1.toString());
		c1.honk(); //c1 inherits all attributes in vehicle
		//c1.blinker(); // errors out because function is private
		
		
		Car c2 = new Car("Car",4,"Toyota");
		
		System.out.println(c2.toString());
		
		//Car c3 = new Car("Car",4); //error because this constructor was not initialized
		
		Vehicle v3 = new Car("Car",4,"Benz","Sedan");
		//Car c3 = new Vehicle("Car",4); 
		//inheritance only works one way : a car is a vehicle but a vehicle does not have to be a car 
		
		
		//Abstraction is where the user interact with an item at a high-level, with lower-level internal details hidden from the user
		//Abstract Data Types have a well defined set of operations 
		
		//Other ADT: other.CS570.Stack, other.CS570.Queue, Stream, Set, List
		
		//Example 1 ArrayList (does not have a defined size)
		ArrayList<String> arrli = new ArrayList<String>(10);
		for (int i = 1; i <= 10; i++) {
			arrli.add("hi");
		}
		arrli.add(0,"hello"); //add at specific index
		System.out.println(arrli.toString());
		System.out.println(arrli.get(0)); //get from specific index
		arrli.remove(0);
		System.out.println(arrli.toString());
		
		
		
		//Example 2 Map
		HashMap<String, Integer> map = new HashMap<>();
		map.put("vishal", 10);
		map.put("akhilesh", 20);
		map.put("professor", 30);
		
		if (map.containsKey("vishal")) {
			System.out.println("key found");
		}

		if (map.containsValue(10)) {
			System.out.println("value found");
		}
	}

}
