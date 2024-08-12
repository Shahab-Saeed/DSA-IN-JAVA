

import java.util.Scanner;

public class A1_Documentation {
    static Scanner sc=new Scanner(System.in);


     static Node createTree(){
        int data=0;
        System.out.println("Enter data: ");
        data=sc.nextInt();
        Node root=new Node(data);

        if (data==-1){
            return null;
        }

         System.out.println("Enter left for "+data);
         root.left=createTree();

         System.out.println("Enter right for "+data);
         root.right=createTree();


        return root;

    }

    static void preOrderTraversal(Node root){
        if (root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void inOrderTraversal(Node root){
        if (root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }

    static void postOrderTraversal(Node root){
        if (root==null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }

    static int countOfNode(Node root){
         if (root==null){
             return 0;
         }
         int left=countOfNode(root.left);
         int right=countOfNode(root.right);
         return left+ right +1;
    }
    public static void main(String[] args) {
        Node root=createTree();

        System.out.println("Inorder Traversal");
        inOrderTraversal(root);

        System.out.println("PostOrder Traversal");
        postOrderTraversal(root);

        System.out.println("Preorder Traversal");
        preOrderTraversal(root);


    }
}
class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
    }
}