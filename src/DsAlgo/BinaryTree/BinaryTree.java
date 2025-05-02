package DsAlgo.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
//  ------------------------------------------ TRAVERSALS -------------------------------------------------------
    void preOrderTraversalRecursion(TreeNode root) {  // USING RECURSION (DFS)
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrderTraversalRecursion(root.left);
        preOrderTraversalRecursion(root.right);
    }

    void preOrderTraversalStack(TreeNode root) {  // USING STACK (DFS)
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            System.out.print(curr.val + " ");
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
        }
    }

    void inOrderTraversalRecursion(TreeNode root) {  // USING RECURSION (DFS)
        if (root == null) return;
        inOrderTraversalRecursion(root.left);
        System.out.print(root.val + " ");
        inOrderTraversalRecursion(root.right);
    }

    void inOrderTraversalStack(TreeNode root) {  // USING STACK (DFS)
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.val + " ");  // Printing after push makes it preOrder
            curr = curr.right;
        }
    }

    void postOrderTraversalRecursion(TreeNode root) {  // (DFS)
        if (root == null) return;
        postOrderTraversalRecursion(root.left);
        postOrderTraversalRecursion(root.right);
        System.out.print(root.val + " ");
    }

    void postOrderTraversalTwoStack(TreeNode root) {  // SAME AS PREORDER BUT USING 2 STACKS
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        TreeNode curr;
        while (!stack1.isEmpty()) {
            curr = stack1.pop();
            stack2.push(curr);
            if (curr.left != null)
                stack1.push(curr.left);
            if (curr.right != null)
                stack1.push(curr.right);
        }
        while (!stack2.isEmpty()) {
            curr = stack2.pop();
            System.out.print(curr.val + " ");
        }
    }

    void postOrderTraversalStack(TreeNode root) {  // USING ONE STACK (DFS)
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }
            if (stack.empty()) return;
            root = stack.pop();
            if (!stack.empty() && stack.peek() == root) {
                root = root.right;
            } else {
                System.out.print(root.val + " ");
                root = null;
            }
        }
    }

    void levelOrderTraversalRecursion(TreeNode root){  // LEVEl ORDER = BFS
        Map<Integer, List<Integer>> res = new HashMap();   // USE LIST WHEN LEVEL NUMBER NOT REQUIRED
        levelOrderRec(root, 0, res);
        res.forEach((k,v) -> {
            System.out.print("level " + k + ": ");
            v.forEach(va -> System.out.print(va + " "));
            System.out.println();
        });
    }

    void levelOrderRec(TreeNode root, int level, Map<Integer, List<Integer>> res) {
        if (root == null) return;
        if (res.get(level) == null) res.put(level, new ArrayList<>());
        res.get(level).add(root.val);
        levelOrderRec(root.left, level + 1, res);
        levelOrderRec(root.right, level + 1, res);
    }

    void levelOrderTraversal(TreeNode root) {  // SAME AS PREORDER BUT WITH QUEUE
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
        }
    }

    void levelOrderTraversalLineByLine(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currLevel = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.print("level " + currLevel + ": ");
            for (int i = 0; i < len; i++) {
                TreeNode current = queue.poll();
                System.out.print(current.val + " ");
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
            currLevel++;
            System.out.println();
        }
    }

    void verticalTraversalRecursion(TreeNode root) {
        Map<Integer, List<Integer>> res = new HashMap();  // USE MAP WHEN LEVEL NUMBER NOT REQUIRED
        verticalOrderRec(root, 0, res);
        res.forEach((k,v) -> {
            System.out.print("level " + k + ": ");
            v.forEach(va -> System.out.print(va + " "));
            System.out.println();
        });
    }

    void verticalOrderRec (TreeNode root, int level, Map<Integer, List<Integer>> res) {
        if (root == null) return;
        if (res.get(level) == null) res.put(level, new ArrayList<>());
        res.get(level).add(root.val);
        verticalOrderRec(root.left, level - 1, res);
        verticalOrderRec(root.right, level + 1, res);
    }

    void diagonalTraversalRecursion(TreeNode root) {
        Map<Integer, List<Integer>> res = new HashMap();
        diagonalOrderRec(root, 0, res);
        res.forEach((k,v) -> {
            System.out.print("level " + k + ": ");
            v.forEach(va -> System.out.print(va + " "));
            System.out.println();
        });
    }

    void diagonalOrderRec (TreeNode root, int level, Map<Integer, List<Integer>> res) {
        if (root == null) return;
        if (res.get(level) == null) res.put(level, new ArrayList<>());
        res.get(level).add(root.val);
        diagonalOrderRec(root.left, level + 1, res);
        diagonalOrderRec(root.right, level, res);
    }

//  -------------------------------------------- VIEWS ---------------------------------------------------------
    void rightView() {
        // Level Order Traversal and pick last element of all rows
    }

    void leftView() {
        // Level Order Traversal and pick first element of all rows
    }

    void topView() {
        // Vertical Order Traversal and pick first element of all rows
    }

    void bottomView() {
        // Vertical Order Traversal and pick last element of all rows
    }

//  ----------------------------------------------MISCELLANEOUS--------------------------------------------------
    int getSize(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return getSize(root.left) + getSize(root.right) + 1;
    }

    int getHeight(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return 0;
        return Math.max(getHeight(root.left) + 1, getHeight(root.right) + 1);
    }

    int getLevel(TreeNode root, int node) {
        return getLevelImpl(root, node, 0);
    }

    int getLevelImpl(TreeNode root, int node, int level) {
        if (root == null) return -1;
        if (root.val == node) return level;
        int leftLevel = getLevelImpl(root.left, node, level + 1);
        if (leftLevel != -1) {
            return leftLevel;
        }
        return getLevelImpl(root.right, node, level + 1);
    }

    int getMax(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return root.val;
        return Math.max(getMax(root.left), getMax(root.right));
    }

    boolean isIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }

    boolean isMirror(TreeNode root1, TreeNode root2) {
        return true;
    }

    boolean isPerfect() {
        return true;
    }

    boolean isCousins() {
        return true;
    }
}
