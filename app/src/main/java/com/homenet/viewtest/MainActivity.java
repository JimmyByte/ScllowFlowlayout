package com.homenet.viewtest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private TagFlowLayout tagFlowLayout;
    private LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tagFlowLayout = findViewById(R.id.job_details_dialog_tfl);

        mInflater = LayoutInflater.from(this);
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            stringList.add("第" + i);
        }

        ViewGroup.MarginLayoutParams iteminterviewdialogtimellLayoutParams = (ViewGroup.MarginLayoutParams) tagFlowLayout.getLayoutParams(); //取控件textView当前的布局参数

        iteminterviewdialogtimellLayoutParams.width = 200*10;
        tagFlowLayout.setLayoutParams(iteminterviewdialogtimellLayoutParams);


        setDialogFlowLayoutAdapter(tagFlowLayout, stringList);
    }


    private void setDialogFlowLayoutAdapter(final TagFlowLayout flowLayout, List<String> stringList) {
        flowLayout.setMaxSelectCount(1);
        TagAdapter tagAdapter=new TagAdapter<String>(stringList) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                View tv = (View) mInflater.inflate(R.layout.item_interview_dialog_time, flowLayout, false);

                TextView tvDateName = tv.findViewById(R.id.tvDateName);
                tvDateName.setText(o);
                return tv;
            }
        };
        tagAdapter.setSelectedList(2);
        flowLayout.setAdapter(tagAdapter);
    }
}
