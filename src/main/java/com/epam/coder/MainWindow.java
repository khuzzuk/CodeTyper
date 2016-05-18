package com.epam.coder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainWindow extends Application {

    private CodeText codeText;
    private TextArea area;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        codeText = new CodeText();
        codeText.loadText();
        AnchorPane pane = new AnchorPane();
        Scene scene = new Scene(pane, 800, 600);
        scene.getStylesheets().add("window.css");
        primaryStage.setScene(scene);
        area = new TextArea();
        area.addEventFilter(KeyEvent.KEY_PRESSED,this::handleCoding);
        area.setStyle("-fx-text-fill: green; -fx-font-size: 16;");
        area.setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));
        pane.getChildren().addAll(area);
        area.setPrefSize(800,600);
        area.setText(codeText.getText());
        primaryStage.show();
    }
    public void handleCoding(KeyEvent event){
        switch (event.getCode()){
            case BACK_SPACE:
                area.setText(null);
                area.setText(codeText.getPreviousText());
                break;
            default:
                area.setText(null);
                area.setText(codeText.getNextText());
        }
    }
}
