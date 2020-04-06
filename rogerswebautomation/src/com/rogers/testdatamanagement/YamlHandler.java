package com.rogers.testdatamanagement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import com.rogers.yaml.pojo.AccountData;
import com.rogers.yaml.pojo.Config;
import com.rogers.yaml.pojo.PaymentDetails;



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

}

