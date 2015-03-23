package com.vgrec.espressoexamples;

import android.test.ActivityInstrumentationTestCase2;

import com.vgrec.espressoexamples.activities.SpinnerSelectionActivity;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.vgrec.espressoexamples.matchers.CustomMatchers.withAdaptedData;
import static com.vgrec.espressoexamples.matchers.CustomMatchers.withItemContent;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.not;


/**
 * @author vgrec, created on 3/17/15.
 */
public class SpinnerSelectionTest extends ActivityInstrumentationTestCase2<SpinnerSelectionActivity> {

    public static final String INVALID_COUNTRY_NAME = "NoSuchCountry";
    public static final String VALID_COUNTRY_NAME = "Moldova";
    public static final String FIRST_ITEM_TEXT = "Select your country";

    public SpinnerSelectionTest() {
        super(SpinnerSelectionActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testCountryNotInList() {
        onView(withId(R.id.countries_spinner)).check(matches(not(withAdaptedData(withItemContent(INVALID_COUNTRY_NAME)))));
    }

    public void testLabelDoesNotChangeIfFirstItemSelected() {
        // Click on the Spinner
        onView(withId(R.id.countries_spinner)).perform(click());

        // Click on the first item from the list, which is a marker string: "Select your country"
        onData(allOf(is(instanceOf(String.class)))).atPosition(0).perform(click());

        // Check that the country label is not updated.
        onView(withId(R.id.country_label)).check(matches(not(withText(FIRST_ITEM_TEXT))));
    }

    public void testLabelUpdatesIfValidCountrySelected() {
        onView(withId(R.id.countries_spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is(VALID_COUNTRY_NAME))).perform(click());
        onView(withId(R.id.country_label)).check(matches(withText(VALID_COUNTRY_NAME)));
    }
}
