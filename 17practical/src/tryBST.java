import org.w3c.dom.Node;

import java.security.Key;

//idowu Popoola
//Comsuluted Claude(free version)
class tNode{
    int key;
    tNode left,right,parent;
    public tNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
class Tree {
    tNode root;
    public Tree() {
        root = null;
    }
    public void insert(int key){
        root = insertRec(root,null,key);
    }
    private tNode insertRec(tNode node,tNode parent,int key){
        if (node == null){
            tNode newNode = new tNode(key);
            newNode.parent = parent;
            return newNode;
        }
        if (key < node.key)
            node.left = insertRec(node.left,node,key);
        else
            node.right = insertRec(node.right,node,key);

        return node;
    }
    //Cheching bST
    public boolean isBST(){
        return isBSTRec(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean isBSTRec(tNode node,int min,int max){
        if (node == null){
            return true;
        }
        if (node.key <= min || node.key >= max){
            return false;
        }
        return isBSTRec(node.left,min,node.key) && isBSTRec(node.right,node.key,max);
    }
    //Removing Node
    public void remove(int key){
        root= removeRec(root,key);
    }
    private tNode removeRec(tNode node,int key){
        if (node == null){
            return null;
        }
        if (key < node.key){
            node.left = removeRec(node.left,key);
        } else if (key > node.key) {
            node.right = removeRec(node.right,key);
        }
        else {
            //no child
            if(node.left == null && node.right == null){
                return null;
            }
            //one child
            if (node.left == null){
                return node.right;
            }
            if (node.right == null){
                return node.left;
            }
            //two children
            int maxLeft = findMax(node.left);
            node.key = maxLeft;
            node.left = removeRec(node.left,maxLeft);

        }
return node;
    }

}
