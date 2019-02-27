package com.zlx.lxviewlibs.ui.combine_view.widget.region;

import android.graphics.Region;

public interface IRegionManager {
    Region[] calculateRegion(int size, int subSize, int gap, int count);
}
