import java.util.ArrayList;
public class Lab8P2 {

    private int indexOf(int[] array, int element){
        for(int i = 0; i < array.length; i++){
            if(array[i] == element)
                return i;
        }
        return -1;
    }
    private static int preOrderIndex = 0;
    private Lab8P1.BTNode reconstruct_tree(int[] preOrder, int[] inOrder, int startingIndex, int endingIndex) {
        Lab8P1 traversals = new Lab8P1();
        System.out.println("Starting Index "+startingIndex);
        System.out.println("Ending Index "+endingIndex);
        if (startingIndex > endingIndex) return null;
        int headVal = preOrder[preOrderIndex++];
        Lab8P1.BTNode header = new Lab8P1.BTNode(headVal, null, null);
        if(startingIndex == endingIndex){
            return header;
        }
        // Find where preOrder Element is in inOrder Index
        int splitIndex = indexOf(inOrder, headVal);
        header.left = reconstruct_tree(preOrder, inOrder, startingIndex, splitIndex-1);
        header.right = reconstruct_tree(preOrder, inOrder, splitIndex+1, endingIndex );
        return header;
    }

    public static void main(String[] args) {
        Lab8P2 tree = new Lab8P2();
        int[] preorder = {1,2,4,5,3};
        int[] inorder = {4,2,5,1,3};
        Lab8P1.BTNode root = tree.reconstruct_tree(preorder, inorder, 0, preorder.length -1);
        Lab8P1 traversals = new Lab8P1();
        ArrayList<Lab8P1.BTNode> levelList = new ArrayList<>();
        levelList.add(root);
        traversals.levelOrder(levelList);
        traversals.preOrder(root);
        System.out.println();
        traversals.inOrder(root);
        System.out.println();
    }

}
