package org.clay.Book_Re_Other;

/**
 * 树的子结构
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class SubTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t==null) return false;
        if(s==null && t!=null) return false;
        boolean flag = false;
        if(s.val==t.val){
            flag = isSubTreeD(s,t);
        }
        if(!flag){
            flag = isSubtree(s.left, t);
            if(!flag){
                flag = isSubtree(s.right, t);
            }
        }
        return flag;
    }

    private boolean isSubTreeD(TreeNode root1, TreeNode root2) {
        if(root2==null) return true;
        
        if(root1==null && root2!=null) return false;
        if(root1.val==root2.val){
            return isSubTreeD(root1.left, root2.left) &&  isSubTreeD(root1.right, root2.right);
        }else{
            return false;
        }
    }

    public static void main(String[] args) {

        SubTree s = new SubTree();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);
        root1.right.left.left = new TreeNode(9);
        root1.right.right.right = new TreeNode(10);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.left = new TreeNode(9);
        root2.right.right = new TreeNode(10);

        //System.out.println(s.isSubTree(root1,root2));

    }
}
