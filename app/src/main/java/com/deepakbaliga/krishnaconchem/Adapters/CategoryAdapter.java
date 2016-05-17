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
import com.deepakbaliga.krishnaconchem.ButtonClick;
import com.deepakbaliga.krishnaconchem.R;
import com.deepakbaliga.krishnaconchem.retrofit.model.Category;

import java.util.LinkedList;

/**
 * Created by baliga on 09/05/16.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CateogryViewHolder> {

    private Context context;
    private LinkedList<Category> categories = new LinkedList<>();
    private ButtonClick click;

    public CategoryAdapter(Context context, LinkedList<Category> categories, ButtonClick click) {
        this.context = context;
        this.categories = categories;
        this.click = click;
    }

    @Override
    public CateogryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);

        return new CateogryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CateogryViewHolder holder, int position) {

        holder.getTitle().setText(categories.get(position).getName());
        Glide.with(context).load(categories.get(position).getIcon()).into(holder.getCover());

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CateogryViewHolder extends RecyclerView.ViewHolder{

        private ImageView cover;
        private TextView title;
        public CateogryViewHolder(View itemView) {
            super(itemView);

            cover = (ImageView) itemView.findViewById(R.id.cover);
            title = (TextView) itemView.findViewById(R.id.category_title);

            cover.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click.onClick(getLayoutPosition());
                }
            });
        }

        public ImageView getCover() {
            return cover;
        }

        public void setCover(ImageView cover) {
            this.cover = cover;
        }

        public TextView getTitle() {
            return title;
        }

        public void setTitle(TextView title) {
            this.title = title;
        }
    }
}
