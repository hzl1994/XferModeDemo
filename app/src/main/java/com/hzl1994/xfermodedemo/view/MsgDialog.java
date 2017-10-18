package com.hzl1994.xfermodedemo.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.hzl1994.xfermodedemo.R;


/**
 * Created by 黄智龙 on 2017/7/6.
 */

public class MsgDialog extends Dialog {

    public MsgDialog(Activity activity,  View view) {
        super(activity, R.style.ProMsgDialogStyle);
        setContentView(view);
        WindowManager manager = activity.getWindowManager();
        Display display = manager.getDefaultDisplay();
        android.view.WindowManager.LayoutParams lp = getWindow()
                .getAttributes();
        lp.width = display.getWidth() * 1;
        getWindow().setAttributes(lp);
    }
}
