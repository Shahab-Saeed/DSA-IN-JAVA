//building a Binary Search Tree


public class B1_BINARY_SEARCH_TREE {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
        }
    }


    public static Node createBinarySearchTree(Node root, int value){
            if (root==null){
                root =new Node(value);
                return root;
            }
            if (root.data>value){
                root.left=createBinarySearchTree(root.left,value);
            }
            else if (root.data<value){
                root.right=createBinarySearchTree(root.right,value);
            }
            return root;
        } // tc= O(H)

    public static void inOrder(Node root)   {
        if (root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static boolean searchBT(Node root, int key){
        if (root==null){
            return false;
        }

        else if (root.data>key){
            return searchBT(root.left,key);
        }

        else if  (root.data==key){
            return  true;
        }
        else {
            return searchBT(root.right,key);
        }

    }// tc= O(height)/ tc= O(logn)

    public static Node delete(Node root, int key){
        if (root.data>key){
            root.left=delete(root.left,key);
        }
        else if(root.data<key){
            root.right=delete(root.right,key);
        }
        else{
            //case 1 --> 0 child
            if (root.left==null && root.right==null){
                return null;
            }

            //case 2 --> 1 child
            if (root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }

            //case 3 --> Having two child
            Node is=inorderSuccessor(root.right);
            root.data=is.data;
            root.right=delete(root.right,is.data);
        }
        return root;
    }

    public static Node inorderSuccessor(Node root){
        while (root.left!=null){
            root=root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int []v={5,1,3,4,2,7};
        Node root=null;
        for (int i=0;i<v.length;i++){
            root=createBinarySearchTree(root,v[i]);
        }
        System.out.println("Before");
        inOrder(root);
        System.out.println();

        System.out.println("After");
        delete(root,4);
        inOrder(root);

        }
    }

