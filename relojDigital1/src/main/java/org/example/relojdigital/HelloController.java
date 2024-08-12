package org.example.relojdigital;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class HelloController {
    @FXML
    private Label relojLabel;
    @FXML
    private Label fechaLabel;

    @FXML
    private Label diaSemanaLabel;

    private DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    private DateTimeFormatter formatoFecha=DateTimeFormatter.ofPattern("dd/MM");

    public void initialize() {
        Font customFont = Font.loadFont(getClass().getResourceAsStream("Cattie-Regular.ttf"),80);
        Timeline lineaTiempo = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            LocalTime tiempoActual = LocalTime.now();
            LocalDate fechaActual=LocalDate.now();
            relojLabel.setText(tiempoActual.format(formatoHora));
            relojLabel.setFont(customFont);
            fechaLabel.setText(fechaActual.format(formatoFecha));
//            fechaLabel.setFont(customFont);
            String diasemanal=fechaActual.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
            diaSemanaLabel.setText(diasemanal);
//            diaSemanaLabel.setFont(customFont);
        }));

        lineaTiempo.setCycleCount(Animation.INDEFINITE);
        lineaTiempo.play();
    }
}