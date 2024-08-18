# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Để xác định xem một danh sách liên kết có chu trình hay không, ta có thể sử dụng một cấu trúc dữ liệu để lưu trữ các nút đã duyệt qua. Nếu ta gặp lại một nút đã duyệt, tức là có chu trình.
# Approach
<!-- Describe your approach to solving the problem. -->

Sử dụng một HashMap để lưu trữ các nút đã duyệt qua.
Duyệt qua danh sách liên kết, với mỗi nút:

Kiểm tra xem nút đã tồn tại trong HashMap chưa.
Nếu đã tồn tại, tức là có chu trình, trả về true.
Nếu chưa, thêm nút vào HashMap và di chuyển đến nút tiếp theo.


Nếu duyệt hết danh sách mà không phát hiện chu trình, trả về false.

# Complexity

Time complexity:

<!-- Add your time complexity here, e.g. $$O(n)$$ -->
$$O(n)$$, trong đó n là số nút trong danh sách liên kết. Trong trường hợp xấu nhất, ta phải duyệt qua tất cả các nút một lần.

Space complexity:

<!-- Add your space complexity here, e.g. $$O(n)$$ -->
$$O(n)$$, trong trường hợp xấu nhất (không có chu trình), ta phải lưu trữ tất cả n nút trong HashMap.

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
        Map<Object, Boolean> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) {
                return true;
            }

            map.put(head, true);
            head = head.next;
        }

        return false;
    }
}
```