package com.vgrec.espressoexamples;

import com.vgrec.espressoexamples.models.Book;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author vgrec, created on 3/23/15.
 */
public class Database {

    public static final ArrayList<Book> NEW_BOOKS = new ArrayList<>(Arrays.asList(
            new Book(1, "Some book", "Robert Mulavski"),
            new Book(2, "Some book", "Robert Mulavski"),
            new Book(3, "Book 2", "Robert Mulavski"),
            new Book(4, "Alice in the", "Robert Mulavski"),
            new Book(5, "C++ for primers", "Robert Mulavski")
    ));

    public static final ArrayList<Book> ALL_BOOKS = new ArrayList<>(Arrays.asList(
            new Book(1, "Some book", "Robert Mulavski"),
            new Book(2, "Some book", "Robert Mulavski"),
            new Book(3, "Book 2", "Robert Mulavski"),
            new Book(4, "Alice in the", "Robert Mulavski"),
            new Book(5, "C++ for primers", "Robert Mulavski"),
            new Book(6, "What to do", "Robert Mulavski"),
            new Book(7, "How much", "Robert Mulavski"),
            new Book(8, "Why", "Robert Mulavski"),
            new Book(9, "Be cool", "Robert Mulavski"),
            new Book(10, "Anton", "Robert Mulavski"),
            new Book(11, "Alizar", "Robert Mulavski"),
            new Book(12, "How amazon", "Robert Mulavski"),
            new Book(13, "Aricie", "Robert Mulavski"),
            new Book(14, "Master Book", "Robert Mulavski"),
            new Book(15, "Nonavici", "Robert Mulavski"),
            new Book(16, "Roberto", "Robert Mulavski"),
            new Book(17, "Utilita", "Robert Mulavski")
    ));
}
