import java.util.*;
public class cap {

   static Scanner input = new Scanner(System.in);
   int size;
   int arr[];
   int choose;
   static int queue = -1;
   static int front = 0;
   static int rear = -1;
   static int capacity;


    public cap(int size){

        front = rear = 0;
        capacity  = size;
        arr = new int[capacity];


    }

    public void menu() {
        while (true) {
            System.out.println("--------Menu--------");
            System.out.println("[1] - Enqueue");
            System.out.println("[2] - Dequeue");
            System.out.println("[3] - Front");
            System.out.println("[4] - Rear");
            System.out.println("[5] - Print");
            System.out.println("-------------------");
            System.out.println();
            System.out.print("Enter choice: ");
            int choose = input.nextInt();
            choose(choose);
        }

    }

    public void choose(int choose){
        Scanner input = new Scanner(System.in);
        if(choose ==1){
            elementenqueue();
        }else if(choose == 2){
            dequeue();
        }else if(choose == 3) {
            System.out.println("Element rear is "+front());
        }

        else if(choose ==4){
            System.out.println("Element rear is "+rear());
        }
        else if(choose == 5){
            print();
        }
    }

    public void enqueue(int info){
        queue++;
        arr[queue] = info;
        System.out.println("Element contents: "+info);


    }

    public void elementenqueue(){

        if(queue == arr.length-1){
            System.out.println("queue is full!");
        }else {
            try{
                System.out.println("Enter an element: ");
                int element  = input.nextInt();
                enqueue(element);
            }catch (InputMismatchException e){
                System.out.println("Invalid input!");
                input.nextInt();
            }
        }
    }

    public void dequeue() {
        if (queue == -1) {
            System.out.println("Queue is empty!");
        } else {
            arr[queue--] = 0;

        }
    }

    public int  front(){
        if(queue < 0 ){
            System.out.println("Queue is empty!");
            return -1;
        }
        return arr[0];
    }

    public int rear(){
      if(queue < 0){
          System.out.println("Queue is empty!");
          return -1;
      }
      int rear = arr[queue];
      return rear;
    }
    public void print(){
        System.out.println();
        for(int i = 0; i <=queue; i++){
            System.out.print(arr[i]+" ");

        }
        System.out.println();
    }



}

