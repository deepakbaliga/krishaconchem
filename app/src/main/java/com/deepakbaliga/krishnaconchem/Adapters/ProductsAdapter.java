package com.deepakbaliga.krishnaconchem.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.deepakbaliga.krishnaconchem.ButtonClick;
import com.deepakbaliga.krishnaconchem.R;
import com.deepakbaliga.krishnaconchem.retrofit.model.Product;
import com.deepakbaliga.krishnaconchem.retrofit.model.Publication;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baliga on 09/05/16.
 */
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>{

    Context context;
    List<Product> products = new ArrayList<>();
    ButtonClick click;

    public ProductsAdapter(Context context, List<Product> products, ButtonClick click) {
        this.context = context;
        this.products = products;
        this.click = click;
    }

    @Override
    public ProductsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductsViewHolder holder, int position) {

        //Glide.with(this).load(R.drawable.publications).into(publicationsImageView);
        holder.getTitle().setText(products.get(position).getName());
        holder.getDescription().setText(products.get(position).getDescription());


        Glide.with(context).load(products.get(position).getCover()).placeholder(R.drawable.logo).into(holder.getCover());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder{

        private ImageView cover;
        private TextView title;
        private TextView description;

        public ProductsViewHolder(View itemView) {
            super(itemView);

            cover = (ImageView) itemView.findViewById(R.id.cover);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);

            itemView.setOnClickListener(new View.OnClickListener() {
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

        public TextView getDescription() {
            return description;
        }

        public void setDescription(TextView description) {
            this.description = description;
        }
    }
}
