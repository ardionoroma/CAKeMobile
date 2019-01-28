package com.smti08.cakemobile;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetCompany {
    private Cursor cursor;
    private DataCenter dbHelper;

    private SQLiteDatabase dbaca, dbwrite, db;
    int numCompany;
    String idCompany, namaCompany, descCompany, image, stockPrice, currentAsset1, currentAsset2, currentLiab1,
            currentLiab2, outstandingShare, totalEquity, netIncome, capitalExpenditure, depreciation, cwc, dividendPayment, capm,
            dividendPayout, retentionRatio, totalAsset, totalLiab12, interestExpense, ebit, fcff, costDebt, wacc, returnCapital,
            expectedGrowthFCFF, intrinsikFCFF, eps, newDebtIssued, debtRepayment, fcfe, returnEquity, expectedGrowthFCFE,
            intrinsikFCFE, info, updatedUsing, updatedAt, kurs, sql;
    int usingDollar, idSector;
    float beta;
    ProgressDialog progressDialog;
    String URL_COMPANY = "http://multimediagunadarma.tk/cakeapps/jsonCompany.php";

    public GetCompany(Activity activity, Context context, ProgressDialog progressDialog){
        progressDialog = new ProgressDialog(context);
        dbHelper = new DataCenter(activity);
        dbaca = dbHelper.getReadableDatabase();
        cursor = dbaca.rawQuery("SELECT * FROM companyprint", null);
        getCompany(context, progressDialog);
    }

    private void getCompany(final Context context, final ProgressDialog progressDialog){
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        idCompany = "";
        db = dbHelper.getWritableDatabase();

        com.android.volley.RequestQueue queue = Volley.newRequestQueue(context);

        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, URL_COMPANY,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.cancel();
                        try {
                            if (response != null){
                                JSONArray whole_company = response.getJSONArray("content");
                                if (whole_company.length() != 0){
                                    dbwrite = dbHelper.getWritableDatabase();
                                    sql = "DELETE FROM companyprint;";
                                    dbwrite.execSQL(sql);
                                }
                                kurs = response.getString("kurs");
                                sql = "INSERT INTO kurs(currency, value) VALUES ('DOLLAR','"+ kurs +"')";
                                db.execSQL(sql);
                                Log.d("DEBUG_KURS_", sql);
                                numCompany = whole_company.length();
                                Log.d("DEBUG_", "On Response get Lokasi Kajian");
                                for (int i=0; i < numCompany; i++){
                                    JSONObject jsonObjectCompany;
                                    jsonObjectCompany = whole_company.getJSONObject(i);
                                    idCompany = jsonObjectCompany.getString("id_company");
                                    Log.d("DEBUG_", idCompany);
                                    namaCompany = jsonObjectCompany.getString("name_company");
                                    descCompany = jsonObjectCompany.getString("desc_company");
                                    image = jsonObjectCompany.getString("image");
                                    stockPrice = jsonObjectCompany.getString("stock_price");
                                    beta = Float.parseFloat(jsonObjectCompany.getString("beta"));
                                    usingDollar = Integer.parseInt(jsonObjectCompany.getString("using_dollar"));
                                    currentAsset1 = jsonObjectCompany.getString("current_asset1");
                                    currentAsset2 = jsonObjectCompany.getString("current_asset2");
                                    currentLiab1 = jsonObjectCompany.getString("current_l1");
                                    currentLiab2 = jsonObjectCompany.getString("current_l2");
                                    outstandingShare = jsonObjectCompany.getString("outstanding_share");
                                    totalEquity = jsonObjectCompany.getString("total_equity");
                                    netIncome = jsonObjectCompany.getString("net_income");
                                    capitalExpenditure = jsonObjectCompany.getString("capital_expenditure");
                                    depreciation = jsonObjectCompany.getString("depreciation");
                                    cwc = jsonObjectCompany.getString("cwc");
                                    dividendPayment = jsonObjectCompany.getString("dividend_payment");
                                    capm = jsonObjectCompany.getString("capm");
                                    dividendPayout = jsonObjectCompany.getString("dividend_payout");
                                    retentionRatio = jsonObjectCompany.getString("retention_ratio");
                                    totalAsset = jsonObjectCompany.getString("total_asset");
                                    totalLiab12 = jsonObjectCompany.getString("total_l12");
                                    interestExpense = jsonObjectCompany.getString("interest_expense");
                                    ebit = jsonObjectCompany.getString("ebit");
                                    fcff = jsonObjectCompany.getString("fcff");
                                    costDebt = jsonObjectCompany.getString("cost_debt");
                                    wacc = jsonObjectCompany.getString("wacc");
                                    returnCapital = jsonObjectCompany.getString("return_capital");
                                    expectedGrowthFCFF = jsonObjectCompany.getString("expected_growth_fcff");
                                    intrinsikFCFF = jsonObjectCompany.getString("intrinsik_fcff");
                                    eps = jsonObjectCompany.getString("eps");
                                    newDebtIssued = jsonObjectCompany.getString("new_debt_issued");
                                    debtRepayment = jsonObjectCompany.getString("debt_repayment");
                                    fcfe = jsonObjectCompany.getString("fcfe");
                                    returnEquity = jsonObjectCompany.getString("return_equity");
                                    expectedGrowthFCFE = jsonObjectCompany.getString("expected_growth_fcfe");
                                    intrinsikFCFE = jsonObjectCompany.getString("intrinsik_fcfe");
                                    info = jsonObjectCompany.getString("info");
                                    idSector = Integer.parseInt(jsonObjectCompany.getString("id_sector"));
                                    updatedUsing = jsonObjectCompany.getString("updated_using");
                                    updatedAt = jsonObjectCompany.getString("updated_at");
                                    sql = "INSERT INTO companyprint (id_company, name_company, desc_company, image, stock_price, " +
                                            "beta, using_dollar, current_asset1, current_asset2, current_l1, current_l2, " +
                                            "outstanding_share, total_equity, net_income, capital_expenditure, depreciation, cwc, " +
                                            "dividend_payment, capm, dividend_payout, retention_ratio, total_asset, total_l12, " +
                                            "interest_expense, ebit, fcff, cost_debt, wacc, return_capital, expected_growth_fcff, " +
                                            "intrinsik_fcff, eps, new_debt_issued, debt_repayment, fcfe, return_equity, " +
                                            "expected_growth_fcfe, intrinsik_fcfe, info, id_sector, updated_using, updated_at) VALUES ('" +
                                            idCompany +
                                            "','" +
                                            namaCompany +
                                            "','" +
                                            descCompany +
                                            "','" +
                                            image +
                                            "','" +
                                            stockPrice +
                                            "'," +
                                            beta +
                                            "," +
                                            usingDollar +
                                            ",'" +
                                            currentAsset1 +
                                            "','" +
                                            currentAsset2 +
                                            "','" +
                                            currentLiab1 +
                                            "','" +
                                            currentLiab2 +
                                            "','" +
                                            outstandingShare +
                                            "','" +
                                            totalEquity +
                                            "','" +
                                            netIncome +
                                            "','" +
                                            capitalExpenditure +
                                            "','" +
                                            depreciation +
                                            "','" +
                                            cwc +
                                            "','" +
                                            dividendPayment +
                                            "','" +
                                            capm +
                                            "','" +
                                            dividendPayout +
                                            "','" +
                                            retentionRatio +
                                            "','" +
                                            totalAsset +
                                            "','" +
                                            totalLiab12 +
                                            "','" +
                                            interestExpense +
                                            "','" +
                                            ebit +
                                            "','" +
                                            fcff +
                                            "','" +
                                            costDebt +
                                            "','" +
                                            wacc +
                                            "','" +
                                            returnCapital +
                                            "','" +
                                            expectedGrowthFCFF +
                                            "','" +
                                            intrinsikFCFF +
                                            "','" +
                                            eps +
                                            "','" +
                                            newDebtIssued +
                                            "','" +
                                            debtRepayment +
                                            "','" +
                                            fcfe +
                                            "','" +
                                            returnEquity +
                                            "','" +
                                            expectedGrowthFCFE +
                                            "','" +
                                            intrinsikFCFE +
                                            "','" +
                                            info +
                                            "'," +
                                            idSector +
                                            ",'" +
                                            updatedUsing +
                                            "','" +
                                            updatedAt +
                                            "');";
                                    db.execSQL(sql);
                                    Log.d("DEBUG_", sql);
                                }
                            }
                        } catch (JSONException jee) {
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.cancel();
                Log.d("DEBUG_", "Error : "+error.toString());
                Toast.makeText(context, "Terjadi kesalahan, silahkan coba lagi",
                        Toast.LENGTH_SHORT).show();
            }
        });
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(100000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(stringRequest);
    }
}
