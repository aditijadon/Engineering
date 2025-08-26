package dsa.binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

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

    void postOrderTraversalRecursion(TreeNode root) {  // USING RECURSION (DFS)
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
        TreeNode curr = root;
        while (true) {
            while (curr != null) {
                stack.push(curr);
                stack.push(curr);
                curr = curr.left;
            }
            if (stack.empty()) return;
            curr = stack.pop();
            if (!stack.empty() && stack.peek() == curr) {
                curr = curr.right;
            } else {
                System.out.print(curr.val + " ");
                curr = null;
            }
        }
    }

    void levelOrderTraversalRecursion(TreeNode root){  // LEVEl ORDER = BFS
        Map<Integer, List<Integer>> map = new HashMap();   // USE LIST WHEN LEVEL NUMBER NOT REQUIRED
        levelOrderRec(root, 0, map);
        map.forEach((k,v) -> {
            System.out.print("level " + k + ": ");
            v.forEach(va -> System.out.print(va + " "));
            System.out.println();
        });
    }

    void levelOrderRec(TreeNode root, int level, Map<Integer, List<Integer>> map) {
        if (root == null) return;
        if (map.get(level) == null) map.put(level, new ArrayList<>());
        map.get(level).add(root.val);
        levelOrderRec(root.left, level + 1, map);
        levelOrderRec(root.right, level + 1, map);
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
    void rightView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap();   // USE LIST WHEN LEVEL NUMBER NOT REQUIRED
        rightViewImpl(root, 0, map);
        System.out.print("right view : ");
        map.forEach((k,v) -> {
            System.out.print(v + " ");
        });
    }

    void rightViewImpl(TreeNode root, int level, Map<Integer, Integer> map){
        if(root == null) return;
        map.put(level, root.val);
        rightViewImpl(root.left, level+1, map);
        rightViewImpl(root.right, level+1, map);
    }


    void leftView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap();   // USE LIST WHEN LEVEL NUMBER NOT REQUIRED
        leftViewImpl(root, 0, map);
        System.out.print("left view : ");
        map.forEach((k,v) -> {
            System.out.print(v + " ");
        });
    }

    void leftViewImpl(TreeNode root, int level, Map<Integer, Integer> map){
        if(root == null) return;
        map.putIfAbsent(level, root.val);
        leftViewImpl(root.left, level+1, map);
        leftViewImpl(root.right, level+1, map);
    }

    void topView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();   // USE LIST WHEN LEVEL NUMBER NOT REQUIRED
        topViewImpl(root, 0, map);
        System.out.print("top view: ");
        map.values().forEach(val -> System.out.print(val + " "));
        System.out.println();
    }

    void topViewImpl(TreeNode root, int level, Map<Integer, Integer> map){
        if(root == null) return;
        map.putIfAbsent(level, root.val);
        topViewImpl(root.left, level-1, map);
        topViewImpl(root.right, level+1, map);
    }

    void bottomView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();   // USE LIST WHEN LEVEL NUMBER NOT REQUIRED
        bottomViewImpl(root, 0, map);
        System.out.print("bottom view : ");
        map.forEach((k,v) -> {
            System.out.print(v + " ");
        });
    }

    void bottomViewImpl(TreeNode root, int level, Map<Integer, Integer> map){
        if(root == null) return;
        map.put(level, root.val);
        bottomViewImpl(root.left, level-1, map);
        bottomViewImpl(root.right, level+1, map);
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
