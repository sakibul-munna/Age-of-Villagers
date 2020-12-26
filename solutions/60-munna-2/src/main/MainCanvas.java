package main;

import javafx.scene.canvas.Canvas;

public class MainCanvas {
    private static MainCanvas instance = null;
    private Canvas canvas;

    private MainCanvas() {
        canvas = new Canvas(600, 400);
    }

    public static MainCanvas getInstance() {
        if (instance == null)
            instance = new MainCanvas();
        return instance;
    }

    public Canvas getCanvas(){
        return canvas;
    }
}
