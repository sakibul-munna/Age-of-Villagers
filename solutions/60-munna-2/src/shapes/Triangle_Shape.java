package shapes;

import javafx.scene.canvas.GraphicsContext;

public class Triangle_Shape implements IShape {
    private final GraphicsContext graphicsContext;
    private Point top,left,right;

    public Triangle_Shape(Point top, Point left, Point right, GraphicsContext graphicsContext) {
        this.top = top;
        this.left = left;
        this.right = right;
        this.graphicsContext = graphicsContext;
    }

    @Override
    public void draw() {
        new Line_Shape(top,left,graphicsContext).draw();
        new Line_Shape(top,right,graphicsContext).draw();
        new Line_Shape(left,right,graphicsContext).draw();
    }
}
