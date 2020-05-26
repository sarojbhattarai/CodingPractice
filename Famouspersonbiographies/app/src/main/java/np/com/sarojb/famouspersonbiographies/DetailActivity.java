package np.com.sarojb.famouspersonbiographies;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    private RecyclerView view_recyclerview;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        view_recyclerview = findViewById(R.id.view_recyclerview);
        adapter = new RecyclerViewAdapter(this);
        view_recyclerview.setAdapter(adapter);
        view_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<FamousPersons> famousPerson = new ArrayList<>();
        famousPerson.add(new FamousPersons(1, "AlbertEinstein", "https://cdn.mos.cms.futurecdn.net/c7dppKDbG3JXuMfybV5tUX-320-80.jpg", "Genius", "Science"));
        adapter.setDetailofpersons(famousPerson);
    }
}
