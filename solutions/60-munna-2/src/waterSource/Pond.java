package waterSource;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import main.MainCanvas;
import shapes.Line_Shape;
import shapes.Point;

import java.util.List;

public class Pond implements IWaterSource {
    private Point point1,point2,point3,point4,point5,point6,point7,point8,point9;
    private boolean flag = true;
    private Canvas canvas;

    public Pond(){
        MainCanvas mainCanvas = MainCanvas.getInstance();
        this.canvas = mainCanvas.getCanvas();
    }

    public void Draw()
    {
        this.flag = true;
    }
    public void Dont_Draw()
    {
        this.flag = false;
    }
    public void Pond(){
        MainCanvas mainCanvas = MainCanvas.getInstance();
        this.canvas = mainCanvas.getCanvas();
    }

    @Override
    public void calculating_points(Point main_point) {
        point1 = new Point(main_point.x , main_point.y-5);
        point2 = new Point(main_point.x , main_point.y-8);
        point3 = new Point(main_point.x + 8, main_point.y -7);
        point4 = new Point(main_point.x + 12,main_point.y);
        point5 = new Point(main_point.x +6, main_point.y+8);
        point6 = new Point(main_point.x, main_point.y+6);
        point7 = new Point(main_point.x - 6 , main_point.y + 8 );
        point8 = new Point(main_point.x - 12, main_point.y - 2 );
        point9 = new Point(main_point.x - 9, main_point.y - 8 );
    }

    @Override
    public void draw_water_resource() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        if (flag) {
                            calculating_points(new Point((int) event.getX(), (int) event.getY()));
                            new Line_Shape(point1, point2, graphicsContext).draw();
                            new Line_Shape(point2, point3, graphicsContext).draw();
                            new Line_Shape(point3, point4, graphicsContext).draw();
                            new Line_Shape(point4, point5, graphicsContext).draw();
                            new Line_Shape(point5, point6, graphicsContext).draw();
                            new Line_Shape(point6, point7, graphicsContext).draw();
                            new Line_Shape(point7, point8, graphicsContext).draw();
                            new Line_Shape(point8, point9, graphicsContext).draw();
                            new Line_Shape(point9, point1, graphicsContext).draw();
                        }
                    }
                });
    }
}


