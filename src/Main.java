import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in);
            PrintWriter printWriter = new PrintWriter(System.out)) {
            IOHelper ioHelper = new IOHelper(scanner, printWriter);
            ConsoleDemo consoleQueue = new ConsoleDemo(ioHelper);
            consoleQueue.runConsoleDemo();
        }
    }
}
