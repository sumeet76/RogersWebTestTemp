package com.rogers.testdatamanagement;

import com.rogers.yaml.pojo.CHOneViewConfig;
import com.rogers.yaml.pojo.MigrationData;


import com.rogers.yaml.pojo.AALData;
import com.rogers.yaml.pojo.AccountData;
import com.rogers.yaml.pojo.Config;
import com.rogers.yaml.pojo.HUPData;
import com.rogers.yaml.pojo.PPCData;
import com.rogers.yaml.pojo.PaymentDetails;
import com.rogers.yaml.pojo.SauceSettings;

import com.rogers.yaml.pojo.ContactData;

public class TestDataHandler {	
	public static Config ssConfig;
	public static PaymentDetails paymentInfo;
	public static Config bfaConfig;
	public static Config chConfig;
	public static CHOneViewConfig chOneViewConfig;
	public static PaymentDetails bfaPaymentInfo;
	public static PaymentDetails chPaymentInfo;	
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
	public static AccountData digitalTVAccount;
	public static AccountData solarisInternetAccount;
	public static AccountData igniteTVAccount;
	public static AccountData igniteTV4Plus1Account;
	public static AccountData tc41IgniteTVAccount;
	public static AccountData solarisTVAccount;
	public static AccountData standaloneInternetAccountWithUsage;
	public static AccountData legacyRHP;
	public static AccountData igniteRHP;
	public static AccountData rogersSHM;
	public static AccountData solarisInternetAccountWithUsage;
	public static AccountData tc42SolarisInternetAccountWithUsage;
	public static AccountData solarisInternetAccountForUpgrade;
	public static AccountData solarisTVAccountForUpgrade;
	public static AccountData solarisTVAccountStarterPackage;
	public static AccountData solarisTVAccountFlex5Package;
	public static AccountData solarisTVAccountPopularPackage;
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
	public static AccountData standaloneInternetAccountforUpgrade;
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
	public static AALData testCase7;
	public static HUPData testCase8;
	public static PPCData testCase9;
	public static AALData testCase02;
	public static HUPData testCase05;
	public static HUPData testCase06;
	public static HUPData testCase07;
	public static PPCData testCase08;
	public static HUPData testCase09;
	public static HUPData testCase10;
	public static HUPData buyFlowsOVtestCase01;
	public static HUPData buyFlowsOVtestCase02;
	public static HUPData buyFlowsOVtestCase05;
	public static HUPData buyFlowsOVtestCase06;
	public static PPCData buyFlowsOVtestCase03;
	public static PPCData buyFlowsOVtestCase04;
	public static PPCData buyFlowsOVtestCase07;
	public static SauceSettings sauceSettings;
	public static AccountData igniteTVParentalcontrols;
	public static AccountData solarisAccount;
	public static AccountData solarisTV;
	public static ContactData anonymousData;
	public static MigrationData migrationData;
	public static PaymentDetails ovPaymentInfo;
	public static AccountData tc60;
	public static AccountData tc40SHMAccount;
	public static AccountData tc47TupeloAccount;
	public static AccountData tc43IgniteRHP;
	public static AccountData tc44DigitalTVAccount;
	public static AccountData tc45LegacyInternetAccount;
	public static AccountData tc46LegacyRHP;
	public static AccountData shmAccount;
	public static AccountData tupeloAccount;
	public static Config bfaOneViewConfig;
	public static PaymentDetails bfaOneViewPaymentInfo;
	public static AccountData tc0610;
	public static Config rogersConfig;
	public static AccountData tc01030405;
	public static AccountData tc92;
	public static AccountData tc95;
	public static AccountData tc90;
	public static AccountData tc98;
	public static AccountData tc94;
	
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
    	} else if(strApplicationType.toUpperCase().trim().endsWith("BFAONEVIEW")) {
        		//Buy-Flows Data files
    		buyFlowsOneViewDataInit();
    	} else if(strApplicationType.toUpperCase().trim().endsWith("COV")) {
    		//ch oneview  Data files
    		chOneViewDataInit();
    	}
    	else {
    		//All Data files
    		connectedHomeDataInit(); 
    		selfserveDataInit();
    		buyFlowsDataInit();
    		chOneViewDataInit();
    	}
	
	}
	
	private static void connectedHomeDataInit() {
		chConfig =  YamlHandler.getCableConfig();
      	chPaymentInfo = YamlHandler.getCablePaymentDetails();
      	sauceSettings = YamlHandler.getSauceSettings("/test-data/rogers/connectedhome/SauceSettings.yml");
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
    	rogersSHM = YamlHandler.getCableAccountData("RogersSHM");
    	solarisMultipleSubscriptions = YamlHandler.getCableAccountData("SolarisMultipleSubscriptions");
    	
    	//Ignite Internet test data
    	solarisInternetAccount = YamlHandler.getCableAccountData("SolarisInternetAccount");
    	internetAccountUpgrade   = YamlHandler.getCableAccountData("InternetAccountUpgrade");
    	standaloneInternetAccountforUpgrade   = YamlHandler.getCableAccountData("StandaloneInternetAccountforUpgrade");
    	solarisInternetAccountWithUsage = YamlHandler.getCableAccountData("SolarisInternetAccountWithUsage");
    	solarisInternetAccountForUpgrade = YamlHandler.getCableAccountData("SolarisInternetAccountForUpgrade");
    	standaloneInternetAccountWithUsage = YamlHandler.getCableAccountData("StandaloneInternetAccountWithUsage");
    	solarisInternetOldConstructor  = YamlHandler.getCableAccountData("SolarisInternetOldConstructor");
    	solarisInternetPackageChange = YamlHandler.getCableAccountData("SolarisInternetPackageChange");
    	solarisInternetAccountWithUsageAndPackageUpgrade = YamlHandler.getCableAccountData("SolarisInternetAccountWithUsageAndPackageUpgrade");

    	//Ignite TV test data
    	igniteTVAccount = YamlHandler.getCableAccountData("IgniteTVAccount");
		igniteTV4Plus1Account = YamlHandler.getCableAccountData("IgniteTV4Plus1Account");
    	solarisTVAccount = YamlHandler.getCableAccountData("SolarisTVAccount");
    	solarisPortinFlows = YamlHandler.getCableAccountData("SolarisPortinFlows");
    	solarisTVAccountStarterPackage = YamlHandler.getCableAccountData("SolarisTVAccountStarterPackage");
    	solarisTVAccountFlex5Package = YamlHandler.getCableAccountData("SolarisTVAccountFlex5Package");
    	solarisTVAccountPopularPackage = YamlHandler.getCableAccountData("SolarisTVAccountPopularPackage");
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
    	ssConfig =  YamlHandler.getSSConfig();
    	sauceSettings = YamlHandler.getSauceSettings("/test-data/rogers/selfserve/SauceSettings.yml");
    	paymentInfo = YamlHandler.getSSPaymentDetails();
    	tc013132 = YamlHandler.getSSAccountData("tc01_31_32Postpaid");
    	tc0224 = YamlHandler.getSSAccountData("tc02_24PostpaidLostStolen");
    	tc041139 = YamlHandler.getSSAccountData("tc04_11_39PostpaidLinkAccount");
    	tc040609 = YamlHandler.getSSAccountData("tc04_06_09RecoveryBySMS");
    	tc1314 = YamlHandler.getSSAccountData("tc13_14PostPaidWithSIM");
    	tc161825 = YamlHandler.getSSAccountData("tc16_18_25PostpaidPayment");
    	tc1920 = YamlHandler.getSSAccountData("tc19_20PostpaidPayment");
    	tc2751 = YamlHandler.getSSAccountData("tc27_51PostpaidWithVoicemail");
    	tc36 = YamlHandler.getSSAccountData("tc36PostpaidWithBill");
    	tc495271 = YamlHandler.getSSAccountData("tc49_52_71NSE");
    	tc5074 = YamlHandler.getSSAccountData("tc50_74InfiniteSE(Demoline)");
    	tc53 = YamlHandler.getSSAccountData("tc53Prepaid");
    	tc54 = YamlHandler.getSSAccountData("tc54NSEwithUnlimitedTTOnlyPlan");
    	tc55 = YamlHandler.getSSAccountData("tc55NSEwithLimitedTTOnlyPlan");
    	tc56 = YamlHandler.getSSAccountData("tc56NSEwithDataOnlyPlan");
    	tc57 = YamlHandler.getSSAccountData("tc57NSEwDataUnlimitedTTPlan");
    	tc58 = YamlHandler.getSSAccountData("tc58NSEwDataLimitedTTPlan");
    	tc59 = YamlHandler.getSSAccountData("tc59NSEwDataUnlimitedTTPlanRunningLow");
    	tc61 = YamlHandler.getSSAccountData("tc61SEPlanRunningLow(Demoline)");
    	tc6269 = YamlHandler.getSSAccountData("tc62_69InfiniteSE(Demoline)");
    	tc63 = YamlHandler.getSSAccountData("tc63NSEindividualRunningLow");
    	tc64 = YamlHandler.getSSAccountData("tc64InfiniteNSEReducedSpeed");
    	tc6577 = YamlHandler.getSSAccountData("tc65_77InfiniteNSE");
    	tc727375 = YamlHandler.getSSAccountData("tc72_73_75NSE");
    	tc02 = YamlHandler.getSSAccountData("tc02_PreRegister");
    	tc03 = YamlHandler.getSSAccountData("tc03RecoverUsernameByEmail");
    	tc67 = YamlHandler.getSSAccountData("tc67InfiniteSEReducedSpeed(Demoline)");    
    	tc7681 = YamlHandler.getSSAccountData("tc76_81SEPlanWith6Ctns(Demoline)"); 
    	tc78 = YamlHandler.getSSAccountData("tc78NSESingleLine");    	    	
    	tc60 = YamlHandler.getSSAccountData("tc60SEMultipleCTN");
    	tc80 = YamlHandler.getSSAccountData("TC80NSEwOverage");
    	tc82 = YamlHandler.getSSAccountData("tc82InfiniteSE");
    	tc01030405 =  YamlHandler.getSSAccountData("tc01_03_04_05_FDMInfiniteSE");
    	tc92 = YamlHandler.getSSAccountData("tc92_CancelledInfiniteNSE");
    	tc94 = YamlHandler.getSSAccountData("tc94CreditLimitExceededAccountSEInfinite");
    	tc95 = YamlHandler.getSSAccountData("tc95NSESuspendedCTN");
    	tc90 = YamlHandler.getSSAccountData("tc90_SE_NSE_ResidentialServices");
    	tc98 = YamlHandler.getSSAccountData("tc98PrepaidAccount");
    	
    	//================ Connected home =========================
    	tc43IgniteRHP = YamlHandler.getSSAccountData("tc43IgniteRHP");
    	tc42SolarisInternetAccountWithUsage = YamlHandler.getSSAccountData("tc42SolarisInternetAccountWithUsage");
    	tc41IgniteTVAccount = YamlHandler.getSSAccountData("tc41IgniteTVAccount");
    	tc44DigitalTVAccount = YamlHandler.getSSAccountData("tc44DigitalTVAccount");
    	tc46LegacyRHP = YamlHandler.getSSAccountData("tc46LegacyRHP");
    	tc45LegacyInternetAccount = YamlHandler.getSSAccountData("tc45LegacyInternetAccount");
    	tc40SHMAccount = YamlHandler.getSSAccountData("tc40SHMAccount");
    	tc47TupeloAccount = YamlHandler.getSSAccountData("tc47TupeloAccount");
    	tc0610 = YamlHandler.getSSAccountData("tc06_10DemolineSEPlanMultiLine");
	}
	
	private static void buyFlowsDataInit() {
		rogersConfig = YamlHandler.getBFAConfig();
		bfaConfig =  YamlHandler.getBFAConfig();
		sauceSettings = YamlHandler.getSauceSettings("/test-data/rogers/buyflows/SauceSettings.yml");
		bfaPaymentInfo = YamlHandler.getBFAPaymentDetails();
		testCase7 = YamlHandler.getAALdata("tc7AAL");
		testCase8 = YamlHandler.getHUPdata("tc8HUP");
    	testCase9 = YamlHandler.getPPCdata("tc9PPC");
    	testCase02 = YamlHandler.getAALdata("tc02AAL");
    	testCase05 = YamlHandler.getHUPdata("tc05HUP");
    	testCase06 = YamlHandler.getHUPdata("tc06HUP");
    	testCase10 = YamlHandler.getHUPdata("tc10HUP");
    	testCase08 = YamlHandler.getPPCdata("tc08PPC");    	
	}
	
	private static void buyFlowsOneViewDataInit() {
		bfaOneViewConfig =  YamlHandler.getBFAOneViewConfig();
		sauceSettings = YamlHandler.getSauceSettings("/test-data/rogers/buyflows/SauceSettings.yml");
		bfaOneViewPaymentInfo = YamlHandler.getBFAOneViewPaymentDetails();
		buyFlowsOVtestCase01 = YamlHandler.getHUPdataOneView("tc01OVHUPWithPPCMultilineAccount");
		buyFlowsOVtestCase02 = YamlHandler.getHUPdataOneView("tc02OVHUPExistingPlanMultilineAccount");
		buyFlowsOVtestCase03 = YamlHandler.getPPCdataOneView("tc03OVPPCMultilineAccountForBothLines");
		buyFlowsOVtestCase04 = YamlHandler.getPPCdataOneView("tc04OVPPCMultilineAccount");
		buyFlowsOVtestCase05 = YamlHandler.getHUPdataOneView("tc05OVHUPWithPPCSinglelineAccount");
		buyFlowsOVtestCase06 = YamlHandler.getHUPdataOneView("tc06OVHUPExistingPlanSinglelineAccount");
		buyFlowsOVtestCase07 = YamlHandler.getPPCdataOneView("tc07OVPPCSinglelineAccount");		
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

}
