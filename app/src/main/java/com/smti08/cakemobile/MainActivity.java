package com.smti08.cakemobile;

import android.content.Intent;
import android.graphics.Rect;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterMenu adapterMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager glm = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setPadding(10, 10, 10, 10);
        SpacesItemDecoration space = new SpacesItemDecoration(20);
        recyclerView.addItemDecoration(space);
        recyclerView.setLayoutManager(glm);



        adapterMenu = new AdapterMenu();
        recyclerView.setAdapter(adapterMenu);
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

//    class ModelMenu {
//        String sektor;
//        int img;
//
//        public ModelMenu(String sektor, int img) {
//            this.sektor = sektor;
//            this.img = img;
//        }
//    }

    class AdapterMenu extends RecyclerView.Adapter<AdapterMenu.viewHolder>{

//        List<ModelMenu> itemList = new ArrayList<>();

        AdapterMenu(){
//            this.itemList = itemList;
            notifyDataSetChanged();
        }

        @Override
        public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, null);
//            View itemLayout = getLayoutInflater().inflate(R.layout.item_menu, parent, false);
            return new viewHolder(itemLayout);
        }

        @Override
        public void onBindViewHolder(viewHolder holder, int position) {
            switch (position){
                case 0:
                    holder.teks.setText("Perdagangan");
                    holder.ikon.setImageResource(R.drawable.perdagangan);
                    break;
                case 1:
                    holder.teks.setText("Tambang");
                    holder.ikon.setImageResource(R.drawable.tambang);
                    break;
                case 2:
                    holder.teks.setText("Kimia");
                    holder.ikon.setImageResource(R.drawable.kimia);
                    break;
                case 3:
                    holder.teks.setText("Industri");
                    holder.ikon.setImageResource(R.drawable.industri);
                    break;
                case 4:
                    holder.teks.setText("Konsumsi");
                    holder.ikon.setImageResource(R.drawable.konsumsi);
                    break;
                case 5:
                    holder.teks.setText("Properti");
                    holder.ikon.setImageResource(R.drawable.properti);
                    break;
                case 6:
                    holder.teks.setText("Infrastruktur");
                    holder.ikon.setImageResource(R.drawable.infrastruktur);
                    break;
                case 7:
                    holder.teks.setText("Keuangan");
                    holder.ikon.setImageResource(R.drawable.keuangan);
                    break;
                case 8:
                    holder.teks.setText("Jasa");
                    holder.ikon.setImageResource(R.drawable.jasa);
                    break;
            }
        }

        @Override
        public int getItemCount() {
            return 9;
        }


        class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView teks;
            ImageView ikon;

            public viewHolder(View itemView) {
                super(itemView);
                itemView.setOnClickListener(this);
                teks = itemView.findViewById(R.id.sektor);
                ikon = itemView.findViewById(R.id.ikon);
            }

            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(i);
            }
        }
    }
}
