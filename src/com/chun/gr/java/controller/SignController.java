package com.chun.gr.java.controller;

import com.chun.gr.java.model.enums.ImageNm;
import com.chun.gr.java.util.ImageUtils;
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
        signPane.setBackground(ImageUtils.setBackgroundImage(ImageNm.login_Image));

        signInController.setParentController(this);
        signUpController.setParentController(this);

        signInController.stateProperty().addListener((observable, oldValue, newValue) -> changeIn2Up());
        signUpController.stateProperty().addListener((observable, oldValue, newValue) -> changeUp2In());
    }

    private void changeIn2Up(){
        signPane.getChildren().forEach(node -> {
            if(node.getId().equals("signUpPane")){
                node.setVisible(true);
            } else if(node.getId().equals("loginPane")){
                node.setVisible(false);
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
