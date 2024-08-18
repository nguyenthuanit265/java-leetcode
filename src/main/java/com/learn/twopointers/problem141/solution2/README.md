# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Sử dụng hai con trỏ di chuyển với tốc độ khác nhau trong danh sách liên kết. Nếu có chu trình, hai con trỏ sẽ gặp nhau tại một điểm nào đó.
# Approach
<!-- Describe your approach to solving the problem. -->

Khởi tạo hai con trỏ slow (rùa) và fast (thỏ) cùng trỏ vào đầu danh sách.
Di chuyển slow một bước và fast hai bước trong mỗi lần lặp.
Nếu có chu trình, fast sẽ "bắt kịp" slow tại một điểm nào đó.
Nếu fast đạt tới null, tức là không có chu trình.

# Complexity

Time complexity:

<!-- Add your time complexity here, e.g. $$O(n)$$ -->
$$O(n)$$, trong đó n là số nút trong danh sách liên kết. Trong trường hợp xấu nhất, ta phải duyệt qua tất cả các nút một lần.

Space complexity:

<!-- Add your space complexity here, e.g. $$O(n)$$ -->
$$O(1)$$, vì ta chỉ sử dụng hai con trỏ phụ trợ, không phụ thuộc vào kích thước của danh sách đầu vào.
# Code
```
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }
}
```

# Giải thích:

- Đầu tiên, kiểm tra các trường hợp đặc biệt: danh sách rỗng hoặc chỉ có một nút.
- Khởi tạo slow tại head và fast tại head.next để tránh trường hợp phát hiện sai khi cả hai cùng bắt đầu ở head.
- Trong vòng lặp, di chuyển slow một bước và fast hai bước.
- Nếu fast đạt tới null hoặc fast.next là null, tức là không có chu trình.
- Nếu slow và fast gặp nhau, tức là có chu trình.

