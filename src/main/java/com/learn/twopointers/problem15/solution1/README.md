# Intuition

<!-- Describe your first thoughts on how to solve this problem. -->
Để tìm tất cả các bộ ba số có tổng bằng 0, chúng ta có thể sắp xếp mảng đầu vào và sử dụng phương pháp two pointers kết
hợp với một vòng lặp bên ngoài. Việc sắp xếp mảng cho phép chúng ta tránh được các bộ ba trùng lặp và tối ưu hóa quá
trình tìm kiếm.

# Approach

<!-- Describe your approach to solving the problem. -->

Sắp xếp mảng đầu vào.
Sử dụng một Set để lưu trữ các bộ ba kết quả, tránh trùng lặp.
Duyệt qua mảng với index i:

Với mỗi i, sử dụng two pointers (l và r) để tìm hai số còn lại.
l bắt đầu từ i+1, r bắt đầu từ cuối mảng.
Di chuyển l và r dựa trên tổng của ba số tại i, l, và r.
Nếu tổng bằng 0, thêm bộ ba vào Set kết quả.

Chuyển đổi Set thành List và trả về kết quả.

# Complexity

Time complexity: $$O(n^2)$$

<!-- Add your time complexity here, e.g. $$O(n)$$ -->
Sắp xếp mảng mất O(n log n). Vòng lặp ngoài chạy n lần, và với mỗi lần, two pointers có thể duyệt qua tối đa n phần tử.
Do đó, tổng độ phức tạp là O(n^2).

Space complexity: $$O(n)$$

<!-- Add your space complexity here, e.g. $$O(n)$$ -->
Trong trường hợp xấu nhất, Set có thể chứa O(n^2) bộ ba (mặc dù điều này hiếm khi xảy ra). Tuy nhiên, không gian bổ sung
được sử dụng để lưu trữ kết quả không tính vào độ phức tạp không gian của thuật toán. Do đó, độ phức tạp không gian thực
tế là O(n) cho việc sắp xếp (tùy thuộc vào thuật toán sắp xếp được sử dụng).

# Code

```java []
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                } else {
                    ans.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
```

# Link github

https://github.com/nguyenthuanit265/java-leetcode