package np.com.sarojb.famouspersonbiographies;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class IndividualActivity extends AppCompatActivity {

    ImageView individual_imageview_photo;
    TextView individual_textview_name;
    TextView individual_textview_shortdesc;
    TextView individual_textview_longdesc;
    ImageView individual_imageview_favouritebutton;
    AllData ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual);
        initView();
        ad = new AllData();

        Intent intent  = getIntent();
        if (intent != null ){
            int personId = intent.getIntExtra("ID",-1);
            if(personId != -1){
                    FamousPersons fp = ad.getPersonByID(personId);
                    if (fp != null){
                        setData(fp);
                    }
            }
        }



    }
    private void setData(final FamousPersons fp){
        Glide.with(this).asBitmap().load(fp.getImageUrl()).into(individual_imageview_photo);
        individual_textview_name.setText(fp.getName());
        individual_textview_shortdesc.setText(fp.getShortdesc());
        individual_textview_longdesc.setText(fp.getLongdesc());
        individual_imageview_favouritebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fp.isEnabled == false){
                    individual_imageview_favouritebutton.setImageResource(R.drawable.favourite_after_clicked);
                    fp.setEnabled(true);
                    Snackbar.make(v,"Added to favourites", BaseTransientBottomBar.LENGTH_SHORT).show();
                }
                else {
                    individual_imageview_favouritebutton.setImageResource(R.drawable.fav_before_clicked);
                    fp.setEnabled(false);
                    Snackbar.make(v,"Removed to favourites", BaseTransientBottomBar.LENGTH_SHORT).show();
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
