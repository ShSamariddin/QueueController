import Queue.IOHelper;
import Queue.ManyQueue;
import com.sun.net.httpserver.HttpServer;
import web.ManyQueueModifier;
import web.QueueModifier;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.util.Scanner;


class WebMain {
    private static HttpServer server;
    public static void main(String[] args) throws IOException {


        ManyQueue manyQueue = new ManyQueue(new IOHelper(new Scanner(System.in), new PrintWriter(System.out)));

        int serverPort = 8000;
        server = HttpServer.create(new InetSocketAddress(serverPort), 0);
        new ManyQueueModifier(server, manyQueue);
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    public HttpServer getServer() {
        return server;
    }
}