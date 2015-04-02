package com.vgrec.espressoexamples;

import android.support.test.espresso.contrib.PickerActions;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.vgrec.espressoexamples.activities.DateTimePickerActivity;

import org.hamcrest.Matchers;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * @author vgrec, created on 4/2/15.
 */
public class DateTimePickerTest extends ActivityInstrumentationTestCase2<DateTimePickerActivity> {
    public DateTimePickerTest() {
        super(DateTimePickerActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testSetDate() {
        int year = 2020;
        int month = 11;
        int day = 15;

        onView(withId(R.id.date_picker_button)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(year, month + 1, day));
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.status)).check(matches(withText(year + "/" + month + "/" + day)));
    }

    public void testSetTime() {
        int hour = 10;
        int minutes = 59;

        onView(withId(R.id.time_picker_button)).perform(click());
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName()))).perform(PickerActions.setTime(hour, minutes));
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.status)).check(matches(withText(hour + ":" + minutes)));
    }
}
