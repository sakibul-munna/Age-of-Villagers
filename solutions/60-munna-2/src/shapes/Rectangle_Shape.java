package shapes;

import javafx.scene.canvas.GraphicsContext;

public class Rectangle_Shape implements IShape {
    private Point topLeft;
    private Point bottomRight;
    private Point topRight;
    private Point bottomLeft;
    private GraphicsContext graphicsContext;

    public Rectangle_Shape(Point topLeft, Point bottomRight, GraphicsContext graphicsContext) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        this.graphicsContext = graphicsContext;

        topRight = new Point(bottomRight.x, topLeft.y);
        bottomLeft = new Point(topLeft.x, bottomRight.y);
    }

    @Override
    public void draw() {
        new Line_Shape(topLeft, topRight, graphicsContext).draw();
        new Line_Shape(topRight, bottomRight, graphicsContext).draw();
        new Line_Shape(bottomRight, bottomLeft, graphicsContext).draw();
        new Line_Shape(bottomLeft, topLeft, graphicsContext).draw();
    }


}
