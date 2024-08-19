# Intuition

<!-- Describe your first thoughts on how to solve this problem. -->
Để kiểm tra xem một chuỗi có phải là palindrome hay không, ta cần so sánh các ký tự đối xứng từ hai đầu của chuỗi sau
khi đã loại bỏ các ký tự không phải chữ cái hoặc số và chuyển tất cả về chữ thường.

# Approach

<!-- Describe your approach to solving the problem. -->

Loại bỏ tất cả các ký tự không phải chữ cái hoặc số từ chuỗi đầu vào.
Chuyển chuỗi về chữ thường.
Chuyển chuỗi thành mảng các ký tự.
Sử dụng hai con trỏ (l và r) để so sánh các ký tự đối xứng từ hai đầu mảng.
Nếu tất cả các cặp ký tự đối xứng đều giống nhau, chuỗi là palindrome.

# Complexity

Time complexity: $$O(n)$$

<!-- Add your time complexity here, e.g. $$O(n)$$ -->
Trong đó n là độ dài của chuỗi đầu vào. Mặc dù có nhiều bước xử lý chuỗi, nhưng mỗi bước đều có độ phức tạp O(n).

Space complexity: $$O(n)$$

<!-- Add your space complexity here, e.g. $$O(n)$$ -->
Chúng ta tạo ra một mảng mới từ chuỗi đã xử lý, có độ dài tương đương với số ký tự hợp lệ trong chuỗi gốc.

# Code

```java []
class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        System.out.println(s);
        String[] arr = s.split("");
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            if (!Objects.equals(arr[l++], arr[r--])) {
                return false;
            }
        }

        return true;

    }
}
```

# Link github

https://github.com/nguyenthuanit265/java-leetcode
