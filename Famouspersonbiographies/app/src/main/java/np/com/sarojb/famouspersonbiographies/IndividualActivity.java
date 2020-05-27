package np.com.sarojb.famouspersonbiographies;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IndividualActivity extends AppCompatActivity {

    ImageView individual_imageview_photo;
    TextView individual_textview_name;
    TextView individual_textview_shortdesc;
    TextView individual_textview_longdesc;
    ImageView individual_imageview_favouritebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual);


        initView();
    }

    private void initView() {
        individual_imageview_photo = findViewById(R.id.individual_imageview_photo);
        individual_textview_name = findViewById(R.id.individual_textview_name);
        individual_textview_shortdesc = findViewById(R.id.individual_textview_shortdesc);
        individual_textview_longdesc = findViewById(R.id.individual_textview_longdesc);
        individual_imageview_favouritebutton = findViewById(R.id.individual_imageview_favouritebutton);
    }
}
