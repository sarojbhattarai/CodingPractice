package np.com.sarojb.famouspersonbiographies;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.bumptech.glide.Glide;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;

public class IndividualActivity extends AppCompatActivity {

    public static final String ERROR = "I am error";
    ImageView individual_imageview_photo;
    TextView individual_textview_name;
    TextView individual_textview_shortdesc;
    TextView individual_textview_longdesc;
    SwitchCompat switchbutton;
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
        ArrayList<FamousPersons> arrayList = databaseHelper.getFamousPersonFromDatabase();
        final int b = arrayList.get(id).isFavourite;
        if(b == 0){
            switchbutton.setChecked(false);
        }
        else {
            switchbutton.setChecked(true);
        }
        switchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchbutton.isChecked()){
                    databaseHelper.updateData(1,id);
                }
                else {
                    databaseHelper.updateData(0,id);
                }
            }
        });

    }


    private void initView() {
        individual_imageview_photo = findViewById(R.id.individual_imageview_photo);
        individual_textview_name = findViewById(R.id.individual_textview_name);
        individual_textview_shortdesc = findViewById(R.id.individual_textview_shortdesc);
        individual_textview_longdesc = findViewById(R.id.individual_textview_longdesc);
        switchbutton = findViewById(R.id.switchbutton);
    }
}
