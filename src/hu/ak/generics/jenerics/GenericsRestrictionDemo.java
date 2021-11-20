package hu.ak.generics.jenerics;

import java.util.ArrayList;
import java.util.List;

public class GenericsRestrictionDemo<T> {
	
//	static T staticField; // <-- Ezt nem lehet

//	GenericsRestrictionDemo<String>
//	GenericsRestrictionDemo<Integer>
//	GenericsRestrictionDemo<List<Integer>>
	
	public static void main(String[] args) {
		
//		Nem tudunk primitív típusokat használni
//		List<int> list = new ArrayList<>();
		Object list = new ArrayList<>();
		
//		if (list instanceof List<String>) {
//			System.out.println("Alma");
//		}
		
		if (list instanceof List<?>) {
			System.out.println("Alma");
		}
		
//		Object[] arraysOfList = new ArrayList<String>[10];
//		arraysOfList[0] = new ArrayList<String>();
//		arraysOfList[1] = new ArrayList<Integer>();
		
//		Object[] array = new String[3];
//		array[0] = "Alma";
//		array[1] = 10; // <-- ArrayStoreException
		
	}
	
//	static class MyException<T> extends Exception {
//		
//	}
	
//	static <T extends Exception> void method() {
//		try {
//			createInstance(null);
//		} catch (T e) { // <-- nem tudjuk eldönteni, hogy ez lefedi-e a keletkező kivételeket
//			
//		}
//	}

	static <T> void createInstance(T object) {
//		Ezek a típusok nincsenek jelen futási időben!
//		T instance = new T("Alma");
	}
	
	
}
