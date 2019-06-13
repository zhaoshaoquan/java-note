/**
 * Created by zsq on 2019-05-24.
 */
public class Main2{

    public static void main(String[] args){
        Main2 test2 = new Main2();
        Node node = new Node(100);
        test2.insert(node,new Node(101));




        System.out.println(node);

    }


    public void insert(Node root,Node node){
        if(root == null){
            root = node;
        }else{
            Node currNode = root;
            for(Node n=currNode;currNode!=null;){

            }
        }
    }

    static class Node{
        private Integer value;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }

        public void setValue(int value){
            this.value = value;
        }

        public Node getLeft(){
            return left;
        }

        public void setLeft(Node left){
            this.left = left;
        }

        public Node getRight(){
            return right;
        }

        public void setRight(Node right){
            this.right = right;
        }
    }

}
