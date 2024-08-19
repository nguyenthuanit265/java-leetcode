# Intuition

<!-- Describe your first thoughts on how to solve this problem. -->
Để tìm lợi nhuận tối đa từ việc mua và bán cổ phiếu, chúng ta cần tìm ra sự chênh lệch lớn nhất giữa giá mua thấp nhất
và giá bán cao nhất sau đó. Thay vì xem xét tất cả các cặp giá có thể, chúng ta có thể duyệt qua mảng một lần, liên tục
cập nhật giá mua thấp nhất và tính toán lợi nhuận tiềm năng tại mỗi bước.

# Approach

<!-- Describe your approach to solving the problem. -->

Khởi tạo biến minPrice với giá trị lớn nhất có thể để đảm bảo giá đầu tiên sẽ được gán cho nó.
Khởi tạo biến maxProfit để lưu lợi nhuận tối đa, ban đầu là 0.
Duyệt qua mảng giá:

Nếu giá hiện tại thấp hơn minPrice, cập nhật minPrice.
Ngược lại, tính lợi nhuận tiềm năng bằng cách trừ minPrice từ giá hiện tại và cập nhật maxProfit nếu lợi nhuận này lớn
hơn maxProfit hiện tại.

Sau khi duyệt qua tất cả các phần tử, trả về maxProfit.

# Complexity

Time complexity: $$O(n)$$

<!-- Add your time complexity here, e.g. $$O(n)$$ -->
Thuật toán duyệt qua mảng một lần, trong đó n là số phần tử của mảng prices.

Space complexity: $$O(1)$$

<!-- Add your space complexity here, e.g. $$O(n)$$ -->
Thuật toán chỉ sử dụng một số biến phụ trợ (minPrice, maxProfit) không phụ thuộc vào kích thước đầu vào.

# Code

```
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }

        return maxProfit;
    }
}
```

# Link github

https://github.com/nguyenthuanit265/java-leetcode