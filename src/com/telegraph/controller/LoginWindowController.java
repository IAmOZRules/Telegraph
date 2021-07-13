package com.telegraph.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

import com.telegraph.EmailManager;
import com.telegraph.view.ViewFactory;

public class LoginWindowController extends BaseController {


    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField emailAddressField;

    @FXML
    private Label errorLabel;

    @FXML
    void loginButtonAction() {
        System.out.println("Login Button is the CLick");
    }

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }
}
