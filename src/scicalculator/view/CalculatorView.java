package scicalculator.view;

import javafx.scene.layout.BorderPane;

/**
 * Main UI container for the calculator application
 * Creates and organizes all UI components
 * Handles responsive layout for window resizing
 *
 * @author Abdelrahman
 */
public class CalculatorView extends BorderPane {

    private DisplayPanel displayPanel;
    private ButtonPanel buttonPanel;

    /**
     * Constructs the main calculator view
     * Initializes all UI components and sets up the layout
     */
    public CalculatorView() {
        initializeComponents();
        setupLayout();
    }

    /**
     * Initialize all UI components
     */
    private void initializeComponents() {
        displayPanel = new DisplayPanel();
        buttonPanel = new ButtonPanel();
    }

    /**
     * Set up the layout structure
     * Uses BorderPane for flexible, responsive design
     */
    private void setupLayout() {
        setTop(displayPanel);
        setCenter(buttonPanel);

        // Add CSS styling class
        getStyleClass().add("calculator-view");
    }

    /**
     * Get the display panel component
     * @return The display panel
     */
    public DisplayPanel getDisplayPanel() {
        return displayPanel;
    }

    /**
     * Get the button panel component
     * @return The button panel
     */
    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }
}
