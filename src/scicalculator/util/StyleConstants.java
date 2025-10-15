package scicalculator.util;

import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Constants for UI styling and theming
 * Centralizes all style-related values for consistency
 * Makes it easy to customize the calculator's appearance
 *
 * @author Abdelrahman
 */
public class StyleConstants {

    /**
     * Private constructor to prevent instantiation
     */
    private StyleConstants() {
        throw new AssertionError("Utility class should not be instantiated");
    }

    // ==================== Window Size Constants ====================
    public static final double WINDOW_MIN_WIDTH = 320.0;
    public static final double WINDOW_MIN_HEIGHT = 480.0;
    public static final double WINDOW_DEFAULT_WIDTH = 400.0;
    public static final double WINDOW_DEFAULT_HEIGHT = 600.0;

    // ==================== Font Constants ====================
    public static final String FONT_FAMILY = "Segoe UI";
    public static final double DISPLAY_FONT_SIZE = 32.0;
    public static final double HISTORY_FONT_SIZE = 14.0;
    public static final double BUTTON_FONT_SIZE = 18.0;
    public static final FontWeight DISPLAY_FONT_WEIGHT = FontWeight.BOLD;
    public static final FontWeight BUTTON_FONT_WEIGHT = FontWeight.NORMAL;

    // ==================== Color Constants ====================
    // Display colors
    public static final Color DISPLAY_BACKGROUND = Color.rgb(30, 30, 30);
    public static final Color DISPLAY_TEXT_COLOR = Color.WHITE;
    public static final Color HISTORY_TEXT_COLOR = Color.rgb(180, 180, 180);

    // Button colors - Numbers
    public static final Color NUMBER_BUTTON_BACKGROUND = Color.rgb(60, 60, 60);
    public static final Color NUMBER_BUTTON_TEXT = Color.WHITE;
    public static final Color NUMBER_BUTTON_HOVER = Color.rgb(70, 70, 70);

    // Button colors - Operators
    public static final Color OPERATOR_BUTTON_BACKGROUND = Color.rgb(80, 80, 80);
    public static final Color OPERATOR_BUTTON_TEXT = Color.WHITE;
    public static final Color OPERATOR_BUTTON_HOVER = Color.rgb(90, 90, 90);

    // Button colors - Special (Equals, Clear)
    public static final Color EQUALS_BUTTON_BACKGROUND = Color.rgb(0, 120, 215);
    public static final Color EQUALS_BUTTON_TEXT = Color.WHITE;
    public static final Color EQUALS_BUTTON_HOVER = Color.rgb(0, 100, 180);

    public static final Color CLEAR_BUTTON_BACKGROUND = Color.rgb(200, 50, 50);
    public static final Color CLEAR_BUTTON_TEXT = Color.WHITE;
    public static final Color CLEAR_BUTTON_HOVER = Color.rgb(180, 40, 40);

    // Button colors - Scientific functions
    public static final Color SCIENTIFIC_BUTTON_BACKGROUND = Color.rgb(50, 50, 70);
    public static final Color SCIENTIFIC_BUTTON_TEXT = Color.WHITE;
    public static final Color SCIENTIFIC_BUTTON_HOVER = Color.rgb(60, 60, 80);

    // Background colors
    public static final Color MAIN_BACKGROUND = Color.rgb(40, 40, 40);

    // ==================== Spacing Constants ====================
    public static final double PADDING_SMALL = 5.0;
    public static final double PADDING_MEDIUM = 10.0;
    public static final double PADDING_LARGE = 15.0;

    public static final double BUTTON_SPACING = 5.0;
    public static final double COMPONENT_SPACING = 10.0;

    public static final Insets DISPLAY_PADDING = new Insets(PADDING_MEDIUM);
    public static final Insets BUTTON_PANEL_PADDING = new Insets(PADDING_MEDIUM);

    // ==================== Button Size Constants ====================
    public static final double BUTTON_MIN_WIDTH = 50.0;
    public static final double BUTTON_MIN_HEIGHT = 50.0;
    public static final double BUTTON_PREF_WIDTH = 70.0;
    public static final double BUTTON_PREF_HEIGHT = 70.0;

    // ==================== Border/Corner Constants ====================
    public static final double BUTTON_CORNER_RADIUS = 5.0;
    public static final double PANEL_CORNER_RADIUS = 10.0;

    // ==================== CSS Style Classes ====================
    public static final String STYLE_CALCULATOR_VIEW = "calculator-view";
    public static final String STYLE_DISPLAY_PANEL = "display-panel";
    public static final String STYLE_DISPLAY_LABEL = "display-label";
    public static final String STYLE_HISTORY_LABEL = "history-label";
    public static final String STYLE_BUTTON_PANEL = "button-panel";
    public static final String STYLE_BUTTON = "calculator-button";
    public static final String STYLE_BUTTON_NUMBER = "number-button";
    public static final String STYLE_BUTTON_OPERATOR = "operator-button";
    public static final String STYLE_BUTTON_EQUALS = "equals-button";
    public static final String STYLE_BUTTON_CLEAR = "clear-button";
    public static final String STYLE_BUTTON_SCIENTIFIC = "scientific-button";

    // ==================== Helper Methods ====================

    /**
     * Create a CSS style string for inline styling
     * @param properties Variable arguments of CSS property-value pairs
     * @return The CSS style string
     */
    public static String createStyle(String... properties) {
        // TODO: Implement CSS style string builder
        // Takes pairs of property-value strings
        // Returns formatted CSS string
        return String.join("; ", properties);
    }

    /**
     * Convert Color to CSS hex string
     * @param color The color to convert
     * @return The CSS hex string (e.g., "#FFFFFF")
     */
    public static String toHexString(Color color) {
        // TODO: Implement color to hex conversion
        return String.format("#%02X%02X%02X",
            (int) (color.getRed() * 255),
            (int) (color.getGreen() * 255),
            (int) (color.getBlue() * 255));
    }

    /**
     * Get responsive font size based on window width
     * @param baseSize The base font size
     * @param windowWidth The current window width
     * @return The scaled font size
     */
    public static double getResponsiveFontSize(double baseSize, double windowWidth) {
        // TODO: Implement responsive font sizing
        // Scale font based on window width
        // Maintain minimum and maximum bounds
        double scale = windowWidth / WINDOW_DEFAULT_WIDTH;
        return baseSize * Math.max(0.8, Math.min(1.5, scale));
    }
}