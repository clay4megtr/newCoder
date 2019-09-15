package org.clay.Book_Re_Tree;

/**
 * 有序数组转换为二叉搜索树
 */
public class SortArray2BST {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return constract(nums,0,nums.length-1);
    }

    public TreeNode constract(int[] nums,int left,int right){

        if(left > right){
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = constract(nums,left,mid-1);
        node.right = constract(nums,mid+1,right);

        return node;
    }

}
