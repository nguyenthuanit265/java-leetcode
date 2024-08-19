# Intuition

<!-- Describe your first thoughts on how to solve this problem. -->
Để tìm lợi nhuận tối đa từ việc mua và bán cổ phiếu, ta có thể xem xét tất cả các cặp giá (mua vào và bán ra) có thể và
tìm ra sự chênh lệch lớn nhất.

# Approach

<!-- Describe your approach to solving the problem. -->

Sử dụng hai vòng lặp lồng nhau để xem xét tất cả các cặp giá có thể.
Vòng lặp ngoài (i) đại diện cho ngày mua.
Vòng lặp trong (j) đại diện cho ngày bán, luôn sau ngày mua.
Tính chênh lệch giá giữa ngày bán và ngày mua.
Cập nhật lợi nhuận tối đa (ans) nếu tìm thấy chênh lệch lớn hơn.

# Complexity

Time complexity:

<!-- Add your time complexity here, e.g. $$O(n)$$ -->
$$O(n^2)$$, trong đó n là số ngày (độ dài của mảng prices). Điều này là do ta sử dụng hai vòng lặp lồng nhau, mỗi vòng
lặp có thể duyệt qua tối đa n phần tử.

Space complexity:

<!-- Add your space complexity here, e.g. $$O(n)$$ -->
$$O(1)$$, vì ta chỉ sử dụng một số biến phụ trợ (ans, i, j) không phụ thuộc vào kích thước đầu vào.

# Code

```
public static int maxProfit(int[] prices) {
    int ans = 0;
    for (int i = 0; i < prices.length; i++) {
        for (int j = i + 1; j < prices.length; j++) {
            if (prices[j] - prices[i] > ans) {
                ans = prices[j] - prices[i];
            }
        }
    }
    return ans;
}
```

# Another solution

sử dụng thuật toán Kadane hoặc một lần quét duy nhất qua mảng, theo dõi giá thấp nhất đã thấy và tính toán lợi nhuận tối
đa có thể tại mỗi bước. Điều này sẽ giảm độ phức tạp thời gian xuống O(n)

# Link github

https://github.com/nguyenthuanit265/java-leetcode