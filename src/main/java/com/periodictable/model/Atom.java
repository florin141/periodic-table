package com.periodictable.model;

import com.periodictable.service.ElementsData;
import java.util.ArrayList;

public class Atom {

	/** Lista ce va contine proprietatile elementului */
	private ArrayList<String> prop;

	/** Constructorul clasei. Are un parametru de tip
	 * int ce reprezinta numarul atomic. Acest parametru
	 * trebuie sa fie mai mare sau egal cu unu si
	 * maimic sau egal cu 118. */
	public Atom(int atomicNumber) {

		this.prop = ElementsData.obtListaProp(atomicNumber);

	}

	/** Aceasta metoda intoarce valoarea proprietatii
	 * specificate ca argument. De exemplu, pentru
	 * Atom a = new Atom(2);
	 * System.out.println(a.get(Prop.SYMBOL));
	 * va afisa "He" */
	public String get(Prop property) {

		return prop.get(property.getIndex());

	}

	@Override
	public String toString() {

		return prop.toString();

	}
}
