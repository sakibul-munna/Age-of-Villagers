package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

public class Circle_Shape implements IShape{

    private Point center_of_circle;
    private int diameter_of_circle;
    private GraphicsContext graphicsContext;

    public Circle_Shape(Point center_of_circle, int diameter_of_circle, GraphicsContext graphicsContext) {
        this.center_of_circle = center_of_circle;
        this.diameter_of_circle = diameter_of_circle;
        this.graphicsContext = graphicsContext;
    }

    @Override
    public void draw() {
        graphicsContext.strokeArc(center_of_circle.x, center_of_circle.y, diameter_of_circle, diameter_of_circle, 0, 360, ArcType.OPEN);
    }
}
