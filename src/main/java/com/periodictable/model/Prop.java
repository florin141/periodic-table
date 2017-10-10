package com.periodictable.model;

public enum Prop {
	// CATEGORIA: INFORMATII GENERALE
	SYMBOL ("Symbol", 1),
	GROUP ("Group", 2),
	PERIOD ("Period", 4),
	OLD_GROUP ("Old Group", 3),
	EN_NAME ("English Name", 5),
	GE_NAME ("German Name", 6),
	FR_NAME ("French Name", 7),
	SP_NAME ("Spanish Name", 8),
	IT_NAME ("Italian Name", 9),
	DISCOVERED ("Year Discovered", 40),
	SOURCE ("Source", 37),
	CAS_NUMBER ("CAS Registry Number", 28),


	// CATEGORIA: PROPRIETATI ATOMICE
	ATOMIC_NUM ("Atomic Number", 0),
	ATOMIC_MASS ("Atomic Mass", 10),
	ATOMIC_MASS_IUPAC ("Atomic Mass (IUPAC 2005)", 11),
	ELECTRONEGATIVITY ("Electronegativity (Pauling)", 16),
	IONIZATION_POTENTIAL_1V ("1st ionization potential (eV)", 17),
	IONIZATION_POTENTIAL_2V ("2st ionization potential (eV)", 18),
	IONIZATION_POTENTIAL_3V ("3st ionization potential (eV)", 19),
	IONIZATION_POTENTIAL_1kJ ("1st ionization potential (kJ/mol)", 20),
	IONIZATION_POTENTIAL_2kJ ("2st ionization potential (kJ/mol)", 21),
	IONIZATION_POTENTIAL_3kJ ("3st ionization potential (kJ/mol)", 22),
	PREDICTED_ELECTRON_CONFIG ("Predicted Electron Configuration", 23),
	OBSERVED_ELECTRON_CONFIG ("Observed Electron Configuration", 24),
	ATOMIC_RADIUS ("Atomic Radius (pm)", 25),
	ATOMIC_VOLUME ("Atomic Volume (cm^3/mol)", 26),


	// CATEGORIA: PROPRIETATI FIZICE
	COLOR ("Color", 38),
	CRISTAL_STRUCTURE ("Crystal Structure", 27),
	DENSITY ("Density", 15),
	STATE ("State at Room Temperature", 14),
	MELTING_POINT ("Melting Point", 12),
	BOILING_POINT ("Boiling Point", 13),
	ELECTRICAL_CONDUCTIVITY ("Electrical Conductivity (mho/cm)", 29),
	TERMAL_CONDUCTIVITY ("Thermal Conductivity (W/(m K))", 33),
	SPECIFIC_HEAT ("Specific Heat (J/g K)", 30),
	HEAT_OF_VAPORIZATION ("Heat of Vaporization (kJ/mol)", 32),
	HEAT_OF_FUSION ("Heat of Fusion (kJ/mol)", 31),


	// CATEGORIA: DETALII
	ABUNDANCE_EARTH ("Abundance in Earth's Crust (mg/kg)", 34),
	ABUNDANCE_OCEAN ("Abundance in the Ocean (mg/L)", 35),
	ABUNDANCE_HUMAN ("Abundance in Humans (%)", 36),
	USES ("Uses", 39);


	/** Obiect de tip String ce stocheaza
	 * numele proprietatii */
	private final String description;

	/** Variabila de tip int ce stocheaza
	 * indexul din lista de proprietati */
	private final int index;


	/** Constructorul */
	private Prop(String description, int index) {
		this.description = description;
		this.index = index;
	}

	/** Metoda intoarce numele proprietatii */
	public String toString() {
		return description;
	}

	/** Metoda intoarce indexul proprietatii */
	public int getIndex() {
		return index;
	}
}
