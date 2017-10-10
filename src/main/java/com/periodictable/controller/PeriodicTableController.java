package com.periodictable.controller;

import com.periodictable.model.Atom;
import com.periodictable.view.AtomDetailsView;
import com.periodictable.view.AtomView;
import com.periodictable.view.PeriodicTableView;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PeriodicTableController {
	private PeriodicTableView view;

	public PeriodicTableController(PeriodicTableView view) {
		this.view = view;

		/* Se cauta in tabelul periodic, elementele cu id pentru
		 * inregistrarea metodelor de tratare a evenimentelor. */
		for (int i = 1; i <= 118; i++) {
			view.lookup("#" + i).setOnMouseEntered(this::evidentiaza);
			view.lookup("#" + i).setOnMouseExited(this::implicit);
			view.lookup("#" + i).setOnMouseClicked(this::afiseazeDetalii);
		}
	}

	/** Medoda de tratare a evenimentului generat atunci
	 * cand cursorul mouse-ului intra in aria unui element. */
	private void evidentiaza(MouseEvent event) {

		((AtomView)event.getSource()).evidentiaza();

	}

	/** Medoda de tratare a evenimentului generat atunci
	 * cand cursorul mouse-ului paraseste aria unui element. */
	private void implicit(MouseEvent event) {

		((AtomView)event.getSource()).implicit();

	}

	/** Medoda de tratare a evenimentului generat atunci cand
	 * sa detectat apasarea butonului pricipal al mouse-ului.
	 * Aceasta metoda verifica daca sa mai dat click pe
	 * elementul respectiv, iar daca nu sa mai dat click
	 * se creaza o instanta a clasei AtomDetailsView, o scena,
	 * si o fereastra (stage), dupa care se afiseaza fereastra. */
	private void afiseazeDetalii(MouseEvent event) {

		if (event.getButton() == MouseButton.PRIMARY) {
			AtomView atomView = (AtomView)event.getSource();

			if (!atomView.esteAfisat()) {
				atomView.setAfisat(true);

				Atom atom = atomView.getAtom();
				AtomDetailsView details = new AtomDetailsView(atom);

				Scene scene = new Scene(details);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.setTitle(atomView.toString());
				stage.show();

				stage.setOnCloseRequest(e -> {
					atomView.setAfisat(false);
				});
			}
		}
	}
}
