package com.chun.gr.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable {
    @FXML
    Pane loginPane;
    @FXML
    Button signUpBtn;
    @FXML
    TextField loginIdTb;
    @FXML
    PasswordField loginPwTb;
    @FXML
    Button loginBtn;
    @FXML
    Label loginWarningLbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
