package com.smti08.cakemobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.ViewHolder> {
    private List<ModelCategory> modelCategory = new ArrayList<>();
    Context context;
    SharedPreferences sp, sharedPreferences;
    String id_company, name_company, desc_company, image, stock_price, current_asset1, current_asset2, current_l1, current_l2,
            outstanding_share, total_equity, net_income, capital_expenditure, depreciation, cwc, dividend_payment, capm,
            dividend_payout, retention_ratio, total_asset, total_l12, interest_expense, ebit, fcff, cost_debt, wacc, return_capital,
            expected_growth_fcff, intrinsik_fcff, eps, new_debt_issued, debt_repayment, fcfe, return_equity, expected_growth_fcfe,
            intrinsik_fcfe, info, updated_using, updated_at;
    int using_dollar, id_sector;
    float beta;

    public AdapterCategory(Context context, List<ModelCategory> modelCategory){
        Log.d("DEBUG_", "Container ListAdapter");
        this.modelCategory = modelCategory;
        this.context = context;
    }


    @Override
    public AdapterCategory.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("DEBUG_", "View Holder");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterCategory.ViewHolder holder, int position) {
        Log.d("DEBUG_", "Bind ViewHolder");
        final ModelCategory modelcategory = modelCategory.get(position);
        holder.nama.setText(modelcategory.getName_company());
        holder.deskripsi.setText(modelcategory.getDesc_company());
        holder.harga.setText(modelcategory.getStock_price());
        Picasso.with(context).load("http://multimediagunadarma.tk/cakeapps/img/"+modelcategory.getImage()).into(holder.ikon);
    }

    @Override
    public int getItemCount() {
        return modelCategory.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView nama, deskripsi, harga;
        ImageView ikon;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ikon = itemView.findViewById(R.id.ikon);
            nama = itemView.findViewById(R.id.nama);
            deskripsi = itemView.findViewById(R.id.deskripsi);
            harga = itemView.findViewById(R.id.harga);
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(context, DetailActivity.class);
            context.startActivity(i);
        }
    }
}
