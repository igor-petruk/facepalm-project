package com.myfacepalm.domain;

import org.springframework.util.DigestUtils;

public final class Resource {

	public enum Type
	{
		IMAGE,TEXT
	}

	final Type type;
	final String rawData;

	String artificaialHexId;

	public Resource(Type type, String rawData)
	{
		this.type = type;
		this.rawData = rawData;
	}

	/**
	 * Do some resource type specific preprocessing here e.g. add protocol name to url in format //image.bla.bla.bla
	 * or remove useless whitespaces from the text 
	 * @return
	 */
	public String get()
	{
		return rawData;
	}

	/**
	 * Use it as a reference on the our site. From outside the resource url on our site will look like
	 * www.myfacepalm.com/GeNerAteDHexCoDE
	 * @return
	 */
	public String getId()
	{
		if (artificaialHexId == null) {
			artificaialHexId = generateId(rawData);
		}
		return artificaialHexId;
	}

	private String generateId(String str)
	{
		return DigestUtils.md5DigestAsHex(str.getBytes());
	}

}
