/*
 * @author Tom Tsiliopoulos
 * @author Taylor Bazouzi 100579090
 * @created 10-12-2021
 *
 *        A simple JavaFX program that display labels
 *        and changes label text when button is clicked
 *        and label appearance when hovered over
 */
package ca.durhamcollege.oop3200f2021week13;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
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

        // Step 1 - instantiate controls
        Label hellolabel = new Label("Hello, World!");
        Label goodbyelabel = new Label("Goodbye, World!");
        Button clickmebutton = new Button("Click me!");

        // instantiate contaneirs - step 1
        GridPane row0 = BuildRow0(hellolabel, goodbyelabel);

        GridPane row1 = BuildRow1(hellolabel, goodbyelabel);

        GridPane row2 = BuildRow2(clickmebutton);


        VBox vbox = new VBox(row0, row1, row2); // like a Vertical Stack (like a vertical list ) - Row Data
        vbox.setStyle("-fx-border-color: blue; -fx-border-width: 1px; -fx-font-family: Consolas");

        // Step 3 -  setup and configure Scene
        Scene scene = new Scene(vbox, 640, 480);
        // Step 4 - setup  stage
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    private GridPane BuildRow0(Label helloLabel, Label goodbyelabel) {
        GridPane row = new GridPane();
        row.setStyle("-fx-border-color: red; " +
                "-fx-border-width: 1px; " +
                "-fx-font-family: Garamond;" +
                "-fx-font-size: 20px");

        helloLabel.setStyle("-fx-font-family: 'Arial Black'; -fx-font-weight: bold; -fx-text-fill: green;");
        ColumnConstraints column0 = new ColumnConstraints();
        column0.setPercentWidth(17); // two columns - each at 8%
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(33); // four columns
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(33); // four columns
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(17); // two columns
        row.getColumnConstraints().addAll(column0, column1, column2, column3);

        HBox hbox = new HBox(helloLabel);
        hbox.setAlignment(Pos.CENTER);
        hbox.setStyle("-fx-border-color: black; -fx-border-width: 1px;");

        row.add(hbox, 1, 0);
        row.add(goodbyelabel, 2, 0);

        //var firstNode = row.getChildren().get(0);
        //firstNode.setVisible(false);
        return row;
    }
    private GridPane BuildRow1(Label hellolabel, Label goodbyelabel)
    {
        GridPane row = new GridPane();
        row.setStyle("-fx-border-color: blue; -fx-border-width: 1px");

        hellolabel.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                hellolabel.setStyle("-fx-font-weight: bold");
            }
        });

        hellolabel.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                hellolabel.setStyle("-fx-font-weight: normal");
            }
        });

        ColumnConstraints column0 = new ColumnConstraints();
        column0.setPercentWidth(9); // 2 columns - each @ 8%
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(49); // 4 columns
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(25); // 4 columns
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(17); // 2 columns
        row.getColumnConstraints().addAll(column0, column1, column2, column3);

        row.add(hellolabel, 1, 0);
        row.add(goodbyelabel, 2, 0);

        return row;
    }



/*
        HBox hbox = new HBox(hellolabel, clickmebutton);
        VBox vbox = new VBox(helloLabel, clickmebutton);

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
        hellolabel.setPadding();
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().add(hellolabel);
        hbox.getChildren().add(goodbyelabel);

        System.out.println(hbox.getChildren());

        Scene scene = new Scene(hbox, 640, 480);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/
        private GridPane BuildRow2(Button button)
        {
            GridPane row = new GridPane();

            ColumnConstraints column0 = new ColumnConstraints();
            column0.setPercentWidth(17); // two columns - each column is 8%
            ColumnConstraints column1 = new ColumnConstraints();
            column1.setPercentWidth(33); // four columns
            ColumnConstraints column2 = new ColumnConstraints();
            column2.setPercentWidth(33); // four columns
            ColumnConstraints column3 = new ColumnConstraints();
            column3.setPercentWidth(17); // two columns
            row.getColumnConstraints().addAll(column0, column1, column2, column3);

            button.setOnAction(new EventHandler()
            {

                @Override
                public void handle(Event event)
                {
                    System.out.println("ClickMeButton Clicked!");
                    button.setText("Clicked!");
                }

            });

            button.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent)
                {
                    button.setStyle("-fx-opacity: 0.5");
                }

            });


            button.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    button.setStyle("-fx-opacity: 1.0");
                }
            });

            row.add(button, 2, 0);
            return row;
        }


    public static void main(String[] args) {
        launch();
    }
}