package com.example.myimage.Adapter;

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
import com.example.myimage.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ImageViewAdapter extends RecyclerView.Adapter<ImageViewAdapter.ViewHolder> {
    Context context;
    ArrayList<Photo> photoArrayList;
    AdapterListener adapterListener;

    public ImageViewAdapter(Context context, ArrayList<Photo> photoArrayList, AdapterListener adapterListener) {
        this.context = context;
        this.photoArrayList = photoArrayList;
        this.adapterListener = adapterListener;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvView;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.imageview);
            tvView = itemView.findViewById(R.id.textviewView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
    //Sự kiện khi click vào item
    public interface AdapterListener{
        void OnClick(int position);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Photo photo = photoArrayList.get(position);
        holder.tvView.setText(photo.getViews());
        Picasso.with(context).load(photo.getUrlL()).into(holder.imgPhoto);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterListener.OnClick(position);
            }
        });

    }
    @Override
    public int getItemCount() {
        return photoArrayList.size();
    }
}
