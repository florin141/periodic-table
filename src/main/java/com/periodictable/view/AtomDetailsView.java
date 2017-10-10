package com.periodictable.view;

import com.periodictable.model.Atom;
import com.periodictable.model.Prop;
import javafx.geometry.Insets;
import javafx.scene.control.Accordion;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class AtomDetailsView extends Accordion {
	/* CONSTANTE */
	public static final Insets SPATIU = new Insets(10, 25, 10, 25);

	/* PROPRIETATILE */
	private final Atom atom;

	public AtomDetailsView(Atom atom) {
		this.atom = atom;
		init();
	}

	/** Aceasta metode creaza patru file pentru acordeon. 
	 * Prima fila este extinsa in mod implicit. Continutul 
	 * pentru fiecare fila este un container de tip ScrollPane
	 * al carul continut este un container de tip VBox. Fiecare 
	 * container de tip VBox contine proprietatile atomului. */
	private void init() {
		VBox contPropGen = new VBox(5); /* creaza container */
		contPropGen.setPadding(SPATIU); /* seteaza spatiu */
		contPropGen.getChildren().addAll( /* adauga proprietati */
			obtProp(Prop.SYMBOL), new Separator(),
			obtProp(Prop.GROUP), new Separator(),
			obtProp(Prop.PERIOD), new Separator(),
			obtProp(Prop.OLD_GROUP), new Separator(),
			obtProp(Prop.EN_NAME), new Separator(),
			obtProp(Prop.GE_NAME), new Separator(),
			obtProp(Prop.FR_NAME), new Separator(),
			obtProp(Prop.SP_NAME), new Separator(),
			obtProp(Prop.IT_NAME), new Separator(),
			obtProp(Prop.DISCOVERED), new Separator(),
			obtProp(Prop.SOURCE), new Separator(),
			obtProp(Prop.CAS_NUMBER), new Separator()
		);
		ScrollPane defilarePropGen = new ScrollPane();/* creaza container */
		defilarePropGen.setContent(contPropGen);/* seteaza continutul */
		defilarePropGen.setFitToWidth(true);/* extinde continutul */
		TitledPane filaPropGen = new TitledPane();/* creaza fila */
		filaPropGen.setText("General Properties");/* seteaza titlul */
		filaPropGen.setContent(defilarePropGen);/* seteaza continutul */

		VBox contPropAtom = new VBox(5); /* creaza container */
		contPropAtom.setPadding(SPATIU); /* seteaza spatiu */
		contPropAtom.getChildren().addAll( /* adauga proprietati */
			obtProp(Prop.ATOMIC_NUM), new Separator(),
			obtProp(Prop.ATOMIC_MASS), new Separator(),
			obtProp(Prop.ATOMIC_MASS_IUPAC), new Separator(),
			obtProp(Prop.ELECTRONEGATIVITY), new Separator(),
			obtProp(Prop.IONIZATION_POTENTIAL_1V), new Separator(),
			obtProp(Prop.IONIZATION_POTENTIAL_2V), new Separator(),
			obtProp(Prop.IONIZATION_POTENTIAL_3V), new Separator(),
			obtProp(Prop.IONIZATION_POTENTIAL_1kJ), new Separator(),
			obtProp(Prop.IONIZATION_POTENTIAL_2kJ), new Separator(),
			obtProp(Prop.IONIZATION_POTENTIAL_3kJ), new Separator(),
			obtProp(Prop.PREDICTED_ELECTRON_CONFIG), new Separator(),
			obtProp(Prop.OBSERVED_ELECTRON_CONFIG), new Separator(),
			obtProp(Prop.ATOMIC_RADIUS), new Separator(),
			obtProp(Prop.ATOMIC_VOLUME), new Separator()
		);
		ScrollPane defilarePropAtom = new ScrollPane();/* creaza container */
		defilarePropAtom.setContent(contPropAtom);/* seteaza continutul */
		defilarePropAtom.setFitToWidth(true);/* extinde continutul */
		TitledPane filaPropAtom = new TitledPane();/* creaza fila */
		filaPropAtom.setText("Atomic Properties");/* seteaza titlul */
		filaPropAtom.setContent(defilarePropAtom);/* seteaza continutul */

		VBox contPropFizice = new VBox(5); /* creaza container */
		contPropFizice.setPadding(SPATIU); /* seteaza spatiu */
		contPropFizice.getChildren().addAll( /* adauga proprietati */
			obtProp(Prop.COLOR), new Separator(),
			obtProp(Prop.CRISTAL_STRUCTURE), new Separator(),
			obtProp(Prop.DENSITY), new Separator(),
			obtProp(Prop.STATE), new Separator(),
			obtProp(Prop.MELTING_POINT), new Separator(),
			obtProp(Prop.BOILING_POINT), new Separator(),
			obtProp(Prop.ELECTRICAL_CONDUCTIVITY), new Separator(),
			obtProp(Prop.TERMAL_CONDUCTIVITY), new Separator(),
			obtProp(Prop.SPECIFIC_HEAT), new Separator(),
			obtProp(Prop.HEAT_OF_VAPORIZATION), new Separator(),
			obtProp(Prop.HEAT_OF_FUSION), new Separator()
		);
		ScrollPane defilarePropFizice = new ScrollPane();/* creaza container */
		defilarePropFizice.setContent(contPropFizice);/* seteaza continutul */
		defilarePropFizice.setFitToWidth(true);/* extinde continutul */
		TitledPane filaPropFizice = new TitledPane();/* creaza fila */
		filaPropFizice.setText("Physical Properties");/* seteaza titlul */
		filaPropFizice.setContent(defilarePropFizice);/* seteaza continutul */

		VBox contAlteProp = new VBox(5); /* creaza container */
		contAlteProp.setPadding(SPATIU); /* seteaza spatiu */
		contAlteProp.getChildren().addAll( /* adauga proprietati */
			obtProp(Prop.ABUNDANCE_EARTH), new Separator(),
			obtProp(Prop.ABUNDANCE_OCEAN), new Separator(),
			obtProp(Prop.ABUNDANCE_HUMAN), new Separator(),
			obtProp(Prop.USES), new Separator()
		);
		ScrollPane defilareAlteProp = new ScrollPane(); /* creaza container */
		defilareAlteProp.setContent(contAlteProp); /* seteaza continutul */
		defilareAlteProp.setFitToWidth(true); /* extinde continutul */
		TitledPane filaAlteProp = new TitledPane(); /* creaza fila */
		filaAlteProp.setText("Other Properties"); /* seteaza titlul */
		filaAlteProp.setContent(defilareAlteProp); /* seteaza continutul */
		
		setExpandedPane(filaPropGen); /* deschide filaPropGen */
		setPrefSize(300, 400); /* seteaza dimensiunea pref */
		getPanes().addAll(filaPropGen, filaPropAtom, 
			filaPropFizice, filaAlteProp);			/* adauga filele */
	}

	/** Aceasta metode creaza un container de tip VBox
	 * si adatuga doua obiecte de tip text. Primul text
	 * afiseaza numele proprietatii cu un font ingrosat,
	 * iar al doilea text afiseaza valoarea proprietatii. */
	private VBox obtProp(Prop property) {
		Text textNumeProp = new Text(property + ":");
		textNumeProp.setFont(Font.font(null, FontWeight.BOLD, 12));

		Text textValProp = new Text(atom.get(property));
		textValProp.setFont(Font.font(null, FontPosture.REGULAR, 12));

		return new VBox(textNumeProp, textValProp);
	}
}