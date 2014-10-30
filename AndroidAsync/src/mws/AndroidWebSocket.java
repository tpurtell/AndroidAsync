package mws;

import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpClient.WebSocketConnectCallback;
import com.koushikdutta.async.http.WebSocket;

public class AndroidWebSocket {
    public static java.util.concurrent.Future<WebSocket> connect(String uri, String protocol,
            WebSocketConnectCallback callback) {
        return AsyncHttpClient.getDefaultInstance().websocket(uri, protocol, callback);
    }
}
