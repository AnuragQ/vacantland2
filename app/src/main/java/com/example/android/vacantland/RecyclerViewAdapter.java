package com.example.android.vacantland;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    //vars
    private ArrayList<Integer> mImageResourceId = new ArrayList<Integer>();
    private ArrayList<String> mLocation = new ArrayList<String>();
    private ArrayList<String> mDesc = new ArrayList<String>();
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<Integer> ImageResourceId, ArrayList<String> location, ArrayList<String> Desc) {
        mImageResourceId = ImageResourceId;
        mLocation = location;
        mDesc = Desc;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.individual_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.imageView.setImageResource(mImageResourceId.get(position));
        holder.locationView.setText(mLocation.get(position));
        holder.descView.setText(mDesc.get(position));

    }

    @Override
    public int getItemCount() {
        return mImageResourceId.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView locationView;
        TextView descView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image_view);
            locationView = (TextView) itemView.findViewById(R.id.location_textView);
            descView = (TextView) itemView.findViewById(R.id.desc_textView);
        }
    }
}
