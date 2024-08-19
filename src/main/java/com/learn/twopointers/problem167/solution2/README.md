# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Vì mảng đầu vào đã được sắp xếp, chúng ta có thể sử dụng phương pháp hai con trỏ để tìm cặp số có tổng bằng target. Một con trỏ bắt đầu từ đầu mảng và con trỏ kia bắt đầu từ cuối mảng.
# Approach
<!-- Describe your approach to solving the problem. -->

Khởi tạo hai con trỏ: l ở đầu mảng (index 0) và r ở cuối mảng (index numbers.length - 1).
Trong khi l < r, thực hiện:

Nếu tổng của numbers[l] và numbers[r] lớn hơn target, giảm r (vì mảng đã sắp xếp, giảm r sẽ giảm tổng).
Nếu tổng nhỏ hơn target, tăng l (vì mảng đã sắp xếp, tăng l sẽ tăng tổng).
Nếu tổng bằng target, trả về mảng chứa l + 1 và r + 1 (cộng 1 vì đề bài yêu cầu index bắt đầu từ 1).


Nếu không tìm thấy cặp số thỏa mãn, trả về mảng rỗng.

# Complexity

Time complexity: $$O(n)$$

<!-- Add your time complexity here, e.g. $$O(n)$$ -->
Thuật toán duyệt qua mảng tối đa một lần, trong đó n là độ dài của mảng numbers.

Space complexity: $$O(1)$$

<!-- Add your space complexity here, e.g. $$O(n)$$ -->
Thuật toán chỉ sử dụng một số biến phụ trợ (l, r) và một mảng kết quả có kích thước cố định, không phụ thuộc vào kích thước đầu vào.

# Code
```java []
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] > target) {
                r--;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                return new int[]{l + 1, r + 1};
            }

        }

        return new int[]{};
    }
}
```

# Link github:
https://github.com/nguyenthuanit265/java-leetcode