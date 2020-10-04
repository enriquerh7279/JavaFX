package ch11LayoutPanes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;

import java.awt.*;

public class TilePanes extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        TilePane tile1 = new TilePane();
        tile1.setHgap(10);
        tile1.setVgap(10);
        tile1.setPadding(new Insets(10));

        for(int i = 1; i < 13; i++) {
            Rectangle r = new Rectangle(100, 100);
            r.setFill(Color.LIGHTGRAY);
            Label l = new Label("A-" + i);
            StackPane s = new StackPane(r, l);
            tile1.getChildren().add(s);
        }

//        This code adds a scroll pane to accomodate the tile pane that is too large for the pane
//        ScrollPane spane = new ScrollPane(tile1);
//        Scene scene = new Scene(spane, 500,500);

        Scene scene = new Scene(tile1, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rectangles");
        primaryStage.show();
    }
}
