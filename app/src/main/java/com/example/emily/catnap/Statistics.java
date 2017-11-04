package com.example.emily.catnap;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
//import com.jjoe64.graphview.GridLabelRenderer;

public class Statistics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        GraphView graph = findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint []{
                new DataPoint(0,1),
                new DataPoint(1,5)
        });

        series.setTitle("Statistics");
        series.setColor(Color.BLUE);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);
        series.setThickness(7);
//        series.setVerticalAxisTitle("Minutes slept");
//        series.setHorizontalAxisTitle("Hours");
        graph.addSeries(series);
    }

}
