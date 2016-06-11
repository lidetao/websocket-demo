package com.lidetao.websocket.client;

import java.net.URI;

import com.lidetao.websocket.client.WebsocketClient.StringMessageHandler;

public class WebsocketClientTest {

	public void setTest(String test) {
		testClient();
	}

	public static void main(String[] args) {
		new WebsocketClientTest().testClient();
	}

	public void testClient() {

		URI uri = URI.create("ws://localhost:8082/websocket-server/wsApi/test");

		try {
			WebsocketClient client = new WebsocketClient(uri,
					new StringMessageHandler() {

						@Override
						public boolean handleWithClosed(String message) {
							System.out.println(message);
							return true;
						}
					});

			if (client != null) {
				client.sendMessage("hello,first websocket");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
