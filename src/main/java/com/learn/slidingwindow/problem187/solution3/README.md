# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

Ý tưởng ban đầu là sử dụng kỹ thuật cửa sổ trượt (sliding window) kết hợp với các tập hợp (Set) để theo dõi và xác định các chuỗi con DNA 10 ký tự xuất hiện nhiều hơn một lần. Thay vì sử dụng StringBuilder, chúng ta có thể sử dụng phương thức substring() của String để trích xuất các chuỗi con.

# Approach
<!-- Describe your approach to solving the problem. -->

1. Kiểm tra độ dài chuỗi đầu vào, nếu nhỏ hơn 10, trả về list rỗng.
2. Sử dụng hai Set:
   - `visited`: để lưu trữ tất cả các chuỗi con 10 ký tự đã gặp.
   - `ans`: để lưu trữ các chuỗi con 10 ký tự xuất hiện nhiều hơn một lần.
3. Duyệt qua chuỗi đầu vào, sử dụng cửa sổ trượt có kích thước 10:
   - Trích xuất chuỗi con 10 ký tự hiện tại bằng phương thức substring().
   - Kiểm tra xem chuỗi con đã tồn tại trong `visited` chưa:
      - Nếu có, thêm vào `ans`.
      - Nếu chưa, thêm vào `visited`.
4. Cuối cùng, chuyển `ans` thành ArrayList và trả về.

# Complexity
- Time complexity: $$O(n)$$
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

Trong đó n là độ dài của chuỗi đầu vào. Chúng ta duyệt qua chuỗi một lần duy nhất. Mặc dù phương thức substring() có độ phức tạp O(1) trong Java, nhưng nó tạo ra một đối tượng String mới mỗi lần gọi.

- Space complexity: $$O(min(n, 4^{10}))$$
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

Trong trường hợp xấu nhất, chúng ta có thể lưu trữ tất cả các chuỗi con có thể có (4^10 vì có 4 ký tự DNA và độ dài chuỗi con là 10), nhưng không bao giờ vượt quá n - 9 chuỗi con (với n là độ dài chuỗi đầu vào).

# Code
```java
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int windowSize = 10;
        if (s.length() < windowSize) {
            return Collections.emptyList();
        }
        Set<String> visited = new HashSet<>();
        Set<String> ans = new HashSet<>();

        for (int i = windowSize; i <= s.length(); i++) {
            String sub = s.substring(i - windowSize, i);
            if (visited.contains(sub)) {
                ans.add(sub);
            } else {
                visited.add(sub);
            }
        }

        return new ArrayList<>(ans);
    }
}
```
# Link github

https://github.com/nguyenthuanit265/java-leetcode