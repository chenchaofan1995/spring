package ccf.autoConstructor;

import java.util.LinkedList;

public class T {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue(10);
        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(()->{
                Message message = new Message(id,"内容"+id);
                messageQueue.put(message);
            }).start();
        }

        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(()->{
                Message take = messageQueue.take();
                System.out.println(take);
            }).start();
        }


    }
}


class MessageQueue{
    private LinkedList<Message> messagesQueue = new LinkedList<>();
    private int captial;

    MessageQueue(int captial){
        this.captial = captial;
    }

    public Message take(){
        synchronized (this) {
            while (messagesQueue.isEmpty()){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = messagesQueue.removeFirst();
            this.notifyAll();
            return  message;
        }

    }

    public void put(Message message){
        synchronized (this){
            while (messagesQueue.size() == this.captial){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            messagesQueue.addLast(message);
            this.notifyAll();
        }

    }


}

class Message{
    private int id ;
    private String content;

    public Message(int id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}


