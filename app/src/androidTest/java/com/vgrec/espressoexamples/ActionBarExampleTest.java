package com.vgrec.espressoexamples;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * @author vgrec, created on 3/20/15.
 */
public class ActionBarExampleTest extends ActivityInstrumentationTestCase2<ActionBarExampleActivity> {


    public ActionBarExampleTest() {
        super(ActionBarExampleActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testClickOnMenuItem() {
        // Click on an item from ActionBar
        onView(withId(R.id.action_settings)).perform(click());

        // Verify the correct item was clicked by checking the content of the status TextView
        onView(withId(R.id.status)).check(matches(withText("Settings")));
    }

    public void testOverflowMenuOrOptionsMenu() {
        // Open the action bar overflow or options menu (depending if the device has or not a hardware menu button.)
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getContext());

        // Find the menu item with text "About" and click on it
        onView(withText("About")).perform(click());

        // Verify the correct item was clicked by checking the content of the status TextView
        onView(withId(R.id.status)).check(matches(withText("About")));
    }

    public void testActionMode() {
        // Show the contextual ActionBar
        onView(withId(R.id.toggle_action_mode)).perform(click());

        // Click on a context item
        onView(withId(R.id.action_one)).perform(click());

        // Verify the correct item was clicked by checking the content of the status TextView
        onView(withId(R.id.status)).check(matches(withText("ActionMode1")));
    }
}
