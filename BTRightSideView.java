// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on LeetCode : Yes

// Approach :
//  - Perform a level order traversal, enqueueing the right child before the left child.
//  - For each level, record the first node encountered, since it represents the rightmost node visible from that level. Continue until all levels are processed.

class BTRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);

        while(!nodesQueue.isEmpty()) {
            boolean isFirstNodeAdded = false;
            List<TreeNode> nodeList = new ArrayList<>();
            while(!nodesQueue.isEmpty()) {
                TreeNode node = nodesQueue.poll();
                nodeList.add(node);
                if(!isFirstNodeAdded) {
                    result.add(node.val);
                    isFirstNodeAdded = true;
                }
            }
            for(TreeNode node : nodeList) {
                if(node.right != null) {
                    nodesQueue.add(node.right);
                }
                if(node.left != null) {
                    nodesQueue.add(node.left);
                }
            }
        }

        return result;
    }
}