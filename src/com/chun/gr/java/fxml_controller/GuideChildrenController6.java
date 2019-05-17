package com.chun.gr.java.fxml_controller;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class GuideChildrenController6 implements Initializable {
    @FXML
    private Button nextBtn;
    private BooleanProperty toggle = new SimpleBooleanProperty();
    private GuideController guideController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nextBtn.setOnAction(event -> setToggle(!isToggle()));
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

    public void setParentController(GuideController guideController) {
        this.guideController = guideController;
    }
}
