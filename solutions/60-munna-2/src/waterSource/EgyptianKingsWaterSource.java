package waterSource;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import main.MainCanvas;
import shapes.Circle_Shape;
import shapes.Line_Shape;
import shapes.Point;

public class EgyptianKingsWaterSource implements IWaterSource {
    private boolean flag;
    private Canvas canvas;
    private Point point;

    public EgyptianKingsWaterSource() {
        MainCanvas mainCanvas = MainCanvas.getInstance();
        this.canvas = mainCanvas.getCanvas();
    }

    @Override
    public void draw_water_resource() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if (flag) {
                    point = new Point((int) event.getX(), (int) event.getY());
                    new Circle_Shape(point, 12,graphicsContext).draw();
                }
            }
        });
    }

    @Override
    public void calculating_points(Point main_point) {

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
