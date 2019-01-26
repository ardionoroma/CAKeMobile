package com.smti08.cakemobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterDetail adapterDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
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
            holder.ikon.setImageResource(R.drawable.telkom);
            holder.harga.setText("Rp 3.750,00");
            holder.keterangan.setText("Undervalue");
            holder.keterangan.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            holder.intrinsik.setText("Rp 4.440,00");
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
