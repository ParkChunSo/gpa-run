package com.chun.gr.java.controller;

import com.chun.gr.java.model.enums.FxmlNm;
import com.chun.gr.java.model.enums.ImageNm;
import com.chun.gr.java.util.ImageUtils;
import com.chun.gr.java.util.ResourceUtil;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IntroController implements Initializable {

    @FXML
    StackPane stackPane;

    @FXML
    Pane signPane;

    @FXML
    SignController signController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

            stackPane.setBackground(ImageUtils.setBackgroundImage(ImageNm.Login_Page_Image));
//            signPane = FXMLLoader.load(getClass().getResource("../../res/fxml/sign.fxml"));
//            ObservableList<Node> children = stackPane.getChildren();
//            children.add(signPane);
            stackPane.setAlignment(Pos.CENTER);

            signController.setParentController(this);
            signController.toggleProperty().addListener((observable, oldValue, newValue) -> changeGuidePage());


    }
    private void changeGuidePage(){
        try {
            Parent guideParent = ResourceUtil.getParent(FxmlNm.guide);
            Parent introParent = stackPane.getScene().getRoot();
            ((StackPane) introParent).getChildren().clear();
            ((StackPane) introParent).getChildren().add(guideParent);

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
