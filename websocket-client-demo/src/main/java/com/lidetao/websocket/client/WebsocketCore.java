package com.lidetao.websocket.client;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint
public class WebsocketCore {

	/**
	 * This method level annotation can be used to decorate a Java method that
	 * wishes to be called when a new web socket session is open.<br>
	 * 
	 * <code>OnOpen</code> API:
	 * http://docs.oracle.com/javaee/7/api/javax/websocket/OnOpen.html
	 * 
	 * @param session
	 * @param config
	 */
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		System.out.println("client:onOpen");
	}

	/**
	 * This method level annotation can be used to make a Java method receive
	 * incoming web socket messages. <br>
	 * 
	 * <code>nMessage</code> API:
	 * http://docs.oracle.com/javaee/7/api/javax/websocket/OnMessage.html
	 * 
	 * @param message
	 * @param session
	 * 
	 */
	/*
	 * @OnMessage public void onMessage(String message, Session session) {
	 * System.out.println("client:onMessage," + message); }
	 */

	/**
	 * This method level annotation can be used to decorate a Java method that
	 * wishes to be called in order to handle errors. <br>
	 * 
	 * <code>OnError</code> API:
	 * http://docs.oracle.com/javaee/7/api/javax/websocket/OnError.html
	 * 
	 * @param session
	 * @param e
	 * 
	 */
	@OnError
	public void onError(Session session, Throwable e) {
		System.out.println("client:onError");
		e.printStackTrace();
	}

	/**
	 * This method level annotation can be used to decorate a Java method that
	 * wishes to be called when a web socket session is closing.<br>
	 * 
	 * <code>OnClose</code> API:
	 * http://docs.oracle.com/javaee/7/api/javax/websocket/OnClose.html
	 * 
	 * @param session
	 * @param cr
	 * 
	 */
	@OnClose
	public void onClose(Session session, CloseReason cr) {
		System.out.println("client:onClose");
	}

}
