package com.example.myimage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myimage.ModelGalleries.Gallery;
import com.example.myimage.R;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder>  {
    private Context context;
    private ArrayList<Gallery> GalleryArrayList;
    private AdapterListenerGallery adapterListenerGallery;

    public GalleryAdapter(Context context, ArrayList<Gallery> galleryArrayList, AdapterListenerGallery adapterListenerGallery) {
        this.context = context;
        GalleryArrayList = galleryArrayList;
        this.adapterListenerGallery = adapterListenerGallery;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textviewView);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
    // Sự kiện click vào Item
    public interface AdapterListenerGallery{
        void OnClick(int position);
    }
    @NonNull
    @Override
    public GalleryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.gallery, parent, false);
        return new GalleryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryAdapter.ViewHolder holder, final int position) {
        final Gallery gallery = GalleryArrayList.get(position);
        holder.textView.setText(gallery.getTitle().getContent());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterListenerGallery.OnClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return GalleryArrayList.size();
    }

}
