package com.hzl1994.xfermodedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.hzl1994.xfermodedemo.view.XferModeTestView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 黄智龙 on 2017/10/16.
 */

public class XferAdapter extends BaseAdapter {
    private List<XferModeTest> xferModeTests = new ArrayList<>();
    private Context context;

    public XferAdapter(Context context, List<XferModeTest> xferModeTests) {
        super();
        this.context = context;
        this.xferModeTests = xferModeTests;
    }

    @Override
    public int getCount() {
        if (xferModeTests == null) {
            return 0;
        }
        return xferModeTests.size();
    }

    @Override
    public Object getItem(int i) {
        if (xferModeTests == null) {
            return null;
        }
        return xferModeTests.size() > i ? xferModeTests.get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            // 获得容器
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.xferview_item, null);

            viewHolder.tvTitle = view.findViewById(R.id.tv_title);
            viewHolder.xmtv = view.findViewById(R.id.xmtv);
            view.setTag(viewHolder);
        } else {
            // 取得converHolder附加的对象
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tvTitle.setText(xferModeTests.get(i).getTitle());
        viewHolder.xmtv.setMode(xferModeTests.get(i).getMode());
        viewHolder.xmtv.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, ""+xferModeTests.get(i).getMode(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    class ViewHolder{
        public TextView tvTitle;
        public XferModeTestView xmtv;
    }
}
