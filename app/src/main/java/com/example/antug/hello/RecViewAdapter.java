package com.example.antug.hello;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.MyViewHolder> {
    private String[] myData;

    public RecViewAdapter (String[] myData) {
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
        if (position % 2 == 0) {
            myViewHolder.mImgView.setTag("https://assets.pokemon.com//assets//cms2//img//pokedex//full//041.png");
        } else {
            myViewHolder.mImgView.setTag("https://portalwonder.com.br//wp-content//uploads//2018//06//041_Zubat_ShinyOtm.png");
        }

        new DownloadImgAsync().execute(myViewHolder.mImgView);

        myViewHolder.mTextView.setText(myData[position]);
    }

    @Override
    public int getItemCount() {
        return myData.length;
    }
}
