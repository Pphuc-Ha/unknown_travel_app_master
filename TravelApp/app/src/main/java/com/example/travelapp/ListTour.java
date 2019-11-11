package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.travelapp.R;
import com.example.travelapp.TourItem;
import com.example.travelapp.TourItemAdapter;
import com.squareup.moshi.JsonAdapter;

import org.w3c.dom.Text;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListTour extends AppCompatActivity {
    ImageView imgTrip, imgLine, imgHome ,imgMyTour, imgMap, imgNofi, imgSetting;
    TextView txtTrip;
    SearchView editsearch;
    ListView lvTourItem;
    ArrayList<TourItem> arrayTourItem;
    //ArrayAdapter<String> arrayAdapter;
    TourItem tourItem;
    TourItemAdapter adapter;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        adapter = new TourItemAdapter(this, R.layout.touritem, arrayTourItem);
        lvTourItem.setAdapter(adapter);

        //imgTrip.setImageResource();
        //imgLine.setImageResource();
        imgHome.setImageResource(R.drawable.menu);
        imgMyTour.setImageResource(R.drawable.recent);
        imgMap.setImageResource(R.drawable.map);
        imgNofi.setImageResource(R.drawable.bell);
        imgSetting.setImageResource(R.drawable.settings);

        /*
        // Khởi tạo OkHttpClient để lấy dữ liệu.
        OkHttpClient client = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là User)
        Moshi moshi = new Moshi.Builder().build();
        Type tourItemType = com.squareup.moshi.Types.newParameterizedType(List.class, TourItem.class);
        final JsonAdapter<List<TourItem>> jsonAdapter = moshi.adapter(tourItemType);
         */

//        getHomeList(client, jsonAdapter);

        ///getMyTourList();
        //clickMap();
        //clickNotification();
        //clickSetting();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void AnhXa()
    {
        lvTourItem = findViewById(R.id.listViewNote);
        txtTrip = (TextView) findViewById(R.id.textviewTrips);
        imgLine = (ImageView) findViewById(R.id.imageviewLine);
        imgTrip = (ImageView) findViewById(R.id.imageviewTrips);
        imgHome = (ImageView) findViewById(R.id.imageviewHome);
        imgMyTour = (ImageView) findViewById(R.id.imageviewMyTour);
        imgMap = (ImageView) findViewById(R.id.imageviewMap);
        imgNofi = (ImageView) findViewById(R.id.imageviewNotification);
        imgSetting = (ImageView) findViewById(R.id.imageviewSetting);
        editsearch = (SearchView) findViewById(R.id.searchViewtSearch);
        //editsearch.setOnQueryTextListener(this);
        arrayTourItem = new ArrayList<>();
    }

    private void getHomeList() {
        /*// Tạo request lên server.
        Request request = new Request.Builder()
                .url("https://35.197.153.192:3000/tour/list")
                .method(get).build();
                //.header(token)
                //.body(,)
                //.build();

        // Thực thi request.
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Log.e("Error", "Network Error");
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {

                // Lấy thông tin JSON trả về. Bạn có thể log lại biến json này để xem nó như thế nào.
                String json = response.body().string();
                final List<TourItem> tourItem = (List<TourItem>) jsonAdapter.fromJson(json);

                // Cho hiển thị lên RecyclerView.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        lvTourItem.setAdapter(new UserAdapter(users, MainActivity.this));
                    }
                });
            }
        }*/
    }

    /*private void search()
    {
        edtGhiChu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }*/
}