package scicalculator1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main application class for the Scientific Calculator
 * Entry point for the JavaFX application
 *
 * @author Abdelrahman
 */
public class SciCalculator1 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/CalculatorView.fxml"));
        Parent root = loader.load();

        // Create the scene
        Scene scene = new Scene(root, 480, 760);

        // Configure the stage
        primaryStage.setTitle("Scientific Calculator");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(600);
        primaryStage.setResizable(true);

        // Show the application
        primaryStage.show();
    }

    /**
     * Main entry point
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
