# Intuition / Trực giác
- To determine if two trees are identical, we need to check both their structure and values
- We can convert each tree into a string representation and compare them
- Để xác định hai cây có giống nhau, chúng ta cần kiểm tra cả cấu trúc và giá trị của chúng
- Chúng ta có thể chuyển đổi mỗi cây thành một chuỗi và so sánh chúng

# Approach / Cách tiếp cận
- Use Depth-First Search (DFS) to traverse both trees
- Create string representations including null nodes to capture the complete structure
- Compare the final string representations
- Sử dụng thuật toán Duyệt theo chiều sâu (DFS) để duyệt cả hai cây
- Tạo các chuỗi đại diện bao gồm cả các nút null để nắm bắt đầy đủ cấu trúc
- So sánh các chuỗi đại diện cuối cùng

# Complexity / Độ phức tạp
- Time Complexity/Độ phức tạp thời gian: O(N) where N is the number of nodes in the tree / trong đó N là số nút trong cây
- Space Complexity/Độ phức tạp không gian: O(N) for storing the string representations / để lưu trữ các chuỗi đại diện

# Code
```java
public class MainApp {
    public static class TreeNode {
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

    private static StringBuffer valTree1 = new StringBuffer();
    private static StringBuffer valTree2 = new StringBuffer();

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p, valTree1);
        dfs(q, valTree2);
        return valTree1.toString().contentEquals(valTree2);
    }

    public static void dfs(TreeNode node, StringBuffer valTree) {
        if (node == null) {
            valTree.append("null");
            return;
        }
        valTree.append(node.val);
        dfs(node.left, valTree);
        dfs(node.right, valTree);
    }
}