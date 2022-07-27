package sg.edu.rp.c346.id21012050.custommovielist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvMovieTitle = rowView.findViewById(R.id.textViewMovieTitle);
        TextView tvMovieGenre = rowView.findViewById(R.id.textViewMovieGenre);
        TextView tvReleaseYear = rowView.findViewById(R.id.textViewReleaseYear);
        ImageView ivMovieRatings = rowView.findViewById(R.id.imageViewRating);

        Movie currentItem = movieList.get(position);
        tvMovieTitle.setText(currentItem.getTitle());
        tvMovieGenre.setText(currentItem.getGenre());
        tvReleaseYear.setText(currentItem.getYear() + "");

        if (currentItem.getRating().equals("G")) {
            ivMovieRatings.setImageResource(R.drawable.rating_g);
        } else if (currentItem.getRating().equals("PG")) {
            ivMovieRatings.setImageResource(R.drawable.rating_pg);
        } else if (currentItem.getRating().equals("PG13")) {
            ivMovieRatings.setImageResource(R.drawable.rating_pg13);
        } else if (currentItem.getRating().equals("NC16")) {
            ivMovieRatings.setImageResource(R.drawable.rating_nc16);
        } else if (currentItem.getRating().equals("M18")) {
            ivMovieRatings.setImageResource(R.drawable.rating_m18);
        } else if (currentItem.getRating().equals("R21")) {
            ivMovieRatings.setImageResource(R.drawable.rating_r21);
        }

        return rowView;

    }

}
