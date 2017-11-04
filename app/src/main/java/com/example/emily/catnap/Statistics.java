package com.example.emily.catnap;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class Statistics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        int[] x = new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12};
        int[] y = new int[] {0,0,0,0,0,0,0,7,60,52,0,0,0};

        GraphView graph = findViewById(R.id.graph);
        DataPoint[] values = new DataPoint[x.length];
        for (int i =0; i <x.length;i++) {
            values[i] = new DataPoint(x[i], y[i]);
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(values);


        graph.setTitle("Statistics");
        graph.setTitleTextSize(150);
        series.setColor(Color.BLUE);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);
        series.setThickness(7);
        graph.getGridLabelRenderer().setVerticalAxisTitle("Minutes slept");
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Time of day (in hours)");
        graph.addSeries(series);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(12);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(60);

    }

}
