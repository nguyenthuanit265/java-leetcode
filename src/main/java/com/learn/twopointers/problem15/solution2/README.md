# Intuition

<!-- Describe your first thoughts on how to solve this problem. -->
Để giải quyết bài toán 3Sum, ta có thể sắp xếp mảng đầu vào và sử dụng kỹ thuật two pointers kết hợp với một vòng lặp
ngoài. Việc sử dụng Set giúp loại bỏ các bộ ba trùng lặp một cách tự động.

# Approach

<!-- Describe your approach to solving the problem. -->

Sắp xếp mảng đầu vào để có thể áp dụng kỹ thuật two pointers.
Duyệt qua mảng với index i.
Với mỗi i, sử dụng two pointers (l và r) để tìm hai số còn lại.
Di chuyển l và r dựa trên tổng của ba số tại i, l, và r.
Khi tìm thấy một bộ ba có tổng bằng 0, thêm vào Set kết quả.
Để tối ưu, bỏ qua các giá trị trùng lặp cho l và r.
Cuối cùng, chuyển Set thành List để trả về kết quả.

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
    public static List<List<Integer>> threeSum(int[] nums) {
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

                    // Bỏ qua các giá trị trùng lặp cho left và right
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
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