package com.deepakbaliga.krishnaconchem.Adapters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.deepakbaliga.krishnaconchem.ButtonClick;
import com.deepakbaliga.krishnaconchem.R;
import com.deepakbaliga.krishnaconchem.retrofit.model.Publication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baliga on 04/05/16.
 */
public class PublicationAdapter extends RecyclerView.Adapter<PublicationAdapter.ViewHolder> {

    private List<Publication> publications =  new ArrayList<>();
    private ButtonClick click;

    public PublicationAdapter(List<Publication> publications, ButtonClick click) {
        this.publications = publications;
        this.click = click;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.publication_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Publication publication = publications.get(position);

        holder.title.setText(publication.getTitle());
        holder.description.setText(publication.getDescription());
        holder.authors.setText(publication.getAuthors());

        holder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                click.onClick(position);
            }
        });
    }



    @Override
    public int getItemCount() {
        return publications.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title, authors, description;
        public Button download;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.publication_title);
            authors = (TextView) itemView.findViewById(R.id.publication_authors);
            description = (TextView) itemView.findViewById(R.id.publication_description);
            download = (Button) itemView.findViewById(R.id.publication_download);



        }
    }
}
