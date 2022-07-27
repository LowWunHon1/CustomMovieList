package sg.edu.rp.c346.id21012050.custommovielist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ModifyActivity extends AppCompatActivity {

    EditText etID, etModTitle, etModGenre, etModYear;
    Spinner spnRatings;
    Button btnUpdate, btnDelete, btnCancel;
    ArrayList spnItems;
    int ratingIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        etID = findViewById(R.id.editTextID);
        etModTitle = findViewById(R.id.editTextModTitle);
        etModGenre = findViewById(R.id.editTextModGenre);
        etModYear = findViewById(R.id.editTextModYear);
        spnRatings = findViewById(R.id.spinner);
        btnUpdate = findViewById(R.id.buttonUpdate);
        btnDelete = findViewById(R.id.buttonDelete);
        btnCancel = findViewById(R.id.btnCancel);

        spnItems.add("G");
        spnItems.add("PG");
        spnItems.add("PG13");
        spnItems.add("NC16");
        spnItems.add("M18");
        spnItems.add("R21");


        Intent i = getIntent();
        final Movie currentMovie = (Movie) i.getSerializableExtra("data");

        etID.setText(currentMovie.getId()+"");
        etModTitle.setText(currentMovie.getTitle());
        etModGenre.setText(currentMovie.getGenre());
        etModYear.setText(currentMovie.getYear()+"");
        for (int x = 0;x < spnItems.size();x++){
            if (currentMovie.getRating() == spnItems.get(x)){
                ratingIndex = x;
            }
        }
        spnRatings.setSelection(ratingIndex);


    }
}
