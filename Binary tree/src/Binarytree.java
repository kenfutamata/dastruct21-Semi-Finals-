import java.util.*;
public class Binarytree {
    static Scanner input = new Scanner(System.in);
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;

    public void setRoot(int rootvalue){
        root = new Node(rootvalue);
    }


    public void inOrderTraversal(){
    inOrdertraversal(root);
    }

    public void preOrderTraversal(){
    postOrdertraversal(root);
    }

    public void postOrderTraversal(){
    postOrdertraversal(root);
    }

    public void insertleft(int data){
        root.left = new Node(data);
    }
    public void insertright(int data){
        root.right = new Node(data);
    }

    private void inOrdertraversal(Node node){
        if(node !=null){
            inOrdertraversal(node.left);
            System.out.print(node.data+" ");
            inOrdertraversal(node.right);
        }
    }

    private void preOrdertraversal(Node node){
        if (node!=null){
            System.out.print(node.data+" ");
            inOrdertraversal(node.left);
            inOrdertraversal(node.right);
        }
    }

    public void postOrdertraversal(Node node){
        if (node!=null){
            inOrdertraversal(node.left);
            inOrdertraversal(node.right);
            System.out.print(node.data+" ");
        }
    }

    public void rootdisplay(){
        System.out.println("Root is "+root);
    }
    public void root(){
        //enters the root first before inputting the rest of the root below
        System.out.println("Enter the value for the root: ");
        int rootvalue = input.nextInt();
        setRoot(rootvalue);
        menu();
    }
    public void menu(){
        try {
            while (true) {
                System.out.println("[1] - INSERT");
                System.out.println("[2] - DISPLAY");
                System.out.println("[3] - ROOT");
                System.out.println("[4] - LEAF");
                System.out.println("[5] - EXIT");
                System.out.println("Enter a program: ");
                int choose = input.nextInt();
                choose(choose);
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid input!");
        }
    }

    public Node choose(int choose){

        if (choose == 1){
            //inputs the below part of the root
            System.out.println("Enter value: ");
            int data = input.nextInt();
            //program promts the user to choose if the user wants to bring the value to the left or to the right
            System.out.println("Enter L if the you want to go left or R if you want to go right: ");
            String direction = input.next();
            if(direction.equals("L")){
                insertleft(data);
            }
            else if (direction.equals("R")) {
                insertright(data);
            }
        }
        else if(choose == 2){
            //displays the 3 traversals
            System.out.println("In-order traversal: ");
            inOrderTraversal();
            System.out.println();
            //pre-order traversal
            System.out.println("Pre-order traversal: ");
            preOrderTraversal();
            System.out.println();
            //post order traversal
            System.out.println("Post-order traversal: ");
            postOrderTraversal();
            System.out.println();
        }
        else if (choose == 3){
           rootdisplay();
        }
        else if(choose == 4){

        }
        else if (choose == 5) {
            System.exit(0);
        }
        else {
            System.out.println("Invalid input");
        }
        return root;
    }
    public static void main(String[] args) {
    Binarytree BT = new Binarytree();
    BT.root();
    }
}
