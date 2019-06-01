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
    private Timeline objectThread;
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
                if(state.getStateType() == StateType.RUN || state.getStateType() == StateType.FEVER) {
                    state.setStateType(StateType.JUMP);
                    characterThread.createJumpAnimation().start();
                }
                break;

            case DOWN:
                if(state.getStateType() == StateType.RUN || state.getStateType() == StateType.SLIDING) {
                    state.setStateType(StateType.SLIDING);
                    characterThread.setOtherMotion(ResourceUtil.getImage(ImageNm.Sliding), GameConstant.CHARACTER_SLIDING_LAYOUT_X, GameConstant.CHARACTER_SLIDING_LAYOUT_Y,
                            GameConstant.CHARACTER_SLIDING_IMAGE_WIDTH, GameConstant.CHARACTER_SLIDING_IMAGE_HEIGHT);
                }
                break;

            case Z:
                if(state.getHitPoint() == GameConstant.MAX_HIT_POINT){
                    state.setHitPoint(0);
                    state.setStateType(StateType.FEVER);
                    characterThread.setOtherMotion(ResourceUtil.getImage(ImageNm.fever),GameConstant.CHARACTER_FEVER_LAYOUT_X, GameConstant.CHARACTER_FEVER_LAYOUT_Y,
                            GameConstant.CHARACTER_FEVER_IMAGE_WIDTH, GameConstant.CHARACTER_FEVER_IMAGE_HEIGHT);
                }
                break;

            case ESCAPE:
                if(state.getStateType().equals(StateType.PAUSE)){
                    state.setStateType(StateType.RUN);
                    backgroundThread1.play();
                    backgroundThread2.play();
                    characterThread.play();
                }else{
                    state.setStateType(StateType.PAUSE);
                    backgroundThread1.pause();
                    backgroundThread2.pause();
                    characterThread.pause();
                }
                break;
        }
    }

    public void setRunMotion(){
        state.setStateType(StateType.RUN);
        characterThread.setOtherMotion(ResourceUtil.getImage(ImageNm.Character_Run_Image),GameConstant.CHARACTER_RUN_LAYOUT_X, GameConstant.CHARACTER_RUN_LAYOUT_Y,
                GameConstant.CHARACTER_RUN_IMAGE_WIDTH, GameConstant.CHARACTER_RUN_IMAGE_HEIGHT);
    }

    private void transformToFever(){

    }

    private KeyFrame createJelly(ImageView jelly, int x, int y, int width, int height, int speed){
//        KeyFrame keyFrame = new KeyFrame(Duration.INDEFINITE, )
//        KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(0.002), new EventHandler<ActionEvent>() {
//
//            public void handle(ActionEvent event) {
//                double imageMinX = image_jelly.getBoundsInParent().getMinX();
//                double imageMaxY = image_jelly.getBoundsInParent().getMaxY();
//                if (imageMinX > Game_Maincharacter_ImageView.getBoundsInParent().getMinX()
//                        && imageMinX < Game_Maincharacter_ImageView.getBoundsInParent().getMaxX()
//                        && imageMaxY < Game_Maincharacter_ImageView.getBoundsInParent().getMaxY()
//                        && imageMaxY > Game_Maincharacter_ImageView.getBoundsInParent().getMinY()) {
//                    image_jelly.setImage(null);
//                    image_jelly.setLayoutX(0);
//                    Game_GageBar_ImageView.setFitWidth(Game_GageBar_ImageView.getFitWidth() + 3);
//                    Game_Score_Label.setText("" + control.setJellySocre());
//                    if (fever == true) {
//                        Game_GageBar_ImageView.setFitWidth(Game_GageBar_ImageView.getFitWidth() - 6);
//
//                    }
//
//                }
//                if (Game_GageBar_ImageView.getFitWidth() > 300) {
//
//                    splite_image.seting_fever_sprite(Game_Maincharacter_ImageView, animation, splite_image);
//                    fever = true;
//                }
//                if (Game_GageBar_ImageView.getFitWidth() < 50) {
//                    fever = false;
//                    animation.stop();
//                    splite_image.seting_run_sprite(Game_Maincharacter_ImageView, animation, splite_image);
//                    animation.play();
//                }
//                image_jelly.setTranslateX(image_jelly.getTranslateX() + dx);
//            }
//        });
//        timeLine_jelly.getKeyFrames().add(move_jelly);
//        timeLine_jelly.play();
//        Game_pane.getChildren().add(image_jelly);
//        i++;
        return null;
    }

    private void createBottomObstacle(){

    }

    private void createUpObstacle(){

    }

    public StateModel getState(){
        return state;
    }

    public void setStateType(StateType stateType){
        state.setStateType(stateType);
    }
}
