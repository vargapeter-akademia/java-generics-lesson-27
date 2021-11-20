package hu.ak.generics.jenerics;

public class Currency {
	
	private Currency() {}

	static class Money {
		
	}
	
	static class Cash 
	extends Money { }
	
	static class Coin
	extends Cash { }
	
	static class Banknote
	extends Cash { }
	
	static class CreditCard
	extends Money { }
	
}
