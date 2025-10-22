/**
 * Main controller for the Scientific Calculator Handles all UI events and
 * delegates to the backend CalculatorEngine
 *
 * @author Muahmmadjibril
 */
package scicalculator1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import scicalculator1.model.CalculatorEngine;
import scicalculator1.model.Operation;
import scicalculator1.exception.CalculatorException;
import scicalculator1.util.FormatUtils;


public class CalculatorController {

    // ======== DISPLAY ========
    @FXML
    private Label resultLabel;   // big number
    @FXML
    private Label historyLabel;  // small expression

    // ======== UI CONTAINERS (for runtime styling) ========
    @FXML
    private GridPane keypad;     // fx:id on the GridPane with all keys
    @FXML
    private HBox memoryBar;      // fx:id on the memory bar HBox

    // ======== BACKEND ENGINE ========
    private CalculatorEngine engine;

    // ======== HISTORY TRACKING ========
    private String historyExpression = "";

    // ======== COLORS (no CSS file) ========
    private static final String COL_BG = "#202020"; // window & display bg
    private static final String COL_BTN = "#313131"; // button base
    private static final String COL_BTN_HOVER = "#3a3a3a";
    private static final String COL_PRESSED = "#4bbefa"; // pressed & equals
    private static final String COL_TEXT = "#ffffff";
    private static final String COL_TEXT_DARK = "#000000";
    private static final String BASE_BORDER = "-fx-border-color:" + COL_BG + "; -fx-border-radius:6; -fx-background-radius:6;";

    // ======== INITIALIZE: style everything at runtime ========
    @FXML
    private void initialize() {
        // Initialize backend engine
        engine = new CalculatorEngine();

        // Display text styles (kept here to avoid app.css)
        resultLabel.setStyle("-fx-text-fill:" + COL_TEXT + "; -fx-font-size:60px; -fx-font-weight:700; -fx-padding:0 12 4 12;");
        historyLabel.setStyle("-fx-text-fill:#a6a6a6; -fx-font-size:15px; -fx-padding:0 12 10 12;");

        // Style memory chips
        if (memoryBar != null) {
            for (Node n : memoryBar.getChildren()) {
                if (n instanceof Button) {
                    styleChip((Button) n);
                }
            }
        }

        // Style all keypad buttons uniformly
        if (keypad != null) {
            for (Node n : keypad.getChildren()) {
                if (n instanceof Button) {
                    Button b = (Button) n;
                    boolean isEquals = "=".equals(b.getText());
                    styleKey(b, isEquals);
                }
            }
        }

        updateDisplay();
    }

    // Uniform style for keypad buttons (with hover/press simulation)
    private void styleKey(Button b, boolean isEquals) {
        b.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE); // responsive fill

        if (isEquals) {
            b.setStyle("-fx-font-size:18px; -fx-font-weight:700; "
                    + "-fx-background-color:" + COL_PRESSED + "; "
                    + "-fx-text-fill:" + COL_TEXT + "; "
                    + BASE_BORDER + " -fx-padding:16;");
            // Keep equals blue on press/release too:
            b.setOnMouseEntered(e -> b.setStyle("-fx-font-size:18px; -fx-font-weight:700; "
                    + "-fx-background-color:" + COL_PRESSED + "; "
                    + "-fx-text-fill:" + COL_TEXT + "; "
                    + BASE_BORDER + " -fx-padding:16;"));
            b.setOnMouseExited(e -> b.setStyle("-fx-font-size:18px; -fx-font-weight:700; "
                    + "-fx-background-color:" + COL_PRESSED + "; "
                    + "-fx-text-fill:" + COL_TEXT + "; "
                    + BASE_BORDER + " -fx-padding:16;"));
            b.setOnMousePressed(e -> b.setStyle("-fx-font-size:18px; -fx-font-weight:700; "
                    + "-fx-background-color:" + COL_PRESSED + "; "
                    + "-fx-text-fill:" + COL_TEXT + "; "
                    + BASE_BORDER + " -fx-padding:16;"));
            b.setOnMouseReleased(e -> {
                if (b.isHover()) {
                    b.setStyle("-fx-font-size:18px; -fx-font-weight:700; "
                            + "-fx-background-color:" + COL_PRESSED + "; "
                            + "-fx-text-fill:" + COL_TEXT + "; "
                            + BASE_BORDER + " -fx-padding:16;");
                } else {
                    b.setStyle("-fx-font-size:18px; -fx-font-weight:700; "
                            + "-fx-background-color:" + COL_PRESSED + "; "
                            + "-fx-text-fill:" + COL_TEXT + "; "
                            + BASE_BORDER + " -fx-padding:16;");
                }
            });
            return;
        }

        // Base / hover / pressed for normal keys
        final String base = "-fx-font-size:18px; -fx-font-weight:500; "
                + "-fx-background-color:" + COL_BTN + "; "
                + "-fx-text-fill:" + COL_TEXT + "; "
                + BASE_BORDER + " -fx-padding:16;";
        final String hover = base.replace(COL_BTN, COL_BTN_HOVER);
        final String pressed = "-fx-font-size:18px; -fx-font-weight:700; "
                + "-fx-background-color:" + COL_PRESSED + "; "
                + "-fx-text-fill:" + COL_TEXT + "; "
                + BASE_BORDER + " -fx-padding:16;";

        b.setStyle(base);
        b.setOnMouseEntered(e -> b.setStyle(hover));
        b.setOnMouseExited(e -> b.setStyle(base));
        b.setOnMousePressed(e -> b.setStyle(pressed));
        b.setOnMouseReleased(e -> b.setStyle(b.isHover() ? hover : base));
    }

    // Memory chip styling (rounded)
    private void styleChip(Button b) {
        final String base = "-fx-background-color:" + COL_BTN + "; -fx-text-fill:" + COL_TEXT + "; "
                + "-fx-background-radius:16; -fx-border-radius:16; -fx-padding:6 12 6 12; -fx-border-color:" + COL_BG + ";";
        final String hover = "-fx-background-color:" + COL_BTN_HOVER + "; -fx-text-fill:" + COL_TEXT + "; "
                + "-fx-background-radius:16; -fx-border-radius:16; -fx-padding:6 12 6 12; -fx-border-color:" + COL_BG + ";";
        final String pressed = "-fx-background-color:" + COL_PRESSED + "; -fx-text-fill:" + COL_TEXT_DARK + "; "
                + "-fx-background-radius:16; -fx-border-radius:16; -fx-padding:6 12 6 12; -fx-border-color:" + COL_BG + ";";

        b.setStyle(base);
        b.setOnMouseEntered(e -> b.setStyle(hover));
        b.setOnMouseExited(e -> b.setStyle(base));
        b.setOnMousePressed(e -> b.setStyle(pressed));
        b.setOnMouseReleased(e -> b.setStyle(b.isHover() ? hover : base));
    }

    // ======== DISPLAY UPDATE ========
    private void updateDisplay() {
        resultLabel.setText(engine.getDisplay());
    }

    // ======== DIGITS & DOT ========
    @FXML private void handleDigit(ActionEvent e) {
        String d = ((Button) e.getSource()).getText();
        int digit = Integer.parseInt(d);
        engine.inputDigit(digit);
        updateDisplay();
    }

    @FXML private void handleDot() {
        engine.inputDecimal();
        updateDisplay();
    }

    // ======== CLEAR / BACKSPACE ========
    @FXML private void handleClear() {
        engine.clearAll();
        historyLabel.setText("");
        historyExpression = "";
        updateDisplay();
    }

    @FXML private void handleClearEntry() {
        engine.clearEntry();
        historyLabel.setText("");
        historyExpression = "";
        updateDisplay();
    }

    @FXML private void handleBackspace() {
        engine.backspace();
        updateDisplay();
    }

    // ======== UNARY FUNCTIONS ========
    @FXML private void handlePercent() {
        try {
            String historyText = engine.performPercent();
            historyLabel.setText(historyText);
            updateDisplay();
        } catch (CalculatorException ex) {
            updateDisplay();
        }
    }

    @FXML private void handleSign() {
        try {
            engine.performUnaryOperation(Operation.NEGATE);
            updateDisplay();
        } catch (CalculatorException ex) {
            engine.getState().setDisplayText("Error");
            updateDisplay();
        }
    }

    @FXML private void sqrt() {
        try {
            double v = FormatUtils.parseNumber(engine.getDisplay());
            engine.performUnaryOperation(Operation.SQRT);
            historyLabel.setText("√(" + FormatUtils.formatNumber(v) + ")");
            updateDisplay();
        } catch (CalculatorException ex) {
            engine.getState().setDisplayText("Error");
            updateDisplay();
        }
    }

    @FXML private void square() {
        try {
            double v = FormatUtils.parseNumber(engine.getDisplay());
            engine.performUnaryOperation(Operation.SQUARE);
            historyLabel.setText("sqr(" + FormatUtils.formatNumber(v) + ")");
            updateDisplay();
        } catch (CalculatorException ex) {
            engine.getState().setDisplayText("Error");
            updateDisplay();
        }
    }

    @FXML private void reciprocal() {
        try {
            double v = FormatUtils.parseNumber(engine.getDisplay());
            engine.performUnaryOperation(Operation.RECIPROCAL);
            historyLabel.setText("1/(" + FormatUtils.formatNumber(v) + ")");
            updateDisplay();
        } catch (CalculatorException ex) {
            engine.getState().setDisplayText("Error");
            updateDisplay();
        }
    }

    /**
     * Absolute value operation
     *
     * @author Abdelrahman
     */
    @FXML private void abs() {
        try {
            double v = FormatUtils.parseNumber(engine.getDisplay());
            engine.performUnaryOperation(Operation.ABS);
            historyLabel.setText("abs(" + FormatUtils.formatNumber(v) + ")");
            updateDisplay();
        } catch (CalculatorException ex) {
            engine.getState().setDisplayText("Error");
            updateDisplay();
        }
    }

    @FXML private void exp() {
        try {
            double v = FormatUtils.parseNumber(engine.getDisplay());
            engine.performUnaryOperation(Operation.EXP);
            historyLabel.setText("exp(" + FormatUtils.formatNumber(v) + ")");
            updateDisplay();
        } catch (CalculatorException ex) {
            engine.getState().setDisplayText("Error");
            updateDisplay();
        }
    }

    @FXML private void tenPowX() {
        try {
            double v = FormatUtils.parseNumber(engine.getDisplay());
            engine.performUnaryOperation(Operation.TENPOWX);
            historyLabel.setText("10^(" + FormatUtils.formatNumber(v) + ")");
            updateDisplay();
        } catch (CalculatorException ex) {
            engine.getState().setDisplayText("Error");
            updateDisplay();
        }
    }

    @FXML private void log10() {
        try {
            double v = FormatUtils.parseNumber(engine.getDisplay());
            engine.performUnaryOperation(Operation.LOG);
            historyLabel.setText("log(" + FormatUtils.formatNumber(v) + ")");
            updateDisplay();
        } catch (CalculatorException ex) {
            engine.getState().setDisplayText("Error");
            updateDisplay();
        }
    }

    @FXML private void ln() {
        try {
            double v = FormatUtils.parseNumber(engine.getDisplay());
            engine.performUnaryOperation(Operation.LN);
            historyLabel.setText("ln(" + FormatUtils.formatNumber(v) + ")");
            updateDisplay();
        } catch (CalculatorException ex) {
            engine.getState().setDisplayText("Error");
            updateDisplay();
        }
    }

    @FXML private void factorial() {
        try {
            double v = FormatUtils.parseNumber(engine.getDisplay());
            engine.performUnaryOperation(Operation.FACTORIAL);
            historyLabel.setText("fact(" + FormatUtils.formatNumber(v) + ")");
            updateDisplay();
        } catch (CalculatorException ex) {
            engine.getState().setDisplayText("Error");
            updateDisplay();
        }
    }

    @FXML private void constPi() {
        String historyText = engine.inputConstant(Math.PI);
        historyLabel.setText(historyText);
        updateDisplay();
    }

    @FXML private void constE() {
        String historyText = engine.inputConstant(Math.E);
        historyLabel.setText(historyText);
        updateDisplay();
    }

    // ======== BINARY OPS & EQUALS ========
    @FXML private void handleOperator(ActionEvent e) {
        try {
            String sym = ((Button) e.getSource()).getText();
            Operation op = mapSymbolToOperation(sym);

            if (op != null) {
                engine.performBinaryOperation(op);
                historyLabel.setText(engine.getDisplay() + " " + sym);
                updateDisplay();
            }
        } catch (CalculatorException ex) {
            engine.getState().setDisplayText("Error");
            updateDisplay();
        }
    }

    @FXML private void handleEquals() {
        try {
            if (engine.getState().getCurrentOperation() != null) {
                String currentDisplay = engine.getDisplay();
                engine.calculateResult();
                historyLabel.setText(historyLabel.getText() + " " + currentDisplay + " =");
                updateDisplay();
            }
        } catch (CalculatorException ex) {
            engine.getState().setDisplayText("Error");
            updateDisplay();
        }
    }

    private Operation mapSymbolToOperation(String symbol) {
        switch (symbol) {
            case "+":
                return Operation.ADD;
            case "−":
                return Operation.SUBTRACT;
            case "×":
                return Operation.MULTIPLY;
            case "÷":
                return Operation.DIVIDE;
            case "mod":
                return Operation.MODULO;
            case "xʸ":
                return Operation.POWER;
            default:
                return null;
        }
    }

    // ======== MEMORY ========
    @FXML private void memClear() {
        engine.memoryClear();
    }

    @FXML private void memRecall() {
        engine.memoryRecall();
        updateDisplay();
    }

    @FXML private void memPlus() {
        engine.memoryAdd();
    }

    @FXML private void memMinus() {
        engine.memorySubtract();
    }

    @FXML private void memStore() {
        engine.memoryStore();
    }

    // ======== TOGGLE SECOND (2ⁿᵈ) BUTTON ========
    /**
     * Handles the "2ⁿᵈ" button toggle for secondary functions.
     * Currently a no-op placeholder for future implementation.
     */
    @FXML private void toggleSecond() {
        // Placeholder for secondary function toggle
        // In a full implementation, this would switch functions like:
        // sin <-> arcsin, cos <-> arccos, x² <-> x³, etc.
    }

    // ======== PARENTHESIS (DISABLED) ========
    /**
     * Placeholder for parenthesis functionality.
     * Currently disabled in the UI.
     */
    @FXML private void noopParen() {
        // No operation - parenthesis buttons are disabled
    }
}
