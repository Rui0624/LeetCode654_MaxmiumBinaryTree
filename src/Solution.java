
//Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0)
        	return null;
        
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }
	
	public static TreeNode constructMaximumBinaryTree(int[] nums, int start, int end){
		if(start > end)
			return null;
		int max = Integer.MIN_VALUE;
		int idx = 0;
		for(int i = start; i <= end; i++){
			if(nums[i] > max){
				max = nums[i];
				idx = i;
			}
		}
		
		TreeNode root = new TreeNode(max);
		root.left = constructMaximumBinaryTree(nums, start, idx - 1);
		root.right = constructMaximumBinaryTree(nums, idx + 1, end);
		return root;
	}
}
