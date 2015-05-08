package mws;

import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.WebSocket.ConnectCallback;
import com.koushikdutta.async.http.spdy.SpdyMiddleware;
import com.koushikdutta.async.http.AsyncSSLEngineConfigurator;
import com.koushikdutta.async.http.*;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLEngine;

public class AndroidWebSocket {
    static {
        SpdyMiddleware middleware = AsyncHttpClient.getDefaultInstance().getSSLSocketMiddleware();
        middleware.addEngineConfigurator(new AsyncSSLEngineConfigurator() {
            @Override
            public void configureEngine(SSLEngine engine, AsyncHttpClientMiddleware.GetSocketData data, String host, int port) {
                String[] suites = engine.getEnabledCipherSuites();
                List<String> filtered = new ArrayList<String>();
                for(String suite : suites) {
                    if(suite.toLowerCase().indexOf("rc4") != -1)
                        continue;
                    filtered.add(suite);
                }
                engine.setEnabledCipherSuites(filtered.toArray(new String[filtered.size()]));
            }
        });
    }
    public static java.util.concurrent.Future<WebSocket> connect(String uri, String protocol,
            WebSocket.ConnectCallback callback) {
        return AsyncHttpClient.getDefaultInstance().websocket(uri, protocol, callback);
    }
}
