package com.myfacepalm.domain;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.util.Assert;

public class Host {
	
	private final URL oUrl;
	
	private Host(URL url)
	{
		oUrl = url;
	}
	
	public String getProtocol(){
		return oUrl.getProtocol();
	}
	
	public int getPort(){
		return oUrl.getPort();
	}
	
	public static Host valueOf(String rawUrl) throws MalformedURLException{
		Assert.notNull(rawUrl);
		return new Host(new URL(rawUrl));
	}
	
}
