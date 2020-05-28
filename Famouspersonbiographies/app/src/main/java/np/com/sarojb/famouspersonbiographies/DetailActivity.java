package np.com.sarojb.famouspersonbiographies;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    private RecyclerView view_recyclerview;
    private RecyclerViewAdapter adapter;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        databaseHelper = new DatabaseHelper(this);
        view_recyclerview = findViewById(R.id.view_recyclerview);
        adapter = new RecyclerViewAdapter(this);
        view_recyclerview.setAdapter(adapter);
        view_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter.setDetailofpersons(databaseHelper.getFamousPersonFromDatabase());
    }




}
