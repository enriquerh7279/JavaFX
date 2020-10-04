package ch11LayoutPanes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class StackPanes extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

//        Rectangle r1 = new Rectangle(100, 100);
//        r1.setFill(Color.DARKGRAY);
//        Rectangle r2 = new Rectangle(50,50);
//        r2.setFill(Color.LIGHTGRAY);

        Rectangle r1 = new Rectangle(400,150);
        r1.setFill(Color.DARKGRAY);

        Rectangle r2 = new Rectangle(200, 400);
        r2.setFill(Color.LIGHTGRAY);

        Rectangle r3 = new Rectangle(150, 150);
        r3.setFill(Color.DIMGRAY);

        StackPane stackpane = new StackPane(r1, r2, r3);
        stackpane.setAlignment(Pos.TOP_CENTER);
        stackpane.setPadding(new Insets(50));
        stackpane.setMargin(r1, new Insets(25));

        Scene scene = new Scene(stackpane, 500,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rectangles");
        primaryStage.show();
    }
}
