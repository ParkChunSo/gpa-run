package com.chun.gr.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    Pane signUpPane;
    @FXML
    TextField singUpIdTb;
    @FXML
    PasswordField signUpPwTb;
    @FXML
    TextField signUpNmTb;
    @FXML
    TextField signUpSnTb;
    @FXML
    Button signUP_Overlap_Btn;

    private SignController signController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setParentController(SignController signController){
        this.signController = signController;
    }
}
