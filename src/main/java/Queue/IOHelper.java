package Queue;

import java.io.PrintWriter;
import java.util.Scanner;

public class IOHelper {
    private final Scanner scanner;
    private final PrintWriter writer;

    public IOHelper(Scanner scanner, PrintWriter writer){
        this.scanner = scanner;
        this.writer = writer;
    }

    public String getField(String field){
        writer.print(field + " ");
        writer.flush();
        return  scanner.next();
    }

    public void printMessage(String message){
        writer.print("      " +  message + "\n");
        writer.flush();
    }

    public void printMessage(Integer message){
       printMessage(message + "");
    }

    public Client getClient(){
        final String clientName = getField("client name:");
        final String clientPhone = getField("client phone number :");
        return new Client(clientName, clientPhone);
    }
}