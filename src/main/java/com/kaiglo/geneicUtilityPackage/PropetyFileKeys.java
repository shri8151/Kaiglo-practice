package com.kaiglo.geneicUtilityPackage;
/*
 * This enum consists of all the keys of property file.
 */
public enum PropetyFileKeys {
	BROWSER("browser"),URL("url"),USERNAME("username"),PASSWORD("password"),TIMEOUT("timeout");
	private String keys;
	
//setter
	private PropetyFileKeys(String keys) {
		this.keys=keys;
	}
	
	//getter
	public String convertToString() {
		return keys.toString();
		
	}
}
