package waterSource;

import shapes.Point;

public class NullWaterSource implements IWaterSource {
    @Override
    public void draw_water_resource() {
        System.out.println("No Tree");
    }

    @Override
    public void calculating_points(Point main_point) {

    }

    @Override
    public void Dont_Draw() {

    }

    @Override
    public void Draw() {

    }
}
