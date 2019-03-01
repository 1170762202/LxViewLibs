package com.zlx.lxviewlibs.ui.drag_view;

/**
 * @date: 2019\2\28 0028
 * @author: zlx
 * @email: 1170762202@qq.com
 * @description:
 */
public enum TypeEnum {

    /**
     * 0:单张
     * 1：单张列表
     * 2：长图列表
     * 3：视频
     */
    singleNormal(0),
    listNormal(1),
    listLong(2),
    listVideo(3);

    private int type;

    TypeEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
