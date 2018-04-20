import java.util.ArrayList;

public class Lab8P1 {
    public static class BTNode
    {
        int data;
        BTNode left;
        BTNode right;
        // Add constructor and/or other methods if required
        public BTNode(int data, BTNode left, BTNode right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public void levelOrder(ArrayList<BTNode> thisLevel){
        ArrayList<BTNode> nextLevel = new ArrayList<>();
        for(BTNode node: thisLevel){
            if(node != null){
                System.out.print(node.data+" ");
                nextLevel.add(node.left);
                nextLevel.add(node.right);
            }
        }
        System.out.println();
        if(nextLevel.size() > 0){
            levelOrder(nextLevel);
        }
    }

    public void inOrder(BTNode root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }

    public void preOrder(BTNode root){
        if(root != null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private BTNode makeTestTree(){
        BTNode left = new BTNode(2,null,null);
        BTNode right = new BTNode(3, null,null);
        BTNode head = new BTNode(1, left, right);
        return(head);
    }
    public static void main(String[] args) {
        Lab8P1 traversals = new Lab8P1();
        BTNode head = traversals.makeTestTree();
        ArrayList<BTNode> levelList = new ArrayList<>();
        levelList.add(head);
        traversals.levelOrder(levelList);
    }
}
