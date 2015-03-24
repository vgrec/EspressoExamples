package com.vgrec.espressoexamples.matchers;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;

import com.vgrec.espressoexamples.models.Book;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static com.android.support.test.deps.guava.base.Preconditions.checkNotNull;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author vgrec, created on 3/17/15.
 */
public class CustomMatchers {


    /**
     * Finds the AdapterView and let another Matcher interrogate the data within it.
     */
    public static Matcher<View> withAdaptedData(final Matcher<Object> dataMatcher) {
        return new TypeSafeMatcher<View>() {

            @Override
            public void describeTo(Description description) {
                description.appendText("with class name: ");
                dataMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                if (!(view instanceof AdapterView)) {
                    return false;
                }
                @SuppressWarnings("rawtypes")
                Adapter adapter = ((AdapterView) view).getAdapter();
                for (int i = 0; i < adapter.getCount(); i++) {
                    if (dataMatcher.matches(adapter.getItem(i))) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    /**
     * Matches an item from an AdapterView with a specific String.
     * (The items in AdapterView should be strings)
     */
    public static Matcher<Object> withItemContent(String expectedText) {
        checkNotNull(expectedText);
        return withItemContent(equalTo(expectedText));
    }

    public static Matcher<Object> withItemContent(final Matcher<String> itemTextMatcher) {
        checkNotNull(itemTextMatcher);
        return new BoundedMatcher<Object, String>(String.class) {
            @Override
            public boolean matchesSafely(String text) {
                return itemTextMatcher.matches(text);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with item content: ");
                itemTextMatcher.describeTo(description);
            }
        };
    }


    /**
     * Matches a Book with a specific ID
     */
    public static Matcher<Object> withBookId(final int bookId) {
        return new BoundedMatcher<Object, Book>(Book.class) {
            @Override
            protected boolean matchesSafely(Book book) {
                return bookId == book.getId();
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with id: " + bookId);
            }
        };
    }

    /**
     * Matches a Book with a specific title
     */
    public static Matcher<Object> withBookTitle(final String bookTitle) {
        return new BoundedMatcher<Object, Book>(Book.class) {
            @Override
            protected boolean matchesSafely(Book book) {
                return bookTitle.equals(book.getTitle());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with id: " + bookTitle);
            }
        };
    }

    /**
     * Matches a Book with a specific author name
     */
    public static Matcher<Object> withBookAuthor(final String bookAuthor) {
        return new BoundedMatcher<Object, Book>(Book.class) {
            @Override
            protected boolean matchesSafely(Book book) {
                return bookAuthor.equals(book.getAuthor());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with id: " + bookAuthor);
            }
        };
    }
}
