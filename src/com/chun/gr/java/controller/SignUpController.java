package com.chun.gr.java.controller;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
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

    private BooleanProperty state = new SimpleBooleanProperty();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginBtn.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("../../res/img/SignUP_Image.png").toString()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true))));
        signUpBtn.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("../../res/img/Cancel_Image.png").toString()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true))));

        loginBtn.setOnAction(event ->{
            //TODO(회원가입 로직 작성)
        });

        signUpBtn.setOnAction(event -> {
            setState(!getState());
        });
    }
    public void setParentController(SignController signController){
        this.signController = signController;
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
}
