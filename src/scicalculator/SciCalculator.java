package scicalculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scicalculator.controller.CalculatorController;
import scicalculator.model.CalculatorEngine;
import scicalculator.view.CalculatorView;
import scicalculator.util.StyleConstants;

/**
 * Main application class for the Scientific Calculator
 * Implements MVC architecture pattern
 *
 * Architecture:
 * - Model: CalculatorEngine handles all business logic and calculations
 * - View: CalculatorView manages the UI components
 * - Controller: CalculatorController connects View and Model
 *
 * @author Abdelrahman
 */
public class SciCalculator extends Application {

    private CalculatorView view;
    private CalculatorEngine engine;
    private CalculatorController controller;

    @Override
    public void start(Stage primaryStage) {
        // Initialize MVC components
        initializeComponents();

        // Create scene with the view
        Scene scene = new Scene(view,
            StyleConstants.WINDOW_DEFAULT_WIDTH,
            StyleConstants.WINDOW_DEFAULT_HEIGHT);

        // TODO: Add CSS stylesheet when ready
        // scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        // Configure stage
        primaryStage.setTitle("Scientific Calculator");
        primaryStage.setMinWidth(StyleConstants.WINDOW_MIN_WIDTH);
        primaryStage.setMinHeight(StyleConstants.WINDOW_MIN_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();

        // TODO: Add responsive listeners for window resizing
        // primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> handleResize(newVal.doubleValue()));
    }

    /**
     * Initialize all MVC components in proper order
     * Model -> View -> Controller
     */
    private void initializeComponents() {
        // Create Model (no dependencies)
        engine = new CalculatorEngine();

        // Create View (no dependencies)
        view = new CalculatorView();

        // Create Controller (depends on both Model and View)
        controller = new CalculatorController(view, engine);
    }

    /**
     * Handle window resize events for responsive design
     * @param newWidth The new window width
     */
    private void handleResize(double newWidth) {
        // TODO: Implement responsive behavior
        // Adjust font sizes based on window width
        // Update button sizes if needed
    }

    /**
     * Main entry point for the application
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
