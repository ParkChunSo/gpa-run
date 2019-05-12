package com.chun.gr.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SignController implements Initializable {
    @FXML
    private Pane signPane;
    @FXML
    private SignInController signInController;
    @FXML
    private SignUpController signUpController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image img = new Image(getClass().getResource("../../res/img/login_Image.png").toString());
        signPane.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true))));

        signInController.setParentController(this);
        signUpController.setParentController(this);

        signInController.stateProperty().addListener((observable, oldValue, newValue) -> changeIn2Up());
        signUpController.stateProperty().addListener((observable, oldValue, newValue) -> changeUp2In());
    }

    private void changeIn2Up(){
        signPane.getChildren().forEach(node -> {
            if(node.getId().equals("loginPane")){
                node.setVisible(false);
            } else if(node.getId().equals("signUpPane")){
                node.setVisible(true);
            }
        });
    }
    private void changeUp2In(){
        signPane.getChildren().forEach(node -> {
            if(node.getId().equals("loginPane")){
                node.setVisible(true);
            } else if(node.getId().equals("signUpPane")){
                node.setVisible(false);
            }
        });
    }
}
