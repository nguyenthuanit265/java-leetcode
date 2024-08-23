# Intuition

<!-- Describe your first thoughts on how to solve this problem. -->

Bài toán yêu cầu kiểm tra xem chuỗi s có phải là chuỗi con của chuỗi t hay không. Ý tưởng đầu tiên là duyệt qua chuỗi t
và tìm kiếm các ký tự của chuỗi s theo thứ tự.

# Approach

<!-- Describe your approach to solving the problem. -->

1. Kiểm tra các trường hợp đặc biệt:
    - Nếu s rỗng hoặc null, trả về true (chuỗi rỗng luôn là chuỗi con).
    - Nếu độ dài của s lớn hơn t, trả về false (không thể là chuỗi con).

2. Chuyển đổi cả hai chuỗi thành mảng các ký tự.

3. Sử dụng hai con trỏ:
    - indexS: chỉ mục hiện tại trong chuỗi s
    - indexT: chỉ mục hiện tại trong chuỗi t

4. Duyệt qua chuỗi t:
    - Nếu ký tự hiện tại của t khớp với ký tự hiện tại của s, tăng cả hai con trỏ.
    - Nếu không khớp, chỉ tăng con trỏ của t.
    - Nếu đã tìm thấy tất cả ký tự của s, trả về true.

5. Nếu kết thúc vòng lặp mà chưa tìm thấy tất cả ký tự của s, trả về false.

# Complexity

- Time complexity: $$O(n)$$

<!-- Add your time complexity here, e.g. $$O(n)$$ -->

Trong đó n là độ dài của chuỗi t. Trong trường hợp xấu nhất, chúng ta phải duyệt qua toàn bộ chuỗi t.

- Space complexity: $$O(m + n)$$

<!-- Add your space complexity here, e.g. $$O(n)$$ -->

Trong đó m và n lần lượt là độ dài của chuỗi s và t. Không gian phụ được sử dụng để lưu trữ mảng ký tự của cả hai chuỗi.

# Code

```java
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }

        String[] sArr = s.split("");
        String[] tArr = t.split("");
        int indexS = 0;
        int indexT = 0;
        while (indexT < tArr.length && indexS < sArr.length) {
            if (Objects.equals(tArr[indexT], sArr[indexS])) {
                if (indexS == sArr.length - 1) {
                    return true;
                }
                indexT++;
                indexS++;
            } else {
                indexT++;
            }
        }

        return false;
    }
}
```

# Link github

https://github.com/nguyenthuanit265/java-leetcode