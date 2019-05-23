package com.MyFilmProjApp.views;

import com.MyFilmProjApp.SQL.SqlUtils;
import com.MyFilmProjApp.UserProperties.UserUtils;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.layout.layer.PopupView;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class RegisterPresenter {

    @FXML
    private View registerView;

    @FXML
    private Button occButton;

    @FXML
    private Button ageButton;

    @FXML
    private  Button genderButton;

    @FXML
    private  Button inscrButton;

    @FXML
    private TextField textMail;

    @FXML
    private TextField textMdp;

    @FXML
    private TextField textPseudo;


    /*NE PAS OUBLIER LE "fx" dans le fxml pour récupérer l'instance !!*/

    /**
     * Passe à la vue des films si inscription réussi
     */
    @FXML
    void inscrButtonClick(){
        System.out.println("textMail "+textMail.getText());
        System.out.println("textMdp "+textMdp.getText());
        System.out.println("textPseudo "+textPseudo.getText());
        System.out.println("Occupation "+occButton.getText());

        SqlUtils sql = new SqlUtils();
        sql.signIn(textPseudo.getText(), textMdp.getText(), textMail.getText(),
                genderButton.getText(), ageButton.getText(), occButton.getText());

        MobileApplication.getInstance().switchView("Secondary View");
    }
    /**
     * Initialise la présentation Register
     */
    public void initialize() {

        /*Age*/
        ageButton.setGraphic(new Icon(MaterialDesignIcon.ARROW_DROP_DOWN));
        ageButton.getStyleClass().add("flat");
        ageButton.setStyle("-fx-border-color: lightgray; -fx-border-width: 0 0 1 0");
        ageButton.setContentDisplay(ContentDisplay.RIGHT);

        PopupView popupAge = new PopupView(ageButton);

        VBox vBoxAge = new VBox();
        for (UserUtils.AgeInterval age : UserUtils.AgeInterval.values()) {
            Button item = new Button(UserUtils.getAgeToString(age));
            item.setPrefWidth(100);
            item.getStyleClass().add("flat");
            item.setOnAction(e -> {
                ageButton.setText(UserUtils.getAgeToString(age));
                System.out.println(UserUtils.getAgeToString(age));
                popupAge.hide();
            });
            vBoxAge.getChildren().add(item);
        }
        ScrollPane scrollPaneAge = new ScrollPane(vBoxAge);
        scrollPaneAge.setMaxHeight(200);
        scrollPaneAge.setPrefWidth(110);

        popupAge.setContent(scrollPaneAge);

        ageButton.setOnAction(event -> popupAge.show());



        /*Occupation*/
        occButton.setGraphic(new Icon(MaterialDesignIcon.ARROW_DROP_DOWN));
        occButton.getStyleClass().add("flat");
        occButton.setStyle("-fx-border-color: lightgray; -fx-border-width: 0 0 1 0");
        occButton.setContentDisplay(ContentDisplay.RIGHT);

        PopupView popupOcc = new PopupView(occButton);

        VBox vBoxOcc = new VBox();
        for (UserUtils.Occupation occ : UserUtils.Occupation.values()) {
            Button item = new Button(UserUtils.getOccupToString(occ));
            item.setPrefWidth(100);
            item.getStyleClass().add("flat");
            item.setOnAction(e -> {
                occButton.setText(UserUtils.getOccupToString(occ));
                System.out.println(UserUtils.getOccupToString(occ));
                popupOcc.hide();
            });
            vBoxOcc.getChildren().add(item);
        }
        ScrollPane scrollPaneOcc = new ScrollPane(vBoxOcc);
        scrollPaneOcc.setMaxHeight(200);
        scrollPaneOcc.setPrefWidth(110);

        popupOcc.setContent(scrollPaneOcc);

        occButton.setOnAction(event -> popupOcc.show());

        /*Gender*/
        genderButton.setGraphic(new Icon(MaterialDesignIcon.ARROW_DROP_DOWN));
        genderButton.getStyleClass().add("flat");
        genderButton.setStyle("-fx-border-color: lightgray; -fx-border-width: 0 0 1 0");
        genderButton.setContentDisplay(ContentDisplay.RIGHT);

        PopupView popupGender = new PopupView(genderButton);

        VBox vBoxGender = new VBox();
        for (UserUtils.Gender gen : UserUtils.Gender.values()) {
            Button item = new Button(UserUtils.getGenderToString(gen));
            item.setPrefWidth(100);
            item.getStyleClass().add("flat");
            item.setOnAction(e -> {
                genderButton.setText(UserUtils.getGenderToString(gen));
                System.out.println(UserUtils.getGenderToString(gen));
                popupGender.hide();
            });
            vBoxGender.getChildren().add(item);
        }
        ScrollPane scrollPaneGender = new ScrollPane(vBoxGender);
        scrollPaneGender.setMaxHeight(200);
        scrollPaneGender.setPrefWidth(110);

        popupGender.setContent(scrollPaneGender);

        genderButton.setOnAction(event -> popupGender.show());

    }
}
