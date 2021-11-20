package hu.ak.generics.jenerics;

import hu.ak.generics.jenerics.Currency.Banknote;
import hu.ak.generics.jenerics.Currency.Cash;
import hu.ak.generics.jenerics.Currency.Coin;
import hu.ak.generics.jenerics.Currency.CreditCard;
import hu.ak.generics.jenerics.Currency.Money;

public class VendingMachineMain {

	public static void main(String[] args) {
		/*
		 * IntegerMachine integerMachine = new IntegerMachine(); MoneyMachine
		 * moneyMachine = new MoneyMachine(); Machine machine = new Machine();
		 * 
		 * // integerMachine.insertMoney("Pénz"); // integerMachine.insertMoney(1); //
		 * integerMachine.insertMoney(new Money()); // //
		 * moneyMachine.insertMoney("Pénz"); // moneyMachine.insertMoney(1); //
		 * moneyMachine.insertMoney(new Money());
		 * 
		 * machine.insertMoney("Pénz"); machine.insertMoney(1); machine.insertMoney(new
		 * Money());
		 */

		/*
		 * Machine<Integer> integerMachine = new Machine<Integer>(); // diamond
		 * operator: <> // Type inference: típus kikövetkeztetés vagy levezetés
		 * Machine<String> stringMachine = new Machine<>();
		 * 
		 * integerMachine.insertMoney("Pénz"); integerMachine.insertMoney(1);
		 * integerMachine.insertMoney(new Money());
		 * 
		 * stringMachine.insertMoney("Pénz"); stringMachine.insertMoney(1);
		 * stringMachine.insertMoney(new Money());
		 */

		Money money = new Money();
		Cash cash = new Cash();
		Coin coin = new Coin();
		Banknote banknote = new Banknote();
		CreditCard card = new CreditCard();

		Machine<Money> moneyMachine = new Machine<>();
		Machine<Cash> cashMachine = new Machine<>();
		Machine<Coin> coinMachine = new Machine<>();
		Machine<CreditCard> cardMachine = new Machine<>();

		// Elfogad minden Money és leszármazottat
		moneyMachine.insertMoney(card);
		moneyMachine.insertMoney(banknote);

		// Elfogad minden Cash és leszármazottat
		cashMachine.insertMoney(coin);
//		cashMachine.insertMoney(card);
//		cashMachine.insertMoney(money);

		payWithMoney(moneyMachine);
		payWithMoney(cashMachine);
		payWithMoney(cardMachine);

// Ha megengedné azt, hogy a machine lehet Machine<Cash>,
// akkor akár kártyával is fizethetnénk a készpénzes automatában
//		payWithMoneyOnly(cashMachine);

	}

//	Machine<Money>
//	Machine<Cash>
//	Money <-- Cash ==/=> Machine<Money> <-- Machine<Cash>

//	Típustörlés:
//	Kicseréli a típus paramétekre való hivatkozást vagy Object-re, vagy ha
//	van korlát definiálva, akkor arra
//	A típus paraméter visszatérési értékekre való hivatkozásoknál beiktat
//	egy castolást is
//	A generikus típusok típus paramétere csak fordítás időben van jelen
//  Ezért a csak típus paraméterekben különböző paraméterlistájú metódusok
//	azonos szignatúrával rendelkeznek futási időben, ami hibát okoz

//	Cash insertMoney = (Cash) cashMachine.insertMoney(banknote);

	static void payWithMoneyOnly(Machine<Money> machine) {
		// Ha megengedné azt, hogy a machine lehet Machine<Cash>,
		// akkor akár kártyával is fizethetnénk a készpénzes automatában

//		Machine<Cash> machine2 = new Machine<>();
//		machine2.insertMoney(new CreditCard());

		machine.insertMoney(new Money());
		machine.insertMoney(new CreditCard());
	}

// Wildcard: ?
// Határozatlan típus
// Ha a típus paraméternek nincsen korlátja, akkor ? == Object
// különben a korlát
// Az alábbi esetben ? == Money
// A wildcardnak is megadhatunk korlátokat
	
// Upper bound / felső korlát (extends)
// ? extends Money == bármilyen típus, ami extendálja a Money osztályt
// A <? extends ...> általában arra jó, hogy a típus paramétert, mint 
// visszatérési érték típusa fel tudja használni
//		Tehát, ha olvasni akarjuk az adatokat, akkor a <? extends...> a
//		jó választás
	
	
//	static void payWithMoney(Machine<?> machine) {
	static void payWithMoney(Machine<? extends Money> machine) {

//		Machine<Cash> machine2 = new Machine<>();
//		machine2.insertMoney(new CreditCard());
		
		// Az <? extends Money> csak annyit jelent ki, hogy a típus
		// paraméter a Money leszármazottja
		// Ennél többet nem is lehet feltételezni
		Money acceptedCurrency = machine.getAcceptedCurrency();
		
//		machine.insertMoney(new Money());
//		machine.insertMoney(new CreditCard());
	}
	
	static void payWithCash(Machine<? extends Cash> machine) {

//		Machine<Cash> machine2 = new Machine<>();
//		machine2.insertMoney(new CreditCard());
		
		// Az <? extends Cash> csak annyit jelent ki, hogy a típus
		// paraméter a Cash leszármazottja
		// De ennél többet nem is lehet feltételezni
		Money acceptedCurrency1 = machine.getAcceptedCurrency();
		Cash acceptedCurrency2 = machine.getAcceptedCurrency();
		
//		machine.insertMoney(new Coin());
//		machine.insertMoney(new Banknote());
	}
	
//	Lower bound / alsó korlát (super)
//	Alsó korlátot csak wildcarddal használhatunk
//	<? super Cash> az azt jelenti, hogy olyan típusok, melyek legalább
//	Cash típusúak
//	Azaz, ez azt jelenti, hogy a Cash vagy az ősosztályai
	
	static void payWithCash2(Machine<? super Cash> machine) {

//		Machine<Cash> machine1 = new Machine<>();
//		Machine<Money> machine2 = new Machine<>();
//		Machine<CreditCard> machine3 = new Machine<>();
		
		Money acceptedCurrency = machine.getAcceptedCurrency();
		
//		Annyit tudunk a Machine<? super Cash>-ről, hogy legalább Cash
//		típus paramétere van, ami lehet Cash, Money, vagy hogyha nem lenne
//		korlátja a Machine-nek, akkor akár Object is
//		Cash acceptedCurrency2 = machine.getAcceptedCurrency();
		
//		"Olvasni" az adatokat nem tudjuk most pontosan, de "írni" tudjuk
		
		machine.insertMoney(new Coin());
		machine.insertMoney(new Banknote());
		
//		A CreditCard túl specifikus, nem Cash vagy ősosztálya
//		machine.insertMoney(new CreditCard());
	}
	
	static void insertFromOtherMachine(Machine<? extends Coin> machineFrom, Machine<? super Coin> machineTo) {
		Coin currency = machineFrom.getAcceptedCurrency();
		machineTo.insertMoney(currency);
	}

}
