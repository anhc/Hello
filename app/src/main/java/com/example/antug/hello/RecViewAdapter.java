package com.example.antug.hello;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.MyViewHolder> {
    private Movie[] myData;

    public RecViewAdapter (Movie[] myData) {
        this.myData = myData;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ImageView mImgView;
        public MyViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.textRecView);
            mImgView = v.findViewById(R.id.adapImgView);
        }
    }

    @NonNull
    @Override
    public RecViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.rec_view_adap, viewGroup, false);

        MyViewHolder viewHolder = new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        myViewHolder.mImgView.setTag(myData[position].getPosterURL());

        new DownloadImgAsync().execute(myViewHolder.mImgView);

        myViewHolder.mTextView.setText(myData[position].getTitulo());

    }

    @Override
    public int getItemCount() {
        return myData.length;
    }
}
