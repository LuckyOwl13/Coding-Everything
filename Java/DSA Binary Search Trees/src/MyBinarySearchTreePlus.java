
public class MyBinarySearchTreePlus <T extends KeyedItem<KT>,
    KT extends Comparable<? super KT>> extends MyBinarySearchTree<T,KT>
    implements BSTPInterface {


    public MyBinarySearchTreePlus() {
    }  // end default constructor

    public MyBinarySearchTreePlus(T rootItem) {
        super(rootItem);
    }	// end Constructor


    @Override
    public int getHeight() {
        int height = 0;

        if (!isEmpty()) {
            height = findHeight(root);
        }	// end if


        return height;
    }	// end getHeight

    protected int findHeight(TreeNode<T> tNode) {
        int leftHeight = 0;
        int rightHeight = 0;

        TreeNode<T> leftChild = tNode.getLeftChild();
        TreeNode<T> rightChild = tNode.getRightChild();
        if (leftChild != null) leftHeight += findHeight(leftChild);
        if (rightChild != null) rightHeight += findHeight(rightChild);

        return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
    }	// end findHeight


    @Override
    public int getSize() {
        int size = 0;

        if (!isEmpty()) {
            size = countSize(root);
        }	// end if

        return size;
    }	// end getSize

    private int countSize(TreeNode<T> tNode) {
        int toReturn = 1;	// the # of nodes in the subtree starting at this node

        TreeNode<T> leftChild = tNode.getLeftChild();
        TreeNode<T> rightChild = tNode.getRightChild();
        if (leftChild != null) toReturn += countSize(leftChild);
        if (rightChild != null) toReturn += countSize(rightChild);

        return toReturn;
    }	// end countSize


    @Override
    public String toStringInorder() {
        String toReturn = "";

        if (!isEmpty()) {
            toReturn = inOrderString(root);
        }	// end if

        return toReturn;
    }	// end toStringInorder

    private String inOrderString(TreeNode<T> tNode) {
        String toReturn = "";

        if (tNode.getLeftChild() != null) {
            toReturn += inOrderString(tNode.getLeftChild()) + "  ";
        }	// end if

        toReturn += tNode.getItem().getKey().toString();

        if (tNode.getRightChild() != null) {
            toReturn += "  " + inOrderString(tNode.getRightChild());
        }	// end if

        return toReturn;
    }	// end inOrderString


    @Override
    public String toStringPreorder() {
        String toReturn = "";

        if (!isEmpty()) {
            toReturn =  preOrderString(root);
        }	// end if

        return toReturn;
    }	// end toStringPreorder

    private String preOrderString(TreeNode<T> tNode) {
        String toReturn = tNode.getItem().getKey().toString();

        if (tNode.getLeftChild() != null) {
            toReturn += "  " + inOrderString(tNode.getLeftChild());
        }	// end if

        if (tNode.getRightChild() != null) {
            toReturn += "  " + inOrderString(tNode.getRightChild());
        }	// end if

        return toReturn;
    }


    @Override
    public String toStringPostorder() {
        String toReturn = "";

        if (!isEmpty()) {
            toReturn = postOrderString(root);
        }	// end if

        return toReturn;
    }	// end toStringPostorder

    private String postOrderString(TreeNode<T> tNode) {
        String toReturn = "";

        if (tNode.getLeftChild() != null) {
            toReturn += postOrderString(tNode.getLeftChild()) + "  ";
        }	// end if

        if (tNode.getRightChild() != null) {
            toReturn += postOrderString(tNode.getRightChild()) + "  ";
        }	// end if

        toReturn += tNode.getItem().getKey().toString();

        return toReturn;
    }	// end postOrderString

    @Override
    public MyBinarySearchTreePlus<T,KT> getCopyOfTree() {
        MyBinarySearchTreePlus<T,KT> newTree = new MyBinarySearchTreePlus<T,KT>(root.getItem());

        if (root.getLeftChild() != null) addCopies(newTree,root.getLeftChild());
        if (root.getRightChild() != null) addCopies(newTree,root.getRightChild());

        return newTree;
    }	// end getCopyOfTree

    private void addCopies(MyBinarySearchTreePlus<T, KT> newTree, TreeNode<T> tNode) {
        newTree.insert(tNode.getItem());

        TreeNode<T> leftChild = tNode.getLeftChild();
        TreeNode<T> rightChild = tNode.getRightChild();
        if (leftChild != null) addCopies(newTree,leftChild);	// if there is a left child, continue recursing with it
        if (rightChild != null) addCopies(newTree,rightChild);	// if there is a right child, continue recursing with it
    }	// end addCopies

}	// end Class
