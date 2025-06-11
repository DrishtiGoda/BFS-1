// TC: O(n)
// SC: O(n)
// Approach: Level order traversal using DFS - Use array ti improve space complexity
// Create list result and check if the level exists in the result list by checking the size of result list
// If it does add the element in that list else create a new list


import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
  List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
  }

  private void helper(TreeNode root, int level, List<List<Integer>> result){
    // base case 
    if(root == null) return;

    // logic 
    if(level == result.size()){
      result.add(new ArrayList<>());
    }

    List<Integer> li = result.get(level);
      li.add(root.val);
      result.set(level, li);
      helper(root.left, level+1, result);
      helper(root.right, level+1, result);
    };
  }
