package sg.edu.rp.c346.id21012050.custommovielist;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
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

        etID.setKeyListener(null);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(ModifyActivity.this);
                myBuilder.setTitle("Danger");
                myBuilder.setMessage("Are you sure you want to edit the movie " + data.getTitle() + "?");
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DBHelper dbh = new DBHelper(ModifyActivity.this);
                        data.setGenre(etModGenre.getText().toString());
                        data.setTitle(etModTitle.getText().toString());
                        data.setYear(Integer.parseInt(etModYear.getText().toString()+""));
                        data.setRating(spnRatings.getSelectedItem().toString());
                        if (data.getYear() >= 1900) {
                            dbh.updateMovies(data);
                        } else {
                            Toast.makeText(ModifyActivity.this, "Update unsuccessful",
                                    Toast.LENGTH_SHORT).show();
                        }
                        dbh.close();
                        Intent i2 = new Intent(ModifyActivity.this,
                                ShowListActivity.class);
                        startActivity(i2);
                    }
                });

                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(ModifyActivity.this);
                myBuilder.setTitle("Danger");
                myBuilder.setMessage("Are you sure you want to delete the movie " + data.getTitle() + "?");
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DBHelper dbh = new DBHelper(ModifyActivity.this);
                        dbh.deleteMovies(data.getId());
                        Intent i2 = new Intent(ModifyActivity.this,
                                ShowListActivity.class);
                        startActivity(i2);
                    }
                });

                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(ModifyActivity.this);
                myBuilder.setTitle("Danger");
                myBuilder.setMessage("Are you sure you want to discard the changes?");
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("Discard", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent i2 = new Intent(ModifyActivity.this,
                                ShowListActivity.class);
                        startActivity(i2);
                    }
                });

                myBuilder.setNeutralButton("Do Not Discard", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });


    }
}
