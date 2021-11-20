package hu.ak.generics.jenerics;

import java.io.Serializable;

import hu.ak.generics.jenerics.Restaurant.Adult;

public class Restaurant {

	static class Person { }
	static class Adult extends Person { }
	static class Child extends Person { }
	interface VeryImportantPerson { }
	static class Owner extends Adult implements VeryImportantPerson { }
	
	static class Order<T extends Person> { 
		
		private T who;
		
		T getWho() {
			return who;
		}
		
		void submit(T who) {
			this.who = who;
		}
		
	}
	
	public static void main(String[] args) {
		Person person = new Adult();
		Adult adult = new Adult();
		Child child = new Child();
		Owner owner = new Owner();
		
		Order<Person> personOrder = new Order<>();
		Order<Adult> adultOrder = new Order<>();
		Order<Owner> ownerOrder = new Order<>();
		
		placeOrder(personOrder, person);
		
//		A person lehet Child is
//		orderAlcoho2(personOrder, person);
//		orderAlcohol2(adultOrder, person);
		orderAlcohol2(adultOrder, adult); // type inference -> <Adult>
		orderAlcohol2(adultOrder, owner); // type inference -> <Adult>
		
		Restaurant.genericMethod("Alma"); // <-- típus kikövetkeztetve
		Restaurant.<Float>genericMethod(10f); // <-- típust meghatározzuk típus paraméterként
		Restaurant.genericMethod(true);
		
//		A típus kikövetkeztetés alapul veszi a paraméterek típusát, típus paramétereit és
//		ősosztályait it
//		Sőt, a visszatérési értéket fogadó változó típusát és típus paramétereit is figyelembe veszi
		
		orderAlcoholForVIP(ownerOrder); // Owner extends Adult implements VIP
//		orderAlcoholForVIP(adultOrder); // Nem implementálja a VIP-t
	}
	
	static void placeOrder(Order<? extends Person> order, Person who) {
		// ...
	}
	
	static void orderAlcohol(Order<? super Adult> order, Adult who) {
		
		order.submit(who);
//		Adult who2 = order.getWho();
	}
	
//	Osztályoknál / interface-eknél a típus neve után adjuk meg
//	Metódusoknál a visszatérési érték típusa előtt
//	Típustörlés itt is történik
	static <R extends Adult> void orderAlcohol2(Order<R> order, R who) {
		
		order.submit(who);
		R who2 = order.getWho();
	}
	
//	R-re nincsen korlát -> R == Object
	static <R> void genericMethod(R param) {
		
	}
	
//	Interfacek felsorolása & jellel
//	Példák:
//	- T extends Adult & VeryImportantPerson & Serializable
//	- T extends VeryImportantPerson & Serializable
//	extends-re ugyanúgy igaz, hogy egyetlen ősosztályt tudunk megjölni
	static <T extends Adult & VeryImportantPerson> void orderAlcoholForVIP(Order<T> order) {
		
	}
	
}
