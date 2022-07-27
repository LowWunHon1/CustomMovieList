package sg.edu.rp.c346.id21012050.custommovielist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;


public class ModifyActivity extends AppCompatActivity {

    EditText etID, etModTitle, etModGenre, etModYear;
    Spinner spnRatings;
    Button btnUpdate, btnDelete, btnCancel;
    Movie data;

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

        Intent i = getIntent();
        data = (Movie) i.getSerializableExtra("data");

        etID.setText(data.getId()+"");
        etModTitle.setText(data.getTitle());
        etModGenre.setText(data.getGenre());
        etModYear.setText(data.getYear()+"");

        if(data.getRating().equals("G")) {
            spnRatings.setSelection(0);
        } else if (data.getRating().equals("PG")) {
            spnRatings.setSelection(1);
        } else if (data.getRating().equals("PG13")) {
            spnRatings.setSelection(2);
        } else if (data.getRating().equals("NC16")) {
            spnRatings.setSelection(3);
        } else if (data.getRating().equals("M18")) {
            spnRatings.setSelection(4);
        } else if (data.getRating().equals("R21")) {
            spnRatings.setSelection(5);
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(ModifyActivity.this);
                data.setGenre(etModGenre.getText().toString());
                data.setTitle(etModTitle.getText().toString());
                data.setYear(Integer.parseInt(etModYear.getText().toString()+""));
                data.setRating(spnRatings.getSelectedItem().toString());
                dbh.updateMovies(data);
                dbh.close();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(ModifyActivity.this);
                dbh.deleteMovies(data.getId());
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ModifyActivity.this,
                        ShowListActivity.class);
                startActivity(i);
            }
        });


    }
}
