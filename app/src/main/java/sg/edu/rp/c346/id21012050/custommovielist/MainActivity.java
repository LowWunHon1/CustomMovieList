package sg.edu.rp.c346.id21012050.custommovielist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnShowList;
    EditText etTitle, etGenre, etYear;
    Spinner spnMovies;
    ArrayList<Movie> alMovies;
    CustomAdapter caMovies;

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

        caMovies = new CustomAdapter(this, R.layout.row, alMovies);

    }
}