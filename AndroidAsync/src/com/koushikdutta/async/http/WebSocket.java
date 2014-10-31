package com.koushikdutta.async.http;

import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.callback.CompletedCallback;


public interface WebSocket extends AsyncSocket {
    static public interface StringCallback {
        public void onStringAvailable(String s);
    }
    static public interface PongCallback {
        public void onPongReceived(String s);
    }
    static public interface RawDataCallback {
        public void onRawDataAvailable(byte[] data);
    }

    public static interface ConnectCallback {
        public void onCompleted(Exception ex, WebSocket webSocket);
    }
    public static interface DisconnectCallback {
        public void onCompleted(Exception ex, int code, String reason);
    }

    public void send(byte[] bytes);
    public void send(String string);
    public void send(byte [] bytes, int offset, int len);
    public void ping(String message);
    
    public void setStringCallback(StringCallback callback);
    public StringCallback getStringCallback();

    public void setPongCallback(PongCallback callback);
    public PongCallback getPongCallback();
    
    public void setRawDataCallback(RawDataCallback callback);
    public RawDataCallback getRawDataCallback();
    
    public void setDisconnectCallback(DisconnectCallback handler);
    public DisconnectCallback getDisconnectCallback();

    public boolean isBuffering();
    
    public AsyncSocket getSocket();
    
    public void close(int code, String reason);
}
