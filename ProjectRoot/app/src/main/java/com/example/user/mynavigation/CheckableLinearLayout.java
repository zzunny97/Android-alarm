package com.example.user.mynavigation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.LinearLayout;

public class CheckableLinearLayout extends LinearLayout implements Checkable {
    CheckBox cb;
    public CheckableLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setChecked(boolean checked) {
        cb = (CheckBox)findViewById(R.id.checkBox1);
        if(cb.isChecked() != checked) {
            cb.setChecked(checked);
        }
    }

    @Override
    public boolean isChecked() {
        cb = (CheckBox)findViewById(R.id.checkBox1);
        return cb.isChecked();
    }

    @Override
    public void toggle() {
        cb = (CheckBox)findViewById(R.id.checkBox1);
        setChecked(cb.isChecked() ? false : true);
    }
}
