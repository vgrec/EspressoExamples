package com.vgrec.espressosamples;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import org.hamcrest.Matchers;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.vgrec.espressosamples.matchers.CustomMatchers.withItemContent;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.not;

/**
 * @author vgrec, created on 3/19/15.
 */
public class SearchViewTest extends ActivityInstrumentationTestCase2<SearchViewActivity> {

    public SearchViewTest() {
        super(SearchViewActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testItemNotFound() {
        // Click on the search icon
        onView(withId(R.id.action_search)).perform(click());

        // Type the text in the search field and submit the query
        onView(isAssignableFrom(EditText.class)).perform(typeText("No such item"), pressImeActionButton());

        // Check the empty view is displayed
        onView(withId(R.id.empty_view)).check(matches(isDisplayed()));
    }

    public void testItemFound() {
        onView(withId(R.id.action_search)).perform(click());
        onView(isAssignableFrom(EditText.class)).perform(typeText("Java"), pressImeActionButton());

        // Check empty view is not displayed
        onView(withId(R.id.empty_view)).check(matches(not(isDisplayed())));

        // Check the item we are looking for is in the search result list.
        onData(allOf(is(instanceOf(String.class)), withItemContent("Java"))).check(matches(isDisplayed()));
    }

    public void testSearchSuggestionDisplayed() {
        onView(withId(R.id.action_search)).perform(click());
        onView(isAssignableFrom(EditText.class)).perform(typeText("Java"), pressImeActionButton());

        // Go back to previous screen
        pressBack();

        // Clear the text in search field
        onView(isAssignableFrom(EditText.class)).perform(clearText());

        // Enter the first letter of the previously searched word
        onView(isAssignableFrom(EditText.class)).perform(typeText("Ja"));

        // Check the search suggestions appear
        onView(withText("Java"))
                .inRoot(withDecorView(not(Matchers.is(getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }

    public void testClickOnSearchSuggestion() {
        onView(withId(R.id.action_search)).perform(click());
        onView(isAssignableFrom(EditText.class)).perform(typeText("Java"), pressImeActionButton());

        // Go back to previous screen
        pressBack();

        // Clear the text in search field
        onView(isAssignableFrom(EditText.class)).perform(clearText());

        // Enter the first letter of the previously searched word
        onView(isAssignableFrom(EditText.class)).perform(typeText("Ja"));


        // Click on the "Java" item from the suggestions list
        onView(withText("Java"))
                .inRoot(withDecorView(not(Matchers.is(getActivity().getWindow().getDecorView()))))
                .perform(click());

        // Check the item appears in search results list.
        onData(allOf(is(instanceOf(String.class)), withItemContent("Java"))).check(matches(isDisplayed()));
    }

}
