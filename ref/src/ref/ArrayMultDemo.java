package ref;

import java.lang.reflect.Array;

public class ArrayMultDemo {

	public static void main(String[] args) {
		int dim[] = {5, 10, 15};
		
		Object array = Array.newInstance(Integer.TYPE, dim);
		Object arrayObj = Array.get(array, 3);
		arrayObj = Array.get(arrayObj, 5);
		
		Array.set(arrayObj, 10, 78);
		
		for(int i=0; i<5; i++) {
			Object array1 = Array.get(array, i);
			for(int j =0; j<10; j++) {
				Object array2 = Array.get(array1, j);
				for(int k=0; k<15; k++) {
					System.out.printf("[%d][%d][%d]:%d\n", i, j, k, Array.get(array2, k));
					
				}
			}
		}
	}

}
