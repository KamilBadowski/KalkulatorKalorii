package utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;


public class FxmlUtils {

    public static Pane fxmlLoader(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FxmlUtils.class.getResource(fxmlPath));
        try {
            return loader.load();
        } catch (Exception exc) {
            System.out.println("Nie ma takiego FXML-a");
        }
        return null;
    }

}
