package com.chun.gr.java.controller;

import com.chun.gr.java.model.StateModel;
import com.chun.gr.java.model.constants.GameConstant;
import com.chun.gr.java.model.enums.ImageNm;
import com.chun.gr.java.model.enums.StateType;
import com.chun.gr.java.util.ResourceUtil;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class PlayController {
    private StateModel state;
    private Timeline backgroundThread1;
    private Timeline backgroundThread2;
    private SpriteAnimation characterThread;

    public PlayController() {
        state = new StateModel();
    }

    public void playBackgroundThread(DoubleProperty BG1Property, DoubleProperty BG2Property, DoubleProperty BGF1Property, DoubleProperty BGF2Property) {
        backgroundThread1 = new Timeline(
                new KeyFrame(Duration.seconds(GameConstant.BACKGROUND_SPEED), new KeyValue(BG1Property, -800))
                , new KeyFrame(Duration.seconds(GameConstant.BACKGROUND_SPEED), new KeyValue(BG2Property, -800))
        );
        backgroundThread1.setCycleCount(Timeline.INDEFINITE);
        backgroundThread1.play();

        backgroundThread2 = new Timeline(
                new KeyFrame(Duration.seconds(GameConstant.BACKGROUND_FRONT_SPEED), new KeyValue(BGF1Property, -800))
                , new KeyFrame(Duration.seconds(GameConstant.BACKGROUND_FRONT_SPEED), new KeyValue(BGF2Property, -800))

        );
        backgroundThread2.setCycleCount(Timeline.INDEFINITE);
        backgroundThread2.play();
    }

    public void playCharacterThread(ImageView characterImageView){
        characterThread = new SpriteAnimation(characterImageView);
        characterThread.play();
    }

    public void setOtherCharacterMotion(KeyCode keyCode){
        switch (keyCode){
            case UP:
                break;
            case DOWN:
                if(state.getStateType() == StateType.RUN || state.getStateType() == StateType.SLIDING)
                characterThread.setOtherMotion(ResourceUtil.getImage(ImageNm.Sliding),GameConstant.CHARACTER_SLIDING_LAYOUT_X, GameConstant.CHARACTER_SLIDING_LAYOUT_Y,
                        GameConstant.CHARACTER_SLIDING_IMAGE_WIDTH, GameConstant.CHARACTER_SLIDING_IMAGE_HEIGHT);
                break;
            case Z:
                if(state.getHitPoint() == GameConstant.MAX_HIT_POINT){
                    state.setHitPoint(0);
                    characterThread.setOtherMotion(ResourceUtil.getImage(ImageNm.fever),GameConstant.CHARACTER_SLIDING_LAYOUT_X, GameConstant.CHARACTER_SLIDING_LAYOUT_Y,
                            GameConstant.CHARACTER_SLIDING_IMAGE_WIDTH, GameConstant.CHARACTER_SLIDING_IMAGE_HEIGHT);
                }
                break;
            case X:
                characterThread.setOtherMotion(ResourceUtil.getImage(ImageNm.fever),GameConstant.CHARACTER_SLIDING_LAYOUT_X, GameConstant.CHARACTER_SLIDING_LAYOUT_Y,
                        GameConstant.CHARACTER_SLIDING_IMAGE_WIDTH, GameConstant.CHARACTER_SLIDING_IMAGE_HEIGHT);
                break;
        }
    }

    public void setRunMotion(){
        state.setStateType(StateType.RUN);
        characterThread.setOtherMotion(ResourceUtil.getImage(ImageNm.Character_Run_Image),GameConstant.CHARACTER_RUN_LAYOUT_X, GameConstant.CHARACTER_RUN_LAYOUT_Y,
                GameConstant.CHARACTER_RUN_IMAGE_WIDTH, GameConstant.CHARACTER_RUN_IMAGE_HEIGHT);
    }

    public void pause(){
        backgroundThread1.pause();
        backgroundThread2.pause();
        characterThread.pause();
    }

    public void playOnPause(){
        backgroundThread1.play();
        backgroundThread2.play();
        characterThread.play();
    }

    private void transformToFever(){

    }

    private void createJelly(){

    }

    private void createBottomObstacle(){

    }

    private void createUpObstacle(){

    }
}
