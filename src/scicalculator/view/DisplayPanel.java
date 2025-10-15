package scicalculator.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Display area component for the calculator
 * Shows current input/result and operation history
 * Implements responsive font sizing
 *
 * @author Abdelrahman
 */
public class DisplayPanel extends VBox {

    private Label historyLabel;
    private Label displayLabel;

    /**
     * Constructs the display panel
     * Initializes display labels and styling
     */
    public DisplayPanel() {
        initializeComponents();
        setupLayout();
    }

    /**
     * Initialize display components
     */
    private void initializeComponents() {
        historyLabel = new Label("");
        displayLabel = new Label("0");

        // Set initial styling
        historyLabel.getStyleClass().add("history-label");
        displayLabel.getStyleClass().add("display-label");
    }

    /**
     * Set up the layout structure
     */
    private void setupLayout() {
        setAlignment(Pos.CENTER_RIGHT);
        setPadding(new Insets(10));
        setSpacing(5);

        getChildren().addAll(historyLabel, displayLabel);
        getStyleClass().add("display-panel");
    }

    /**
     * Update the main display text
     * @param text The text to display
     */
    public void updateDisplay(String text) {
        displayLabel.setText(text);
    }

    /**
     * Update the history display text
     * @param text The history text to display
     */
    public void updateHistory(String text) {
        historyLabel.setText(text);
    }

    /**
     * Clear the display
     */
    public void clear() {
        displayLabel.setText("0");
        historyLabel.setText("");
    }

    /**
     * Get the current display text
     * @return The current display text
     */
    public String getDisplayText() {
        return displayLabel.getText();
    }
}
