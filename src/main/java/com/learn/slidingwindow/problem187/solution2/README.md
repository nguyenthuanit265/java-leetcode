# Intuition

<!-- Describe your first thoughts on how to solve this problem. -->

Ý tưởng ban đầu là sử dụng kỹ thuật cửa sổ trượt (sliding window) kết hợp với một map để theo dõi các chuỗi con đã xuất
hiện. Chúng ta có thể duyệt qua chuỗi, tạo các chuỗi con 10 ký tự và kiểm tra sự xuất hiện của chúng.

# Approach

<!-- Describe your approach to solving the problem. -->

1. Kiểm tra độ dài chuỗi đầu vào, nếu nhỏ hơn 10, trả về list rỗng.
2. Sử dụng một HashMap để lưu trữ các chuỗi con đã gặp và số lần xuất hiện của chúng.
3. Sử dụng một HashSet để lưu trữ các chuỗi con xuất hiện nhiều hơn một lần (kết quả cuối cùng).
4. Sử dụng StringBuilder để xây dựng và cập nhật chuỗi con hiện tại một cách hiệu quả.
5. Duyệt qua chuỗi đầu vào:
    - Ban đầu, xây dựng chuỗi con đầu tiên có độ dài 10.
    - Sau đó, sử dụng kỹ thuật cửa sổ trượt để tạo các chuỗi con tiếp theo.
    - Với mỗi chuỗi con, kiểm tra xem nó đã tồn tại trong map chưa:
        - Nếu có, thêm vào set kết quả.
        - Nếu chưa, thêm vào map.
6. Cuối cùng, chuyển set kết quả thành ArrayList và trả về.

# Complexity

- Time complexity: $$O(n)$$

<!-- Add your time complexity here, e.g. $$O(n)$$ -->

Trong đó n là độ dài của chuỗi đầu vào. Chúng ta duyệt qua chuỗi một lần duy nhất.

- Space complexity: $$O(min(n, 4^{10}))$$

<!-- Add your space complexity here, e.g. $$O(n)$$ -->

Trong trường hợp xấu nhất, chúng ta có thể lưu trữ tất cả các chuỗi con có thể có (4^10 vì có 4 ký tự DNA và độ dài
chuỗi con là 10), nhưng không bao giờ vượt quá n - 9 chuỗi con (với n là độ dài chuỗi đầu vào).

# Code

```java
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int windowSize = 10;
        if (s.length() < windowSize) {
            return Collections.emptyList();
        }
        Map<String, Integer> map = new HashMap<>();
        Set<String> ans = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        String[] sArr = s.split("");
        for (int i = 0; i < windowSize; i++) {
            builder.append(sArr[i]);
        }
        map.put(builder.toString(), 1);

        for (int i = windowSize; i < sArr.length; i++) {
            builder.append(sArr[i]);
            builder.deleteCharAt(0);
            if (map.containsKey(builder.toString())) {
                ans.add(builder.toString());
            } else {
                map.put(builder.toString(), 1);
            }
        }

        return new ArrayList<>(ans);
    }
}
```

# Link github

https://github.com/nguyenthuanit265/java-leetcode