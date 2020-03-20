import java.util.ArrayList;
import java.util.List;

public class Queue {
    private  String  queueName;
    private final List<Client> myQueue = new ArrayList<>();

    public Queue(String queueName){
        this.queueName = queueName;
    }

    public void add(Client client){
        if(!myQueue.contains(client)) {
            myQueue.add(client);
        }
    }

    public void remove(Client client){
        myQueue.remove(client);
    }

    public int findPosition(Client client){
        return myQueue.indexOf(client);
    }

    public void  clear(){
        myQueue.clear();
    }

    public String getQueueName(){
        return queueName;
    }

    public int size()
    {
        return queueName.length();
    }

}
