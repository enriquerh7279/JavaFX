package chapter4StagesScenes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneSwitcher  extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    int iClickCount = 0;
    Label lblClicks;
    Button btnClickMe;
    Button btnSwitchToScene2;
    Scene scene1;

    int iCounter =0;
    Label lblCounter;
    Button btnAdd;
    Button btnSubtract;
    Button getBtnSwitchToScene1;
    Scene scene2;

    Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        lblClicks = new Label("You have not clicked the button.");
        btnClickMe = new Button("Click me please.");
        btnClickMe.setOnAction(
                event -> btnClickMe_Click()
        );

        btnSwitchToScene2 = new Button("Switch!");
        btnSwitchToScene2.setOnAction(
                event -> btnSwitchToScene2_Click()
        );

        VBox panel = new VBox(10);
        panel.getChildren().addAll(lblClicks, btnClickMe, btnSwitchToScene2);

        scene1 = new Scene(panel, 250, 150);

        lblCounter = new Label(Integer.toString(iCounter));
        btnAdd = new Button("Add");
        btnAdd.setOnAction(
                event -> btnAdd_Click()
        );

        btnSubtract = new Button("Subtract");
        btnSubtract.setOnAction(
                event -> btnSubtract_Click()
        );

        btnSwitchToScene2 = new Button("Switch");
        btnSwitchToScene2.setOnAction(
                event -> setBtnSwitchToScene1_Click()
        );

        HBox pane2 = new HBox(10);
        pane2.getChildren().addAll(lblCounter, btnAdd, btnSubtract, btnSwitchToScene2);
        scene2 = new Scene(pane2, 300, 75);

        primaryStage.setScene(scene1);
        primaryStage.setTitle("Scene Switcher");
        primaryStage.show();
    }

    public void btnClickMe_Click() {
        iClickCount++;
        if(iClickCount == 1) {
            lblClicks.setText("You have clicked once.");
        } else {
            lblClicks.setText("You have clicked " + iClickCount + " times.");
        }
    }

    private void btnSwitchToScene2_Click() {
        stage.setScene(scene2);
    }

    private void btnAdd_Click() {
        iCounter++;
        lblCounter.setText(Integer.toString(iCounter));
    }

    private void btnSubtract_Click() {
        iCounter--;
        lblCounter.setText(Integer.toString(iCounter));
    }

    private void setBtnSwitchToScene1_Click() {
        stage.setScene(scene1);
    }
}
