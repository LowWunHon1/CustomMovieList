package sg.edu.rp.c346.id21012050.custommovielist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "simplemovies.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_MOVIES = "movies";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_GENRE = "genre";
    private static final String COLUMN_YEAR = "year";
    private static final String COLUMN_RATING = "ratings";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createNoteTableSql = "CREATE TABLE " + TABLE_MOVIES + "("
                + COLUMN_TITLE + " TEXT,"
                + COLUMN_GENRE + " TEXT,"
                + COLUMN_YEAR + " INTEGER,"
                + COLUMN_RATING + " TEXT ) ";
        db.execSQL(createNoteTableSql);
        Log.i("info", "created tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("ALTER TABLE " + TABLE_MOVIES + " ADD COLUMN  module_name TEXT ");
    }

    public long insertMovie(String title, String genre, int year, String ratings) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_GENRE, genre);
        values.put(COLUMN_YEAR, year);
        values.put(COLUMN_RATING, ratings);
        long result = db.insert(TABLE_MOVIES, null, values);
        db.close();
        Log.d("SQL Insert","ID:"+ result); //id returned, shouldn’t be -1
        return result;
    }

    public ArrayList<Movie> getAllMovies() {
        ArrayList<Movie> songs = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns= {COLUMN_TITLE, COLUMN_GENRE, COLUMN_YEAR, COLUMN_RATING};
        Cursor cursor = db.query(TABLE_MOVIES, columns, null, null,
                null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                String title = cursor.getString(0);
                String genre = cursor.getString(1);
                int year = cursor.getInt(2);
                String ratings = cursor.getString(3);
                Movie movie = new Movie(title, genre, year, ratings);
                songs.add(movie);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return songs;
    }
}