package com.library.web.thread;

import com.library.util.EmailUtils;

/**
 * ȡ������
 * 
 * @author Cheng
 * 
 */

public class GetBookRemindThread implements Runnable {
	private int bid;

	public void run() {
		EmailUtils.getBookEmailRemind(bid);
	}

	public GetBookRemindThread(int bid) {
		super();
		this.bid = bid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

}
