package tree;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import main.MainCanvas;
import shapes.Circle_Shape;
import shapes.Line_Shape;
import shapes.Point;
import shapes.Rectangle_Shape;
import waterSource.Pond;

import javax.sound.sampled.Line;

public class EgyptianKnightsTree implements ITree {
    private Point center, left1,left2,left3,right1,right2,right3,left_mid,right_mid;
    private boolean flag = true;
    private Canvas canvas;
    private Point main_point;

    public void Draw()
    {
        this.flag = true;
    }
    public void Dont_Draw()
    {
        this.flag = false;
    }

    public EgyptianKnightsTree() {
        MainCanvas mainCanvas = MainCanvas.getInstance();
        this.canvas = mainCanvas.getCanvas();
    }

    @Override
    public void calculating_points(Point main_point) {
        center = new Point(main_point.x, main_point.y);
        left_mid = new Point(main_point.x + 3 , main_point.y - 6 );
        right_mid = new Point(main_point.x - 3, main_point.y -6 );
        left1 = new Point(left_mid.x + 4, left_mid.y - 4 );
        left2 = new Point(left_mid.x + 2, left_mid.y - 4 );
        left3 = new Point(left_mid.x - 3, left_mid.y - 4 );
        right1 = new Point(right_mid.x + 2, right_mid.y - 4  );
        right2 = new Point(right_mid.x - 2, right_mid.y - 4 );
        right3 = new Point(right_mid.x  - 4, right_mid.y - 4 );
    }

    @Override
    public void draw_Tree() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if (flag) {
                    main_point = new Point((int) event.getX(), (int) event.getY());
                    calculating_points(main_point);
                    new Line_Shape(center,left_mid,graphicsContext).draw();
                    new Line_Shape(left_mid,left1,graphicsContext).draw();
                    new Line_Shape(left_mid,left2,graphicsContext).draw();
                    new Line_Shape(left_mid,left3,graphicsContext).draw();
                    new Line_Shape(center,right_mid,graphicsContext).draw();
                    new Line_Shape(right_mid,right1,graphicsContext).draw();
                    new Line_Shape(right_mid,right2,graphicsContext).draw();
                    new Line_Shape(right_mid,right3,graphicsContext).draw();
                }
            }
        });
    }
}
