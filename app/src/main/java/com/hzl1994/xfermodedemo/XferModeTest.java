package com.hzl1994.xfermodedemo;

import android.graphics.PorterDuff;

/**
 * Created by 黄智龙 on 2017/10/16.
 */

public class XferModeTest {
    private String title;
    private PorterDuff.Mode mode;

    public XferModeTest(String title, PorterDuff.Mode mode) {
        this.title = title;
        this.mode = mode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PorterDuff.Mode getMode() {
        return mode;
    }

    public void setMode(PorterDuff.Mode mode) {
        this.mode = mode;
    }
}
