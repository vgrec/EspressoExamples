package com.vgrec.espressoexamples;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.AdapterView;

import com.vgrec.espressoexamples.activities.ViewPagerActivity;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.vgrec.espressoexamples.matchers.CustomMatchers.withBookAuthor;
import static com.vgrec.espressoexamples.matchers.CustomMatchers.withBookTitle;
import static org.hamcrest.CoreMatchers.allOf;


/**
 * @author vgrec, created on 3/23/15.
 */
public class ViewPagerTest extends ActivityInstrumentationTestCase2<ViewPagerActivity> {

    private static final String BOOK_TITLE = "C++ for primers";
    private static final String BOOK_AUTHOR = "Robert Mulavski";

    public ViewPagerTest() {
        super(ViewPagerActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testAllTabDisplayedOnSwipe() {
        // Locate the ViewPager and perform a swipe left action
        onView(withId(R.id.pager)).perform(swipeLeft());

        // Check the "ALL BOOKS" text is displayed
        onView(allOf(withId(R.id.header_text), isDisplayed())).check(matches(withText("ALL BOOKS")));
    }

    public void testClickOnBookFromNewTab() {
        // The below commented out line will fail with AmbiguousViewMatcherException because the same ListView is used in both pages of ViewPager.
        // onData(allOf(withBookTitle(BOOK_TITLE), withBookAuthor(BOOK_AUTHOR))).perform(click());

        // We have to refine the query specifying that we are looking for an AdapterView that is currently visible.
        onData(allOf(withBookTitle(BOOK_TITLE), withBookAuthor(BOOK_AUTHOR)))
                .inAdapterView(allOf(isAssignableFrom(AdapterView.class), isDisplayed()))
                .perform(click());

        // Check the correct book title is displayed
        onView(withId(R.id.book_title)).check(matches(withText(BOOK_TITLE)));

        // Check the correct author is displayed
        onView(withId(R.id.book_author)).check(matches(withText(BOOK_AUTHOR)));
    }
}
