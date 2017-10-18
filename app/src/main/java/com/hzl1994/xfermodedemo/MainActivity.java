package com.hzl1994.xfermodedemo;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.hzl1994.xfermodedemo.view.MsgDialog;
import com.hzl1994.xfermodedemo.view.XferModeTestView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_src)
    Button btnSrc;
    @BindView(R.id.btn_dst)
    Button btnDst;
    @BindView(R.id.btn_clear)
    Button btnClear;
    @BindView(R.id.btn_src_over)
    Button btnSrcOver;
    @BindView(R.id.btn_dst_over)
    Button btnDstOver;
    @BindView(R.id.btn_src_in)
    Button btnSrcIn;
    @BindView(R.id.btn_dst_in)
    Button btnDstIn;
    @BindView(R.id.btn_src_out)
    Button btnSrcOut;
    @BindView(R.id.btn_dst_out)
    Button btnDstOut;
    @BindView(R.id.btn_src_atop)
    Button btnSrcAtop;
    @BindView(R.id.btn_dst_atop)
    Button btnDstAtop;
    @BindView(R.id.btn_xor)
    Button btnXor;
    @BindView(R.id.btn_darken)
    Button btnDarken;
    @BindView(R.id.btn_lighten)
    Button btnLighten;
    @BindView(R.id.btn_multiply)
    Button btnMultiply;
    @BindView(R.id.btn_screen)
    Button btnScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_src)
    public void onBtnSrcClicked() {
        new MsgDialog(this,new XferModeTestView(this, PorterDuff.Mode.SRC)).show();
    }

    @OnClick(R.id.btn_dst)
    public void onBtnDstClicked() {
        new MsgDialog(this,new XferModeTestView(this, PorterDuff.Mode.DST)).show();
    }

    @OnClick(R.id.btn_clear)
    public void onBtnClearClicked() {
        new MsgDialog(this,new XferModeTestView(this, PorterDuff.Mode.CLEAR)).show();
    }

    @OnClick(R.id.btn_src_over)
    public void onBtnSrcOverClicked() {
        new MsgDialog(this,new XferModeTestView(this, PorterDuff.Mode.SRC_OVER)).show();
    }

    @OnClick(R.id.btn_dst_over)
    public void onBtnDstOverClicked() {
        new MsgDialog(this,new XferModeTestView(this, PorterDuff.Mode.DST_OVER)).show();
    }

    @OnClick(R.id.btn_src_in)
    public void onBtnSrcInClicked() {
        new MsgDialog(this,new XferModeTestView(this, PorterDuff.Mode.SRC_IN)).show();
    }

    @OnClick(R.id.btn_dst_in)
    public void onBtnDstInClicked() {
        new MsgDialog(this,new XferModeTestView(this, PorterDuff.Mode.DST_IN)).show();
    }

    @OnClick(R.id.btn_src_out)
    public void onBtnSrcOutClicked() {
        new MsgDialog(this,new XferModeTestView(this, PorterDuff.Mode.SRC_OUT)).show();
    }

    @OnClick(R.id.btn_dst_out)
    public void onBtnDstOutClicked() {
        new MsgDialog(this,new XferModeTestView(this, PorterDuff.Mode.DST_OUT)).show();
    }

    @OnClick(R.id.btn_src_atop)
    public void onBtnSrcAtopClicked() {
        new MsgDialog(this,new XferModeTestView(this, PorterDuff.Mode.SRC_ATOP)).show();
    }

    @OnClick(R.id.btn_dst_atop)
    public void onBtnDstAtopClicked() {
        new MsgDialog(this,new XferModeTestView(this, PorterDuff.Mode.DST_ATOP)).show();
    }

    @OnClick(R.id.btn_xor)
    public void onBtnXorClicked() {
        new MsgDialog(this,new XferModeTestView(this, PorterDuff.Mode.XOR)).show();
    }

    @OnClick(R.id.btn_darken)
    public void onBtnDarkenClicked() {
        new MsgDialog(this,new XferModeTestView(this, PorterDuff.Mode.DARKEN)).show();
    }

    @OnClick(R.id.btn_lighten)
    public void onBtnLightenClicked() {
        new MsgDialog(this,new XferModeTestView(this, PorterDuff.Mode.LIGHTEN)).show();
    }

    @OnClick(R.id.btn_multiply)
    public void onBtnMultiplyClicked() {
        new MsgDialog(this,new XferModeTestView(this, PorterDuff.Mode.MULTIPLY)).show();
    }

    @OnClick(R.id.btn_screen)
    public void onBtnScreenClicked() {
        new MsgDialog(this,new XferModeTestView(this, PorterDuff.Mode.SCREEN)).show();
    }
}
