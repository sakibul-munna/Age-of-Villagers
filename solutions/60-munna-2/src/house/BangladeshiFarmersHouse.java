package house;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import main.MainCanvas;
import shapes.Point;
import shapes.Rectangle_Shape;
import shapes.Triangle_Shape;

public class BangladeshiFarmersHouse implements IHouse {

    private Point top_center;
    private Point top_left;
    private Point top_right;
    private Point bottom_left;
    private Point bottom_right;
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
    public BangladeshiFarmersHouse() {
        MainCanvas mainCanvas = MainCanvas.getInstance();
        this.canvas = mainCanvas.getCanvas();
    }

    @Override
    public void calculating_points(Point main_point) {
        top_center = new Point(main_point.x, main_point.y - 10);
        top_left = new Point(main_point.x + 10, main_point.y );
        top_right = new Point(main_point.x - 10, main_point.y);
        bottom_left = new Point(main_point.x + 10, main_point.y +10);
        bottom_right = new Point(main_point.x - 10, main_point.y +10);
    }

    @Override
    public void draw_house() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (flag) {
                    calculating_points(new Point((int) event.getX(), (int) event.getY()));
                    new Rectangle_Shape(top_left, bottom_right, graphicsContext).draw();
                    new Triangle_Shape(top_center, top_left, top_right, graphicsContext).draw();
                }
            }
        });
    }
}
