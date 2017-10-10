package com.periodictable;

import com.periodictable.controller.PeriodicTableController;
import com.periodictable.view.PeriodicTableView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static final double WIDTH = 1280 - 2;
    private static final double HEIGHT = 720 - 32;

    public static void main(String[] args) {
        launch(args);
    }

    @Override /* Override the start method in the Application class */
    public void start(Stage stage) {
        PeriodicTableView view = new PeriodicTableView();
        PeriodicTableController controller = new PeriodicTableController(view);

        Scene scene = new Scene(view, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setTitle("PeriodicTableApp");
        stage.show();
    }
}
