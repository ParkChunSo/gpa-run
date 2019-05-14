package com.chun.gr.java.controller;

import com.chun.gr.java.model.enums.ImageNm;
import com.chun.gr.java.util.ImageUtils;
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

        loginBtn.setBackground(ImageUtils.setBackgroundImage(ImageNm.GameStart_Image));
        signUpBtn.setBackground(ImageUtils.setBackgroundImage(ImageNm.SignUP_Image));
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
