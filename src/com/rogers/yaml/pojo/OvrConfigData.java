package com.rogers.yaml.pojo;

public class OvrConfigData {
    private String sspEnvironment;
    private String sspDealerCode;
    private String ovrQaEnvironment;

    public String getSspIgniteDealerCode() {
        return sspIgniteDealerCode;
    }

    public void setSspIgniteDealerCode(String sspIgniteDealerCode) {
        this.sspIgniteDealerCode = sspIgniteDealerCode;
    }

    private String sspIgniteDealerCode;
    public String getSspDealerCode() {
        return sspDealerCode;
    }
    public void setSspDealerCode(String sspDealerCode) {
        this.sspDealerCode = sspDealerCode;
    }
    public String getOvrQaEnvironment() {
        return ovrQaEnvironment;
    }
    public void setOvrQaEnvironment(String ovrQaEnvironment) {
        this.ovrQaEnvironment = ovrQaEnvironment;
    }

    public String getSspEnvironment() {
        return sspEnvironment;
    }
    public void setSspEnvironment(String sspEnvironment) {
        this.sspEnvironment = sspEnvironment;
    }

}
