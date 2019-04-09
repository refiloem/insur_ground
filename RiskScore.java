package com.financialfitnessbunnies.zakayaka;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class RiskScore extends AppCompatActivity {

    private PieChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_score);

        mChart = findViewById(R.id.chart);
        mChart.setBackgroundColor(Color.WHITE);

        moveOffScreen();

        setData(5, 100);

    }

    String[] riskLevels = new String[] {"High", "Moderate", "Low"};
    private void setData(int count, int range){
        ArrayList<PieEntry> values = new ArrayList<>();

        for (int i =0; i<count; i++) {
            float val = (float)((Math.random()*range)+range/5);
            values.add(new PieEntry(val, riskLevels[i]));
        }

        PieDataSet dataSet = new PieDataSet(values, "Partner");
        dataSet.setSelectionShift(5f);
        dataSet.setSliceSpace(3f);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData data = new PieData(dataSet);
        dataSet.setValueFormatter(new PercentFormatter());
        dataSet.setValueTextSize(15f);
        dataSet.setValueTextColor(Color.WHITE);

        mChart.setData(data);
        mChart.invalidate();
    }

     private void moveOffScreen() {
         Display display = getWindowManager().getDefaultDisplay();
         DisplayMetrics metrics = new DisplayMetrics();
         getWindowManager().getDefaultDisplay().getMetrics(metrics);
         int height = metrics.heightPixels;

         int offset = (int) (height*0.5);

         RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)mChart.getLayoutParams();
         params.setMargins(0, 0, 0, -offset);
         mChart.setLayoutParams(params);
    }

}





















