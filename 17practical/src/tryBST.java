import java.util.*;
//Idowu Popoola
//Consulted Claude ai (free version)
class tNode {
    private long key;
    private String data;
    private tNode left;
    private tNode right;
    private tNode parent;

    public tNode() {
        this.key = 0;
        this.data = "";
        this.parent = null;
        this.left = null;
        this.right = null;
    }
    public tNode(long k, String d) {
        this.key = k;
        this.data = d;
        this.parent = null;
        this.left = null;
        this.right = null;
    }
    public long getKey() {
        return key;
    }
    public void setKey(long k) {
        key = k;
    }
    public String getData() {
        return data;
    }
    public void setData(String d) {
        data = d;
    }
    public tNode getLeft() {
        return left;
    }
    public void setLeft(tNode n) {
        left = n;
    }
    public tNode getRight() {
        return right;
    }
    public void setRight(tNode n) {
        right = n;
    }
    public tNode getParent() {
        return parent;
    }
    public void setParent(tNode n) {
        parent = n;
    }
}

class Tree {
    private int length;
    private tNode root;
    public Tree() {
        root = null;
        length = 0;
    }
    public int size() {
        return length;
    }
    //Inserting Node
    public void insert(long key, String data) {
        tNode n = new tNode(key, data);
        if (root == null) {
            root = n;
        } else {
            insert(root, n);
        }
        length++;
    }
    private void insert(tNode here, tNode n) {
        if (n.getKey() < here.getKey()) {
            if (here.getLeft() == null) {
                n.setParent(here);
                here.setLeft(n);
            } else {
                insert(here.getLeft(), n);
            }
        } else {
            if (here.getRight() == null) {
                n.setParent(here);
                here.setRight(n);
            } else {
                insert(here.getRight(), n);
            }
        }
    }


    private tNode find(long k) {
        tNode current = root;
        while (current != null) {
            if (k == current.getKey()) {
                return current;
            } else if (k < current.getKey()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }
    public void updateTree(tNode n, tNode p) {
        if (n.getParent() == null) {
            root = p;
            if (root != null) {
                root.setParent(null);
            }
        } else if (n.getKey() < n.getParent().getKey()) {
            n.getParent().setLeft(p);
            if (p != null) p.setParent(n.getParent());{
                n.getParent().setRight(p);
            }
            if (p != null) p.setParent(n.getParent());
        }
    }
    //Removing Method
    public void remove(long k) {
        tNode here, n = find(k);
        if (n != null) {
            if (n.getLeft() == null) {
                updateTree(n, n.getRight());
            } else if (n.getRight() == null) {
                updateTree(n, n.getLeft());
            } else {
                here = n.getLeft();
                while (here.getRight() != null) {
                    here = here.getRight();
                }
                updateTree(here, here.getLeft());
                n.setKey(here.getKey());
                n.setData(here.getData());
            }
            length--;
        } else {
            System.out.println("Node " + k + " not in Tree");
        }
    }


    public boolean isBST() {
        return isBSTRec(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBSTRec(tNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.getKey() <= min || node.getKey() >= max) {
            return false;
        }
        return isBSTRec(node.getLeft(), min, node.getKey()) &&
                isBSTRec(node.getRight(), node.getKey(), max);
    }

    // Removing Evens
    public void removeEvens() {
        removeEvensRec(root);
    }

    private void removeEvensRec(tNode node) {
        if (node == null) {
            return;
        }

        tNode leftChild = node.getLeft();
        tNode rightChild = node.getRight();

        removeEvensRec(leftChild);
        removeEvensRec(rightChild);

        if (node.getKey() % 2 == 0) {
            remove(node.getKey());
        }
    }
}
public class tryBST {
    public static void buildBalanced(Tree T, long start, long end) {
        if (start > end) {
            return;
        }
        long mid = (start + end) / 2;
        T.insert(mid, "");
        buildBalanced(T, start, mid - 1);
        buildBalanced(T, mid + 1, end);
    }

    public static void main(String[] args) {
        int n = 7;
        long max = (long) Math.pow(2, n) - 1;
        int runs = 30;
        long totalInsertTime = 0;
        long totalDeleteTime = 0;
        for (int i = 0; i < runs; i++) {
            Tree T = new Tree();
            long startInsert = System.currentTimeMillis();
            buildBalanced(T, 1, max);
            long endInsert = System.currentTimeMillis();
            totalInsertTime += (endInsert - startInsert);

            if (!T.isBST()) {
                System.out.println("Tree is NOT BST!");
                return;
            }
            long startDelete = System.currentTimeMillis();
            T.removeEvens();
            long endDelete = System.currentTimeMillis();
            totalDeleteTime += (endDelete - startDelete);
        }
        System.out.println("Populate Tree Avg time: " + (totalInsertTime / runs) + " ms");
        System.out.println("Remove Evens avg time: " + (totalDeleteTime / runs) + " ms");
    }
}
