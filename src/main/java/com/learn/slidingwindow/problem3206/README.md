# Intuition

<!-- Describe your first thoughts on how to solve this problem. -->
Để giải quyết bài toán này, ta cần tìm các nhóm 3 phần tử liên tiếp trong mảng có mẫu xen kẽ (ABA). Ý tưởng chính là sử
dụng một cửa sổ trượt kích thước 3 để kiểm tra từng nhóm 3 phần tử liên tiếp. Ngoài ra, cần xem xét trường hợp đặc biệt
khi nhóm xen kẽ "quấn" từ cuối mảng về đầu mảng.

# Approach

<!-- Describe your approach to solving the problem. -->

1. Kiểm tra điều kiện đầu vào: Nếu độ dài mảng nhỏ hơn 3, trả về 0 vì không thể tạo thành nhóm xen kẽ.

2. Khởi tạo biến:
    - `ans`: đếm số nhóm xen kẽ
    - `l` và `r`: con trỏ trái và phải của cửa sổ trượt

3. Sử dụng cửa sổ trượt:
    - Di chuyển cửa sổ qua mảng từ trái sang phải
    - Tại mỗi vị trí, kiểm tra điều kiện xen kẽ: `colors[l] == colors[r] && colors[l + 1] != colors[r]`
    - Nếu thỏa mãn, tăng `ans`

4. Xử lý trường hợp đặc biệt:
    - Kiểm tra nhóm xen kẽ "quấn" từ cuối mảng về đầu:
        * Trường hợp 1: [cuối, đầu, thứ hai]
        * Trường hợp 2: [áp chót, cuối, đầu]

5. Trả về kết quả `ans`.

# Complexity

- Time complexity:

<!-- Add your time complexity here, e.g. $$O(n)$$ -->
$$O(n)$$, trong đó n là độ dài của mảng colors. Chúng ta duyệt qua mảng một lần duy nhất với cửa sổ trượt, và hai phép
kiểm tra cuối cùng cũng chỉ mất thời gian hằng số.

- Space complexity:

<!-- Add your space complexity here, e.g. $$O(n)$$ -->
$$O(1)$$. Chúng ta chỉ sử dụng một số biến cố định (ans, l, r) không phụ thuộc vào kích thước đầu vào.

# Code

```java
class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        if (colors.length < 3) return 0;
        int ans = 0, l = 0, r = 2;
        while (r < colors.length) {
            if (colors[l] == colors[r] && colors[l + 1] != colors[r]) {
                ans++;
            }

            l++;
            r++;
        }

        if (colors[colors.length - 1] != colors[0]
                && colors[1] == colors[colors.length - 1]) {
            ans++;
        }

        if (colors[colors.length - 1] != colors[0]
                && colors[colors.length - 2] == colors[0]) {
            ans++;
        }

        return ans;
    }
}
```

# Link github

https://github.com/nguyenthuanit265/java-leetcode