package test.basic.tree;

/**
 * Created by 123 on 2018/1/31.
 * tree 数组实现
 */
public class TreeNode {
    private Object mData;   //存储的数据
    private int mParent;   //父亲节点的下标

    public TreeNode(Object data, int parent) {
        mData = data;
        mParent = parent;
    }

    public Object getData() {
        return mData;
    }

    public void setData(Object data) {
        mData = data;
    }

    public int getParent() {
        return mParent;
    }

    public void setParent(int parent) {
        mParent = parent;
    }

    public static void main(String[] args){
        TreeNode[] arrayTree = new TreeNode[10];
    }
}
