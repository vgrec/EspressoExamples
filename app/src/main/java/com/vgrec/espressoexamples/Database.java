package com.vgrec.espressoexamples;

import com.vgrec.espressoexamples.models.Book;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class holds constants with some data for testing.
 *
 * @author vgrec, created on 3/23/15.
 */
public class Database {

    public static final ArrayList<Book> NEW_BOOKS = new ArrayList<>(Arrays.asList(
            new Book(1, "Clean Code", "Robert C. Martin"),
            new Book(2, "The Clean Coder", "Robert C. Martin"),
            new Book(3, "Code Complete 2", "Steve McConnell"),
            new Book(4, "Effective Java ", "Joshua Bloch"),
            new Book(5, "Java Concurrency in Practice", "Brian Goetz")
    ));

    public static final ArrayList<Book> ALL_BOOKS = new ArrayList<>(Arrays.asList(
            new Book(1, "Clean Code", "Robert C. Martin"),
            new Book(2, "The Clean Coder", "Robert C. Martin"),
            new Book(3, "Code Complete 2", "Steve McConnell"),
            new Book(4, "Effective Java ", "Joshua Bloch"),
            new Book(9, "Refactoring: Improving the Design of Existing Code", "Martin Fowler"),
            new Book(5, "Java Concurrency in Practice", "Brian Goetz"),
            new Book(6, "Essential Algorithms", "Rod Stephens"),
            new Book(7, "Algorithms", "Robert Sedgewick"),
            new Book(8, "The Passionate Programmer", "Chad Fowler"),
            new Book(10, "The Pragmatic Programmer", "Andrew Hunt"),
            new Book(11, "Seven Languages in Seven Weeks", "Bruce A. Tate"),
            new Book(12, "The Ruby Programming Language", "David Flanagan"),
            new Book(13, "Agile Web Development with Rails 4 ", "Sam Ruby")
    ));

    public static final String[] CITIES = {
            "Berlin",
            "Havana",
            "Helsinki",
            "Jakarta",
            "Paris",
            "Prague",
            "Sofia"
    };
}
