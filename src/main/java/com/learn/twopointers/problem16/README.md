# Intuition

<!-- Describe your first thoughts on how to solve this problem. -->

Bài toán yêu cầu tìm tổng của 3 số trong mảng gần nhất với một giá trị target cho trước. Ý tưởng đầu tiên là sử dụng kỹ
thuật Two Pointers kết hợp với việc sắp xếp mảng để giảm độ phức tạp của thuật toán.

# Approach

<!-- Describe your approach to solving the problem. -->

1. Sắp xếp mảng đầu vào theo thứ tự tăng dần.
2. Duyệt qua từng phần tử trong mảng, coi nó là số đầu tiên trong bộ ba số.
3. Sử dụng kỹ thuật Two Pointers để tìm hai số còn lại:
    - Một con trỏ `l` bắt đầu từ phần tử kế tiếp phần tử hiện tại.
    - Một con trỏ `r` bắt đầu từ phần tử cuối cùng của mảng.
4. Di chuyển các con trỏ để tìm tổng gần nhất với target:
    - Nếu tổng nhỏ hơn target, tăng `l`.
    - Nếu tổng lớn hơn target, giảm `r`.
    - Nếu tổng bằng target, trả về kết quả ngay lập tức.
5. Cập nhật kết quả nếu tìm được tổng gần hơn với target.
6. Lặp lại quá trình cho đến khi duyệt hết mảng.

# Complexity

- Time complexity: $$O(n^2)$$

<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: $$O(1)$$ (không tính không gian sử dụng để sắp xếp)

<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code

```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] < target) {
                    if (Math.abs(target - (nums[i] + nums[l] + nums[r])) <= Math.abs(target - ans)) {
                        ans = nums[i] + nums[l] + nums[r];
                    }
                    l++;
                } else if (nums[i] + nums[l] + nums[r] > target) {
                    if (Math.abs(target - (nums[i] + nums[l] + nums[r])) <= Math.abs(target - ans)) {
                        ans = nums[i] + nums[l] + nums[r];
                    }
                    r--;
                } else {
                    return nums[i] + nums[l] + nums[r];
                }
            }
        }

        return ans;
    }
}
```

# Link github

https://github.com/nguyenthuanit265/java-leetcode