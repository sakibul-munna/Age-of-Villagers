package tree;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import main.MainCanvas;
import shapes.Circle_Shape;
import shapes.Point;
import shapes.Rectangle_Shape;

public class BangladeshiFarmersTree implements ITree {
    private Point circle_center,bottomLeft,topLeft, bottomRight, topRight;
    private boolean flag = true;
    private Canvas canvas;

    public void Draw()
    {
        this.flag = true;
    }
    public void Dont_Draw()
    {
        this.flag = false;
    }

    public BangladeshiFarmersTree() {
        MainCanvas mainCanvas = MainCanvas.getInstance();
        this.canvas = mainCanvas.getCanvas();
    }

    @Override
    public void calculating_points(Point main_point) {
        circle_center = new Point(main_point.x - 8, main_point.y - 12);
        topLeft = new Point(main_point.x + 2, main_point.y - 4);
        bottomRight = new Point(main_point.x - 2, main_point.y + 12);
    }

    @Override
    public void draw_Tree() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        if (flag) {
                            calculating_points(new Point((int) event.getX(), (int) event.getY()));
                            new Circle_Shape(circle_center, 16, graphicsContext).draw();
                            new Rectangle_Shape(topLeft, bottomRight, graphicsContext).draw();
                        }
                    }
                });
    }
}

