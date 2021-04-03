package com.example.chattry;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int last;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        TextView tv = new TextView(this);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        p.weight = 0;
        p.setMargins(0, dp2px(8), 0, 0); // setMargins only accepts values in px so use dp2px

        tv.setLayoutParams(p);

        // set the background resource before setting the padding
        tv.setBackgroundResource(R.drawable.rounded_corner);
        tv.setPadding(dp2px(8), dp2px(8), dp2px(16), dp2px(8));
        tv.setText("Hi! :)");
        tv.setTextColor(Color.BLACK);

        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f);


        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams pdash = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ll.setLayoutParams(pdash);
        ll.addView(tv);

        RelativeLayout rv = (RelativeLayout) findViewById(R.id.rvMain);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.BELOW, R.id.ll2);

        rv.addView(ll, params);
         */
        last = R.id.ll2;

        findViewById(R.id.btnSend).setOnClickListener(v -> {
            TextView tv = new TextView(this);
            EditText et = findViewById(R.id.etData);
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            p.weight = 0;
            p.setMargins(0, dp2px(8), 0, 0); // setMargins only accepts values in px so use dp2px

            tv.setLayoutParams(p);

            // set the background resource before setting the padding
            tv.setBackgroundResource(R.drawable.rounded_corner);
            tv.setPadding(dp2px(8), dp2px(8), dp2px(16), dp2px(8));
            tv.setText(et.getText().toString());
            et.setText("");
            tv.setTextColor(Color.BLACK);

            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f);


            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams pdash = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            ll.setLayoutParams(pdash);
            ll.addView(tv);

            RelativeLayout rv = (RelativeLayout) findViewById(R.id.rvMain);

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            params.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE);
            params.addRule(RelativeLayout.BELOW, last);
            ll.setId(View.generateViewId()); // this is required as by default id of every view is -1
            last = ll.getId(); // store the id of the last chat bubble
            rv.addView(ll, params);
        });
    }

    /**
     * Converts a given value in dp to px
     * @param dpm the value to be converted
     * @return the value dpm in px
     */
    private int dp2px(int dpm) {
        // The following way also works:
        //final float scale = getResources().getDisplayMetrics().density;
        //return (int) (dpm * scale + 0.5f);

        // But I like this one:
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpm, getResources().getDisplayMetrics());
    }
}