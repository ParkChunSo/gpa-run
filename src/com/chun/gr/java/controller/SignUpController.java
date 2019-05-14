package com.chun.gr.java.controller;

import com.chun.gr.java.model.enums.ImageNm;
import com.chun.gr.java.util.ImageUtils;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;

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
    @FXML
    private Button loginBtn;
    @FXML
    private Button signUpBtn;

    private SignController signController;

    private BooleanProperty toggle = new SimpleBooleanProperty();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginBtn.setBackground(ImageUtils.setBackgroundImage(ImageNm.SignUP_Image));
        signUpBtn.setBackground(ImageUtils.setBackgroundImage(ImageNm.Cancel_Image));

        loginBtn.setOnAction(event ->{
            //TODO(회원가입 로직 작성)
        });

        signUpBtn.setOnAction(event -> {
            setToggle(!getToggle());
        });
    }
    public void setParentController(SignController signController){
        this.signController = signController;
    }

    public boolean getToggle() {
        return toggle.get();
    }

    public BooleanProperty toggleProperty() {
        return toggle;
    }

    public void setToggle(boolean state) {
        this.toggle.set(state);
    }
}
