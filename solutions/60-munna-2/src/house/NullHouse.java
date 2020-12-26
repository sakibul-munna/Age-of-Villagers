package house;

import shapes.Point;

public class NullHouse implements IHouse{

    @Override
    public void draw_house() {
        System.out.println("No House");
    }

    @Override
    public void calculating_points(Point main_point) {

    }

    @Override
    public void Draw() {

    }

    @Override
    public void Dont_Draw() {

    }
}
