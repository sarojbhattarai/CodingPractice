package np.com.sarojb.famouspersonbiographies;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    private Button button_allpeople;
    private Button button_favourite;
    private Button button_requestmore;
    private ImageView imageview_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this);
        ArrayList<FamousPersons> arrayList = new ArrayList<>();
        arrayList = databaseHelper.getFamousPersonFromDatabase();
        final int a=  arrayList.size();

        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "http://www.sarojb.com.np/jsondata.json", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("allpersons");
                            int b = a;
                            for (int i = 0; i < jsonArray.length(); i++) {
                                ContentValues contentValues = new ContentValues();
                                JSONObject jsonOb = jsonArray.getJSONObject(i);
                                String firstname = jsonOb.getString("name");
                                String imageUrl = jsonOb.getString("imageUrl");
                                String fieldOfWork = jsonOb.getString("fieldOfWork");
                                String shortdesc = jsonOb.getString("shortdesc");
                                String longdesc = jsonOb.getString("longdesc");
                                try{
                                    contentValues.put("id",b+1);
                                    contentValues.put("name", firstname);
                                    contentValues.put("imageUrl", imageUrl);
                                    contentValues.put("fieldOfWork", fieldOfWork);
                                    contentValues.put("shortdesc", shortdesc);
                                    contentValues.put("longdesc", longdesc);
                                    databaseHelper.insertData(contentValues);
                                    b += 1;
                                }
                                catch (Exception e){
                                    e.printStackTrace();
                                }

                            }
                            Log.e("onResponse: ", "IN response" + response.getString(""));
                        } catch (JSONException e) {
                            Log.e("Error", "error");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", "onErrorResponse: ");
            }
        });
        requestQueue.add(jsonObjectRequest);

//        databaseHelper = new DatabaseHelper(this);
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name", "Albert Bahadur");
//
//        databaseHelper.insertData(contentValues);

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
                Snackbar.make(v, "OOPS Still working on this", Snackbar.LENGTH_LONG).show();
            }
        });

        button_requestmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "OOPS Still working on this", Snackbar.LENGTH_LONG).show();
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
