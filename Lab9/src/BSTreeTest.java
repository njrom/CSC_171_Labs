public class BSTreeTest {
    public static void main(String[] args) {
        BSTree tree = new BSTree();
        int[] n = {5, 18, 3, 25, 27, 45, 97, 88, 26, 15, 17, 16};
        tree.insert(n);
        inOrder(tree.root);
        System.out.println();
        System.out.println(tree.search(3));
        System.out.println(tree.search(88));
        System.out.println(tree.search(27));
        System.out.println(tree.search(28));
        if(!tree.remove(88)) System.out.println("Item not found");
        inOrder(tree.root);
        System.out.println();
        if(!tree.remove(18)) System.out.println("Item not found");
        inOrder(tree.root);
        System.out.println();
        if(!tree.remove(5)) System.out.println("Item not found");
        inOrder(tree.root);
        System.out.println();
        if(!tree.remove(30)) System.out.println("Item not found");
        inOrder(tree.root);
        System.out.println();
        }
    private static void inOrder(BSTNode root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.key+" ");
            inOrder(root.right);
        }
    }

}
