# Intuition

<!-- Describe your first thoughts on how to solve this problem. -->

Bài toán yêu cầu kiểm tra xem chuỗi s có phải là chuỗi con của chuỗi t hay không. Ý tưởng đầu tiên là duyệt qua chuỗi t
và tìm kiếm các ký tự của chuỗi s theo thứ tự.

# Approach

<!-- Describe your approach to solving the problem. -->

Chúng ta có thể sử dụng kỹ thuật hai con trỏ để giải quyết bài toán này:

1. Khởi tạo một chỉ số để theo dõi vị trí của chúng ta trong chuỗi `s`.
2. Duyệt qua từng ký tự trong chuỗi `t`.
3. Mỗi khi một ký tự trong `t` khớp với ký tự hiện tại trong `s` (được chỉ định bởi chỉ số của chúng ta), di chuyển chỉ
   số về phía trước.
4. Nếu chỉ số đạt đến độ dài của `s`, điều đó có nghĩa là tất cả các ký tự của `s` đã được tìm thấy trong `t` theo thứ
   tự, vì vậy trả về `true`.
5. Nếu vòng lặp hoàn thành mà không tìm thấy tất cả các ký tự của `s`, trả về `false`.

# Complexity

- Độ phức tạp thời gian: $$O(n)$$
    - Trong đó `n` là độ dài của chuỗi `t`. Chúng ta duyệt qua từng ký tự của `t` một lần.

- Độ phức tạp không gian: $$O(1)$$
    - Chúng ta sử dụng một lượng không gian bổ sung không đổi bất kể kích thước của các chuỗi đầu vào.

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