package tree;

import shapes.Point;

public class NullTree implements ITree{
    @Override
    public void draw_Tree() {
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
