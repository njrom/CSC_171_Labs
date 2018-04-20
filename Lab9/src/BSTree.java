

public class BSTree {
    public BSTNode root;
    public BSTree(){
    }
    public BSTree(int value){
        this.root = new BSTNode(value, null); // Gits rid of any children of the node
    }
    public boolean insert(int key){
        return insertRecur(root, key);
    }
    public boolean[] insert(int[] values){
        boolean[] bools = new boolean[values.length];
        int index = 0;
        for(int value: values){
            bools[index] = insert(value);
            index++;
        }
        return bools;
    }
    private boolean insertRecur(BSTNode currentRoot, int value){
        if(currentRoot == null){
            this.root = new BSTNode(value, null);
            return true;
        }
        if(value == currentRoot.key) return false; // If value is in the tree don't insert it
        if(value > currentRoot.key){ // If value greater than current node go right
            if(currentRoot.hasRight()){
                insertRecur(currentRoot.right, value);
            } else{ // If there is no child here this is where this value goes
                currentRoot.right = new BSTNode(value, currentRoot);
                return true;
            }
        } else { // If less than current node go left
            if(currentRoot.hasLeft()){
                insertRecur(currentRoot.left, value);
            } else{
                currentRoot.left = new BSTNode(value, currentRoot);
                return true;
            }
        }
        return false; // If something goes wrong return false by default
    }
    public boolean remove(int key){
        return removeRecur(root, key);
    }
    private boolean removeRecur(BSTNode currentRoot, int value){
        if(currentRoot == null) return false;
        if(currentRoot.key == value){
            if(currentRoot.isLeaf()){
                if(currentRoot.parent.left == currentRoot) currentRoot.parent.left = null;
                if(currentRoot.parent.right == currentRoot) currentRoot.parent.right = null;
                return true;
            }
            if(!(currentRoot.hasRight())){
                currentRoot.key = currentRoot.left.maxValue(); // Uses RMLC if no right branch
                return removeRecur(currentRoot.left, currentRoot.key);
            }
            currentRoot.key = currentRoot.right.minValue(); // Swaps LMRC
            return removeRecur(currentRoot.right, currentRoot.key); // Removes LMRC
        }
        if(currentRoot.key < value){ // Traverse Right
            if(currentRoot.hasRight()) {
                return removeRecur(currentRoot.right, value);
            }
            return false;
        }
        if(currentRoot.key > value){ // Traverse Left
            if(currentRoot.hasLeft()) {
                return removeRecur(currentRoot.left, value);
            }
            return false;
        }
        return false;
    }

    public boolean search(int key){
        return searchRecur(root,key);
    }
    private boolean searchRecur(BSTNode currentRoot, int value){
        if(currentRoot == null) return false;
        if(currentRoot.key == value) return true;
        if(currentRoot.key < value){
            return searchRecur(currentRoot.right, value);
        } else{
            return searchRecur(currentRoot.left, value);
        }
    }

}
