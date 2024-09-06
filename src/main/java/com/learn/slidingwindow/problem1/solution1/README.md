# Intuition

Bài toán yêu cầu tìm hai số trong mảng có tổng bằng target. Cách đơn giản nhất là xét tất cả các cặp số có thể.

# Approach

1. Sử dụng hai con trỏ l và r để duyệt qua mảng.
2. Con trỏ l cố định, con trỏ r di chuyển từ l+1 đến cuối mảng.
3. Nếu tìm thấy cặp số có tổng bằng target, trả về ngay vị trí của chúng.
4. Nếu r đến cuối mảng mà chưa tìm thấy, tăng l lên và đặt r = l + 1.
5. Lặp lại quá trình cho đến khi duyệt hết tất cả các cặp có thể.

# Complexity

- Time Complexity: $$O(n^2)$$
  Trong trường hợp xấu nhất, ta phải xét tất cả các cặp số có thể.

- Space Complexity: $$O(1)$$
  Chỉ sử dụng một số biến cố định, không phụ thuộc vào kích thước đầu vào.

# Code

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = 1;
        while (l < nums.length) {
            if (nums[l] + nums[r] == target) {
                return new int[]{l, r};
            } else {
                if (r == nums.length - 1) {
                    l++;
                    r = l + 1;
                } else {
                    r++;
                }
            }
        }

        return new int[]{-1, -1};
    }
}
```
# Submission
![img.png](img.png)

# Link github

https://github.com/nguyenthuanit265/java-leetcode