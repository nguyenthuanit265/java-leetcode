# Intuition

Bài toán yêu cầu tìm độ dài của mảng con nhỏ nhất có tổng lớn hơn hoặc bằng một giá trị target cho trước. Cách tiếp cận
sliding window (cửa sổ trượt) có thể hiệu quả để giải quyết vấn đề này.

# Approach

1. Sử dụng kỹ thuật cửa sổ trượt với hai con trỏ left và right.
2. Mở rộng cửa sổ bằng cách di chuyển con trỏ right và cộng dồn tổng hiện tại.
3. Khi tổng hiện tại >= target, thu hẹp cửa sổ từ bên trái (di chuyển left) để tìm độ dài nhỏ nhất thỏa mãn.
4. Cập nhật độ dài nhỏ nhất (ans) mỗi khi tìm được một mảng con thỏa mãn.
5. Lặp lại quá trình cho đến khi duyệt hết mảng.

# Complexity

- Time complexity: $$O(n)$$
  Mỗi phần tử được thêm vào và loại bỏ khỏi cửa sổ trượt tối đa một lần.

- Space complexity: $$O(1)$$
  Chỉ sử dụng một số biến cố định, không phụ thuộc vào kích thước đầu vào.

# Code

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, left = 0, right = 0;
        int curSum = 0;

        while (right < nums.length && left <= right) {
            curSum += nums[right];
            if (curSum < target) {
                right++;
            } else if (curSum >= target) {
                while (curSum >= target) {
                    ans = Math.min(ans, right - left + 1);
                    curSum -= nums[left];
                    left++;
                }
                right++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
```
# NOTED:
1. Biến `ans` được khởi tạo với giá trị `Integer.MAX_VALUE` để xử lý trường hợp không tìm thấy mảng con thỏa mãn.
2. Vòng lặp while bên trong giúp thu hẹp cửa sổ từ bên trái khi tìm thấy một mảng con thỏa mãn.
3. Cuối cùng, nếu `ans` vẫn là `Integer.MAX_VALUE`, nghĩa là không tìm thấy mảng con thỏa mãn, trả về 0.

# Submission
![img.png](img.png)


# Link github

https://github.com/nguyenthuanit265/java-leetcode