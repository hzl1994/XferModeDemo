package com.hzl1994.xfermodedemo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 黄智龙 on 2017/10/12.
 */

public class XferModeTestView extends View {


    private static final String TAG = "XferModeTestView";

    private int DIAMODE_SCALE = 12; // 透明示意方块宽占屏幕的比例
    private int TRANSPARENCY_DARK = 0xffcecece;
    private int TRANSPARENCY_LIGHT = 0xffffffff;
    private int SHADE_COLOR = 0x40000000; // 按下阴影
    private int WIDTH_DEF = 240; // 默认宽度
    private PorterDuff.Mode MODE_DEF = PorterDuff.Mode.SRC_OVER;


    private OnClickListener clickListener;

    private Paint mSrcPaint;
    private Paint mDstPaint;
    private Context ctx;
    private Bitmap mSrcBitmap;
    private Canvas mSrcCanvas;
    private Bitmap mDstBitmap;
    private Canvas mDstCanvas;
    private PorterDuff.Mode mode;

    private boolean isTouch;

    public XferModeTestView(Context context, PorterDuff.Mode mode) {
        super(context);
        init(context, mode);
    }

    public XferModeTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, MODE_DEF);
    }

    private void init(Context context, PorterDuff.Mode mode) {
        this.ctx = context;
        this.mode = mode;
        this.isTouch = false;
        this.clickListener = null;
        if (mSrcPaint == null) {
            mSrcPaint = new Paint();
            mSrcPaint.setColor(0xff66aaff);
            mSrcPaint.setDither(true);
        }
        if (mDstPaint == null) {
            mDstPaint = new Paint();
            mDstPaint.setColor(0xffffcc44);
            mDstPaint.setDither(true);
        }
        // 关闭硬件加速
        this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        this.setClickable(true);
        this.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Log.i(TAG, "onTouch: DOWN");
                    isTouch = true;
                    invalidate();
                    if (clickListener != null) {
                        clickListener.onClick(XferModeTestView.this);
                    }
                } else {
                    Log.i(TAG, "onTouch: UP");
                    isTouch = false;
                    invalidate();
                }
                return false;
            }

        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int width;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            WIDTH_DEF = (int) (getResources().getDisplayMetrics().widthPixels * 1.0 / 5);
            int desired = (int) (getPaddingLeft() + WIDTH_DEF + getPaddingRight());
            width = desired;
        }

        setMeasuredDimension(width, width);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 清除画布
        //canvas.drawColor(Color.WHITE, PorterDuff.Mode.CLEAR);
        //canvas.drawARGB(255, 139, 197, 186);
        // 画透明示意背景
        int pad_l = getPaddingLeft();
        int pad_r = getPaddingRight();
        int pad_t = getPaddingTop();
        int pad_b = getPaddingBottom();
        int diamode_w = (getWidth() - pad_l - pad_r) / DIAMODE_SCALE;


        Bitmap bitmapDark = Bitmap.createBitmap(diamode_w, diamode_w, Bitmap.Config.ARGB_8888);
        Canvas canvasDark = new Canvas(bitmapDark);
        Paint paintDark = new Paint();
        paintDark.setColor(TRANSPARENCY_DARK);
        canvasDark.drawRect(0, 0, diamode_w, diamode_w, paintDark);

        Bitmap bitmapLight = Bitmap.createBitmap(diamode_w, diamode_w, Bitmap.Config.ARGB_8888);
        Canvas canvasLight = new Canvas(bitmapLight);
        Paint paintLight = new Paint();
        paintLight.setColor(TRANSPARENCY_LIGHT);
        canvasLight.drawRect(0, 0, diamode_w, diamode_w, paintLight);

        for (int i = 0; (i < DIAMODE_SCALE + 1) && ((i * diamode_w + pad_t) < (getWidth() - pad_b)); i++) {
            for (int j = 0; (j < DIAMODE_SCALE + 1) && ((j * diamode_w + pad_l) < (getWidth() - pad_r)); j++) {
                int x = j * diamode_w + pad_l;
                int y = i * diamode_w + pad_t;
                if ((i + j) % 2 != 0) {
                    // light
                    canvas.drawBitmap(bitmapLight, x, y, null);
                } else {
                    // dark
                    canvas.drawBitmap(bitmapDark, x, y, null);
                }
            }
        }

        Log.i(TAG, "onDraw: " + isTouch);
        if (isTouch) {
            Paint paintShade = new Paint();
            paintShade.setColor(SHADE_COLOR);
            canvas.drawRect(pad_l, pad_t, (getWidth() - pad_r), (getHeight() - pad_b), paintShade);
        }


        /*Bitmap bitmapBg = Bitmap.createBitmap(diamode_w *2, diamode_w *2, Bitmap.Config.ARGB_8888);
        Canvas canvasBg = new Canvas(bitmapBg);
        Paint paintBg = new Paint();
        paintBg.setColor(TRANSPARENCY_LIGHT);
        canvasBg.drawRect(0,0, diamode_w, diamode_w,paintBg);
        paintBg.setColor(TRANSPARENCY_DARK);
        canvasBg.drawRect(diamode_w,0, diamode_w *2, diamode_w,paintBg);
        canvasBg.drawRect(0, diamode_w, diamode_w, diamode_w *2,paintBg);
        paintBg.setColor(TRANSPARENCY_LIGHT);
        canvasBg.drawRect(diamode_w, diamode_w, diamode_w *2, diamode_w *2,paintBg);
        BitmapDrawable drawableBg = new BitmapDrawable(bitmapBg);
        drawableBg.setTileModeXY(Shader.TileMode.REPEAT , Shader.TileMode.REPEAT );
        setBackground(drawableBg);*/


        int w = canvas.getWidth() - pad_l - pad_r;
        if (w == 0) {
            w = WIDTH_DEF;
        }
        int r = w / 3;

        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(),
                null, Canvas.ALL_SAVE_FLAG);

        // 注意：2bitmap的大小，和重叠情况
        // DST
        if (mDstBitmap == null) {
            mDstBitmap = Bitmap.createBitmap(3 * r, 3 * r, Bitmap.Config.ARGB_8888);
            mDstCanvas = new Canvas(mDstBitmap);
            mDstCanvas.drawCircle(r, r, r, mDstPaint);
        }
        canvas.drawBitmap(mDstBitmap, 0 + pad_l, 0 + pad_t, null);

        // SRC
        if (mSrcBitmap == null) {
            mSrcBitmap = Bitmap.createBitmap(3 * r, 3 * r, Bitmap.Config.ARGB_8888);
            mSrcCanvas = new Canvas(mSrcBitmap);
            mSrcCanvas.drawRect(r, r, 3 * r, 3 * r, mSrcPaint);
            mSrcPaint.setXfermode(new PorterDuffXfermode(mode));
        }
        canvas.drawBitmap(mSrcBitmap, 0 + pad_l, 0 + pad_t, mSrcPaint);

        canvas.restoreToCount(layerId);
    }


    public void setMode(PorterDuff.Mode mode) {
        this.mode = mode;
        invalidate();
    }

    public void setClickListener(OnClickListener clickListener) {
        this.clickListener = clickListener;
    }
}

