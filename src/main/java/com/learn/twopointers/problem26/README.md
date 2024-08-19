# Intuition

<!-- Describe your first thoughts on how to solve this problem. -->
Để loại bỏ các phần tử trùng lặp trong một mảng đã được sắp xếp, ta có thể sử dụng một con trỏ để theo dõi vị trí cần
ghi đè các phần tử không trùng lặp.

# Approach

<!-- Describe your approach to solving the problem. -->

Sử dụng một biến index để theo dõi vị trí cần ghi đè phần tử không trùng lặp tiếp theo.
Duyệt qua mảng từ đầu đến áp chót.
So sánh phần tử hiện tại với phần tử kế tiếp.
Nếu hai phần tử khác nhau, ghi đè phần tử kế tiếp vào vị trí index và tăng index lên 1.
Cuối cùng, index sẽ là độ dài mới của mảng sau khi loại bỏ các phần tử trùng lặp.

# Complexity

Time complexity:

<!-- Add your time complexity here, e.g. $$O(n)$$ -->
$$O(n)$$, trong đó n là số phần tử của mảng đầu vào. Ta chỉ duyệt qua mảng một lần.

Space complexity:

<!-- Add your space complexity here, e.g. $$O(n)$$ -->
$$O(1)$$, vì ta chỉ sử dụng một số biến phụ trợ và không cần thêm bộ nhớ phụ thuộc vào kích thước đầu vào.

# Code

```
class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[index++] = nums[i + 1];
            }
        }

        return index;
    }
}
```

# Link github

https://github.com/nguyenthuanit265/java-leetcode