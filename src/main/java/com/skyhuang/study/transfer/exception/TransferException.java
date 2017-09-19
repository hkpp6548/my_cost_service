package com.skyhuang.study.transfer.exception;

/**
 * Created by dahoufang the one on 2017/9/19.
 */
public class TransferException extends Exception{
	public TransferException() {
		super();
	}

	public TransferException(String message) {
		super(message);
	}

	public TransferException(String message, Throwable cause) {
		super(message, cause);
	}

	public TransferException(Throwable cause) {
		super(cause);
	}
}
