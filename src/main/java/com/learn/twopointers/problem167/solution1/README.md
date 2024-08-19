# Intuition

<!-- Describe your first thoughts on how to solve this problem. -->
Cách tiếp cận đầu tiên để giải quyết vấn đề này là sử dụng phương pháp brute force. Chúng ta có thể kiểm tra tất cả các
cặp số có thể trong mảng để tìm ra cặp số có tổng bằng target.

# Approach

<!-- Describe your approach to solving the problem. -->

Sử dụng hai vòng lặp lồng nhau để xem xét tất cả các cặp số có thể.
Vòng lặp ngoài (i) bắt đầu từ phần tử đầu tiên.
Vòng lặp trong (j) bắt đầu từ phần tử ngay sau i.
Kiểm tra xem tổng của numbers[i] và numbers[j] có bằng target không.
Nếu tìm thấy cặp số thỏa mãn, trả về mảng chứa chỉ số của hai số đó (cộng thêm 1 vì đề bài yêu cầu chỉ số bắt đầu từ 1).
Nếu không tìm thấy cặp số nào, trả về mảng rỗng.

# Complexity

Time complexity: $$O(n^2)$$

<!-- Add your time complexity here, e.g. $$O(n)$$ -->
Thuật toán sử dụng hai vòng lặp lồng nhau, mỗi vòng lặp có thể duyệt qua tối đa n phần tử, trong đó n là độ dài của mảng
numbers.

Space complexity: $$O(1)$$

<!-- Add your space complexity here, e.g. $$O(n)$$ -->
Thuật toán chỉ sử dụng một số biến phụ trợ và một mảng kết quả có kích thước cố định, không phụ thuộc vào kích thước đầu
vào.

# Code

```
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return new int[]{};
    }
}
```

# Another solution

Một cách tiếp cận hiệu quả hơn là sử dụng phương pháp hai con trỏ, với một con trỏ ở đầu mảng và một con trỏ ở cuối
mảng, di chuyển các con trỏ dựa trên tổng của các phần tử tại vị trí đó. Điều này sẽ giảm độ phức tạp thời gian xuống O(
n).

# Link github

https://github.com/nguyenthuanit265/java-leetcode