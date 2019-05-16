package com.chun.gr.java.controller;

import com.chun.gr.java.model.enums.ImageNm;
import com.chun.gr.java.util.ResourceUtil;
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
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable {
    @FXML
    private Pane loginPane;
    @FXML
    private TextField loginIdTb;
    @FXML
    private PasswordField loginPwTb;
    @FXML
    private Label loginWarningLbl;
    @FXML
    private Button loginBtn;
    @FXML
    private Button signUpBtn;

    private StringProperty id = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    // 회원가입 버튼 클릭시 true
    private BooleanProperty toggle = new SimpleBooleanProperty();
    private BooleanProperty toStart = new SimpleBooleanProperty();
    private SignController signController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginBtn.setOnAction(event -> {
            // TODO(로그인 로직 작성)
            setToStart(!isToStart());
        });
        signUpBtn.setOnAction(event -> {
            setToggle(!getToggle());
        });

        loginBtn.setBackground(ResourceUtil.getBackgroundImage(ImageNm.GameStart_Image));
        signUpBtn.setBackground(ResourceUtil.getBackgroundImage(ImageNm.SignUP_Image));
    }

    public boolean getToggle() {
        return toggle.get();
    }

    public BooleanProperty toggleProperty() {
        return toggle;
    }

    public void setToggle(boolean toggle) {
        this.toggle.set(toggle);
    }

    public boolean isToStart() {
        return toStart.get();
    }

    public BooleanProperty toStartProperty() {
        return toStart;
    }

    public void setToStart(boolean toStart) {
        this.toStart.set(toStart);
    }

    public void setParentController(SignController signController){
        this.signController = signController;
    }
}
