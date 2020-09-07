package com.example.myimage.Adapter;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myimage.Model.Photo;
import com.example.myimage.ModelGalleries.Gallery;
import com.example.myimage.ModelGalleries.PrimaryPhotoExtras;
import com.example.myimage.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GalleryViewAdapter extends RecyclerView.Adapter<GalleryViewAdapter.ViewHolder> {
    Context context;
    private ArrayList<Gallery> ViewGalleryArrayList;
    private AdapterViewListenerGallery adapterViewListenerGallery;

    public GalleryViewAdapter(Context context, ArrayList<Gallery> photoArrayList,AdapterViewListenerGallery adapterListener) {
        this.context = context;
        this.ViewGalleryArrayList = photoArrayList;
        this.adapterViewListenerGallery =adapterListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.imageview2);
            tvView = itemView.findViewById(R.id.textviewView2);
            cardView = itemView.findViewById(R.id.cardView2);
        }
    }

    //Sự kiện khi click vào item
    public interface AdapterViewListenerGallery {
        void OnClick(int position);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_image2, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Gallery gallery = ViewGalleryArrayList.get(position);
        holder.tvView.setText(gallery.getViews());
        Picasso.with(context).load(gallery.getUrlL()).into(holder.imgPhoto);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterViewListenerGallery.OnClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return ViewGalleryArrayList.size();
    }
}