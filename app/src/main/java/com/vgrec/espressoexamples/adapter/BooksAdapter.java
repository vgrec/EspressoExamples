package com.vgrec.espressoexamples.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vgrec.espressoexamples.R;
import com.vgrec.espressoexamples.models.Book;

import java.util.ArrayList;

/**
 * Adapter that provides views for the list
 */
public class BooksAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<Book> items;


    public BooksAdapter(Context context, ArrayList<Book> items) {
        this.items = items;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_book, parent, false);
        }

        TextView bookTitle = (TextView) convertView.findViewById(R.id.book_title);
        bookTitle.setText(items.get(position).getTitle());

        TextView bookAuthor = (TextView) convertView.findViewById(R.id.book_author);
        bookAuthor.setText("by " + items.get(position).getAuthor());

        return convertView;
    }
}