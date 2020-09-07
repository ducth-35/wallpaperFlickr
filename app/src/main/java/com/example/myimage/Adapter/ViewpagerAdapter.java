package com.example.myimage.Adapter;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.myimage.Model.Photo;
import com.example.myimage.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ViewpagerAdapter extends PagerAdapter {
    private Context context;
    private List<Photo> listPhotos;
    private LayoutInflater inflater;

    public ViewpagerAdapter(Context context, List<Photo> listPhotos) {
        this.context = context;
        this.listPhotos = listPhotos;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return listPhotos.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view1 = inflater.inflate(R.layout.item_slide, container, false);
        final ImageView imageView = view1.findViewById(R.id.image_slide);
        Picasso.with(context).load(listPhotos.get(position).getUrlZ()).into(imageView);
        container.addView(view1, 0);
        return view1;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
}
