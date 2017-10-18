package com.hzl1994.xfermodedemo;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.gv_xfer)
    GridView gvXfer;

    private XferAdapter xferAdapter;
    private List<XferModeTest> xferModeTests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {

    }

    private void initData(){
        xferModeTests = new ArrayList<>();
        xferModeTests.add(new XferModeTest("Clear", PorterDuff.Mode.CLEAR));
        xferModeTests.add(new XferModeTest("SRC", PorterDuff.Mode.SRC));
        xferModeTests.add(new XferModeTest("DST", PorterDuff.Mode.DST));
        xferModeTests.add(new XferModeTest("SRC_OVER", PorterDuff.Mode.SRC_OVER));
        xferModeTests.add(new XferModeTest("DST_OVER", PorterDuff.Mode.DST_OVER));
        xferModeTests.add(new XferModeTest("SRC_IN", PorterDuff.Mode.SRC_IN));
        xferModeTests.add(new XferModeTest("DST_IN", PorterDuff.Mode.DST_IN));
        xferModeTests.add(new XferModeTest("SRC_OUT", PorterDuff.Mode.SRC_OUT));
        xferModeTests.add(new XferModeTest("DST_OUT", PorterDuff.Mode.DST_OUT));
        xferModeTests.add(new XferModeTest("SRC_ATOP", PorterDuff.Mode.SRC_ATOP));
        xferModeTests.add(new XferModeTest("DST_ATOP", PorterDuff.Mode.DST_ATOP));
        xferModeTests.add(new XferModeTest("XOR", PorterDuff.Mode.XOR));
        xferModeTests.add(new XferModeTest("DARKEN", PorterDuff.Mode.DARKEN));
        xferModeTests.add(new XferModeTest("LIGHTEN", PorterDuff.Mode.LIGHTEN));
        xferModeTests.add(new XferModeTest("MULTIPLY", PorterDuff.Mode.MULTIPLY));
        xferModeTests.add(new XferModeTest("SCREEN", PorterDuff.Mode.SCREEN));

        xferAdapter = new XferAdapter(this,xferModeTests);
        gvXfer.setAdapter(xferAdapter);
    }
}
