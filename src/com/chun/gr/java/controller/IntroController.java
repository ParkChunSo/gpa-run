package com.chun.gr.java.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IntroController implements Initializable {

    @FXML
    StackPane stackPane;

    @FXML
    Pane signPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Image img = new Image(getClass().getResource("../../res/img/Login_Page_Image.png").toString());
            stackPane.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true))));
            signPane = FXMLLoader.load(getClass().getResource("../../res/fxml/sign.fxml"));
            ObservableList<Node> children = stackPane.getChildren();
            children.add(signPane);
            stackPane.setAlignment(Pos.CENTER);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
