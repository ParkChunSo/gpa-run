package com.chun.gr.java.fxml_controller;

import com.chun.gr.java.model.enums.ImageNm;
import com.chun.gr.java.util.ResourceUtil;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private IntroController introController;

    private BooleanProperty toggle = new SimpleBooleanProperty();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        signPane.setBackground(ResourceUtil.getBackgroundImage(ImageNm.login_Image));

        signInController.setParentController(this);
        signUpController.setParentController(this);

        signInController.toStartProperty().addListener((observable, oldValue, newValue) -> setToggle(!isToggle()));
        signInController.toggleProperty().addListener((observable, oldValue, newValue) -> changeIn2Up());
        signUpController.toggleProperty().addListener((observable, oldValue, newValue) -> changeUp2In());
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

    public void setParentController(IntroController introController){
        this.introController = introController;
    }

    public boolean isToggle() {
        return toggle.get();
    }

    public BooleanProperty toggleProperty() {
        return toggle;
    }

    public void setToggle(boolean toggle) {
        this.toggle.set(toggle);
    }
}
