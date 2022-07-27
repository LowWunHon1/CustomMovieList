package sg.edu.rp.c346.id21012050.custommovielist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnShowList;
    EditText etTitle, etGenre, etYear;
    Spinner spnMovies;
    ArrayList<Movie> alMovies;
    ArrayAdapter<Movie> aaMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.buttonInsert);
        btnShowList = findViewById(R.id.buttonShowList);
        etTitle = findViewById(R.id.editTextTitle);
        etGenre = findViewById(R.id.editTextGenre);
        etYear = findViewById(R.id.editTextYear);
        spnMovies = findViewById(R.id.spinnerMovies);

        alMovies = new ArrayList<>();
        aaMovies = new ArrayAdapter<Movie>(this,
                android.R.layout.simple_list_item_1, alMovies);

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ShowListActivity.class);
                startActivity(i);
            }
        });

    }
}