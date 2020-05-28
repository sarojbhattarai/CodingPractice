package np.com.sarojb.famouspersonbiographies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button button_allpeople;
    private Button button_favourite;
    private Button button_requestmore;
    private ImageView imageview_info;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        /*
        Inserting Data to the database
        famousPerson.add(new FamousPersons(1, "Albert Einstein", "https://www.nobelprize.org/images/einstein-12923-portrait-medium.jpg", "Genius", "Science", "ONe of the brilliant mind of 20th century. His work to theory of relativity is pheonmenol."));
        famousPerson.add(new FamousPersons(2, "Saroj Bhattarai", "https://avatars2.githubusercontent.com/u/24388126?s=460&u=aae9af7c00dd6299cf9f4520678e256437e695ff&v=4", "Programmer", "Software Engineering", "One of the pioneer in Software Engineering in Nepal"));         */

        ContentValues contentValues1 = new ContentValues();
        contentValues1.put("name","Albert Bahadur");
        contentValues1.put("imageUrl","https://www.nobelprize.org/images/einstein-12923-portrait-medium.jpg");
        contentValues1.put("fieldOfWork","Physics");
        contentValues1.put("shortDesc","Math");
        contentValues1.put("longDesc","20th century");

        ContentValues contentValues = new ContentValues();
        contentValues.put("name","Shyam Bahadur");
        contentValues.put("imageUrl","https://miro.medium.com/fit/c/256/256/0*vxdTA7i8MN2eMJhZ.");
        contentValues.put("fieldOfWork","science");
        contentValues.put("shortDesc","Genius");
        contentValues.put("longDesc","One of the brilliant mind of 20th century");

        databaseHelper.insertData(contentValues1);
        databaseHelper.insertData(contentValues);

        initViews();
        button_allpeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
        button_favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"OOPS Still working on this", Snackbar.LENGTH_LONG).show();
            }
        });

        button_requestmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"OOPS Still working on this", Snackbar.LENGTH_LONG).show();
            }
        });
        imageview_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "working on this", Toast.LENGTH_SHORT).show();
            }
        });
        button_favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavouriteActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initViews() {
        button_allpeople = findViewById(R.id.button_allpeople);
        button_favourite = findViewById(R.id.button_favourite);
        button_requestmore = findViewById(R.id.button_requestmore);
        imageview_info = findViewById(R.id.imageview_info);
    }
}
