package com.example.attendancesystem;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{


    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mDescription=new ArrayList<>();
    private instructorFragment mContext;

    public RecyclerViewAdapter(instructorFragment context, ArrayList<String> imageNames, ArrayList<String> images, ArrayList<String> Description) {
        mImageNames = imageNames;
        mImages = images;
        mContext = context;
        mDescription=Description;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.imageName.setText(mImageNames.get(position));
        holder.image.setText(mImages.get(position));
        holder.Description.setText(mDescription.get(position));

//       holder.status.setText(mPost.get(position));

    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView image;
        TextView imageName;
        RelativeLayout parentLayout;
        TextView Description;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.id);
            imageName = itemView.findViewById(R.id.name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            Description = itemView.findViewById(R.id.courseid);


        }

    }



}
