package com.rogers.testdatamanagement;

import com.rogers.yaml.pojo.*;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.rogers.yaml.pojo.AALData;
import com.rogers.yaml.pojo.AccountData;
import com.rogers.yaml.pojo.CHOneViewConfig;
import com.rogers.yaml.pojo.Config;
import com.rogers.yaml.pojo.ContactData;
import com.rogers.yaml.pojo.HUPData;
import com.rogers.yaml.pojo.MigrationData;
import com.rogers.yaml.pojo.NACData;
import com.rogers.yaml.pojo.PPCData;
import com.rogers.yaml.pojo.PaymentDetails;
import com.rogers.yaml.pojo.RedesignConfig;
import com.rogers.yaml.pojo.RedesignRpotgData;
import com.rogers.yaml.pojo.SauceSettings;

public class YamlHandler {

	public static AccountData getSSAccountData(String accountName) {
		Yaml yaml = new Yaml(new Constructor(AccountData.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(
					new File(System.getProperty("user.dir") + "/test-data/rogers/selfserve/" + accountName + ".yml"));
			AccountData account = yaml.load(inputStream);
			return account;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}
	}

	public static AccountData getCableAccountData(String accountName) {
		Yaml yaml = new Yaml(new Constructor(AccountData.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(
					new File(System.getProperty("user.dir") + "/test-data/rogers/connectedhome/" + accountName + ".yml"));
			AccountData account = yaml.load(inputStream);
			return account;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}
	}

	public static AccountData getOVAccountData(String accountName) {
		Yaml yaml = new Yaml(new Constructor(AccountData.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(
					new File(System.getProperty("user.dir") + "/test-data/rogers/choneview/" + accountName + ".yml"));
			AccountData account = yaml.load(inputStream);
			return account;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}
	}
	
	public static Config getSSConfig() {
		Yaml yaml = new Yaml(new Constructor(Config.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/selfserve/Config.yml"));
			Config config = yaml.load(inputStream);
			return config;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}
	
	public static Config getCableConfig() {
		Yaml yaml = new Yaml(new Constructor(Config.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/connectedhome/Config.yml"));
			Config config = yaml.load(inputStream);
			return config;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}
	
	public static Config getBFAConfig() {
		Yaml yaml = new Yaml(new Constructor(Config.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflows/Config.yml"));
			Config config = yaml.load(inputStream);
			return config;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}
	
	public static Config getBFAOneViewConfig() {
		Yaml yaml = new Yaml(new Constructor(Config.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflowsoneview/Config.yml"));
			Config config = yaml.load(inputStream);
			return config;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}
	
	public static CHOneViewConfig getCHOneViewConfig() {
		Yaml yaml = new Yaml(new Constructor(CHOneViewConfig.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/choneview/CHOneViewConfig.yml"));
			CHOneViewConfig config = yaml.load(inputStream);
			return config;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}
	
	public static PaymentDetails getSSPaymentDetails() {
		Yaml yaml = new Yaml(new Constructor(PaymentDetails.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/selfserve/PaymentInfo.yml"));
			PaymentDetails paymentDetails = yaml.load(inputStream);
			return paymentDetails;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}

	public static PaymentDetails getCablePaymentDetails() {
		Yaml yaml = new Yaml(new Constructor(PaymentDetails.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/connectedhome/PaymentInfo.yml"));
			PaymentDetails paymentDetails = yaml.load(inputStream);
			return paymentDetails;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}
	
	public static PaymentDetails getBFAPaymentDetails() {
		Yaml yaml = new Yaml(new Constructor(PaymentDetails.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflows/RogersPaymentInfo.yml"));
			PaymentDetails paymentDetails = yaml.load(inputStream);
			return paymentDetails;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static PaymentDetails getBFAOneViewPaymentDetails() {
		Yaml yaml = new Yaml(new Constructor(PaymentDetails.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflowsoneview/RogersPaymentInfo.yml"));
			PaymentDetails paymentDetails = yaml.load(inputStream);
			return paymentDetails;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	public static PaymentDetails getOVPaymentDetails() {
		Yaml yaml = new Yaml(new Constructor(PaymentDetails.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/choneview/OVPaymentInfo.yml"));
			PaymentDetails paymentDetails = yaml.load(inputStream);
			return paymentDetails;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}
	public static NACData getNACData(String dataFileName) {
		Yaml yaml = new Yaml(new Constructor(NACData.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflows/" + dataFileName + ".yml"));
			NACData nacData = yaml.load(inputStream);
			return nacData;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static AALData getAALdata(String dataFileName) {
		Yaml yaml = new Yaml(new Constructor(AALData.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflows/" + dataFileName + ".yml"));
			AALData aalData = yaml.load(inputStream);
			return aalData;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static HUPData getHUPdata(String dataFileName) {
		Yaml yaml = new Yaml(new Constructor(HUPData.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflows/" + dataFileName + ".yml"));
			HUPData hupData = yaml.load(inputStream);
			return hupData;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static HUPData getHUPdataOneView(String dataFileName) {
		Yaml yaml = new Yaml(new Constructor(HUPData.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflowsoneview/" + dataFileName + ".yml"));
			HUPData hupData = yaml.load(inputStream);
			return hupData;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static PPCData getPPCdata(String dataFileName) {
		Yaml yaml = new Yaml(new Constructor(PPCData.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflows/" + dataFileName + ".yml"));
			PPCData ppcData = yaml.load(inputStream);
			return ppcData;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static PPCData getPPCdataOneView(String dataFileName) {
		Yaml yaml = new Yaml(new Constructor(PPCData.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/buyflowsoneview/" + dataFileName + ".yml"));
			PPCData ppcData = yaml.load(inputStream);
			return ppcData;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ContactData getContactData(String accountName) {
		Yaml yaml = new Yaml(new Constructor(ContactData.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/choneview/" + accountName + ".yml"));
			ContactData contactDetails = yaml.load(inputStream);
			return contactDetails;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}
	public static MigrationData getMigrationData(String accountName) {
		Yaml yaml = new Yaml(new Constructor(MigrationData.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/test-data/rogers/choneview/" + accountName + ".yml"));
			MigrationData migrationData = yaml.load(inputStream);
			return migrationData;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}
	
	public static SauceSettings getSauceSettings(String strSauceSettingLocation) {
		Yaml yaml = new Yaml(new Constructor(SauceSettings.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + strSauceSettingLocation));
			SauceSettings sauceSettings = yaml.load(inputStream);
			return sauceSettings;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}

	public static RedesignConfig getRedesignConfig() {
		Yaml yaml = new Yaml(new Constructor(RedesignConfig.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/redesignrogersNAC/RedesignRogersConfig.yml"));
			RedesignConfig redesignconfig = yaml.load(inputStream);
			return redesignconfig;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}


	public static RedesignRpotgData getRedesignRpotgData() {
		Yaml yaml = new Yaml(new Constructor(RedesignRpotgData.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/redesignrogersNAC/RedesignRpotgTestData.yml"));
			RedesignRpotgData redesignRpotgData = yaml.load(inputStream);
			return redesignRpotgData;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}
	
}
