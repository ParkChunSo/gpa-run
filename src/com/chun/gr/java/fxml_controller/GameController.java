package com.chun.gr.java.fxml_controller;

import com.chun.gr.java.controller.PlayController;
import com.chun.gr.java.controller.SpriteController;
import com.chun.gr.java.model.enums.ImageNm;
import com.chun.gr.java.util.ResourceUtil;
import javafx.animation.Animation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * =================  할 일  =================
 * 1. key 이벤트(UP, Down, Z)
 *  - Up은 ImageView에 TimeLine이벤트 걸어서 위 아래로
 *  - Z는 점수(게이지) 확인해서 일정 이상일 경우 fever로 변신 가능
 * 2. 나머지 UI 삽입
 * 3. Animation(Thread) 관리 => 일시정지 기능
 * 4. 결과 화면 보고 다시하기 기능 추가
 *
 * 5. 가능 하다면 메인 화면 추가
 */
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

        ImageView character = new ImageView();
        character.toFront();
        gamePane.getChildren().add(character);
        Animation spriteController = new SpriteController(character);
        spriteController.play();
    }
}
