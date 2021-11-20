package hu.ak.generics.jenerics;

import hu.ak.generics.jenerics.Currency.Money;

// Programozóként nem jó, hogyha futási időben derül ki,
// hogy egy adott paraméter típusa megfelelő-e

/*
public void insertMoney(Object money) {

		if (acceptedCurrency.isInstance(money)) {
			System.out.println("Inserting money: " + money);
		} else {
			throw new IllegalArgumentException();
		}
	}
*/

// Nem szeretnénk az, hogy futási időben legyen ellenőrizve a
// típus helyesség, de azt se szeretnénk, hogy ismételjük a
// kódot és azzal karbantarthatatlanná tegyük a programot

// Bounded type parameter - korlátolt típus paraméter

public class Machine<T extends Money> {
	
	private T acceptedCurrency;
	
	public T insertMoney(T money) {
		System.out.println("Inserting money: " + money);
		
		return money;
	}
	
	public T getAcceptedCurrency() {
		return acceptedCurrency;
	}

}
