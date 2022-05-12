/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxproject;

import javafx.scene.control.Alert;
import javafx.stage.Window;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Admin
 */
public class AlertHelper{
   public static boolean result = false;
    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        
        if (alertType.name() == null ? Alert.AlertType.ERROR.name() == null : alertType.name().equals(Alert.AlertType.ERROR.name())) {
            Notifications.create()
                    .title(title)
                    .text(message).hideAfter(Duration.seconds(10))
                    .showError();
        }
    }
}