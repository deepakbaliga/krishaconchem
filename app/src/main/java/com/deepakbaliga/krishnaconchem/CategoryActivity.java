package com.deepakbaliga.krishnaconchem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.deepakbaliga.krishnaconchem.Adapters.CategoryAdapter;
import com.deepakbaliga.krishnaconchem.retrofit.model.Category;

import java.util.LinkedList;

public class CategoryActivity extends AppCompatActivity {


    private LinkedList<Category> categories = new LinkedList<>();
    private GridLayoutManager gridLayoutManager;
    private CategoryAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        loadCategories();

        getSupportActionBar().setTitle("Category");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        gridLayoutManager =  new GridLayoutManager(this,2,GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        ButtonClick click = new ButtonClick() {
            @Override
            public void onClick(int position) {

                Intent intent =  new Intent(CategoryActivity.this, ProductActivity.class);
                intent.putExtra("code", categories.get(position).getCode());
                startActivity(intent);
            }
        };

        adapter = new CategoryAdapter(this, categories, click);
        recyclerView.setAdapter( adapter);


    }

    private void loadCategories(){

        categories.add(new Category(0, "TEAM REPAIR", R.drawable.team_repair));
        categories.add(new Category(1, "BIPOLAR CONCRETE PENETRATING CORROSION INHIBITORS", R.drawable.corosion_inhibitors));
        categories.add(new Category(2, "REINFORCEMENT COATING SYSTEMS", R.drawable.reenfforcement));
        categories.add(new Category(3, "BONDING AGENTS  ", R.drawable.bonding_agents));
        categories.add(new Category(4, "REPAIR GROUTS, IMPREGNATORS, & ANCHORS  ", R.drawable.repair_grout));
        categories.add(new Category(5, "REPAIR MORTARS", R.drawable.repair_mortar));
        categories.add(new Category(6, "WATER PROOFING", R.drawable.waterproofing));
        categories.add(new Category(7, "PROTECTIVE COATING", R.drawable.protective_coating));
        categories.add(new Category(8, "ADMIXTURES", R.drawable.admixture));
        categories.add(new Category(9, "SEALANTS, ADHESIVES & CURING COMPOUNDS", R.drawable.selants_adhesive_curing));
        categories.add(new Category(10, "HERITAGE PRODUCTS", R.drawable.heritage_products));
        categories.add(new Category(11, "COMPOSITE STRENGTHENING SYSTEM", R.drawable.composite_strengthening_systems));



    }
}
