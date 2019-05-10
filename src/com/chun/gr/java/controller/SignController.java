package com.chun.gr.java.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignController implements Initializable {
    @FXML
    private Pane signPane;
    @FXML
    private Button loginBtn;
    @FXML
    private Button signUpBtn;
    @FXML
    private SignInController signInController;
    @FXML
    private SignUpController signUpController;

    private Pane loginPane;
    private Pane signUpPane;
    private boolean isLogin = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image img = new Image(getClass().getResource("../../res/img/login_Image.png").toString());
        signPane.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true))));

        img = new Image(getClass().getResource("../../res/img/SignUP_Image.png").toString());
        signUpBtn.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true))));

        img = new Image(getClass().getResource("../../res/img/GameStart_Image.png").toString());
        loginBtn.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true))));

        try {
            loginPane = (Pane) FXMLLoader.load(getClass().getResource("../../res/fxml/sign_in.fxml"));
            signUpPane = (Pane) FXMLLoader.load(getClass().getResource("../../res/fxml/sign_up.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        signPane.getChildren().add(loginPane);

        signInController.setParentController(this);
        signUpController.setParentController(this);

        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(isLogin) {
                    // 게임시작
                    System.out.println(signInController.getId());
                }else{
                    // 회원가입 완료
                    signPane.getChildren().remove(signPane);
                    signPane.getChildren().add(loginPane);
                }
                // TODO 서버에게 전송 및 게임시작 로직
                for (Node child : signPane.getChildren()) {
                    if(child.getId().equals("loginPane")){

                    }
                }

            }
        });

        signUpBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Image img;
                if(isLogin) {
                    // 회원가입
                    signPane.getChildren().remove(loginPane);
                    signPane.getChildren().add(signUpPane);
                    img = new Image(getClass().getResource("../../res/img/SignUP_Image.png").toString());
                    loginBtn.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true))));

                    img = new Image(getClass().getResource("../../res/img/Cancel_Image.png").toString());
                    signUpBtn.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true))));
                }else{
                    //취소 버튼
                    signPane.getChildren().remove(signUpPane);
                    signPane.getChildren().add(loginPane);
                    img = new Image(getClass().getResource("../../res/img/GameStart_Image.png").toString());
                    loginBtn.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true))));

                    img = new Image(getClass().getResource("../../res/img/SignUP_Image.png").toString());
                    signUpBtn.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true))));
                }
                isLogin = !isLogin;
            }
        });
    }
}
