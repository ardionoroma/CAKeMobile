package com.smti08.cakemobile;

import java.io.Serializable;
import java.util.ArrayList;

public class ModelCategory implements Serializable {
    private ArrayList<ModelCategory> modelCategory = new ArrayList<>();
    private String id_company, name_company, desc_company, image, stock_price, current_asset1, current_asset2;
    private String current_l1, current_l2, outstanding_share, total_equity, net_income, capital_expenditure, depreciation, cwc;
    private String dividend_payment, capm, dividend_payout, retention_ratio, total_asset, total_l12, interest_expense, ebit, fcff;
    private String cost_debt, wacc, return_capital, expected_growth_fcff, intrinsik_fcff, eps, new_debt_issued, debt_repayment, fcfe;
    private String return_equity, expected_growth_fcfe, intrinsik_fcfe, info, updated_using, updated_at;
    private int id, using_dollar, id_sector;
    private float beta;

    public ModelCategory() {
    }

    public int getID(){ return id; }
    public void setId(int id) { this.id = id; }
    public String getId_company() { return id_company; }
    public void setId_company(String id_company) { this.id_company = id_company; }
    public String getName_company() { return name_company; }
    public void setName_company(String name_company) { this.name_company = name_company; }
    public String getDesc_company() { return desc_company; }
    public void setDesc_company(String desc_company) { this.desc_company = desc_company; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public String getStock_price() { return stock_price; }
    public void setStock_price(String stock_price) { this.stock_price = stock_price; }
    public float getBeta() { return beta; }
    public void setBeta(float beta) { this.beta = beta; }
    public int getUsing_dollar() { return using_dollar; }
    public void setUsing_dollar(int using_dollar) { this.using_dollar = using_dollar; }
    public String getCurrent_asset1() { return current_asset1; }
    public void setCurrent_asset1(String current_asset1) { this.current_asset1 = current_asset1; }
    public String getCurrent_asset2() { return current_asset2; }
    public void setCurrent_asset2(String current_asset2) { this.current_asset2 = current_asset2; }
    public String getCurrent_l1() { return current_l1; }
    public void setCurrent_l1(String current_l1) { this.current_l1 = current_l1; }
    public String getCurrent_l2() { return current_l2; }
    public void setCurrent_l2(String current_l2) { this.current_l2 = current_l2; }
    public String getOutstanding_share() { return outstanding_share; }
    public void setOutstanding_share(String outstanding_share) { this.outstanding_share = outstanding_share; }
    public String getTotal_equity() { return total_equity; }
    public void setTotal_equity(String total_equity) { this.total_equity = total_equity; }
    public String getNet_income() { return net_income; }
    public void setNet_income(String net_income) { this.net_income = net_income; }
    public String getCapital_expenditure() { return capital_expenditure; }
    public void setCapital_expenditure(String capital_expenditure) { this.capital_expenditure = capital_expenditure; }
    public String getDepreciation() { return depreciation; }
    public void setDepreciation(String depreciation) { this.depreciation = depreciation; }
    public String getCwc() { return cwc; }
    public void setCwc(String cwc) { this.cwc = cwc; }
    public String getDividend_payment() { return dividend_payment; }
    public void setDividend_payment(String dividend_payment) { this.dividend_payment = dividend_payment; }
    public String getCapm() { return capm; }
    public void setCapm(String capm) { this.capm = capm; }
    public String getDividend_payout() { return dividend_payout; }
    public void setDividend_payout(String dividend_payout) { this.dividend_payout = dividend_payout; }
    public String getRetention_ratio() { return retention_ratio; }
    public void setRetention_ratio(String retention_ratio) { this.retention_ratio = retention_ratio; }
    public String getTotal_asset() { return total_asset; }
    public void setTotal_asset(String total_asset) { this.total_asset = total_asset; }
    public String getTotal_l12() { return total_l12; }
    public void setTotal_l12(String total_l12) { this.total_l12 = total_l12; }
    public String getInterest_expense() { return interest_expense; }
    public void setInterest_expense(String interest_expense) { this.interest_expense = interest_expense; }
    public String getEbit() { return ebit; }
    public void setEbit(String ebit) { this.ebit = ebit; }
    public String getFcff(){ return fcff; }
    public void setFcff(String fcff){ this.fcff = fcff; }
    public String getCost_debt(){ return cost_debt; }
    public void setCost_debt(String cost_debt){ this.cost_debt = cost_debt; }
    public String getWacc(){ return wacc; }
    public void setWacc(String wacc){ this.wacc = wacc; }
    public String getReturn_capital(){ return return_capital;}
    public void setReturn_capital(String return_capital){ this.return_capital = return_capital; }
    public String getExpected_growth_fcff(){ return expected_growth_fcff; }
    public void setExpected_growth_fcff(String expected_growth_fcff){ this.expected_growth_fcff = expected_growth_fcff; }
    public String getIntrinsik_fcff(){ return intrinsik_fcff; }
    public void setIntrinsik_fcff(String intrinsik_fcff){ this.intrinsik_fcff = intrinsik_fcff; }
    public String getEps(){ return eps; }
    public void setEps(String eps){ this.eps = eps; }
    public String getNew_debt_issued(){ return new_debt_issued; }
    public void setNew_debt_issued(String new_debt_issued){ this.new_debt_issued = new_debt_issued; }
    public String getDebt_repayment(){ return debt_repayment; }
    public void setDebt_repayment(String debt_repayment){ this.debt_repayment = debt_repayment; }
    public String getFcfe(){ return fcfe; }
    public void setFcfe(String fcfe){ this.fcfe = fcfe; }
    public String getReturn_equity(){ return return_equity; }
    public void setReturn_equity(String return_equity){ this.return_equity = return_equity; }
    public String getExpected_growth_fcfe(){ return expected_growth_fcfe; }
    public void setExpected_growth_fcfe(String expected_growth_fcfe){ this.expected_growth_fcfe = expected_growth_fcfe; }
    public String getIntrinsik_fcfe(){ return intrinsik_fcfe; }
    public void setIntrinsik_fcfe(String intrinsik_fcfe){ this.intrinsik_fcfe = intrinsik_fcfe; }
    public String getInfo(){ return info; }
    public void setInfo(String info){ this.info = info; }
    public int getId_sector(){ return id_sector; }
    public void setId_sector(int id_sector){ this.id_sector = id_sector; }
    public String getUpdated_using(){ return updated_using; }
    public void setUpdated_using(String updated_using){ this.updated_using = updated_using; }
    public String getUpdated_at(){ return updated_at; }
    public void setUpdated_at(String updated_at){ this.updated_at = updated_at; }
}