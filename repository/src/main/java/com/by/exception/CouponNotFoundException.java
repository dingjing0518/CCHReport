package com.by.exception;

/**
 * Created by yagamai on 15-12-8.
 */
public class CouponNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CouponNotFoundException() {
		super("coupon not found");
	}
}
