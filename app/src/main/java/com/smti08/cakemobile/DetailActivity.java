package com.smti08.cakemobile;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterDetail adapterDetail;
    ModelCategory modelCategory = new ModelCategory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        modelCategory = (ModelCategory) getIntent().getSerializableExtra("x");
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setPadding(20,20,20,20);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapterDetail = new AdapterDetail();
        recyclerView.setAdapter(adapterDetail);
    }

    class AdapterDetail extends RecyclerView.Adapter<AdapterDetail.viewHolder>{

        AdapterDetail(){
            notifyDataSetChanged();
        }

        @Override
        public AdapterDetail.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail, null);
            return new viewHolder(itemLayout);
        }

        @Override
        public void onBindViewHolder(AdapterDetail.viewHolder holder, int position) {
            Picasso.with(getApplicationContext()).load("http://multimediagunadarma.tk/cakeapps/img/"+modelCategory.getImage()).into(holder.ikon);
            holder.harga.setText(modelCategory.getStock_price());
            holder.keterangan.setText(modelCategory.getInfo());
            holder.keterangan.setBackgroundColor(getResources().getColor(R.color.Equal));
            holder.keterangan.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            switch (modelCategory.getInfo()){
                case "Undervalue":
                    holder.keterangan.setBackgroundColor(getResources().getColor(R.color.Undervalue));
                    holder.keterangan.setTextColor(getResources().getColor(R.color.White));
                    break;
                case "Overvalue":
                    holder.keterangan.setBackgroundColor(getResources().getColor(R.color.Overvalue));
                    holder.keterangan.setTextColor(getResources().getColor(R.color.White));
                    break;
            }
            if (modelCategory.getUpdated_using().equals("FCFF")){
                holder.intrinsik.setText(modelCategory.getIntrinsik_fcff());
            } else {
                holder.intrinsik.setText(modelCategory.getIntrinsik_fcfe());
            }
        }

        @Override
        public int getItemCount() {
            return 1;
        }

        class viewHolder extends RecyclerView.ViewHolder{
            TextView harga, keterangan, intrinsik;
            ImageView ikon;

            public viewHolder(View itemView){
                super(itemView);
                ikon = itemView.findViewById(R.id.ikon);
                harga = itemView.findViewById(R.id.harga);
                keterangan = itemView.findViewById(R.id.keterangan);
                intrinsik = itemView.findViewById(R.id.intrinsik);
            }
        }
    }
}
