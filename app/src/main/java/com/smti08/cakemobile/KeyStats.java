package com.smti08.cakemobile;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class KeyStats extends android.support.v4.app.Fragment {

    ModelCategory modelCategory = new ModelCategory();
    TextView ket, beta, growthRates, currentAsset, currentLiabilities, workingCapital, totalLiabilities, outstandingShare, totalEquity,
    depreciation, ebit, interestExpense, taxRate, netProfit, eps, capitalExpenditure, dividendPayment, fc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        modelCategory = (ModelCategory) getArguments().getSerializable("x");
        View view = inflater.inflate(R.layout.fragment_keystats, container, false);
        ket = view.findViewById(R.id.ket);
        beta = view.findViewById(R.id.beta);
        growthRates = view.findViewById(R.id.growthRates);
        currentAsset = view.findViewById(R.id.currentAsset);
        currentLiabilities = view.findViewById(R.id.currentLiabilities);
        workingCapital = view.findViewById(R.id.workingCapital);
        totalLiabilities = view.findViewById(R.id.totalLiabilities);
        outstandingShare = view.findViewById(R.id.outstandingShare);
        totalEquity = view.findViewById(R.id.totalEquity);
        depreciation = view.findViewById(R.id.depreciation);
        ebit = view.findViewById(R.id.ebit);
        interestExpense = view.findViewById(R.id.interestExpense);
        taxRate = view.findViewById(R.id.taxRate);
        netProfit = view.findViewById(R.id.netProfit);
        eps = view.findViewById(R.id.eps);
        capitalExpenditure = view.findViewById(R.id.capitalExpenditure);
        dividendPayment = view.findViewById(R.id.dividendPayment);
        fc = view.findViewById(R.id.FC);
        ket.setText(ket.getText()+modelCategory.getUpdated_using());
        beta.setText(String.valueOf(modelCategory.getBeta()));
        currentAsset.setText(modelCategory.getCurrent_asset1());
        currentLiabilities.setText(modelCategory.getCurrent_l1());
        workingCapital.setText(modelCategory.getCwc());
        totalLiabilities.setText(modelCategory.getTotal_l12());
        outstandingShare.setText(modelCategory.getOutstanding_share());
        totalEquity.setText(modelCategory.getTotal_equity());
        depreciation.setText(modelCategory.getDepreciation());
        ebit.setText(modelCategory.getEbit());
        interestExpense.setText(modelCategory.getInterest_expense());
        taxRate.setText("25%");
        netProfit.setText(modelCategory.getNet_income());
        eps.setText(modelCategory.getEps());
        capitalExpenditure.setText(modelCategory.getCapital_expenditure());
        dividendPayment.setText(modelCategory.getDividend_payment());
        if (modelCategory.getUpdated_using().equals("FCFF")){
            growthRates.setText(modelCategory.getExpected_growth_fcff());
            fc.setText(modelCategory.getFcff());
        } else {
            growthRates.setText(modelCategory.getExpected_growth_fcfe());
            fc.setText(modelCategory.getFcfe());
        }
        return view;
    }
}
