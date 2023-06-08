package com.rogers.yaml.pojo;

public class OvrConfigData {

    private String sspEnvironment;
    private String sspDealerCode;
    private String ovrQaEnvironment;
    private String flexChannelsPackageEN;
    private String flexChannelsPackageFR;
    private String sspIgniteDealerCode;

    private String grabAndGoSerialNumber;
    private String sspGrabAndGoDealerCode;
    private String fidoDealerCode;


    public String getGrabAndGoSerialNumber() {
        return grabAndGoSerialNumber;
    }

    public void setGrabAndGoSerialNumber(String grabAndGoSerialNumber) {
        this.grabAndGoSerialNumber = grabAndGoSerialNumber;
    }

    public String getSspGrabAndGoDealerCode() {
        return sspGrabAndGoDealerCode;
    }

    public void setSspGrabAndGoDealerCode(String sspGrabAndGoDealerCode) {
        this.sspGrabAndGoDealerCode = sspGrabAndGoDealerCode;
    }

    public String getFidoDealerCode() {
        return fidoDealerCode;
    }

    public void setFidoDealerCode(String fidoDealerCode) {
        this.fidoDealerCode = fidoDealerCode;
    }


    public String getSspIgniteDealerCode() {
        return sspIgniteDealerCode;
    }

    public void setSspIgniteDealerCode(String sspIgniteDealerCode) {
        this.sspIgniteDealerCode = sspIgniteDealerCode;
    }

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

    public String getFlexChannelsPackageEN() {return flexChannelsPackageEN;}

    public String getFlexChannelsPackageFR() {return flexChannelsPackageFR;}

    public void setFlexChannelsPackageEN(String flexChannelsPackageEN) {
        this.flexChannelsPackageEN = flexChannelsPackageEN;
    }

    public void setFlexChannelsPackageFR(String flexChannelsPackageFR) {
        this.flexChannelsPackageFR = flexChannelsPackageFR;
    }

}
