package np.com.sarojb.famouspersonbiographies;

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
    AllData data = new AllData();
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        view_recyclerview = findViewById(R.id.view_recyclerview);
        adapter = new RecyclerViewAdapter(this);
        view_recyclerview.setAdapter(adapter);
        view_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter.setDetailofpersons(AllData.getFamousPerson());
    }

}
