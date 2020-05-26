package np.com.sarojb.famouspersonbiographies;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    }

    private void initViews() {
        button_allpeople = findViewById(R.id.button_allpeople);
        button_favourite = findViewById(R.id.button_favourite);
        button_requestmore = findViewById(R.id.button_requestmore);
        imageview_info = findViewById(R.id.imageview_info);
    }
}
