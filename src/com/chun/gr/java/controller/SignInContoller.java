package com.chun.gr.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class SignInContoller {
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
}
