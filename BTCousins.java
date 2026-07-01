// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on LeetCode : Yes

// Approach :
//  - Perform a level order traversal (BFS). For each level, check whether x and y appear while ensuring they are not siblings (children of the same parent).
//  - If both are found in the same level and are not siblings, they are cousins.
//  - If only one is found at a level, they cannot be cousins.

class BTCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        while(!nodes.isEmpty()) {
            int size = nodes.size();
            boolean xFound = false, yFound = false;
            for(int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                if(node.left != null && node.right != null) {
                    if(node.left.val == x && node.right.val == y) {
                        return false;
                    }
                    if(node.left.val == y && node.right.val == x) {
                        return false;
                    }
                }

                if(node.left != null) {
                    nodes.offer(node.left);
                    if(node.left.val == x) {
                        xFound = true;
                    } else if(node.left.val == y) {
                        yFound = true;
                    }
                }
                if(node.right != null) {
                    nodes.offer(node.right);
                    if(node.right.val == x) {
                        xFound = true;
                    } else if(node.right.val == y) {
                        yFound = true;
                    }
                }
            }

            if(xFound && yFound) {
                return true;
            }

            if(xFound || yFound) {
                return false;
            }
        }

        return false;
    }
}