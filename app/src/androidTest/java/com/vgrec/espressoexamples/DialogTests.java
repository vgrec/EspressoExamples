package com.vgrec.espressoexamples;

import android.test.ActivityInstrumentationTestCase2;

import com.vgrec.espressoexamples.activities.DialogExampleActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * @author vgrec, created on 3/24/15.
 */
public class DialogTests extends ActivityInstrumentationTestCase2<DialogExampleActivity> {

    public DialogTests() {
        super(DialogExampleActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testCheckDialogDisplayed() {
        // Click on the button that shows the dialog
        onView(withId(R.id.confirm_dialog_button)).perform(click());

        // Check the dialog title text is displayed
        onView(withText(R.string.dialog_title)).check(matches(isDisplayed()));
    }

    public void testClickOkButton() {
        onView(withId(R.id.confirm_dialog_button)).perform(click());

        // android.R.id.button1 = positive button
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.status_text)).check(matches(withText(R.string.ok)));
    }

    public void testClickCancelButton() {
        onView(withId(R.id.confirm_dialog_button)).perform(click());

        // android.R.id.button2 = negative button
        onView(withId(android.R.id.button2)).perform(click());

        onView(withId(R.id.status_text)).check(matches(withText(R.string.cancel)));
    }
}
