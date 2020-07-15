package com.rogers.testdatamanagement;

import com.rogers.yaml.pojo.CHOneViewConfig;
import com.rogers.yaml.pojo.MigrationData;


import com.rogers.yaml.pojo.AALData;
import com.rogers.yaml.pojo.AccountData;
import com.rogers.yaml.pojo.Config;
import com.rogers.yaml.pojo.HUPData;
import com.rogers.yaml.pojo.PPCData;
import com.rogers.yaml.pojo.PaymentDetails;
import com.rogers.yaml.pojo.RedesignConfig;
import com.rogers.yaml.pojo.RedesignRpotgData;
import com.rogers.yaml.pojo.SauceSettings;

import com.rogers.yaml.pojo.ContactData;

public class TestDataHandler {	
	public static Config ssConfig;
	public static PaymentDetails paymentInfo;
	public static Config bfaConfig;
	public static PaymentDetails bfaPaymentInfo;
	public static AccountData tc013132;
	public static AccountData tc0224;
	public static AccountData tc041139;
	public static AccountData tc040609;
	public static AccountData tc1314;
	public static AccountData tc161825;
	public static AccountData tc1920;
	public static AccountData tc2751;
	public static AccountData tc36;
	public static AccountData tc495271;
	public static AccountData tc5074;
	public static AccountData tc53;
	public static AccountData tc54;
	public static AccountData tc55;
	public static AccountData tc56;
	public static AccountData tc57;
	public static AccountData tc58;
	public static AccountData tc59;
	public static AccountData tc6269;
	public static AccountData tc63;
	public static AccountData tc64;
	public static AccountData tc6577;
	public static AccountData tc727375;
	public static AccountData tc02;
	public static AccountData tc03;
	public static AccountData tc61;
	public static AccountData tc67;	
	public static AccountData tc78;
	public static AccountData tc7681;
	public static AccountData tc82;
	public static AccountData tc80;
	public static Config rogersConfig;
	public static AccountData digitalTVAccount;
	public static AccountData solarisInternetAccount;
	public static AccountData igniteTVAccount;
	public static AccountData tc41IgniteTVAccount;
	public static PaymentDetails rogersPaymentInfo;
	public static AccountData solarisTVAccount;
	public static AccountData standaloneInternetAccountWithUsage;
	public static AccountData legacyRHP;
	public static AccountData igniteRHP;
	public static AccountData solarisInternetAccountWithUsage;
	public static AccountData tc42SolarisInternetAccountWithUsage;
	public static AccountData solarisInternetAccountForUpgrade;
	public static AccountData solarisTVAccountForUpgrade;
	public static AccountData solarisTVAccountForUpgradeON;
	public static AccountData solarisTVAccountForUpgradeNL;
	public static AccountData solarisTVAccountForUpgradeNB;
	public static AccountData internetAccountUpgrade;
	public static AccountData digitalTVAccountUpgradePackage;
	public static AccountData  legacyInternetAccount;
	public static AccountData legacyInternetAccountUpgrade;
	public static AccountData solarisPortinFlows;
	public static AccountData digitalTVUpgradeToIgnite;
	public static AccountData  solarisInternetOldConstructor;
	public static AccountData solarisTVOldConstructor;
	public static AccountData noPortInAbondoneFlows;
	public static AccountData solarisInternetPackageChange;
	public static AccountData solarisTVAccountPackageUpgrade;
	public static AccountData solarisMultipleSubscriptions;
	public static AccountData solarisChangeTVPackageAdd4KChannelsAndThemePack;
	public static AccountData solarisChangeTVManageChannels;
	public static AccountData solarisChangeTVManageThemePacks;
	public static AccountData solarisInternetAccountWithUsageAndPackageUpgrade;
	public static AccountData solarisConsumerNoPortinCartAbandon;
	public static AccountData solarisConsumerPortInCartAbandon;
	public static AccountData solarisConsumerGWPDigitalTV;
	public static AccountData solarisConsumerGWPInternetDTV;
	public static AccountData solarisConsumerGWPRhpDtv ;
	public static AccountData solarisConsumerGWPShmDtv;
	public static AccountData solarisConsumerGWPDtvWireless;
	public static AccountData solarisConsumerGWPLegacyInternet;
	public static AccountData solarisConsumerGWPInternetandRHP;
	public static AccountData solarisConsumerGWPInternetSHM;
	public static AccountData solarisConsumerGWPRhp;
	public static AccountData solarisConsumerGWPRhpShm;
	public static AccountData solarisHTOMigrationSignIn;
	public static AALData testCase01;
	public static AALData testCase02;
	public static PPCData testCase03;
	public static HUPData testCase04;
	public static HUPData testCase05;
	public static HUPData testCase06;
	public static HUPData testCase07;
	public static PPCData testCase08;
	public static HUPData testCase09;
	public static SauceSettings sauceSettings;
	public static CHOneViewConfig chOneViewConfig;
	public static AccountData igniteTVParentalcontrols;
	public static AccountData solarisAccount;
	public static AccountData solarisTV;
	public static ContactData anonymousData;
	public static MigrationData migrationData;
	public static PaymentDetails ovPaymentInfo;
	public static AccountData tc60;
	public static RedesignConfig redesignConfig;
	public static RedesignRpotgData redesignRpotgData;
	public static AccountData tc40SHMAccount;
	public static AccountData tc47TupeloAccount;
	public static AccountData tc43IgniteRHP;
	public static AccountData tc44DigitalTVAccount;
	public static AccountData tc45LegacyInternetAccount;
	public static AccountData tc46LegacyRHP;
	public static AccountData tc0610;

	public static void dataInit (String strApplicationType) {	    	
    	if(strApplicationType.toUpperCase().trim().endsWith("CH")) {	    	
    		//cable Data files
    		connectedHomeDataInit();            
    	} else if(strApplicationType.toUpperCase().trim().endsWith("SS")
    			|| strApplicationType.toUpperCase().trim().endsWith("SS]")) {
	    	//Self-Service Data files
    		selfserveDataInit();
    	} else if(strApplicationType.toUpperCase().trim().endsWith("BFA")) {
    		//Buy-Flows Data files
    		buyFlowsDataInit();
    	} else if(strApplicationType.toUpperCase().trim().endsWith("COV")) {
    		//ch oneview  Data files
    		chOneViewDataInit();
    	} else if(strApplicationType.toUpperCase().trim().endsWith("NAC"))
    	{
    		reDesignDataInit();
    	}
    	else {
    		//All Data files
    		connectedHomeDataInit(); 
    		selfserveDataInit();
    		buyFlowsDataInit();
    		chOneViewDataInit();
    		reDesignDataInit();
    	}
	
	}
	
	private static void connectedHomeDataInit() {
		rogersConfig =  YamlHandler.getCableConfig();
      	rogersPaymentInfo = YamlHandler.getCablePaymentDetails();
      	sauceSettings = YamlHandler.getSauceSettings("/data/connectedhome/SauceSettings.yml");
      	//sacueConfig = YamlHandler.getSauceConfig();              	
      	//Digital TV test data
    	digitalTVAccount = YamlHandler.getCableAccountData("DigitalTVAccount");
    	digitalTVUpgradeToIgnite = YamlHandler.getCableAccountData("DigitalTVUpgradeToIgnite");
    	digitalTVAccountUpgradePackage = YamlHandler.getCableAccountData("DigitalTVAccountUpgradePackage");
    	noPortInAbondoneFlows = YamlHandler.getCableAccountData("NoPortInAbondoneFlows");
    	solarisConsumerNoPortinCartAbandon= YamlHandler.getCableAccountData("SolarisConsumerNoPortinCartAbandon");
		solarisConsumerPortInCartAbandon=YamlHandler.getCableAccountData("SolarisConsumerPortInCartAbandon");
		solarisConsumerGWPDigitalTV=YamlHandler.getCableAccountData("solarisConsumerGWPDigitalTV");
		solarisConsumerGWPInternetDTV=YamlHandler.getCableAccountData("solarisConsumerGWPInternetDTV");
		solarisConsumerGWPShmDtv = YamlHandler.getCableAccountData("solarisConsumerGWPDTVSHM");
		solarisConsumerGWPRhpDtv = YamlHandler.getCableAccountData("solarisConsumerGWPDTVRHP");
		solarisConsumerGWPDtvWireless = YamlHandler.getCableAccountData("solarisConsumerGWPDtvWireless");
		solarisConsumerGWPLegacyInternet = YamlHandler.getCableAccountData("solarisConsumerGWPLegacyInternet");
		solarisConsumerGWPInternetandRHP = YamlHandler.getCableAccountData("solarisConsumerGWPInternetandRHP");
		solarisConsumerGWPInternetSHM = YamlHandler.getCableAccountData("solarisConsumerGWPInternetSHM");
		solarisConsumerGWPRhp = YamlHandler.getCableAccountData("solarisConsumerGWPRhp");
		solarisConsumerGWPRhpShm = YamlHandler.getCableAccountData("solarisConsumerGWPRhpShm");
		
    	//Legacy Internet test data
    	legacyInternetAccount = YamlHandler.getCableAccountData("LegacyInternetAccount"); 
    	legacyInternetAccountUpgrade = YamlHandler.getCableAccountData("LegacyInternetAccountUpgrade");
    	
    	//RHP test data
    	legacyRHP = YamlHandler.getCableAccountData("LegacyRHP");
    	igniteRHP = YamlHandler.getCableAccountData("IgniteRHP");
    	solarisMultipleSubscriptions = YamlHandler.getCableAccountData("SolarisMultipleSubscriptions");
    	
    	//Ignite Internet test data
    	solarisInternetAccount = YamlHandler.getCableAccountData("SolarisInternetAccount");
    	internetAccountUpgrade   = YamlHandler.getCableAccountData("InternetAccountUpgrade");
    	solarisInternetAccountWithUsage = YamlHandler.getCableAccountData("SolarisInternetAccountWithUsage");
    	solarisInternetAccountForUpgrade = YamlHandler.getCableAccountData("SolarisInternetAccountForUpgrade");
    	standaloneInternetAccountWithUsage = YamlHandler.getCableAccountData("StandaloneInternetAccountWithUsage");
    	solarisInternetOldConstructor  = YamlHandler.getCableAccountData("SolarisInternetOldConstructor");
    	solarisInternetPackageChange = YamlHandler.getCableAccountData("SolarisInternetPackageChange");
    	solarisInternetAccountWithUsageAndPackageUpgrade = YamlHandler.getCableAccountData("SolarisInternetAccountWithUsageAndPackageUpgrade");

    	//Ignite TV test data
    	igniteTVAccount = YamlHandler.getCableAccountData("IgniteTVAccount");
    	solarisTVAccount = YamlHandler.getCableAccountData("SolarisTVAccount");
    	solarisPortinFlows = YamlHandler.getCableAccountData("SolarisPortinFlows");
    	solarisTVAccountForUpgrade = YamlHandler.getCableAccountData("SolarisTVAccountForUpgrade");
    	solarisTVAccountForUpgradeON = YamlHandler.getCableAccountData("SolarisTVAccountForUpgradeON");
    	solarisTVAccountForUpgradeNL = YamlHandler.getCableAccountData("SolarisTVAccountForUpgradeNL");
    	solarisTVAccountForUpgradeNB = YamlHandler.getCableAccountData("SolarisTVAccountForUpgradeNB"); 
    	solarisTVOldConstructor = YamlHandler.getCableAccountData("SolarisTVOldConstructor");
    	solarisTVAccountForUpgradeNB = YamlHandler.getCableAccountData("SolarisTVAccountForUpgradeNB");
    	solarisTVAccountPackageUpgrade = YamlHandler.getCableAccountData("SolarisTVPackageChange");
    	solarisChangeTVPackageAdd4KChannelsAndThemePack = YamlHandler.getCableAccountData("SolarisChangeTVPackageAdd4KChannelsAndThemePack");
    	solarisChangeTVManageChannels = YamlHandler.getCableAccountData("SolarisChangeTVManageChannels");
    	solarisChangeTVManageThemePacks = YamlHandler.getCableAccountData("SolarisChangeTVManageThemePacks");
    	solarisHTOMigrationSignIn = YamlHandler.getCableAccountData("SolarisHTOMigrationSignIn");
	}
	
	private static void selfserveDataInit() {
    	ssConfig =  YamlHandler.getConfig();
    	sauceSettings = YamlHandler.getSauceSettings("/data/selfserve/SauceSettings.yml");
    	paymentInfo = YamlHandler.getPaymentDetails();
    	tc013132 = YamlHandler.getAccountData("tc01_31_32Postpaid");
    	tc0224 = YamlHandler.getAccountData("tc02_24PostpaidLostStolen");
    	tc041139 = YamlHandler.getAccountData("tc04_11_39PostpaidLinkAccount");
    	tc040609 = YamlHandler.getAccountData("tc04_06_09RecoveryBySMS");
    	tc1314 = YamlHandler.getAccountData("tc13_14PostPaidWithSIM");
    	tc161825 = YamlHandler.getAccountData("tc16_18_25PostpaidPayment");
    	tc1920 = YamlHandler.getAccountData("tc19_20PostpaidPayment");
    	tc2751 = YamlHandler.getAccountData("tc27_51PostpaidWithVoicemail");
    	tc36 = YamlHandler.getAccountData("tc36PostpaidWithBill");
    	tc495271 = YamlHandler.getAccountData("tc49_52_71NSE");
    	tc5074 = YamlHandler.getAccountData("tc50_74InfiniteSE(Demoline)");
    	tc53 = YamlHandler.getAccountData("tc53Prepaid");
    	tc54 = YamlHandler.getAccountData("tc54NSEwithUnlimitedTTOnlyPlan");
    	tc55 = YamlHandler.getAccountData("tc55NSEwithLimitedTTOnlyPlan");
    	tc56 = YamlHandler.getAccountData("tc56NSEwithDataOnlyPlan");
    	tc57 = YamlHandler.getAccountData("tc57NSEwDataUnlimitedTTPlan");
    	tc58 = YamlHandler.getAccountData("tc58NSEwDataLimitedTTPlan");
    	tc59 = YamlHandler.getAccountData("tc59NSEwDataUnlimitedTTPlanRunningLow");
    	tc61 = YamlHandler.getAccountData("tc61SEPlanRunningLow(Demoline)");
    	tc6269 = YamlHandler.getAccountData("tc62_69InfiniteSE(Demoline)");
    	tc63 = YamlHandler.getAccountData("tc63NSEindividualRunningLow");
    	tc64 = YamlHandler.getAccountData("tc64InfiniteNSEReducedSpeed");
    	tc6577 = YamlHandler.getAccountData("tc65_77InfiniteNSE");
    	tc727375 = YamlHandler.getAccountData("tc72_73_75NSE");
    	tc02 = YamlHandler.getAccountData("tc02_PreRegister");
    	tc03 = YamlHandler.getAccountData("tc03RecoverUsernameByEmail");
    	tc67 = YamlHandler.getAccountData("tc67InfiniteSEReducedSpeed(Demoline)");    
    	tc7681 = YamlHandler.getAccountData("tc76_81SEPlanWith6Ctns(Demoline)"); 
    	tc78 = YamlHandler.getAccountData("tc78NSESingleLine");    	    	
    	tc60 = YamlHandler.getAccountData("tc60SEMultipleCTN");
    	tc80 = YamlHandler.getAccountData("TC80NSEwOverage");
    	tc82 = YamlHandler.getAccountData("tc82InfiniteSE");
    	
    	//================ Connected home =========================
    	tc43IgniteRHP = YamlHandler.getAccountData("tc43IgniteRHP");
    	tc42SolarisInternetAccountWithUsage = YamlHandler.getAccountData("tc42SolarisInternetAccountWithUsage");
    	tc41IgniteTVAccount = YamlHandler.getAccountData("tc41IgniteTVAccount");
    	tc44DigitalTVAccount = YamlHandler.getAccountData("tc44DigitalTVAccount");
    	tc46LegacyRHP = YamlHandler.getAccountData("tc46LegacyRHP");
    	tc45LegacyInternetAccount = YamlHandler.getAccountData("tc45LegacyInternetAccount");
    	tc40SHMAccount = YamlHandler.getAccountData("tc40SHMAccount");
    	tc47TupeloAccount = YamlHandler.getAccountData("tc47TupeloAccount");
    	tc0610 = YamlHandler.getAccountData("tc06_10DemolineSEPlanMultiLine");
	}
	
	private static void buyFlowsDataInit() {
		ssConfig =  YamlHandler.getBFAConfig();
		bfaConfig =  YamlHandler.getBFAConfig();
		sauceSettings = YamlHandler.getSauceSettings("/data/buyflows/SauceSettings.yml");
		bfaPaymentInfo = YamlHandler.getBFAPaymentDetails();
    	testCase01 = YamlHandler.getAALdata("tc01AAL");
    	testCase02 = YamlHandler.getAALdata("tc02AAL");
    	testCase03 = YamlHandler.getPPCdata("tc03PPC");
    	testCase04 = YamlHandler.getHUPdata("tc04HUP");
    	testCase05 = YamlHandler.getHUPdata("tc05HUP");
    	testCase06 = YamlHandler.getHUPdata("tc06HUP");
    	testCase07 = YamlHandler.getHUPdata("tc07HUP");
    	testCase08 = YamlHandler.getPPCdata("tc08PPC");
    	testCase09 = YamlHandler.getHUPdata("tc09HUP");
	}
	
	private static void chOneViewDataInit() {
     	chOneViewConfig =  YamlHandler.getCHOneViewConfig();
    	ovPaymentInfo=YamlHandler.getOVPaymentDetails();
      	igniteTVParentalcontrols = YamlHandler.getOVAccountData("IgniteTVParentalcontrols");
      	solarisAccount = YamlHandler.getOVAccountData("SolarisAccount");
      	solarisTV = YamlHandler.getOVAccountData("SolarisTV");
      	anonymousData=YamlHandler.getContactData("AnonymousData");
      	migrationData=YamlHandler.getMigrationData("MigrationData");      
	}

	private static void reDesignDataInit(){
		redesignConfig=YamlHandler.getRedesignConfig();
		sauceSettings = YamlHandler.getSauceSettings("/data/redesignrogersNAC/SauceSettings.yml");
		redesignRpotgData=YamlHandler.getRedesignRpotgData();
	}

}
