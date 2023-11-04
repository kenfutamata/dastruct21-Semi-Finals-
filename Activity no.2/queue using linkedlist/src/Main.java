import java.util.*;
public class Main {

    static Scanner input = new Scanner(System.in);
    public  static Node front, rear;
    public static int s;
    public static class Node{
        int info;
        Node next;
    }

    public void main(){
        front = null;
        rear = null;
        s = 0;
    }

    public static boolean isempty(){
        return (s == 0);
    }

    public static void enqueue(int info){
        Node oldnode = rear;
        rear = new Node();
        rear.info = info;
        rear.next = null;
        if(isempty()){

            front = rear;
        }else{
            oldnode.next = rear;
        }
        s++;
        System.out.println(info+" is added to the queue");
    }

    public static void dequeue(){
        int info = front.info;
        front = front.next;
        if(isempty()){
            System.out.println("Queue is empty.");
            rear = null;
        }
        System.out.println("A number has been removed of the queue");
        s--;
    }

    public static void front(){
        if(isempty()){
            System.out.println("Queue is empty!");
        }else{
            System.out.println("Front is: "+front.info);
        }

    }

    public static void rear(){
        if(isempty()){
            System.out.println("Queue is empty!");
            
        }else {
            System.out.println("Rear is "+rear.info);
        }

    }

    public static void print(){
        if (isempty()) {
            System.out.println("Queue is empty.");
            return;
        }

        Node current = front;
        System.out.print("Queue: ");
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.next;
        }
        System.out.println();

    }

    public static void  menu(){
        while(true) {
            System.out.println("[1] - ENQUEUE");
            System.out.println("[2] - DEQUEUE");
            System.out.println("[3] - FRONT");
            System.out.println("[4] - REAR");
            System.out.println("[5] - PRINT");
            int choose = input.nextInt();
            choose(choose);
        }
    }

    public static Node choose(int choose){

            if (choose == 1) {
                System.out.println("Enter a number for the queue: ");
                int num = input.nextInt();
                enqueue(num);
            } else if (choose == 2) {
                dequeue();
            } else if (choose == 3) {
                front();
            } else if (choose == 4) {
                rear();
            } else if (choose == 5) {
                print();
            }
            return front;

    }

    public static void main(String[] args) {
        menu();
    }
}
