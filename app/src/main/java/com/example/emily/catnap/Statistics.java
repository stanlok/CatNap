package com.example.emily.catnap;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

/**
 * Created by Emily on 11/4/2017.
 *
 * This class creates a line graph for the Statistics page
 * to plot the amount of time the user is sleeping, which is
 * measured by the amount of time their phone screen is off
 * during the user's specified time interval.
 */

public class Statistics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        /**
         * x - The hour in the day
         *
         * y - The amount of sleep the user got
         */
        int[] x = new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12};
        int[] y = new int[] {0,15,0,25,5,0,0,7,10,20,2,0,0};

        /**
         * Graphs and displays the data in a line graph
         */
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
