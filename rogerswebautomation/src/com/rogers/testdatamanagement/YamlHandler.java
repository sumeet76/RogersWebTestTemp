package com.rogers.testdatamanagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import com.rogers.yaml.pojo.AALData;
import com.rogers.yaml.pojo.AccountData;
import com.rogers.yaml.pojo.Config;
import com.rogers.yaml.pojo.HUPData;
import com.rogers.yaml.pojo.NACData;
import com.rogers.yaml.pojo.PPCData;
import com.rogers.yaml.pojo.PaymentDetails;
import com.rogers.yaml.pojo.SauceConfig;



public class YamlHandler {

	public static AccountData getAccountData(String accountName) {
		Yaml yaml = new Yaml(new Constructor(AccountData.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(
					new File(System.getProperty("user.dir") + "/data/selfserve/" + accountName + ".yml"));
			AccountData account = yaml.load(inputStream);
			return account;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}
	}

	public static Config getConfig() {
		Yaml yaml = new Yaml(new Constructor(Config.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/selfserve/Config.yml"));
			Config config = yaml.load(inputStream);
			return config;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}
	
	public static SauceConfig getSauceConfig() {
		Yaml yaml = new Yaml(new Constructor(Config.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/selfserve/SauceConfig.yml"));
			SauceConfig sauceconfig = yaml.load(inputStream);
			return sauceconfig;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}
	}
	
	public static PaymentDetails getPaymentDetails() {
		Yaml yaml = new Yaml(new Constructor(PaymentDetails.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/selfserve/PaymentInfo.yml"));
			PaymentDetails paymentDetails = yaml.load(inputStream);
			return paymentDetails;
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
					new File(System.getProperty("user.dir") + "/data/connectedhome/" + accountName + ".yml"));
			AccountData account = yaml.load(inputStream);
			return account;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}
	}

	public static Config getCableConfig() {
		Yaml yaml = new Yaml(new Constructor(Config.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/connectedhome/RogersConfig.yml"));
			Config config = yaml.load(inputStream);
			return config;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}
	
	
	public static PaymentDetails getCablePaymentDetails() {
		Yaml yaml = new Yaml(new Constructor(PaymentDetails.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/connectedhome/RogersPaymentInfo.yml"));
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
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/buyflows/" + dataFileName + ".yml"));
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
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/buyflows/" + dataFileName + ".yml"));
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
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/buyflows/" + dataFileName + ".yml"));
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
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/buyflows/" + dataFileName + ".yml"));
			PPCData ppcData = yaml.load(inputStream);
			return ppcData;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Config getBFAConfig() {
		Yaml yaml = new Yaml(new Constructor(Config.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/buyflows/Config.yml"));
			Config config = yaml.load(inputStream);
			return config;
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}

	public static PaymentDetails getBFAPaymentDetails() {
		Yaml yaml = new Yaml(new Constructor(PaymentDetails.class));
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/data/buyflows/PaymentInfo.yml"));
			PaymentDetails paymentDetails = yaml.load(inputStream);
			return paymentDetails;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
