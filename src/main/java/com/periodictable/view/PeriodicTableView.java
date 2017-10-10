package com.periodictable.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;

public class PeriodicTableView extends GridPane {

	public static final Insets SPATIU = new Insets(45.5, 18.5, 18.5, 18.5);

	public PeriodicTableView() {
		setSnapToPixel(false);
		setPadding(SPATIU);				/* seteaza spatiu */
		setAlignment(Pos.CENTER);		/* seteaza alinierea */
		setVgap(1); 					/* seteaza spatiu */
		setHgap(1); 					/* seteaza spatiu */

		init();
	}

	/** Aceasta metoda adauga instante
	 * ale clasei AtomCell containerului */
	private void init() {
		int element = 1;

		/* Period 1 */
		add(new AtomView(element++), 0, 0);
		add(new AtomView(element++), 17, 0);

		/* Period 2 */
		add(new AtomView(element++), 0, 1);
		add(new AtomView(element++), 1, 1);
		for (int col = 12; col <= 17; col++)
			add(new AtomView(element++), col, 1);

		/* Period 3 */
		add(new AtomView(element++), 0, 2);
		add(new AtomView(element++), 1, 2);
		for (int col = 12; col <= 17; col++)
			add(new AtomView(element++), col, 2);

		/* Period 4 */
		for (int col = 0; col <= 17; col++)
			add(new AtomView(element++), col, 3);

		/* Period 5 */
		for (int col = 0; col <= 17; col++)
			add(new AtomView(element++), col, 4);

		/* Period 6 */
		add(new AtomView(element++), 0, 5);
		add(new AtomView(element++), 1, 5);
		add(new AtomView("57-71"), 2, 5); // place holder
		element = 72;
		for (int col = 3; col <= 17; col++)
			add(new AtomView(element++), col, 5);

		/* Period 7 */
		add(new AtomView(element++), 0, 6);
		add(new AtomView(element++), 1, 6);
		add(new AtomView("89-103"), 2, 6); // place holder
		element = 104;
		for (int col = 3; col <= 17; col++)
			add(new AtomView(element++), col, 6);

		/* Separator */
		for (int i = 0; i <= 17; i++) {
			Separator separator = new Separator();
			separator.setVisible(false);
			add(separator, i, 7);
		}

		/* Lanthanide */
		element = 57;
		for (int col = 2; col <= 16; col++)
			add(new AtomView(element++), col, 8);

		/* Actinide */
		element = 89;
		for (int col = 2; col <= 16; col++)
			add(new AtomView(element++), col, 9);
	}
}
