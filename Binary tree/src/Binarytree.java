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
        if (root == null) {
            root = new Node(data);
        } else {
            root.left = insertleftelement(root.left, data);
        }
    }
    public Node insertleftelement(Node node, int data){
        if(node == null){
            return new Node(data);
        }
        node.left=insertleftelement(node.left,data);
        return node;
    }
    public void insertright(int data){
        if (root == null) {
            root = new Node(data);
        } else {
            root.right = insertrightelement(root.right, data);
        }
    }

    public Node insertrightelement(Node node, int data){
        if (node == null) {
            return new Node(data);
        }

        node.right = insertrightelement(node.right, data);
        return node;
    }

    private void inOrdertraversal(Node root){

        if(root !=null){
            inOrdertraversal(root.left);
            System.out.print(root.data+" ");
            inOrdertraversal(root.right);
        }
    }

    private void preOrdertraversal(Node root){

        if (root!=null){
            System.out.print(root.data+" ");
            inOrdertraversal(root.left);
            inOrdertraversal(root.right);
        }
    }

    public void postOrdertraversal(Node root){
        if (root!=null){
            inOrdertraversal(root.left);
            inOrdertraversal(root.right);
            System.out.print(root.data+" ");
        }
    }

    public void finalrootdisplay(){
        try {
            System.out.println("Roots of the display: ");
            rootdisplay(root);
        }
        catch (Exception e){
            System.out.println(e+" Invalid");
        }
    }

    public void rootdisplay(Node node){

        if (node == null) {
            return;
        }

        // Check if the current node is a root (no parent or no siblings)
        if ((node.left == null && node.right == null) || (node.left == null || node.right == null)) {
            System.out.println(node.data);
        }
        rootdisplay(node.left);
        rootdisplay(node.right);
    }


    public void root(){
        //enters the root first before inputting the rest of the root below
        System.out.println("Enter the value for the root: ");
        int rootvalue = input.nextInt();
        setRoot(rootvalue);
        menu();
    }

    public void displayleaves(){
        System.out.println("Leaves of the binary tree: ");
        leaves(root);
    }

    public void leaves(Node node){
        if (node == null) {
            return;
        }

        // Check if the current node is a leaf
        if (node.left == null && node.right == null) {
            System.out.print(node.data+" ");
            System.out.println();
        }

        // Recursively check the left and right subtrees
        leaves(node.left);
        leaves(node.right);

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
           finalrootdisplay();
        }
        else if(choose == 4){
            displayleaves();
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
