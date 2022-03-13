package com.rogers.yaml.pojo;

public class OvrReusableData {
    public  String getBanNumber() {
        return banNumber;
    }
    public void setBanNumber(String banNumber) {
        this.banNumber = banNumber;
    }
    public  String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    private   String banNumber;
    private   String postalCode;
    private   String addOnPlan;
    private String addOnPlanFr;
    public String getAddOnPlan() {return this.addOnPlan; }
    public void setAddOnPlan(String AddOnPlan) {this.addOnPlan = AddOnPlan;}

    public String getAddOnPlanFr() {
        return addOnPlanFr;
    }

    public void setAddOnPlanFr(String addOnPlanFr) {
        this.addOnPlanFr = addOnPlanFr;
    }

}
