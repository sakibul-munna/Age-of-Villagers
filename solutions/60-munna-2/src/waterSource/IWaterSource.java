package waterSource;

import javafx.scene.canvas.Canvas;
import shapes.Point;

public interface IWaterSource {
    void draw_water_resource();
    void calculating_points(Point main_point);

    void Dont_Draw();
    void Draw();
}
