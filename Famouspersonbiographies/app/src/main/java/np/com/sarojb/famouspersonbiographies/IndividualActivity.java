package np.com.sarojb.famouspersonbiographies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class IndividualActivity extends AppCompatActivity {

    public static final String ERROR = "I am error";
    ImageView individual_imageview_photo;
    TextView individual_textview_name;
    TextView individual_textview_shortdesc;
    TextView individual_textview_longdesc;
    ImageView individual_imageview_favouritebutton;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual);
        initView();
        databaseHelper = new DatabaseHelper(this);
        Intent intent = getIntent();
        if (intent != null) {
            int id = intent.getIntExtra("ID", -1);
            if (id != -1) {
                setData(databaseHelper.getFamousPersonFromDatabase().get(id - 1), (id - 1));
            }
        }
    }


    private void setData(FamousPersons famousPersons, final int id) {
        Glide.with(this).asBitmap().load(databaseHelper.getFamousPersonFromDatabase().get(id).getImageUrl()).into(individual_imageview_photo);
        individual_textview_name.setText(databaseHelper.getFamousPersonFromDatabase().get(id).getName());
        individual_textview_shortdesc.setText(databaseHelper.getFamousPersonFromDatabase().get(id).getShortdesc());
        individual_textview_longdesc.setText(databaseHelper.getFamousPersonFromDatabase().get(id).getLongdesc());
        final int a = databaseHelper.getFamousPersonFromDatabase().get(id).getIsFavourite();
        if(a == 0){
            individual_imageview_favouritebutton.setImageResource(R.drawable.fav_before_clicked);
        }
        if(a == 1){
            individual_imageview_favouritebutton.setImageResource(R.drawable.favourite_after_clicked);
        }

        individual_imageview_favouritebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a == 0) {
                    individual_imageview_favouritebutton.setImageResource(R.drawable.favourite_after_clicked);
                    int isFavou = 1;
                    databaseHelper.updateTable(id, isFavou);
                }
                else {
                    individual_imageview_favouritebutton.setImageResource(R.drawable.fav_before_clicked);
                    int isFavou = 0;
                    databaseHelper.updateTable(id, isFavou);
                }
            }
        });

    }


    private void initView() {
        individual_imageview_photo = findViewById(R.id.individual_imageview_photo);
        individual_textview_name = findViewById(R.id.individual_textview_name);
        individual_textview_shortdesc = findViewById(R.id.individual_textview_shortdesc);
        individual_textview_longdesc = findViewById(R.id.individual_textview_longdesc);
        individual_imageview_favouritebutton = findViewById(R.id.individual_imageview_favouritebutton);

    }
}
