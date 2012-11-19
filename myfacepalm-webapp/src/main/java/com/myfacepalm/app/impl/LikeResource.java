package com.myfacepalm.app.impl;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.myfacepalm.app.Endpoint;
import com.myfacepalm.domain.LikeService;

/**
 * Application's entry point, all needed stuff is injected by IoC
 * 
 * @author Volodymyr_Krasnikov
 *
 */
public class LikeResource implements Endpoint {

	@Autowired(required = true)
	LikeService service;
	
	@Override
	public Response like(String pictureUrl, String owningHost)
	{
		// validate input params with help of framework
		return null;
	}

	@Override
	public Response count(String pictureUrl)
	{
		// validate input params with help of framework
		return null;
	}

}
