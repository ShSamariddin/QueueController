package web;

import Queue.ManyQueue;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.util.Map;

public class ManyQueueModifier {
    HttpServer server;
    private final ManyQueue manyQueue;
    public ManyQueueModifier(HttpServer server, ManyQueue manyQueue){
        this.manyQueue = manyQueue;
        this.server = server;
        server.createContext("/api/addNewQueue" , (exchange ->{
            String par = exchange.getRequestURI().getRawQuery();
            
        }));
    }
}
