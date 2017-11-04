package com.example.emily.catnap;

import android.app.Application;

/**
 * Created by Stanley on 11/4/2017.
 */

public class GlobalVars extends Application {

    private boolean do_not_show = false;
    private boolean snoozed = true;

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
}
