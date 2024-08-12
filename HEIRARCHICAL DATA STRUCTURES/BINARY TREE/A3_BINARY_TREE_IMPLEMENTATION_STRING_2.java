import java.util.LinkedList;
import java.util.Queue;

public class A3_BINARY_TREE_IMPLEMENTATION_STRING_2 {
    static class Node{
        String value;
        Node left;
        Node right;
        Node(String value){
            this.value=value;
        }
    }

    static class BinaryTree{
        static int index=-1;

        //creating a binary tree method
        public Node createBinaryTree(String []  arr){
            index++;
            if (arr[index]==null){
                return null;
            }

                Node n=new Node(arr[index]);
                n.left=createBinaryTree(arr);
                n.right=createBinaryTree(arr);

                return n;

        }

        //creating a pre order traversal method
        public void preOrder(Node root){
            if (root==null){
                return;
            }
            else{
                System.out.print(root.value+" ");
                preOrder(root.left);
                preOrder(root.right);
            }
        }

        //creating a inorder traversal method
        public void inOrder(Node root){
            if (root==null){
                return ;
            }
            inOrder(root.left);
            System.out.print(root.value+" ");
            inOrder(root.right);
        }

        //creating a postorder traversal
        public void postOrder(Node root){
            if (root==null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.value+" ");
        }

        //creating a levelOrder Traversal method 1
        public void levelOrderTraversal1(Node root){
            if (root==null){
                return;
            }
            else{
                Queue<Node> q=new LinkedList<>();
                q.add(root);
                q.add(null);

                while (!q.isEmpty()){
                    Node curr=q.remove();
                    if (curr==null){
                        System.out.println();
                        if (q.isEmpty()){
                            break;
                        }
                        else{
                            q.add(null);
                        }
                    }
                    else{
                        System.out.print(curr.value+" ");
                        if (curr.left!=null ){
                            q.add(curr.left);
                        }
                        if (curr.right!=null ){
                            q.add(curr.right);
                        }
                    }
                }
            }
        }

        //creating a countOfNodes method
        public int countOfNodes(Node root){
            if (root==null){
                return 0;
            }
            int left=countOfNodes(root.left);
            int right=countOfNodes(root.right);
            return 1 + left+ right;

        }

        //creating a height of tree method 1
        public int heightOfTree1(Node root){
            if (root==null){
                return 0;
            }
            int left=heightOfTree1(root.left);
            int right=heightOfTree1(root.right);
            return Math.max(left,right)+1;
        }

        //creating a height of tree method 2
        public int heightOfTree2(Node root){
            int height=0;
            if (root==null){
                return 0;
            }
            else{
                Queue<Node> q=new LinkedList<>();
                q.add(root);
                q.add(null);
                while (!q.isEmpty()){
                    Node cur=q.remove();
                    if (cur==null){
                        height++;
                        if (q.isEmpty()){
                            break;
                        }
                        else{
                            q.add(null);
                        }
                    }
                    else{
                        if (cur.left!=null){
                            q.add(cur.left);
                        }
                        if (cur.right!=null){
                            q.add(cur.right);
                        }
                    }
                }

            }
            return height;
        }

        public int diameter(Node root){
            if (root==null){
                return 0;
            }
            int left=diameter(root.left);
            int right=diameter(root.right);
            int diam3=heightOfTree1(root.left)+ heightOfTree1(root.right)+1;
            return Math.max(Math.max(left,right),diam3);
        }
        }
    public static void main(String[] args) {
        String [] arr= {"Ghulam Muhammad","Saeed Ahmed","Umair Saeed",null,null,"Muhammad Shayan",null,null,"Shabbir Ahmed","Amad Ali",null,null,null};
        BinaryTree bt=new BinaryTree();
        Node a=bt.createBinaryTree(arr);
        System.out.println("Root Value"+a.value);
        System.out.println();
        System.out.println();
        System.out.println("Pre Order Traversal");
        bt.preOrder(a);
        System.out.println();
        System.out.println();
        System.out.println("In Order Traversal");
        bt.inOrder(a);
        System.out.println();
        System.out.println();
        System.out.println("Post Order Traversal");
        bt.inOrder(a);
        System.out.println();
        System.out.println();
        System.out.println("Level Order Traversal");
        bt.levelOrderTraversal1(a);
        System.out.println();
        System.out.println();
        System.out.print("Count Of Nodes: ");
        int b=bt.countOfNodes(a);
        System.out.println(b);
        System.out.println();
        System.out.println();
        System.out.print("Height Of Tree: ");
        int c=bt.heightOfTree1(a);
        System.out.println(c);
        System.out.println();
        System.out.println();
        System.out.print("Height Of Tree: ");
        int d=bt.heightOfTree2(a);
        System.out.println(d);
        System.out.println();
        System.out.println();
        System.out.print("Diameter Of Tree: ");
        int e=bt.diameter(a);
        System.out.println(e);

    }
}
