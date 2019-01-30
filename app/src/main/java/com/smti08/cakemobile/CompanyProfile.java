package com.smti08.cakemobile;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CompanyProfile extends Fragment {

    AdapterPerusahaan adapterPerusahaan;
    ModelCategory modelCategory = new ModelCategory();
    TextView teks;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        modelCategory = (ModelCategory) getArguments().getSerializable("x");
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        teks = view.findViewById(R.id.teks);
        teks.setText(modelCategory.getDesc_company());
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setPadding(10, 10, 10, 10);
        SpacesItemDecoration space = new SpacesItemDecoration(20);
        recyclerView.addItemDecoration(space);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        adapterPerusahaan = new AdapterPerusahaan();
        recyclerView.setAdapter(adapterPerusahaan);
        return view;
    }

    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;
            outRect.top = space;
        }
    }

    class AdapterPerusahaan extends RecyclerView.Adapter<CompanyProfile.AdapterPerusahaan.viewHolder>{

        AdapterPerusahaan(){
            notifyDataSetChanged();
        }

        @Override
        public CompanyProfile.AdapterPerusahaan.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_company, null);
//            View itemLayout = getLayoutInflater().inflate(R.layout.item_menu, parent, false);
            return new viewHolder(itemLayout);
        }

        @Override
        public void onBindViewHolder(CompanyProfile.AdapterPerusahaan.viewHolder holder, int position) {
            switch(position){
                case 0:
                    holder.ikon.setImageResource(R.drawable.adhi);
                    holder.kode.setText("ADHI");
                    holder.harga.setText("Rp 1.870,00");
                    break;
                case 1:
                    holder.ikon.setImageResource(R.drawable.bri);
                    holder.kode.setText("BBRI");
                    holder.harga.setText("Rp 3.160,00");
                    break;
                case 2:
                    holder.ikon.setImageResource(R.drawable.telkom);
                    holder.kode.setText("TLKM");
                    holder.harga.setText("Rp 3.750,00");
                    break;
                case 3:
                    holder.ikon.setImageResource(R.drawable.unilever);
                    holder.kode.setText("UNVR");
                    holder.harga.setText("Rp 46.350,00");
                    break;
            }
        }

        @Override
        public int getItemCount() {
            return 4;
        }

        class viewHolder extends RecyclerView.ViewHolder {
            TextView kode, harga;
            ImageView ikon;

            public viewHolder(View itemView){
                super(itemView);
//                itemView.setOnClickListener(this);
                ikon = itemView.findViewById(R.id.ikon);
                kode = itemView.findViewById(R.id.kode);
                harga = itemView.findViewById(R.id.harga);
            }

//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getContext(), DetailActivity.class);
//                startActivity(i);
//            }
        }
    }
}
