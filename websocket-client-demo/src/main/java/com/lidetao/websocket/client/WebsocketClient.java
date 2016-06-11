package com.lidetao.websocket.client;

import java.io.IOException;
import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class WebsocketClient {

	private Session session;

	public WebsocketClient(URI uri, final StringMessageHandler handler)
			throws Exception {

		if (handler == null) {
			throw new Exception("MessageHandler is null.");
		}

		/**
		 * create connection
		 */
		WebSocketContainer container = ContainerProvider
				.getWebSocketContainer();
		this.session = container.connectToServer(WebsocketCore.class, uri);

		/**
		 * set handler
		 */
		this.session.addMessageHandler(new MessageHandler.Whole<String>() {

			@Override
			public void onMessage(String message) {
				if (handler.handleWithClosed(message)) {
					try {
						session.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		});

	}

	/**
	 * send string message
	 * 
	 * @param message
	 * @throws IOException
	 */
	public void sendMessage(String message) throws IOException {
		session.getBasicRemote().sendText(message);
	}

	public static interface StringMessageHandler {
		boolean handleWithClosed(String message);
	}

}
