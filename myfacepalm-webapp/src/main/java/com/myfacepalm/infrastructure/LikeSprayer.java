package com.myfacepalm.infrastructure;

import org.springframework.util.Assert;

import com.myfacepalm.domain.Like;

/**
 * This class publish given user action (like, dislike) in all available social networks 
 * 
 * @author Volodymyr_Krasnikov
 *
 */
public class LikeSprayer {
	
	/**
	 * Must NOT be synchronous !
	 * @param action
	 */
	public void publish(Like like){
		Assert.notNull(like);
	}
	
}
