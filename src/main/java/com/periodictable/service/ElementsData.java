package com.periodictable.service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ElementsData {

	/** Obiect de tip String, stocheaza delimitatorul */
	private static final String DELIMIT = ";";


	/** Obiect de tip ArrayList<ArrayList<String>>.
	 * Acest obiect va contine o lista cu toate
	 * elementele aflate in fisier, iar fiecare
	 * lista va contine proprietatile elementului */
	private static ArrayList<ArrayList<String>> listaElem = new ArrayList<>();

	/** Obiect de tip ElementsData care are atribuit referinta clasei */
	private static ElementsData instantaUnica = new ElementsData();


	/** Constructorul clasei */
	private ElementsData() {
		try {
			init();
		}
		catch (FileNotFoundException ex) {
			System.out.println(ex.toString());
		}
	}

	/** Acesta metoda citeste datele din fisierul FISIER linie cu linie.
	 * Fiecare linie reprezinta un element din tabelul periodic.
	 * Proprietatile sunt separate de ";". Se foloseste un obiect de tip
	 * StringTokenizer pentru separarea lor. Toti tokenii sunt adaugati
	 * unei liste. Lista cu proprietatile elementelor va fi returnata de
	 * metoda obtListaProp(). */
	private void init() throws FileNotFoundException {
		ClassLoader classLoader = getClass().getClassLoader();
		String path = classLoader.getResource("periodic-table-data.csv").getPath();

		Scanner scanner = new Scanner(new File(path), String.valueOf(StandardCharsets.ISO_8859_1));

		while (scanner.hasNextLine()) {
			String linie = scanner.nextLine();
			StringTokenizer valoriProp = new StringTokenizer(linie, DELIMIT);
			ArrayList<String> listaProprietati = new ArrayList<>();

			while (valoriProp.hasMoreElements()) {
				listaProprietati.add(valoriProp.nextToken());
			}

			listaElem.add(listaProprietati);
		}
	}

	public static ArrayList<String> obtListaProp(int nrAtomic) {

		return listaElem.get(nrAtomic);

	}
}
