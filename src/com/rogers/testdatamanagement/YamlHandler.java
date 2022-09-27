package com.rogers.testdatamanagement;

import com.rogers.yaml.pojo.*;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class YamlHandler {

	public static AccountData getSSAccountData(String accountName) throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(AccountData.class));
		InputStream inputStream;

		inputStream = new FileInputStream(
				new File(System.getProperty("user.dir") + "/test-data/rogers/selfserve/" + accountName + ".yml"));
		AccountData account = yaml.load(inputStream);
		return account;


	}

	public static AccountData getCableAccountData(String accountName) throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(AccountData.class));
		InputStream inputStream;

		inputStream = new FileInputStream(
				new File(System.getProperty("user.dir") + "/test-data/rogers/connectedhome/" + accountName + ".yml"));
		AccountData account = yaml.load(inputStream);
		return account;

	}

	public static AccountData getOVAccountData(String accountName) throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(AccountData.class));
		InputStream inputStream;

		inputStream = new FileInputStream(
				new File(System.getProperty("user.dir") + "/test-data/rogers/choneview/" + accountName + ".yml"));
		AccountData account = yaml.load(inputStream);
		return account;

	}

	public static Config getSSConfig() throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(Config.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/selfserve/Config.yml"));
		Config config = yaml.load(inputStream);
		return config;

	}

	public static Config getBFAConfig() throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(Config.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflows/Config.yml"));
		Config config = yaml.load(inputStream);
		return config;


	}

	public static Config getBFAOneViewConfig() throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(Config.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflowsoneview/Config.yml"));
		Config config = yaml.load(inputStream);
		return config;


	}

	public static DBConnection getDBConnection() throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(DBConnection.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/selfserve/DBConnection.yml"));
		DBConnection dbConnection = yaml.load(inputStream);
		return dbConnection;


	}

	public static LoginDetails getBFAOneViewLoginDetails() throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(LoginDetails.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflowsoneview/LoginDetails.yml"));
		LoginDetails login = yaml.load(inputStream);
		return login;


	}


	public static PaymentDetails getSSPaymentDetails() throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(PaymentDetails.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/selfserve/PaymentInfo.yml"));
		PaymentDetails paymentDetails = yaml.load(inputStream);
		return paymentDetails;


	}

	public static PaymentDetails getCablePaymentDetails() throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(PaymentDetails.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/connectedhome/PaymentInfo.yml"));
		PaymentDetails paymentDetails = yaml.load(inputStream);
		return paymentDetails;


	}

	public static PaymentDetails getBFAPaymentDetails() throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(PaymentDetails.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflows/RogersPaymentInfo.yml"));
		PaymentDetails paymentDetails = yaml.load(inputStream);
		return paymentDetails;


	}

	public static PaymentDetails getBFAOneViewPaymentDetails() throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(PaymentDetails.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflowsoneview/RogersPaymentInfo.yml"));
		PaymentDetails paymentDetails = yaml.load(inputStream);
		return paymentDetails;


	}


	public static PaymentDetails getOVPaymentDetails() throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(PaymentDetails.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/choneview/OVPaymentInfo.yml"));
		PaymentDetails paymentDetails = yaml.load(inputStream);
		return paymentDetails;


	}

	public static NACData getNACData(String dataFileName) throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(NACData.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflows/" + dataFileName + ".yml"));
		NACData nacData = yaml.load(inputStream);
		return nacData;


	}

	public static AALData getAALdata(String dataFileName) throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(AALData.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflows/" + dataFileName + ".yml"));
		AALData aalData = yaml.load(inputStream);
		return aalData;


	}

	public static AALOVData getAALdataOneView(String dataFileName) throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(AALOVData.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflowsoneview/" + dataFileName + ".yml"));
		AALOVData aalData = yaml.load(inputStream);
		return aalData;


	}

	public static HUPData getHUPdata(String dataFileName) throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(HUPData.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflows/" + dataFileName + ".yml"));
		HUPData hupData = yaml.load(inputStream);
		return hupData;


	}

	public static HUPData getHUPdataOneView(String dataFileName) throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(HUPData.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflowsoneview/" + dataFileName + ".yml"));
		HUPData hupData = yaml.load(inputStream);
		return hupData;


	}

	public static PPCData getPPCdata(String dataFileName) throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(PPCData.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflows/" + dataFileName + ".yml"));
		PPCData ppcData = yaml.load(inputStream);
		return ppcData;


	}

	public static PPCData getPPCdataOneView(String dataFileName) throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(PPCData.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflowsoneview/" + dataFileName + ".yml"));
		PPCData ppcData = yaml.load(inputStream);
		return ppcData;


	}

	public static ContactData getContactData(String accountName) throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(ContactData.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/choneview/" + accountName + ".yml"));
		ContactData contactDetails = yaml.load(inputStream);
		return contactDetails;


	}

	public static MigrationData getMigrationData(String accountName) throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(MigrationData.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/choneview/" + accountName + ".yml"));
		MigrationData migrationData = yaml.load(inputStream);
		return migrationData;


	}

	public static SauceSettings getSauceSettings(String strSauceSettingLocation) throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(SauceSettings.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + strSauceSettingLocation));
		SauceSettings sauceSettings = yaml.load(inputStream);
		return sauceSettings;


	}

	public static RedesignConfig getRedesignConfig() throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(RedesignConfig.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/redesignrogersNAC/RedesignRogersConfig.yml"));
		RedesignConfig redesignconfig = yaml.load(inputStream);
		return redesignconfig;


	}


	public static RedesignRpotgData getRedesignRpotgData() throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(RedesignRpotgData.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/redesignrogersNAC/RedesignRpotgTestData.yml"));
		RedesignRpotgData redesignRpotgData = yaml.load(inputStream);
		return redesignRpotgData;


	}

	public static RedesignRpotgData getRedesignNACData(String dataFileName) throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(RedesignRpotgData.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflows/" + dataFileName + ".yml"));
		RedesignRpotgData redesignRpotgData = yaml.load(inputStream);
		return redesignRpotgData;


	}

	public static RedesignRpotgOVData getRedesignOVNACData(String dataFileName) throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(RedesignRpotgOVData.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflowsoneview/" + dataFileName + ".yml"));
		RedesignRpotgOVData redesignRpotgOVData = yaml.load(inputStream);
		return redesignRpotgOVData;


	}

	public static OvrConfigData getOvrConfigData() throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(OvrConfigData.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/ovr/Config.yml"));
		OvrConfigData ovrConfigData = yaml.load(inputStream);
		return ovrConfigData;
	}

	public static OvrReusableData getOvrReusableData(String dataFileName) throws FileNotFoundException {
		Yaml yaml = new Yaml(new Constructor(OvrReusableData.class));
		InputStream inputStream;

		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/ovr/" + dataFileName + ".yml"));
		OvrReusableData ovrReusableData = yaml.load(inputStream);
		return ovrReusableData;
	}

	public static AddonData getAddonData(String dataFileName) throws FileNotFoundException{
		Yaml yaml = new Yaml(new Constructor(AddonData.class));
		InputStream inputStream;
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflows/" + dataFileName + ".yml"));
			AddonData addonData = yaml.load(inputStream);
			return addonData;
	}
}







