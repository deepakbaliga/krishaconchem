package com.deepakbaliga.krishnaconchem.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.deepakbaliga.krishnaconchem.R;

/**
 * Created by baliga on 04/05/16.
 */
public class CertificationAdapter extends RecyclerView.Adapter<CertificationAdapter.CertHolder>{

    private int pictures[] =  new int[]{};
    private String titles[] =  new String[]{};
    private Context context;

    public CertificationAdapter(int[] pictures, String[] titles, Context context) {
        this.pictures = pictures;
        this.titles = titles;
        this.context = context;
    }

    @Override
    public CertHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.certification_item, parent, false);
        return new CertHolder(view);
    }

    @Override
    public void onBindViewHolder(CertHolder holder, int position) {
        holder.title.setText(titles[position]);
        Glide.with(context).load(pictures[position]).into(holder.logo);
    }

    @Override
    public int getItemCount() {
        return pictures.length;
    }

    public class CertHolder extends RecyclerView.ViewHolder{

        public SquareView logo;
        public TextView  title;

        public CertHolder(View itemView) {
            super(itemView);

            logo = (SquareView) itemView.findViewById(R.id.certificate_image_view);
            title = (TextView) itemView.findViewById(R.id.certificate_title);

        }
    }
}
