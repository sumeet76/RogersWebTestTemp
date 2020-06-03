package com.rogers.test.helpers;

public class RogersEnums {

	public enum OS {
        WIN, LIN, MAC
    };//
	
    public enum MakePayOptions {
	    Bank,
	    Creditcard,
	    Interac
	  };
	  
	public enum GroupName {
		connectedhome_legacyanonymous,
		connectedhome_igniteanonymous,
		connectedhome_legacylogin,
		connectedhome_ignitelogin,
		connectedhome_login,
		selfserve_login,
		selfserve,
		mobile_selfserve,
		buyflows
		  } ;
    
    public enum SauceCapabilities{
    	seleniumVersion,
    	maxDuration,
    	commandTimeout,
    	idleTimeout,
    	build,
    	browserVersion,
    	platformName,
    	platformVersion,
    	appiumVersion,
    	deviceName,
    	deviceOrientation
    };
}
