package com.chun.gr.java.fxml_controller;

import com.chun.gr.java.controller.PlayController;
import com.chun.gr.java.controller.SpriteAnimation;
import com.chun.gr.java.model.enums.ImageNm;
import com.chun.gr.java.model.enums.StateType;
import com.chun.gr.java.util.ResourceUtil;
import javafx.animation.Animation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
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

//    PlayController playController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PlayController playController = new PlayController();

        ImageView backgroundImgView1 = new ImageView(ResourceUtil.getImage(ImageNm.Background_image));
        ImageView backgroundImgView2 = new ImageView(ResourceUtil.getImage(ImageNm.Background_image));
        ImageView backgroundFrontImgView1 = new ImageView(ResourceUtil.getImage(ImageNm.BackGround_Front_Image));
        ImageView backgroundFrontImgView2 = new ImageView(ResourceUtil.getImage(ImageNm.BackGround_Front_Image));
        backgroundImgView2.setLayoutX(800);
        backgroundFrontImgView2.setLayoutX(800);

        ImageView character = new ImageView();
        character.toFront();
        character.setFocusTraversable(true);    // 주인공 케릭터에게 포커스, Key 이벤트를 이미지 뷰에 받는다.

        ImageView basicUiImgView = new ImageView(ResourceUtil.getImage(ImageNm.UI));
        ImageView gaugeImgView = new ImageView(ResourceUtil.getImage(ImageNm.Gage_Image));
        gaugeImgView.setFitWidth(20);gaugeImgView.setFitHeight(19);
        gaugeImgView.setLayoutX(81);gaugeImgView.setLayoutY(69);

        Label score = new Label();


        character.setOnKeyPressed(event -> playController.setOtherCharacterMotion(event.getCode()));
        character.setOnKeyReleased(event -> {
            if(event.getCode() == KeyCode.DOWN) {
                playController.setRunMotion();
            }
            else if(event.getCode() == KeyCode.UP) {
                playController.setStateType(StateType.RUN);
            }
        });


        playController.playBackgroundThread(backgroundImgView1.translateXProperty(), backgroundImgView2.translateXProperty(), backgroundFrontImgView1.translateXProperty(), backgroundFrontImgView2.translateXProperty());
        playController.playCharacterThread(character);

        gamePane.getChildren().addAll(backgroundImgView1, backgroundImgView2, backgroundFrontImgView1, backgroundFrontImgView2,
                character, basicUiImgView,gaugeImgView);



    }
}
