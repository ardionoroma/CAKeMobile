package com.smti08.cakemobile;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    TextView judul, nama;
    ImageView back;
    RecyclerView recyclerView;
    AdapterDetail adapterDetail;
    ModelCategory modelCategory = new ModelCategory();
    ViewPager viewPager;
    TabLayout tabLayout;
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        toolbar = findViewById(R.id.tulbar);
        judul = toolbar.findViewById(R.id.judul);
        nama = toolbar.findViewById(R.id.nama);
        back = toolbar.findViewById(R.id.back);
        modelCategory = (ModelCategory) getIntent().getSerializableExtra("x");
        judul.setText(modelCategory.getId_company());
        nama.setText(modelCategory.getName_company());
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
//        bundle.putString("x", modelCategory.getName_company());
        bundle.putSerializable("x", modelCategory);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setPadding(20,20,20,20);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapterDetail = new AdapterDetail();
        recyclerView.setAdapter(adapterDetail);

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        KeyStats keyStats = new KeyStats();
        CompanyProfile companyProfile = new CompanyProfile();
        keyStats.setArguments(bundle);
        companyProfile.setArguments(bundle);
        Log.d("DEBUG_KURS_DETAIL", String.valueOf(bundle));
        adapter.addFragment(keyStats, "KEYSTATS");
        adapter.addFragment(companyProfile, "PROFILE");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) { return mFragmentTitleList.get(position); }
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
