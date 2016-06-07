package com.lidetao.websocket.api;

import java.io.IOException;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * websocket server<br>
 * 
 * <code>ServerEndpoint</code> API:
 * http://docs.oracle.com/javaee/7/api/javax/websocket/server/
 * ServerEndpoint.html
 * 
 * @author Administrator
 *
 */
@ServerEndpoint(value = "/wsApi/{actCode}")
public class WebsocketAPI {

	/**
	 * This method level annotation can be used to decorate a Java method that
	 * wishes to be called when a new web socket session is open.<br>
	 * 
	 * <code>OnOpen</code> API:
	 * http://docs.oracle.com/javaee/7/api/javax/websocket/OnOpen.html
	 * 
	 * @param session
	 * @param config
	 * @param actCode
	 */
	@OnOpen
	public void onOpen(Session session, EndpointConfig config,
			@PathParam("actCode") String actCode) {
		System.out.println("actCode=" + actCode + ":onOpen");
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
	 * @param actCode
	 */
	@OnMessage
	public void onMessage(String message, Session session,
			@PathParam("actCode") String actCode) {
		System.out.println("actCode=" + actCode + ":onMessage," + message);

		/**
		 * reply message
		 */
		try {
			session.getBasicRemote().sendText("copy that!");
		} catch (IOException e) {
			System.out.println("actCode=" + actCode + ":reply error!");
			e.printStackTrace();
		}

	}

	/**
	 * This method level annotation can be used to decorate a Java method that
	 * wishes to be called in order to handle errors. <br>
	 * 
	 * <code>OnError</code> API:
	 * http://docs.oracle.com/javaee/7/api/javax/websocket/OnError.html
	 * 
	 * @param session
	 * @param e
	 * @param actCode
	 */
	@OnError
	public void onError(Session session, Throwable e,
			@PathParam("actCode") String actCode) {
		System.out.println("actCode=" + actCode + ":onError");
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
	 * @param actCode
	 */
	@OnClose
	public void onClose(Session session, CloseReason cr,
			@PathParam("actCode") String actCode) {
		System.out.println("actCode=" + actCode + ":onClose");
	}

}
