package com.conley.behaviorType.chainOfResponsibility;

/**
 * 审批处理抽象类
 * @author zhukangli
 *
 */
public abstract class Handler {
	protected Handler handler;
	public abstract boolean approve(double day);

	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
