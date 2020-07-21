package ch6UserInput;

import chapter4StagesScenes.MessageBox;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PizzaOrder extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Stage stage;

    //Customer name, phone, and address fields
    TextField txtName;
    TextField txtPhone;
    TextField txtAddress;

    //Size radio buttons
    RadioButton rdoSmall;
    RadioButton rdoMedium;
    RadioButton rdoLarge;

    //Crust style radio buttons
    RadioButton rdoThin;
    RadioButton rdoThick;

    //Topping Radio buttons
    CheckBox chkPepperoni;
    CheckBox chkSausage;
    CheckBox chkLinguica;
    CheckBox chkOlives;
    CheckBox chkMushrooms;
    CheckBox chkTomatoes;
    CheckBox chkAnchovies;

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;

        //---------Create the top pane-------------
        Text textHeading = new Text("Order Your Pizza Now!");
        textHeading.setFont(new Font(20));
        HBox paneTop = new HBox(textHeading);
        paneTop.setPadding(new Insets(20, 10, 20, 10));

        //--------Create the customer Pane----------

        //Create the name label and text field
        Label lblName = new Label("Name");
        lblName.setPrefWidth(100);
        txtName = new TextField();
        txtName.setPrefColumnCount(20);
        txtName.setPromptText("Enter the customer's name");
        txtName.setMaxWidth(Double.MAX_VALUE);
        HBox paneName = new HBox(lblName, txtName);

        //Create the phone number label and text field
        Label lblPhone = new Label("Phone Number:");
        lblPhone.setPrefWidth(100);
        txtPhone = new TextField();
        txtPhone.setPrefColumnCount(20);
        txtPhone.setPromptText("Enter the customer's phone number here");
        HBox panePhone = new HBox(lblPhone, txtPhone);

        //Create the address label and text field
        Label lblAddress = new Label("Address:");
        lblAddress.setPrefWidth(100);
        txtAddress = new TextField();
        txtAddress.setPrefColumnCount(20);
        txtAddress.setPromptText("Enter the customer's address here");
        HBox paneAddress = new HBox(lblAddress, txtAddress);

        //Create the Customer Pane
        VBox paneCustomer = new VBox(10, paneName, panePhone, paneAddress);

        //-----------Create the order pane------------

        //Create the size pane
        Label lblSize = new Label("Size");
        rdoSmall = new RadioButton("Small");
        rdoMedium = new RadioButton("Medium");
        rdoLarge = new RadioButton("Large");
        rdoMedium.setSelected(true);
        ToggleGroup groupSize = new ToggleGroup();
        rdoSmall.setToggleGroup(groupSize);
        rdoMedium.setToggleGroup(groupSize);
        rdoLarge.setToggleGroup(groupSize);

        VBox paneSize = new VBox(lblSize, rdoSmall, rdoMedium, rdoLarge);
        paneSize.setSpacing(10);

        //Create the crust pane
        Label lblCrust = new Label("Crust");
        rdoThin = new RadioButton("Thin");
        rdoThick = new RadioButton("Thick");
        rdoThin.setSelected(true);
        ToggleGroup groupCrust = new ToggleGroup();
        rdoThin.setToggleGroup(groupCrust);
        rdoThick.setToggleGroup(groupCrust);

        VBox paneCrust = new VBox(lblCrust, rdoThin, rdoThick);
        paneCrust.setSpacing(10);

        //Create the toppings Pane
        Label lblToppings = new Label("Toppings");
        chkPepperoni = new CheckBox("Pepperoni");
        chkSausage = new CheckBox("Sausage");
        chkLinguica = new CheckBox("Linguica");
        chkOlives = new CheckBox("Olives");
        chkMushrooms = new CheckBox("Mushrooms");
        chkTomatoes = new CheckBox("Tomatoes");
        chkAnchovies = new CheckBox("Anchovies");

        FlowPane paneToppings = new FlowPane(Orientation.VERTICAL, chkPepperoni,
                chkSausage, chkLinguica, chkOlives, chkMushrooms, chkTomatoes, chkAnchovies);

        //Add the size, crust, and toppings panes to the order Pane
        HBox paneOrder = new HBox(50, paneSize, paneCrust, paneToppings);

        //Create The CenterPane
        VBox paneCenter = new VBox(20, paneCustomer, paneOrder);
        paneCenter.setPadding(new Insets(0, 10, 0, 10));

        //-------------------Create the bottom pane----------------

        Button btnOk = new Button("OK");
        btnOk.setPrefWidth(80);
        btnOk.setOnAction(e -> btnOk_Click());

        Button btnCancel = new Button("Cancel");
        btnCancel.setPrefWidth(80);
        btnCancel.setOnAction(e -> btnCancel_Click());

        Region spacer = new Region();

        HBox paneBottom = new HBox(10, spacer, btnOk, btnCancel);
        paneBottom.setHgrow(spacer, Priority.ALWAYS);
        paneBottom.setPadding(new Insets(20, 10, 20, 10));

        //------------Finish the scene-------------
        BorderPane paneMain = new BorderPane();
        paneMain.setTop(paneTop);
        paneMain.setCenter(paneCenter);
        paneMain.setBottom(paneBottom);

        //Create the scene and stage
        Scene scene = new Scene(paneMain, 400, 375);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pizza Order");
        primaryStage.show();
    }

    public void btnOk_Click() {

        //Create a message string with the customer information
        String msg = "Customer: \n\n";
        msg += "\t" + txtName.getText() + "\n";
        msg += "\t" + txtAddress.getText() + "\n";
        msg += "\t" + txtPhone.getText() + "\n\n";
        msg += "You have ordered a ";

        //Add the pizza size
        if(rdoSmall.isSelected()) msg += "small ";
        if(rdoMedium.isSelected()) msg += "medium ";
        if(rdoLarge.isSelected()) msg += "large ";

        //Add the crust style
        if(rdoThin.isSelected()) msg += "thin crust with ";
        if(rdoThick.isSelected()) msg += "thick crust with ";

        //Add the Toppings
        String toppings = "";
        toppings = buildToppings(chkPepperoni, toppings);
        toppings = buildToppings(chkSausage, toppings);
        toppings = buildToppings(chkLinguica, toppings);
        toppings = buildToppings(chkOlives, toppings);
        toppings = buildToppings(chkTomatoes, toppings);
        toppings = buildToppings(chkMushrooms, toppings);
        toppings = buildToppings(chkAnchovies, toppings);
        if(toppings.equals("")) {
            msg += "no toppings.";
        } else {
            msg += "the toppings:\n" + toppings;
        }

        //Display the message
        MessageBox.show(msg, "OrderDetails");
    }

    public String buildToppings(CheckBox chk, String msg) {

        //Helper method for displaying the list of toppings
        if(chk.isSelected()) {
            if(!msg.equals("")) msg += ", ";
            msg += chk.getText();
        }
        return msg;
    }

    public void btnCancel_Click() {
        stage.close();
    }
}
