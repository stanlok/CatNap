package com.example.emily.catnap;

import android.app.Application;

import java.util.Calendar;

/**
 * Created by Stanley on 11/4/2017.
 *
 * This class holds the variables that will remain persistent
 * through the entire session (independent of Activity switching).
 *
 */

public class GlobalVars extends Application {

    /**
     * Global Variables:
     *   do_not_show - used to skip showing the Terms and Conditions page
     *                 once the user checks the "Do not show again" checkbox
     *
     *   snoozed     - used to control the toggle button on the Customize
     *                 activity page, which controls whether the user's phone
     *                 will receive notifications at the specified time interval
     *
     *   startTime   - stores the user-inputted start time of when they should be
     *                 sleeping; when snoozed is set to false, user will receive
     *                 notifications beginning at this time
     *
     *   endTime     - stores the user-inputted end time of when they should wake
     *                 up; when snoozed is set to false, user will stop receiving
     *                 notifications after this time
     */
    private boolean do_not_show = false;
    private boolean snoozed = true;
    private Calendar startTime =  Calendar.getInstance() ;
    private Calendar endTime =  Calendar.getInstance() ;

    /**
     * Used to determine whether or not to show the Terms and
     * Conditions page
     *
     * @return global boolean value of do_not_show
     */
    public boolean get_do_not_show() {
        return do_not_show;
    }

    /**
     * Used to set the global value of do_not_show, determined by
     * whether the user clicks on the checkbox or not in the Terms
     * and Conditions page
     *
     * @param flag
     *      set to true if user chooses to tick the checkbox
     */
    public void set_do_not_show(boolean flag) {
        do_not_show = flag;
    }

    /**
     * Used to determine whether the user will receive notifications
     * within the user-specified time interval; when snoozed is true,
     * user will not receive notifications
     *
     * @return global boolean value of snoozed
     */
    public boolean get_snoozed() {
        return snoozed;
    }

    /**
     * Used to set the global value of snoozed to toggle between receiving
     * and not receiving notifications; value is changed when user clicks on
     * the toggle button on the Customize activity page
     *
     * @param flag
     *      alternates between true and false depending on the state of the
     *      toggle button at the time of a user onClick
     */
    public void set_snoozed(boolean flag) {
        snoozed = flag;
    }

    /**
     * @return the user-inputted starting interval of the time they specified
     *         to be sleeping
     */
    public Calendar get_startTime() { return startTime; }

    /**
     * Obtains the user-specified starting time of the interval when they
     * should be asleep
     *
     * @param date
     *      Specified starting time of sleeping stored as a Calendar object
     */
    public void set_startTime(Calendar date) {
        startTime = date;
    }

    /**
     * @return the user-inputted ending interval of the time they specified
     *         to be sleeping
     */
    public Calendar get_endTime() { return endTime; }

    /**
     * Obtains the user-specified ending time of the interval when they
     * should be asleep
     *
     * @param date
     *      Specified ending time of sleeping stored as a Calendar object
     */
    public void set_endTime(Calendar date) {
        endTime = date;
    }
}
