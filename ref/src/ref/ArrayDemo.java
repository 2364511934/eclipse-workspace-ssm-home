package ref;

import java.lang.reflect.Array;

public class ArrayDemo {
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> classType = Class.forName("java.lang.String");
		
		Object array = Array.newInstance(classType, 10); 
		Array.set(array, 5, "1234567890");
		for(int i = 0; i<10; i++) {
			System.out.printf("[%d]: %s\n", i, Array.get(array, i));
		}
		
		
		
		
		
	}
}
