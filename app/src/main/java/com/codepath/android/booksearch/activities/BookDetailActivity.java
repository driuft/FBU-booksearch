package com.codepath.android.booksearch.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.android.booksearch.R;
import com.codepath.android.booksearch.models.Book;

import org.parceler.Parcel;
import org.parceler.Parcels;

public class BookDetailActivity extends AppCompatActivity {
    private ImageView ivBookCover;
    private TextView tvTitle;
    private TextView tvAuthor;
    private TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        // Fetch views
        ivBookCover = (ImageView) findViewById(R.id.ivBookCover);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvAuthor = (TextView) findViewById(R.id.tvAuthor);
        tvDate = (TextView) findViewById(R.id.tvDate);

        // Extract book object from intent extras
        Book book = (Book) Parcels.unwrap(getIntent().getParcelableExtra(BookListActivity.KEY_BOOK));
        getSupportActionBar().setTitle(book.getTitle());

        // Use book object to populate data into views
        tvTitle.setText(book.getTitle());
        tvAuthor.setText(book.getAuthor());
        Log.d("Book Date: ", book.getDate());
        tvDate.setText(book.getDate());
        Glide.with(getApplicationContext()).load(book.getCoverUrl()).into(ivBookCover);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
