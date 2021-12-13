package com.rogers.yaml.pojo;

public class OvrConfigData {
    private String sspEnvironment;
    private String sspdealercode;
    public String getSspdealercode() {
        return sspdealercode;
    }
    public void setSspdealercode(String sspdealercode) {
        this.sspdealercode = sspdealercode;
    }
    public String getOvrQaEnvironment() {
        return ovrQaEnvironment;
    }
    public void setOvrQaEnvironment(String ovrQaEnvironment) {
        this.ovrQaEnvironment = ovrQaEnvironment;
    }
    private String ovrQaEnvironment;
    public String getSspEnvironment() {
        return sspEnvironment;
    }
    public void setSspEnvironment(String sspEnvironment) {
        this.sspEnvironment = sspEnvironment;
    }

}
