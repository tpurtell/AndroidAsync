package mws;

import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.WebSocket.WebSocketConnectCallback;

public class AndroidWebSocket {
    public static java.util.concurrent.Future<WebSocket> connect(String uri, String protocol,
            WebSocket.WebSocketConnectCallback callback) {
        return AsyncHttpClient.getDefaultInstance().websocket(uri, protocol, callback);
    }
}
