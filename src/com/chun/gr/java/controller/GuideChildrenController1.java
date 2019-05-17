package com.chun.gr.java.controller;

import com.chun.gr.java.model.enums.ImageNm;
import com.chun.gr.java.util.ResourceUtil;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class GuideChildrenController1 implements Initializable {
    @FXML
    private AnchorPane children1;

    @FXML
    private Button nextBtn;
    private BooleanProperty toggle = new SimpleBooleanProperty();
    private GuideController guideController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        children1.setBackground(ResourceUtil.getBackgroundImage(ImageNm.Information1));
        nextBtn.setBackground(ResourceUtil.getBackgroundImage(ImageNm.Yes_btn));
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
