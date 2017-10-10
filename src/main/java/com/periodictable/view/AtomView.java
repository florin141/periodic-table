package com.periodictable.view;

import com.periodictable.model.Atom;
import com.periodictable.model.Prop;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class AtomView extends StackPane {

	/** Constante ce specifica latimea
	 * si lungimea celulei */
	private static final int LAT = 68;
	private static final int LUN = 68;

	/** Constante ce specifica culorile
	 * implicite, raza colturilor si spatiile */
	private static final Color CUL_IMPLICITA = Color.rgb(200, 200, 200);
	private static final Color CUL_EVIDENTIERE = Color.LIGHTSKYBLUE;
	private static final CornerRadii RAZA_COLT = new CornerRadii(5);
	private static final Insets SPATIU = Insets.EMPTY;

	/** Effectele de umbrire implicite si de evidentiere */
	private static final InnerShadow EFECT_IMP = new InnerShadow(20, CUL_IMPLICITA.darker());
	private static final InnerShadow EFECT_EVID = new InnerShadow(20, CUL_EVIDENTIERE.darker());


	/** Fundalul implicit si de evidentiere */
	public static final BackgroundFill FUNDAL_IMP_UMP = new BackgroundFill(CUL_IMPLICITA, RAZA_COLT, SPATIU);
	public static final BackgroundFill FUNDAL_EVID_UMP = new BackgroundFill(CUL_EVIDENTIERE, RAZA_COLT, SPATIU);
	private static final Background FUNDAL_IMP = new Background(FUNDAL_IMP_UMP);
	private static final Background FUNDAL_EVID = new Background(FUNDAL_EVID_UMP);


	/** Componentele celulei sunt formate din mai
	 * multe obiecte de tip Text. Mai exact avem
	 * obiecte de tip text ce reprezinta numarul
	 * atomic, simbolul, numele, si masa atomica
	 * a elementului.*/
	private final Text textNumarAtomic = new Text();
	private final Text textSimbol = new Text();
	private final Text textNumeEl = new Text();
	private final Text textMasa = new Text();


	/** Variabila de tip boolean ce specifica
	 * daca sa dat click in celula */
	private boolean afisat = false;

	/** Obiect de tip Atom ce stocheaza
	 * proprietatile atomului */
	private Atom atom;


	/** Constructorul clasei. Acest constructor este
	 * folosit doar in cazul lanthanide si al actinide */
	public AtomView(String atomicNumberRange) {
		textNumarAtomic.setText(atomicNumberRange);

		init();
	}

	/** Constructorul clasei. Acest constructor creaza o
	 * instanta a clasei Atom, seteaza clasei un id,
	 * seteaza textul, si apoi seteaza modul de afisare
	 * componentelor celulei apeland metoda init() */
	public AtomView(int atomicNumber) {
		this.atom = new Atom(atomicNumber);

		/* seteaza ca id numarul atomic */
		this.setId(String.valueOf(atomicNumber));

		textNumarAtomic.setText(String.valueOf(atomicNumber));
		textSimbol.setText(atom.get(Prop.SYMBOL));
		textNumeEl.setText(atom.get(Prop.EN_NAME));
		textMasa.setText(atom.get(Prop.ATOMIC_MASS));

		init();
	}

	/** Aceasta metoda seteaza modul de afisarea al celulei. */
	private void init() {
		textNumarAtomic.setFont(Font.font(null, FontWeight.BOLD, 10));
		textSimbol.setFont(Font.font(null, FontWeight.BOLD, 22));
		textNumeEl.setFont(Font.font(null, FontWeight.BOLD, 9));
		textMasa.setFont(Font.font(null, 10));

		implicit();

		setPrefSize(LAT, LUN);
		setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);
		setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);

		getChildren().add(textNumarAtomic);
		StackPane.setAlignment(textNumarAtomic, Pos.TOP_LEFT);
		StackPane.setMargin(textNumarAtomic, new Insets(5, 0, 0, 5));

		getChildren().add(textSimbol);
		StackPane.setMargin(textSimbol, new Insets(0, 0, 10, 0));

		VBox contNumeMasa = new VBox(-2);			/* creaza container */
		contNumeMasa.setPadding(new Insets(0, 0, 5, 0));
		contNumeMasa.setAlignment(Pos.BOTTOM_CENTER);
		contNumeMasa.getChildren().add(textNumeEl);
		contNumeMasa.getChildren().add(textMasa);

		getChildren().add(contNumeMasa);
	}

	/** Metoda care este apelata atunci cand cursorul
	 * mouse-ului intra in aria celulei. Metoda schimba
	 * fundalul si efectul de umbrire. */
	public void evidentiaza() {
		setBackground(FUNDAL_EVID);
		setEffect(EFECT_EVID);
	}


	/** Metoda care este apelata atunci cand cursorul
	 * mouse-ului paraseste  aria celulei. Metoda schimba
	 * fundalul si efectul de umbrire la valorile implicite. */
	public void implicit() {
		setBackground(FUNDAL_IMP);
		setEffect(EFECT_IMP);
	}

	/** Metoda ce intoarce referina obiectului de tip Atom */
	public Atom getAtom() {
		return atom;
	}

	public boolean esteAfisat() {
		return afisat;
	}

	public void setAfisat(boolean afisat) {
		this.afisat = afisat;
	}

	@Override
	public String toString() {
		return Character.toUpperCase(atom.get(Prop.EN_NAME).charAt(0)) +
			atom.get(Prop.EN_NAME).substring(1);
	}
}
