module Telegraph {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;

    opens com.telegraph;
    opens com.telegraph.view;
    opens com.telegraph.controller;
}