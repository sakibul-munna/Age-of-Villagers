package nations;

import house.BangladeshiFarmersHouse;
import house.IHouse;
import tree.ITree;
import waterSource.IWaterSource;

public interface INation {
    IHouse getHouse();
    ITree getTree();
    IWaterSource getWaterSource();
}
