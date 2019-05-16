package com.chun.gr.java.controller;

import com.chun.gr.java.model.enums.ImageNm;
import com.chun.gr.java.util.ResourceUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class GuideController implements Initializable {
    @FXML
    private StackPane guidePane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        guidePane.setBackground(ResourceUtil.getBackgroundImage(ImageNm.Background_image));
    }
}
