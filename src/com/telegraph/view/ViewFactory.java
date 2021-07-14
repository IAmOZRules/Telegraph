package com.telegraph.view;

import com.telegraph.EmailManager;
import com.telegraph.controller.BaseController;
import com.telegraph.controller.LoginWindowController;
import com.telegraph.controller.MainWindowController;
import com.telegraph.controller.OptionsWindowController;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class ViewFactory {
    private EmailManager emailManager;

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    // View Options Handling
    private ColorTheme colorTheme = ColorTheme.DEFAULT;
    private FontSize fontSize = FontSize.REGULAR;

    public void showLoginWindow() {
        BaseController controller = new LoginWindowController(emailManager, this, "LoginWindow.fxml");
        initStage(controller, false);
    }

    public void showMainWindow() {
        BaseController controller = new MainWindowController(emailManager, this, "MainWindow.fxml");
        initStage(controller, true);
    }

    public void showOptionsWindow() {
        BaseController controller = new OptionsWindowController(emailManager, this, "OptionsWindow.fxml");
        initStage(controller, false);
    }

    public void closeStage(Stage stageToClose) {
        stageToClose.close();
    }

    private void initStage(BaseController baseController, Boolean resizeableFlag) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
        fxmlLoader.setController(baseController);
        Parent parent;

        try {
            parent = fxmlLoader.load();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setResizable(resizeableFlag);
        stage.setScene(scene);
        stage.show();
    }
}
