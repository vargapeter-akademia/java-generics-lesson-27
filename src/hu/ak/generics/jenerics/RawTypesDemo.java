package hu.ak.generics.jenerics;

import java.util.ArrayList;
import java.util.List;

public class RawTypesDemo {

	public static void main(String[] args) {
//		Generikusok Java 5-ben jelentek meg
//		Előtte Object osztályt használtak a "generikus" típusban
//		instanceof és castolás használat mindenhol
//		A programozó felelőssége volt, hogy az adatok típusát ellenőrizze és helyesen kezelje
//		Generikus típusok lényege, hogy ezt a programozó válláról levegye és
//		helyette a fordító program végezze el az ellenőrzést és a castolás injektálását
		
//		Backward compatibility / visszafele kompatibilitás támogatása
//		Például ha egy kód Java 4-ben volt megírva, az működjön Java 5-ben is
		
//		List<String> list = new ArrayList<>();
//		Nyers típus (raw type) - Egy olyan generikus típusra hivatkozunk, aminek nem adjuk meg
//		a típus paramétereit, sőt, teljesen figyelmen kívül hagyjuk őket
//		Ekkor, a nyers típusban a típus paramétereket átveszi az Object
		
		List rawList = new ArrayList();
		rawList.add("Alma");
		rawList.add(1);
		
		List<String> list = rawList; // <-- ArrayList<Object>, ennek nem szabadna lefordulnia!
//		List<String> list = new ArrayList<Object>(); // <-- ArrayList<Object>
		
		String integerElement = (String) list.get(1);
		
		String element = (String) list.get(0);
		
//		Hátránya, hogy a Java által nyújtott fordítás idejű típus ellenőrzésről lemondunk
//		Viszont ekkor a Java nem ellenőrzi egyáltalán a típusokat
		
//		Általánosságban elmondható, hogy a nyers típusok használata nem jó programozó gyakorlat
		
	}

}
