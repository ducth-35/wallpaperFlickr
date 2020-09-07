package com.example.myimage.Main;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.app.AlertDialog;

import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myimage.Adapter.ViewpagerAdapter;
import com.example.myimage.Model.FlickrPhoto;
import com.example.myimage.Model.Photo;
import com.example.myimage.R;
import com.example.myimage.SaveImageHelper;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.Sharer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MainActivity2 extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 1000;
    FloatingActionButton fab, fab1, fab2, fab3, fab4, fab5;
    public ViewPager viewPager;
    CallbackManager callbackManager;
    ShareDialog shareDialog;
    public ImageView image_slide;
    ProgressDialog progressBar;
    private int progressBarStatus = 0;
    private Handler progressBarHandler = new Handler();
    private long fileSize = 0;
    ViewpagerAdapter viewpagerAdapter;
    TextView tv1, tv2, tv3, tv4, tv5;
    boolean FloatingActionButton = false;
    AlertDialog dialog;
    String link;
    public int position;
    List<Photo> photos;

   final  Target target = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            SharePhoto sharePhoto = new SharePhoto.Builder()
                    .setBitmap(bitmap)
                    .build();
            if (ShareDialog.canShow(SharePhotoContent.class)) {
                SharePhotoContent content = new SharePhotoContent.Builder()
                        .addPhoto(sharePhoto)
                        .build();
                shareDialog.show(content);
            }
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {

        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }
    };

    private void FloatingActionButton1() {
        fab1.hide();
        fab2.hide();
        fab3.hide();
        fab4.hide();
        fab5.hide();
        tv1.setVisibility(View.INVISIBLE);
        tv2.setVisibility(View.INVISIBLE);
        tv3.setVisibility(View.INVISIBLE);
        tv4.setVisibility(View.INVISIBLE);
        tv5.setVisibility(View.INVISIBLE);
    }

    private void FloatingActionButton2() {
        fab1.show();
        fab2.show();
        fab3.show();
        fab4.show();
        fab5.show();
        tv1.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.VISIBLE);
        tv3.setVisibility(View.VISIBLE);
        tv4.setVisibility(View.VISIBLE);
        tv5.setVisibility(View.VISIBLE);
    }

    // người dùng đã cấp quyền hay chưa
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Ðã được cho phép", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Quyền bị từ chối", Toast.LENGTH_SHORT).show();
                }
            }
            break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        printKeyHash();
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        image_slide = findViewById(R.id.image_slide);
        fab = findViewById(R.id.fab);
        fab1 = findViewById(R.id.fab1);
        tv1 = findViewById(R.id.tv1);
        fab2 = findViewById(R.id.fab2);
        tv2 = findViewById(R.id.tv2);
        fab3 = findViewById(R.id.fab3);
        tv3 = findViewById(R.id.tv3);
        fab4 = findViewById(R.id.fab4);
        tv4 = findViewById(R.id.tv4);
        fab5 = findViewById(R.id.fab5);
        tv5 = findViewById(R.id.tv5);

        viewPager = findViewById(R.id.viewPager);
        Intent intent = this.getIntent();
        position = intent.getIntExtra("position", 0);
        getData();

        // xin quyền lưu vào bộ nhớ
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
            requestPermissions(new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE

            }, PERMISSION_REQUEST_CODE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (FloatingActionButton == false) {
                    FloatingActionButton2();
                    FloatingActionButton = true;
                } else {
                    FloatingActionButton1();
                    FloatingActionButton = false;
                }
            }
        });

        //
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // xin quyền lưu trữ
                if (ActivityCompat.checkSelfPermission(MainActivity2.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity2.this, "", Toast.LENGTH_SHORT).show();
                    requestPermissions(new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    }, PERMISSION_REQUEST_CODE);
                    return;
                } else {
                    progressBar = new ProgressDialog(view.getContext());
                    progressBar.setCancelable(true);
                    progressBar.setMessage("File downloading ...");
                    progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progressBar.setProgress(0);
                    progressBar.setMax(100);
                    progressBar.show();
                    progressBarStatus = 0;

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (progressBarStatus < 100) {
                                progressBarStatus = doOpeartion();
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                progressBarHandler.post(new Runnable() {

                                    @Override
                                    public void run() {
                                        String fileName = UUID.randomUUID().toString() + ".jpg";
                                        Picasso.with(getBaseContext())
                                                .load(photos.get(viewPager.getCurrentItem()).getUrlL())
                                                .into(new SaveImageHelper(getBaseContext(), dialog,
                                                        getApplicationContext().getContentResolver(),
                                                        fileName, "Image description"));
                                        progressBar.setProgress(progressBarStatus);
                                    }
                                });
                            }
                            if (progressBarStatus >= 100) {
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                progressBar.dismiss();
                            }
                        }
                    }).start();
                }
            }

            public int doOpeartion() {
                while (fileSize <= 1000) {
                    fileSize++;
                    if (fileSize == 1000) {
                        return 10;
                    } else if (fileSize == 2000) {
                        return 20;
                    } else if (fileSize == 3000) {
                        return 30;
                    } else if (fileSize == 4000) {
                        return 40;
                    }
                }
                return 100;
            }
        });


        //
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // xin quyền lưu trữ
                if (ActivityCompat.checkSelfPermission(MainActivity2.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity2.this, "", Toast.LENGTH_SHORT).show();
                    requestPermissions(new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    }, PERMISSION_REQUEST_CODE);
                    return;
                } else {
                    progressBar = new ProgressDialog(view.getContext());
                    progressBar.setCancelable(true);
                    progressBar.setMessage("File downloading ...");
                    progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progressBar.setProgress(0);
                    progressBar.setMax(100);
                    progressBar.show();
                    //reset progress bar and filesize status
                    progressBarStatus = 0;

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (progressBarStatus < 100) {
                                progressBarStatus = doOpeartion();
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                progressBarHandler.post(new Runnable() {

                                    @Override
                                    public void run() {
                                        String fileName = UUID.randomUUID().toString() + ".jpg";
                                        Picasso.with(getBaseContext())
                                                .load(photos.get(viewPager.getCurrentItem()).getUrlC())
                                                .into(new SaveImageHelper(getBaseContext(), dialog,
                                                        getApplicationContext().getContentResolver(),
                                                        fileName, "Image description"));
                                        progressBar.setProgress(progressBarStatus);
                                    }
                                });
                            }
                            if (progressBarStatus >= 100) {
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                progressBar.dismiss();
                            }
                        }
                    }).start();
                }
            }

            public int doOpeartion() {
                while (fileSize <= 1000) {
                    fileSize++;
                    if (fileSize == 1000) {
                        return 10;
                    } else if (fileSize == 2000) {
                        return 20;
                    } else if (fileSize == 3000) {
                        return 30;
                    } else if (fileSize == 4000) {
                        return 40;
                    }
                }
                return 100;
            }
        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // xin quyền lưu trữ
                if (ActivityCompat.checkSelfPermission(MainActivity2.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity2.this, "", Toast.LENGTH_SHORT).show();
                    requestPermissions(new String[]{
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    }, PERMISSION_REQUEST_CODE);
                    return;
                } else {
                    progressBar = new ProgressDialog(view.getContext());
                    progressBar.setCancelable(true);
                    progressBar.setMessage("File downloading ...");
                    progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progressBar.setProgress(0);
                    progressBar.setMax(100);
                    progressBar.show();
                    //reset progress bar and filesize status
                    progressBarStatus = 0;

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (progressBarStatus < 100) {
                                progressBarStatus = doOpeartion();
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                progressBarHandler.post(new Runnable() {

                                    @Override
                                    public void run() {
                                        String fileName = UUID.randomUUID().toString() + ".jpg";
                                        Picasso.with(getBaseContext())
                                                .load(photos.get(viewPager.getCurrentItem()).getUrlC())
                                                .into(new SaveImageHelper(getBaseContext(), dialog,
                                                        getApplicationContext().getContentResolver(),
                                                        fileName, "Image description"));
                                        progressBar.setProgress(progressBarStatus);
                                    }
                                });
                            }
                            if (progressBarStatus >= 100) {
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                progressBar.dismiss();
                            }
                        }
                    }).start();
                }
            }

            public int doOpeartion() {
                while (fileSize <= 1000) {
                    fileSize++;
                    if (fileSize == 1000) {
                        return 10;
                    } else if (fileSize == 2000) {
                        return 20;
                    } else if (fileSize == 3000) {
                        return 30;
                    } else if (fileSize == 4000) {
                        return 40;
                    }
                }
                return 100;
            }
        });
        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                WallpaperManager wpm = WallpaperManager.getInstance(getApplicationContext());
                InputStream ins = null;
                try {
                    ins = new URL(photos.get(viewPager.getCurrentItem()).getUrlL()).openStream();
                    wpm.setStream(ins);
                    Toast.makeText(MainActivity2.this, "Đặt thành công", Toast.LENGTH_LONG).show();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        fab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {
                    @Override
                    public void onSuccess(Sharer.Result result) {
                        Toast.makeText(MainActivity2.this, "Share thành công", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(MainActivity2.this, "Share thất bại", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(FacebookException error) {
                        Toast.makeText(MainActivity2.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
                Picasso.with(getBaseContext())
                        .load(photos.get(viewPager.getCurrentItem()).getUrlL())
                        .into(target);
        }
    });
}

    private void getData() {
        final ProgressDialog loading = new ProgressDialog(MainActivity2.this);
        loading.setMessage("Loading...");
        loading.show();
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity2.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://www.flickr.com/services/rest", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                FlickrPhoto flickrPhoto = gson.fromJson(response, FlickrPhoto.class);
                photos = flickrPhoto.getPhotos().getPhoto();

                viewpagerAdapter = new ViewpagerAdapter(MainActivity2.this, photos);
                link = photos.get(viewPager.getCurrentItem()).getUrlL();
                viewPager.setAdapter(viewpagerAdapter);
                viewPager.setCurrentItem(position, true);
                viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    }

                    @Override
                    public void onPageSelected(int position) {
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                    }
                });
                viewpagerAdapter.notifyDataSetChanged();
                loading.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.dismiss();
                Toast.makeText(MainActivity2.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("api_key", "d0de649afc5b3d2d342a3419598d72d1");
                params.put("user_id", "186966300@N06");
                params.put("extras", "views,media,path_alias,url_sq,url_t,url_s,url_q,url_m,url_n,url_z,url_c,url_l,url_o");
                params.put("format", "json");
                params.put("method", "flickr.favorites.getList");
                params.put("nojsoncallback", "1");

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void printKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.example.myimage", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
