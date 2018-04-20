public class BSTNode {
    int key;
    BSTNode parent;
    BSTNode left;
    BSTNode right;
    // Add constructor and other methods if required.
    public BSTNode(int key, BSTNode parent){
        this.parent = parent;
        this.key = key;
    }
    public boolean hasRight(){
        return this.right != null;
    }
    public boolean hasLeft(){
        return this.left != null;
    }
    public boolean isLeaf(){
        return this.right == null && this.left == null;
    }
    public int minValue(){
        if(this.hasLeft()){
            return this.left.minValue();
        }
        return this.key;
    }
    public int maxValue(){
        if(this.hasRight()){
            return this.right.maxValue();
        }
        return this.key;
    }
}
