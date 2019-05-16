package com.chun.gr.java.controller;

import com.chun.gr.java.model.enums.FxmlNm;
import com.chun.gr.java.model.enums.ImageNm;
import com.chun.gr.java.util.ResourceUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

public class IntroController implements Initializable {

    @FXML
    private StackPane introPane;

    @FXML
    private SignController signController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            introPane.setBackground(ResourceUtil.getBackgroundImage(ImageNm.Login_Page_Image));

            signController.setParentController(this);
            signController.toggleProperty().addListener((observable, oldValue, newValue) -> changeGuidePage());
    }

    private void changeGuidePage(){
//        try {
//            Parent guideParent = ResourceUtil.getParent(FxmlNm.guide);
//            Parent introParent = introPane.getScene().getRoot();
//            ((StackPane) introParent).getChildren().clear();
//            ((StackPane) introParent).getChildren().remove(introPane);
//            ((StackPane) introParent).getChildren().add(guideParent);
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }
        ResourceUtil.changePage((StackPane) introPane.getScene().getRoot(), introPane, FxmlNm.guide);
    }

}
