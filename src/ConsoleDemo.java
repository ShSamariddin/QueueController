import java.util.ArrayList;
import java.util.zip.ZipOutputStream;

public class ConsoleDemo {
    private final IOHelper ioHelper;
    private String availableCommands;
    private ManyQueue<Client> manyQueue;

    public ConsoleDemo(final IOHelper ioHelper) {
        this.ioHelper = ioHelper;
        manyQueue = new ManyQueue<Client>(ioHelper);
        availableCommands =
                "You can use full commands or short forms of a commands \n\n"+
                "command            short form of commands    arguments\n\n" +
                "add_new_queue              anq                 [queue name]\n" +
                "remove_queue               rq                  [queue name]\n" +
                "remove_all_queue           raq             \n" +
                "add_client                 ac                  [queue name] [client name] [client phone number]\n" +
                "number_of_queues           noq             \n" +
                "queue_size                 qs                  [queue name]\n" +
                "remove_client              rc                  [queue name] [client name] [client phone number]\n" +
                "find_position_in_queue     fpiq                [queue name] [client name] [client phone number]\n" +
                "clear_the_queue            ctq                 [queue name]\n" +
                "list_of_queues             loq              \n" +
                "show_queue                 sq                  [queue name]\n" +
                "help                                        \n" +
                "exit                                        \n";
    }

    public boolean checkQueue(final String name) {
        if (!manyQueue.containQueue(name)) {
            ioHelper.printMessage("Error: there is no queue by name " + name);
            String ans = ioHelper.getField("Do you  want to create such a queue?(yes or no): ");
            ans.toLowerCase();
            if (ans.equals("yes")) {
                manyQueue.addQueue(name);
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    private String endsOfNumber(int x){
        if(x % 100 >= 11 && x % 100 <= 13)
            return "th";
        if(x % 10 == 1)
            return "st";
        if(x % 10 == 2)
            return "nd";
        if(x % 10 == 3)
            return "rd";
        return "th";

    }

    public boolean runConsoleDemo() {
        try {
            ioHelper.printMessage("List of available commands:\n");
            ioHelper.printMessage(availableCommands);
            String queueName;
            Client curClient;
            while (true) {


                String command = ioHelper.getField("Command:");
                switch (command) {
                    case "add_new_queue": case "anq":
                        manyQueue.addQueue(
                                ioHelper.getField("queue name:")
                        );
                        break;
                    case "remove_queue": case "rq":
                        manyQueue.removeQueue(
                                ioHelper.getField("queue name:")
                        );
                        break;
                    case "remove_all_queues" : case "raq":
                        manyQueue.removeAllQueues();
                        break;
                    case "add_client": case "ac":
                        queueName = ioHelper.getField("queue name:");
                        if (checkQueue(queueName)) {
                            manyQueue.getQueue(
                                    queueName
                            ).add(
                                    ioHelper.getClient()
                            );
                        }
                        break;
                    case "number_of_queues": case "noq":
                        ioHelper.printMessage("number of queues: " + manyQueue.size());
                        break;
                    case "queue_size": case "qs":
                        queueName = ioHelper.getField("queue name:");
                        if (checkQueue(queueName)) {
                            ioHelper.printMessage(queueName + "'s queue size is: " +
                                    manyQueue.getQueue(
                                            queueName
                                    ).size()
                            );
                        }
                        break;
                    case "remove_client": case "rc":
                        queueName = ioHelper.getField("queue name: ");
                        if (checkQueue(queueName)) {
                            curClient = ioHelper.getClient();
                            if (manyQueue.getQueue(
                                    queueName
                            ).remove(curClient)) {
                                ioHelper.printMessage("successfully removed from the queue");
                            } else {
                                ioHelper.printMessage("Error: " + curClient.toString() + "isn't in queue");
                            }
                        }
                        break;
                    case "find_position_in_queue": case "fpiq":
                        queueName = ioHelper.getField("queue name:");
                        if (checkQueue(queueName)) {
                            curClient = ioHelper.getClient();
                            int placeNumber = manyQueue.getQueue(
                                    queueName
                            ).findPosition(curClient);
                            if (placeNumber != -1) {
                                placeNumber++;
                                ioHelper.printMessage("a client with the name \"" + curClient.getName()
                                        +  "\" and with a phone number \"" + curClient.getPhoneNumber()
                                        + "\" is on the " + placeNumber + endsOfNumber(placeNumber) + " place");
                            } else {
                                ioHelper.printMessage("Error: " + curClient.toString() + "isn't in queue by name " + queueName);
                            }
                        }
                        break;
                    case "clear_the_queue": case "ctq":
                        queueName = ioHelper.getField("queue name:");
                        if (checkQueue(queueName)) {
                            manyQueue.getQueue(queueName).clear();
                        }
                        break;
                    case "list_of_queues": case "loq":
                        ArrayList<String> listOfQueue = manyQueue.queuesNameList();
                        if (listOfQueue.size() == 0) {
                            ioHelper.printMessage("list of queues is empty");
                        } else {
                            ioHelper.printMessage("list of queue:");
                            for (String name : listOfQueue) {
                                ioHelper.printMessage(name + "");
                            }
                        }
                        break;
                    case "show_queue": case "sq":
                        queueName = ioHelper.getField("queue name:");
                        if (checkQueue(queueName)) {
                            manyQueue.getQueue(queueName).showQueue();
                        }
                        break;
                    case "help":
                        ioHelper.printMessage(availableCommands);
                        break;
                    case "exit":
                        ioHelper.printMessage("Bye");
                        return true;
                    default:
                        ioHelper.printMessage("Wrong command name.");
                        ioHelper.printMessage("Please try again");
                        ioHelper.printMessage("You can use command --help to see all available commands");

                }


            }
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}