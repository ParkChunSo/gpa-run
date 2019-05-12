package com.chun.gr.java.controller;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

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
    @FXML
    private Button loginBtn;
    @FXML
    private Button signUpBtn;

    private StringProperty id = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    // 회원가입 버튼 클릭시 true
    private BooleanProperty state = new SimpleBooleanProperty();
    private SignController signController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginBtn.setOnAction(event -> {
            // TODO(로그인 로직 작성)
        });
        signUpBtn.setOnAction(event -> {
            setState(!getState());
        });

        loginBtn.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("../../res/img/GameStart_Image.png").toString()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true))));
        signUpBtn.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("../../res/img/SignUP_Image.png").toString()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true))));
    }

    public boolean getState() {
        return state.get();
    }

    public BooleanProperty stateProperty() {
        return state;
    }

    public void setState(boolean state) {
        this.state.set(state);
    }

    public void setParentController(SignController signController){
        this.signController = signController;
    }
}
