import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.DbManager;


public class Main extends Application {

    private static final String MAIN_FXML = "/fxml/Main.fxml";
    private static final String APPLICATION_NAME = "Kalkulator Kalorii";

    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void start(Stage mainStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(MAIN_FXML));

        Pane mainPane = loader.load();
        Scene scene = new Scene(mainPane);
        mainStage.setScene(scene);
        mainStage.setTitle(APPLICATION_NAME);
        mainStage.show();

        DbManager.initConnection();

    }



}
