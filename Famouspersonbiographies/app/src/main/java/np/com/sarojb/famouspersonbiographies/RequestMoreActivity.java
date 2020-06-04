package np.com.sarojb.famouspersonbiographies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class RequestMoreActivity extends AppCompatActivity {
    EditText requestedperson;
    Button RequestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_more);
        requestedperson = findViewById(R.id.requestedperson);
        RequestButton = findViewById(R.id.RequestButton);
        final String person = requestedperson.getText().toString();

        RequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Submitted Successfully", BaseTransientBottomBar.LENGTH_SHORT).show();
            }
        });
    }
}
