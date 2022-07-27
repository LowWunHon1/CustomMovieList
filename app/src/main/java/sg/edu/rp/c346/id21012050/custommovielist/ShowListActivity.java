package sg.edu.rp.c346.id21012050.custommovielist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowListActivity extends AppCompatActivity {

    Button btnPG13;
    ListView lvMovies;
    ArrayList<Movie> alMovies;
    ArrayAdapter<Movie> aaMovies;
    CustomAdapter caMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        btnPG13 = findViewById(R.id.buttonPG13);
        lvMovies = findViewById(R.id.listViewMovies);

        alMovies = new ArrayList<Movie>();

        aaMovies = new ArrayAdapter<Movie>(this, android.R.layout.simple_list_item_1, alMovies);

        caMovies = new CustomAdapter(this, R.layout.row, alMovies);

        lvMovies.setAdapter(caMovies);

        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(ShowListActivity.this,
                        ModifyActivity.class);
                Movie data = alMovies.get(position);
                i.putExtra("data", data);
                startActivity(i);
            }
        });

        btnPG13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(ShowListActivity.this);

                alMovies.clear();
                alMovies.addAll(dbh.getAllPG13Movies());
                caMovies.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbh = new DBHelper(ShowListActivity.this);
        alMovies.clear();
        alMovies.addAll(dbh.getAllMovies());
        caMovies.notifyDataSetChanged();
        lvMovies.performClick();
    }
}