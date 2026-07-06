import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class BreadthFirstTraversalIterative {
    public static ArrayList<ArrayList<Integer>> levelOrder(Node root){
        if(root == null){
            return new ArrayList<>();
        }
        // create an empty queue for level order traversal
        Queue<Node> que = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        //Enqueue root
        que.offer(root);
        int currLevel = 0;
        while(!que.isEmpty()){
            int len = que.size();
            res.add(new ArrayList<>());
            for(int i=0;i < len; i++){
                // Add front of queue and remove it from queue
                OurNode node = (OurNode) que.poll();
                res.get(currLevel).add(node.data);

                // Enqueue left child
                if(node.left != null){
                    que.offer(node.left);
                }
                if(node.right != null){
                    que.offer(node.right);
                }
            }
            currLevel++;
        }
        return res;
    }

    public static void main(String[] args) {
        OurNode root = new OurNode(5);
        root.left = new OurNode(12);
        root.right = new OurNode(13);

        root.left.left = new OurNode(7);
        root.left.right = new OurNode(14);

        root.right.right = new OurNode(2);

        root.left.left.left = new OurNode(17);
        root.left.left.right = new OurNode(23);

        root.left.right.left = new OurNode(27);
        root.left.right.right = new OurNode(3);

        root.right.right.right = new OurNode(11);
        root.right.right.left = new OurNode(8);

//        BreadthFirstTraversal bft = new BreadthFirstTraversal();
        ArrayList<ArrayList<Integer>> res = BreadthFirstTraversalIterative.levelOrder(root);
        for(ArrayList<Integer> level:res){
            for(int val:level){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

class OurNode extends Node{
    int data;
    OurNode left,right;
    public OurNode(int value){
        super(value);
        data = value;
        left = right = null;
    }

}
