# Intuition

<!-- Describe your first thoughts on how to solve this problem. -->
Để tìm nút giữa của một danh sách liên kết đơn, ta có thể sử dụng kỹ thuật hai con trỏ: một con trỏ di chuyển nhanh (
fast) và một con trỏ di chuyển chậm (slow).

# Approach

<!-- Describe your approach to solving the problem. -->

Khởi tạo hai con trỏ slow và fast, cả hai đều trỏ vào đầu danh sách.
Di chuyển con trỏ fast hai bước và con trỏ slow một bước trong mỗi lần lặp.
Khi con trỏ fast đến cuối danh sách (hoặc null), con trỏ slow sẽ ở vị trí giữa danh sách.
Trả về nút mà con trỏ slow đang trỏ tới.

# Complexity

Time complexity:

<!-- Add your time complexity here, e.g. $$O(n)$$ -->
$$O(n)$$, trong đó n là số nút trong danh sách liên kết. Ta duyệt qua danh sách một lần với con trỏ fast.

Space complexity:

<!-- Add your space complexity here, e.g. $$O(n)$$ -->
$$O(1)$$, vì ta chỉ sử dụng hai con trỏ phụ trợ, không phụ thuộc vào kích thước của danh sách đầu vào.

# Code

```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
```

# # # 

Đoạn code này sử dụng kỹ thuật "Tortoise and Hare" (Rùa và Thỏ) để tìm nút giữa của danh sách liên kết. Kỹ thuật này rất
hiệu quả vì nó chỉ cần duyệt qua danh sách một lần và không cần biết trước độ dài của danh sách.

# Link github

https://github.com/nguyenthuanit265/java-leetcode