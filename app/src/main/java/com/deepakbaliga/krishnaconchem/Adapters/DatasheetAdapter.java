package com.deepakbaliga.krishnaconchem.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.deepakbaliga.krishnaconchem.ButtonClick;
import com.deepakbaliga.krishnaconchem.R;
import com.deepakbaliga.krishnaconchem.retrofit.model.DataSheet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baliga on 09/05/16.
 */
public class DatasheetAdapter extends RecyclerView.Adapter<DatasheetAdapter.DataSetViewHolder> {


    private List<DataSheet> dataSheets = new ArrayList<>();
    private ButtonClick buttonClick;

    public DatasheetAdapter(List<DataSheet> dataSheets, ButtonClick buttonClick) {
        this.dataSheets = dataSheets;
        this.buttonClick = buttonClick;
    }

    @Override
    public DataSetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_datasheet, parent, false);

        return new DataSetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataSetViewHolder holder, final int position) {
        holder.getTitle().setText(dataSheets.get(position).getTitle());
        holder.getDownload().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    buttonClick.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSheets.size();
    }

    public class DataSetViewHolder extends RecyclerView.ViewHolder{

        private ImageView download;
        private TextView title;

        public DataSetViewHolder(View itemView) {
            super(itemView);

            download = (ImageView) itemView.findViewById(R.id.download);
            title = (TextView) itemView.findViewById(R.id.title);
        }

        public ImageView getDownload() {
            return download;
        }

        public void setDownload(ImageView download) {
            this.download = download;
        }

        public TextView getTitle() {
            return title;
        }

        public void setTitle(TextView title) {
            this.title = title;
        }
    }
}
