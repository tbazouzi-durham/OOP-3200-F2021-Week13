/*
 * @author Tom Tsiliopoulos
 * @author Taylor Bazouzi 100579090
 * @created 10-12-2021
 *
 *        A simple JavaFX program that display labels
 *        and changes label text when button is clicked
 *
 */
package ca.durhamcollege.oop3200f2021week13;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HelloApplication extends Application {
    public static int WIDTH = 640;
    public static int HEIGHT = 480;

    @Override
    public void start(Stage stage) throws IOException {

        Label hellolabel = new Label("Hello, World!");
        Label goodbyelabel = new Label("Goodbye, World!");
        Button clickmebutton = new Button("Click me!");

        // control configuration
        Font font = Font.font("Consolas", FontWeight.BOLD, 30);
        clickmebutton.setFont(font);

        clickmebutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("ClickMe Button Clicked!");

                hellolabel.setText("Clicked!");
            }
        });
        /*
        HBox hbox = new HBox(hellolabel, clickmebutton);
        VBox vbox = new VBox(helloLabel, clickmebutton);*/

        // create controls
        GridPane gridPane = new GridPane();

        gridPane.add(hellolabel, 1, 0);
        gridPane.add(goodbyelabel, 1, 1);
        gridPane.add(clickmebutton, 2, 2);

        // add layout container
        Scene scene = new Scene(gridPane, WIDTH, HEIGHT);

        // add scene to stage
        stage.setScene(scene);

        stage.show();
    }
        /*hellolabel.setPadding();
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().add(hellolabel);
        hbox.getChildren().add(goodbyelabel);

        System.out.println(hbox.getChildren());

        Scene scene = new Scene(hbox, 640, 480);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/


    public static void main(String[] args) {
        launch();
    }
}