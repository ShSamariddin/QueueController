import java.util.ArrayList;
import java.util.HashMap;

public class ManyQueue<T> {
    private final IOHelper ioHelper;
    private  HashMap<String, Queue<T>> queueList = new HashMap<>();

    public ManyQueue(IOHelper ioHelper) {
        this.ioHelper = ioHelper;
    }

    public boolean addQueue(String name) {
        if (!queueList.containsKey(name)) {
            queueList.put(name, new Queue<T>(name, ioHelper));
            ioHelper.printMessage("queue added successfully");
            return true;
        } else {
            ioHelper.printMessage("Error: added  existing queue");
            return false;
        }
    }

    public boolean containQueue(String name){
        return queueList.containsKey(name);
    }

    public Queue<T> getQueue(String name){

        return queueList.get(name);
    }

    public boolean removeQueue(String name){
        if(!queueList.containsKey(name)){
            ioHelper.printMessage("queue " + name + " doesn't exist");
            return false;
        } else{
            queueList.remove(name);
            return true;
        }
    }

    public void removeAllQueues(){
        queueList.clear();
    }

    public ArrayList<String> queuesNameList(){
        return new ArrayList<>(queueList.keySet());
    }

    public int size(){
        return queueList.size();
    }



}
