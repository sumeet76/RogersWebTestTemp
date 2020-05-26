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
		selfserve
		  } ;
    
    public enum SauceCapabilities{
    	seleniumVersion,
    	maxDuration,
    	commandTimeout,
    	idleTimeout,
    	build,
    	browserVersion,
    	platformVersion	       
    };
}
