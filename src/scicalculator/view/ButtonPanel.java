package scicalculator.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import java.util.HashMap;
import java.util.Map;

/**
 * Button grid component for the calculator
 * Organizes all calculator buttons with consistent styling
 * Implements responsive button sizing
 *
 * @author Abdelrahman
 */
public class ButtonPanel extends GridPane {

    private Map<String, Button> buttons;

    /**
     * Constructs the button panel
     * Initializes all calculator buttons and sets up the grid layout
     */
    public ButtonPanel() {
        buttons = new HashMap<>();
        initializeComponents();
        setupLayout();
    }

    /**
     * Initialize all calculator buttons
     */
    private void initializeComponents() {
        // TODO: Create all calculator buttons
        // Digits: 0-9
        // Operators: +, -, *, /
        // Scientific: sin, cos, tan, log, ln, sqrt, power
        // Special: C (clear), DEL (delete), = (equals), . (decimal)
        // Parentheses: (, )
    }

    /**
     * Set up the grid layout structure
     */
    private void setupLayout() {
        setPadding(new Insets(10));
        setHgap(5);
        setVgap(5);
        getStyleClass().add("button-panel");

        // TODO: Arrange buttons in grid layout
    }

    /**
     * Create a calculator button with specified text
     * @param text The button text
     * @return The created button
     */
    private Button createButton(String text) {
        Button button = new Button(text);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.getStyleClass().add("calculator-button");
        buttons.put(text, button);
        return button;
    }

    /**
     * Get a button by its text label
     * @param text The button text
     * @return The button, or null if not found
     */
    public Button getButton(String text) {
        return buttons.get(text);
    }

    /**
     * Get all buttons
     * @return Map of all buttons keyed by their text
     */
    public Map<String, Button> getAllButtons() {
        return buttons;
    }
}
