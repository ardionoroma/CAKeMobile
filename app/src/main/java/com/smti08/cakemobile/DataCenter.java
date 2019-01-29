package com.smti08.cakemobile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

public class DataCenter extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "cakemobile.db";
    private static final int DATABASE_VERSION = 4;

    public DataCenter(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql_companyprint = "create table companyprint(id integer primary key, id_company text, name_company text, " +
                "desc_company text, image text, stock_price text, beta real, using_dollar integer, current_asset1 text, " +
                "current_asset2 text, current_l1 text, current_l2 text, outstanding_share text, total_equity text, net_income text, " +
                "capital_expenditure text, depreciation text, cwc text, dividend_payment text, capm text, dividend_payout text, " +
                "retention_ratio text, total_asset text, total_l12 text, interest_expense text, ebit text, fcff text, cost_debt text, " +
                "wacc text, return_capital text, expected_growth_fcff text, intrinsik_fcff text, eps text, new_debt_issued text, " +
                "debt_repayment text, fcfe text, return_equity text, expected_growth_fcfe text, intrinsik_fcfe text, info text, " +
                "id_sector integer, updated_using text, updated_at text);";
        sqLiteDatabase.execSQL(sql_companyprint);
        Log.d("Data", "onCreate: " + sql_companyprint);

        String sql_kurs = "create table kurs(id_kurs integer primary key, currency text, value text);";
        sqLiteDatabase.execSQL(sql_kurs);
        Log.d("Data", "onCreate: " + sql_kurs);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
