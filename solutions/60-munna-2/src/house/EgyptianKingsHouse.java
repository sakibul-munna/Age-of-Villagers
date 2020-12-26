package house;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import main.MainCanvas;
import shapes.Line_Shape;
import shapes.Point;

public class EgyptianKingsHouse implements IHouse{
    private Point top,left,down,right;
    private Canvas canvas;
    private boolean flag;

    public EgyptianKingsHouse() {
        MainCanvas mainCanvas = MainCanvas.getInstance();
        this.canvas = mainCanvas.getCanvas();
    }

    @Override
    public void draw_house() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (flag) {
                            calculating_points(new Point((int) event.getX(), (int) event.getY()));
                            new Line_Shape(top, left, graphicsContext).draw();
                            new Line_Shape(left, down, graphicsContext).draw();
                            new Line_Shape(down, right, graphicsContext).draw();
                            new Line_Shape(right, top, graphicsContext).draw();
                            new Line_Shape(top, down, graphicsContext).draw();
                        }
                    }
                });
    }

    @Override
    public void calculating_points(Point main_point) {
        top = new Point(main_point.x, main_point.y);
        down = new Point(main_point.x - 2, main_point.y + 10 );
        left = new Point(main_point.x + 6, main_point.y + 7 );
        right = new Point(main_point.x - 5, main_point.y -5  );
    }
    public void Draw()
    {
        this.flag = true;
    }
    public void Dont_Draw()
    {
        this.flag = false;
    }
}
