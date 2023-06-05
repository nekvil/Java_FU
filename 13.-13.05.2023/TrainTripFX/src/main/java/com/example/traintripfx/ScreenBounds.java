package com.example.traintripfx;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

/**
 * A utility class for retrieving screen bounds and calculating window dimensions based on screen size.
 */
public class ScreenBounds {

    /**
     * Retrieves the width of the window based on the screen size and a specified ratio.
     *
     * @param ratio The ratio of the window width to the screen width.
     * @return The calculated window width.
     */
    public static double getWindowWidth(Double ratio) {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        return screenBounds.getWidth() * ratio;
    }

    /**
     * Retrieves the height of the window based on the screen size and a specified ratio.
     *
     * @param ratio The ratio of the window height to the screen height.
     * @return The calculated window height.
     */
    public static double getWindowHeight(Double ratio) {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        return screenBounds.getHeight() * ratio;
    }
}
