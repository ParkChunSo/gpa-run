package com.chun.gr.java.fxml_controller;

import com.chun.gr.java.controller.PlayController;
import com.chun.gr.java.model.enums.ImageNm;
import com.chun.gr.java.util.ResourceUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private Pane gamePane;

    PlayController playController = new PlayController();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpBackground();

    }

    private void setUpBackground() {
        ImageView backgroundImgView1 = new ImageView(ResourceUtil.getImage(ImageNm.Background_image));
        ImageView backgroundImgView2 = new ImageView(ResourceUtil.getImage(ImageNm.Background_image));
        ImageView backgroundFrontImgView1 = new ImageView(ResourceUtil.getImage(ImageNm.BackGround_Front_Image));
        ImageView backgroundFrontImgView2 = new ImageView(ResourceUtil.getImage(ImageNm.BackGround_Front_Image));
        backgroundImgView2.setLayoutX(800);
        backgroundFrontImgView2.setLayoutX(800);

        gamePane.getChildren().addAll(backgroundImgView1, backgroundImgView2, backgroundFrontImgView1, backgroundFrontImgView2);

        playController.playBackgroundThread(backgroundImgView1.translateXProperty(), backgroundImgView2.translateXProperty(), backgroundFrontImgView1.translateXProperty(), backgroundFrontImgView2.translateXProperty());
    }
}
