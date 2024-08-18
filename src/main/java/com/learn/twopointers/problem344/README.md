# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Để đảo ngược một chuỗi, ta có thể sử dụng phương pháp "hai con trỏ", trong đó một con trỏ bắt đầu từ đầu chuỗi và con trỏ kia bắt đầu từ cuối chuỗi. Sau đó, ta hoán đổi các ký tự tại hai vị trí này và di chuyển các con trỏ vào trong cho đến khi chúng gặp nhau.
# Approach
<!-- Describe your approach to solving the problem. -->

Kiểm tra nếu chuỗi rỗng, không cần thực hiện đảo ngược.
Khởi tạo hai con trỏ: begin ở đầu chuỗi và end ở cuối chuỗi.
Lặp lại quá trình sau cho đến khi begin < end:

Hoán đổi ký tự tại vị trí begin và end.
Tăng begin lên 1 và giảm end xuống 1.


Kết thúc quá trình khi hai con trỏ gặp nhau hoặc vượt qua nhau.

# Complexity

Time complexity: $$O(n)$$

<!-- Add your time complexity here, e.g. $$O(n)$$ -->
Thuật toán duyệt qua một nửa chuỗi, trong đó n là độ dài của chuỗi. Do đó, độ phức tạp thời gian là O(n/2), được đơn giản hóa thành O(n).

Space complexity: $$O(1)$$

<!-- Add your space complexity here, e.g. $$O(n)$$ -->
Thuật toán chỉ sử dụng một số biến phụ trợ (begin, end, temp) không phụ thuộc vào kích thước đầu vào. Việc đảo ngược được thực hiện trực tiếp trên mảng đầu vào mà không cần thêm bộ nhớ phụ.
# Code
```
class Solution {
    public void reverseString(char[] s) {
        if (s.length == 0) {
            return;
        }
        int begin = 0;
        int end = s.length - 1;
        int size = s.length - 1;
        for (begin = 0; begin < end; ) {
            char temp = s[begin];
            s[begin++] = s[end];
            s[end--] = temp;
        }
    }
}
```

# Link github
https://github.com/nguyenthuanit265/java-leetcode
