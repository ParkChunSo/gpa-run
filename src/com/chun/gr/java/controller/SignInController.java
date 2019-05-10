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
    TextField loginIdTb;
    @FXML
    PasswordField loginPwTb;
    @FXML
    Label loginWarningLbl;

    private String id;
    private String password;
    private SignController signController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginIdTb.setOnKeyPressed(event -> {
            id = loginIdTb.getText();
        });

        loginPwTb.setOnKeyPressed(event -> {
            password = loginPwTb.getText();
        });
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setParentController(SignController signController){
        this.signController = signController;
    }
}
