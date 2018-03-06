package test.basic.tree;

/**
 * Created by 123 on 2018/2/1.
 */
public class BinaryTreeArrayNode {
    /**
     * 数组实现，保存的不是 左右子树的引用，而是数组下标
     * 一般使用左右链表示的节点来构造二叉树。
     */
    private int mData;
    private int mLeftChild;
    private int mRightChild;

    public int getData() {
        return mData;
    }

    public void setData(int data) {
        mData = data;
    }

    public int getLeftChild() {
        return mLeftChild;
    }

    public void setLeftChild(int leftChild) {
        mLeftChild = leftChild;
    }

    public int getRightChild() {
        return mRightChild;
    }

    public void setRightChild(int rightChild) {
        mRightChild = rightChild;
    }
}
