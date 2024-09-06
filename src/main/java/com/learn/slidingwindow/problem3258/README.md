# Intuition

Bài toán yêu cầu đếm số lượng substring thỏa mãn điều kiện K. Ta có thể sử dụng kỹ thuật cửa sổ trượt (sliding window)
để giải quyết vấn đề này một cách hiệu quả.

# Approach

Sử dụng hai con trỏ left và right để định nghĩa cửa sổ trượt.
Di chuyển con trỏ right để mở rộng cửa sổ, đồng thời đếm số lượng ký tự '0' và '1'.
Khi số lượng cả '0' và '1' vượt quá K, ta thu hẹp cửa sổ bằng cách di chuyển con trỏ left.
Tại mỗi bước, ta cộng dồn số lượng substring hợp lệ (right - left + 1) vào kết quả.
Tiếp tục quá trình cho đến khi duyệt hết chuỗi.

# Complexity

Time complexity: $$O(n)$$
Trong đó n là độ dài của chuỗi s. Ta duyệt qua chuỗi một lần với hai con trỏ.
Space complexity: $$O(1)$$
Ta chỉ sử dụng một số biến để lưu trữ trạng thái, không phụ thuộc vào kích thước đầu vào.

# Code

```java
class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        if (k <= 0) {
            return 0;
        }
        int left = 0, right = 0, ans = 0, count0 = 0, count1 = 0;
        while (right < s.length()) {
            if (s.charAt(right) == '0') {
                count0++;
            } else if (s.charAt(right) == '1') {
                count1++;
            }
            while (count0 > k && count1 > k) {
                if (s.charAt(left) == '0') {
                    count0--;
                } else if (s.charAt(left) == '1') {
                    count1--;
                }
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}
```

# Link github

https://github.com/nguyenthuanit265/java-leetcode