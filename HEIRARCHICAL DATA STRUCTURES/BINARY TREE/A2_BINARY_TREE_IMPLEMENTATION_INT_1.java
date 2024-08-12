

import java.util.*;

public class A2_BINARY_TREE_IMPLEMENTATION_INT_1 {
    //creating the node class
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }

    //creating the binary class
    static class BinaryTree{
        int index=-1;
        //creating a  method to create a binary tree
         Node createBinaryTree(int [] array){
             index++;
            if (array[index]==-1){
                return null;
            }

                Node nn=new Node(array[index]);
                nn.left=createBinaryTree(array);
                nn.right=createBinaryTree(array);
                return nn;


        }

        //creating a  method to do PreOrder traversal
        void preOrder(Node root){
             if (root==null){
                 return ;
             }

                 System.out.print(root.data+" ");
                 preOrder(root.left);
                 preOrder(root.right);

        }

        //creating a  method to do InOrder traversal
        void InOrder(Node root){
             if (root==null){
                 return;
             }
             else{
                 InOrder(root.left);
                 System.out.print(root.data+" ");
                 InOrder(root.right);
             }
        }

        //creating a  method to do postOrder traversal
        void PostOrder(Node root){
             if (root==null){
                 return;
             }
             else{
                 PostOrder(root.left);
                 PostOrder(root.right);
                 System.out.print(root.data+" ");
             }
        }

        //creating a  method to do Level Order traversal
        public void levelOrderTraversal(Node root){
             if (root==null){
                 return;
             }
             else {
                 Queue<Node> q = new LinkedList<>();
                 q.add(root);
                 q.add(null);
                 while (!q.isEmpty()) {
                     Node cur=q.remove();
                     if (cur==null){
                         System.out.println(" ");
                         if (q.isEmpty()){
                             break;
                         }
                         else{
                             q.add(null);
                         }
                     }
                     else{
                         System.out.print(cur.data+" ");
                         if (cur.left!=null){
                             q.add(cur.left);
                         }
                         if (cur.right!=null){
                             q.add(cur.right);
                         }

                     }
                 }

             }
        }

        //count of nodes
        public int countOfNodes(Node root){
             if (root==null){
                 return 0;
             }
             int left=countOfNodes(root.left);
             int right=countOfNodes(root.right);
             return  left + right + 1;
        }

        //Sum of values of nodes
        public int sumOfNodes(Node root){
             if (root==null){
                 return 0;
             }
             int left=sumOfNodes(root.left);
             int right=sumOfNodes(root.right);
             return root.data+ left+ right;
        }

        //calculating the height of a tree by method 1
        public int heightOfTreem1(Node root){
             if (root==null){
                 return 0;
             }
             else{
                 int left=heightOfTreem1(root.left);
                 int right=heightOfTreem1(root.right);
                 return Math.max(left,right)+1;

             }
        }

        //calculating the height of a tree by method 2
        public int heightOfTreem2(Node root){
             int height=0;
             if (root==null){
                 return 0;
             }
             else{
                 Queue<Node> q=new LinkedList<>();
                 q.add(root);
                 q.add(null);
                 while (!q.isEmpty()){
                     Node curr=q.remove();
                     if (curr==null){
                         height++;
                         if (q.isEmpty()){
                             break;
                         }
                         else{
                             q.add(null);
                         }
                     }
                     else{
                         if (curr.left!=null){
                             q.add(curr.left);
                         }
                         if (curr.right!=null){
                             q.add(curr.right);
                         }
                     }
                 }
             }
             return height;
        }

        //calculating the diameter of a tree
        public  int diameter(Node root){
             if (root==null){
                 return 0;
             }
             else{
                 int d1=diameter(root.left);
                 int d2=diameter(root.right);
                 int d3=heightOfTreem1(root.left) + heightOfTreem1(root.right)+1;
                 return Math.max(Math.max(d1,d2),d3);

             }
        }//TC= O(n^n)
    }

    public static void main(String[] args) {
        int [] array={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt=new BinaryTree();
        Node root=bt.createBinaryTree(array);
        System.out.print(root.data);
        System.out.println();
        System.out.println("Pre Order Traversal");
        bt.preOrder(root);
        System.out.println();
        System.out.println("In Order Traversal");
        bt.InOrder(root);
        System.out.println();
        System.out.println("post Order Traversal");
        bt.PostOrder(root);
        System.out.println();
        System.out.println("Level Order Traversal");
        bt.levelOrderTraversal(root);
        System.out.println();
        System.out.print("Total Number Of Nodes In a Binary Tree is: ");
        int ans=bt.countOfNodes(root);
        System.out.print(ans);
        System.out.println();
        System.out.print("Sum Of Nodes: ");
        int val=bt.sumOfNodes(root);
        System.out.print(val);
        System.out.println();
        System.out.print("Height of a Tree by Method 1: ");
        int a=bt.heightOfTreem1(root);
        System.out.print(a);
        System.out.println();
        System.out.print("Height of a Tree by Method 2: ");
        int b=bt.heightOfTreem2(root);
        System.out.print(b);
        System.out.println();
        System.out.print("Diameter of a Tree by Method 1: ");
        int c=bt.diameter(root);
        System.out.print(c);

    }
}
