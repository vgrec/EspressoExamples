package com.vgrec.espressosamples;

import android.test.ActivityInstrumentationTestCase2;

import com.vgrec.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

/**
 * @author vgrec, created on 3/17/15.
 */
public class EnterNameTest extends ActivityInstrumentationTestCase2<EnterNameActivity> {

    public static final String USER_NAME = "John";
    public static final String GREETING_MESSAGE = "Hello " + USER_NAME + "!";

    public EnterNameTest() {
        super(EnterNameActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testHintDisplayed() {
        onView(withId(R.id.name_edittext)).check(matches(withHint(R.string.enter_name)));
    }

    public void testErrorMessageDisplayed() {
        // Making sure the error message is not displayed by default
        onView(withId(R.id.error_text)).check(matches(is(not(isDisplayed()))));

        // Click on "Next" button
        onView(withId(R.id.next_button)).perform(click());

        // Now check the error message is displayed
        onView(withId(R.id.error_text)).check(matches(isDisplayed()));
    }

    public void testGreetingMessageWithNameDisplayed() {
        onView(withId(R.id.name_edittext)).perform(typeText(USER_NAME));
        onView(withId(R.id.next_button)).perform(click());
        onView(withId(R.id.greeting_message)).check(matches(withText(GREETING_MESSAGE)));
    }
}
