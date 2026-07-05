import java.util.ArrayList;

public class BreadthFirstTraversal {

    public static void main(String[] args) {
        MyNode root = new MyNode(5);
        root.left = new MyNode(12);
        root.right = new MyNode(13);

        root.left.left = new MyNode(7);
        root.left.right = new MyNode(14);

        root.right.right = new MyNode(2);

        root.left.left.left = new MyNode(17);
        root.left.left.right = new MyNode(23);

        root.left.right.left = new MyNode(27);
        root.left.right.right = new MyNode(3);

        root.right.right.right = new MyNode(11);
        root.right.right.left = new MyNode(8);

        BreadthFirstTraversal bft = new BreadthFirstTraversal();
        ArrayList<ArrayList<Integer>> res = bft.levelOrder(root);
        for(ArrayList<Integer> level:res){
            for(int val:level){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    void levelOrderRec(MyNode root, int level, ArrayList<ArrayList<Integer>> res){
        // Base case
        if(root == null){
            return;
        }
        // Add a new level to result if needed
        if(res.size() <= level){
            res.add(new ArrayList<>());
        }

        // Add current node's data to its corresponding level
        res.get(level).add(root.data);
        //Recur for left and right children
        levelOrderRec(root.left, level + 1, res);
        levelOrderRec(root.right, level + 1, res);
    }

    // Function to perform level order traversal
    ArrayList<ArrayList<Integer>> levelOrder(MyNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        levelOrderRec(root,0,res);
        return res;
    }
}
class MyNode{
    int data;
    MyNode left, right;

    MyNode(int value){
        data = value;
        left = null;
        right = null;
    }
}
