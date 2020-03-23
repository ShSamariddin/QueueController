import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
    private  String  queueName;
    private  List<T> myQueue = new ArrayList<>();
    private  final IOHelper ioHelper;

    public Queue(String queueName, IOHelper ioHelper){
        this.ioHelper = ioHelper;
        this.queueName = queueName;
    }
    public boolean contains(T client){
        return myQueue.contains(client);
    }
    public void add(T client){
        if(!myQueue.contains(client)) {
            myQueue.add(client);
        }

    }

    public boolean remove(T client){
        if(myQueue.contains(client)){
            myQueue.remove(client);
            return true;
        } else{
            return false;
        }
    }

    public int findPosition(T client){
        return myQueue.indexOf(client);
    }

    public void  clear(){
        myQueue.clear();
    }
    public void showQueue(){
        if(myQueue.size() == 0){
            ioHelper.printMessage(queueName + "'s queue is empty");
        } else {
            ioHelper.printMessage(queueName + "'s queue");
            ioHelper.printMessage("{name: phone number}");
            for (T client : myQueue) {
                ioHelper.printMessage(client.toString());
            }
        }
    }
    public String getQueueName(){
        return queueName;
    }

    public int size()
    {
        return myQueue.size();
    }


}