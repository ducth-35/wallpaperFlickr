package com.example.myimage.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myimage.Adapter.GalleryAdapter;
import com.example.myimage.ModelGalleries.Example;
import com.example.myimage.ModelGalleries.Gallery;
import com.example.myimage.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gallery_Activity extends AppCompatActivity {
    GalleryAdapter galleryAdapter;
    RecyclerView recyclerViewImage;
    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Ảnh theo chủ đề");
        setContentView(R.layout.activity_gallery_);
        recyclerViewImage = findViewById(R.id.recyclerview2);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.orange, R.color.green, R.color.blue);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //swipeRefreshLayout.setRefreshing(true);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        GetData();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
            }
        });
        GetData();
    }
    private void GetData() {
        RequestQueue requestQueue = Volley.newRequestQueue(Gallery_Activity.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://www.flickr.com/services/rest", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Example example = gson.fromJson(response, Example.class);
                List<Gallery> galleries = example.getGalleries().getGallery();
                //Chuyển màn hình
                galleryAdapter = new GalleryAdapter(getApplication(), (ArrayList<Gallery>) galleries,
                        new GalleryAdapter.AdapterListenerGallery() {
                            @Override
                            public void OnClick(int position) {
                                Intent intent = new Intent(Gallery_Activity.this, ViewGallery.class);
                                intent.putExtra("position", position);
                                startActivity(intent);
                            }
                        });
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Gallery_Activity.this, LinearLayoutManager.VERTICAL,false);
                recyclerViewImage.setLayoutManager(linearLayoutManager);
                recyclerViewImage.setAdapter(galleryAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(Gallery_Activity.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("api_key", "d0de649afc5b3d2d342a3419598d72d1");
                params.put("user_id", "186966300@N06");
                params.put("extras", "views,media,path_alias,url_sq,url_t,url_s,url_q,url_m,url_n,url_z,url_c,url_l,url_o");
                params.put("format", "json");
                params.put("method", "flickr.galleries.getList");
                params.put("nojsoncallback", "1");

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}