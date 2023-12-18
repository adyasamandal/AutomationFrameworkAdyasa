package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

Properties pro;

	public ReadConfig() {
		File src= new File("./Configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}catch(Exception e) {
			System.out.println("Exception is" +e.getMessage());
		}
		
	}

public String getApplicationURL() 
{
	String url=pro.getProperty("baseURL");
	return url;
}
public String getmobile() 
{
	String mobile=pro.getProperty("mobile");
	return mobile;
}
public String getotp1() 
{
	String otp1=pro.getProperty("otp1");
	return otp1;
}

public String getotp2() 
{
	String otp2=pro.getProperty("otp2");
	return otp2;
}

public String getotp3() 
{
	String otp3=pro.getProperty("otp3");
	return otp3;
}

public String getotp4() 
{
	String otp4=pro.getProperty("otp4");
	return otp4;
}
public String getotp5() 
{
	String otp5=pro.getProperty("otp5");
	return otp5;
}

public String getotp6() 
{
	String otp6=pro.getProperty("otp6");
	return otp6;
}






public String getchromepath() 
{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
}
public String getgeckopath() {
	String geckopath=pro.getProperty("geckopath");
	return geckopath;

}

}