package com.example.emily.catnap;

import android.app.Application;

import java.util.Calendar;

/**
 * Created by Stanley on 11/4/2017.
 */

public class GlobalVars extends Application {

    private boolean do_not_show = false;
    private boolean snoozed = true;
    private Calendar startTime =  Calendar.getInstance() ;
    private Calendar endTime =  Calendar.getInstance() ;

    public boolean get_do_not_show() {
        return do_not_show;
    }

    public void set_do_not_show(boolean flag) {
        do_not_show = flag;
    }

    public boolean get_snoozed() {
        return snoozed;
    }

    public void set_snoozed(boolean flag) {
        snoozed = flag;
    }

    public Calendar get_startTime() { return startTime; }

    public void set_startTime(Calendar date) {
        startTime = date;
    }

    public Calendar get_endTime() { return endTime; }

    public void set_endTime(Calendar date) {
        endTime = date;
    }
}
