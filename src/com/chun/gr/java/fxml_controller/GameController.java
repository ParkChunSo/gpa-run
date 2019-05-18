package com.chun.gr.java.fxml_controller;

import com.chun.gr.java.model.enums.ImageNm;
import com.chun.gr.java.util.ResourceUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private StackPane rootPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpBeforePlay();

    }

    private void setUpBeforePlay(){
        rootPane.setBackground(null);

        ImageView backgroundImgView = new ImageView(ResourceUtil.getImage(ImageNm.Background_image));
        ImageView backgroundFrontImgView = new ImageView(ResourceUtil.getImage(ImageNm.BackGround_Front_Image));

        rootPane.getChildren().addAll(backgroundImgView,backgroundFrontImgView);
    }
}
