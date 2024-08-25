# Intuition

Vấn đề yêu cầu tìm tất cả các tập hợp bốn số khác nhau trong một mảng sao cho tổng của chúng bằng mục tiêu cho trước. Ý
tưởng đầu tiên của tôi là sử dụng phương pháp hai con trỏ kết hợp với sắp xếp. Phương pháp này bao gồm việc cố định hai
phần tử và sau đó sử dụng hai con trỏ để tìm hai phần tử còn lại sao cho tổng của chúng cộng với các phần tử đã cố định
bằng mục tiêu.

# Approach

1. **Sắp xếp Mảng**:
    - Sắp xếp mảng `nums` để dễ dàng bỏ qua các phần tử trùng lặp và sử dụng kỹ thuật hai con trỏ. Sắp xếp giúp việc so
      sánh và điều chỉnh con trỏ dễ dàng hơn.

2. **Lặp Qua Các Phần Tử**:
    - Sử dụng hai vòng lặp lồng nhau để cố định hai phần tử đầu tiên của bộ bốn số.
    - Vòng lặp ngoài (vòng lặp `i`) chọn phần tử đầu tiên, và vòng lặp trong (vòng lặp `j`) chọn phần tử thứ hai.

3. **Sử Dụng Kỹ Thuật Hai Con Trỏ**:
    - Khởi tạo hai con trỏ `l` và `r`, với `l` bắt đầu từ phần tử ngay sau `j` và `r` bắt đầu từ cuối mảng.
    - Tính tổng của bốn phần tử: `nums[i]`, `nums[j]`, `nums[l]`, và `nums[r]`.
    - Nếu tổng nhỏ hơn mục tiêu, tăng con trỏ trái `l` để tăng tổng.
    - Nếu tổng lớn hơn mục tiêu, giảm con trỏ phải `r` để giảm tổng.
    - Nếu tổng bằng mục tiêu, lưu kết quả vào `Set` để đảm bảo tính duy nhất và di chuyển cả hai con trỏ để tìm các kết
      quả khác.

4. **Tránh Phần Tử Trùng Lặp**:
    - Khi tìm thấy một bộ bốn số hợp lệ, tiếp tục di chuyển con trỏ `l` và `r` để bỏ qua các phần tử trùng lặp.
    - Sử dụng vòng lặp để tăng `l` khi phần tử `nums[l]` trùng lặp với phần tử tiếp theo, và giảm `r` khi phần tử
      `nums[r]` trùng lặp với phần tử trước đó.

5. **Chuyển Đổi Kết Quả**:
    - Chuyển đổi `Set` chứa các bộ bốn số duy nhất thành `ArrayList` và trả về kết quả.

# Complexity

- Thời gian: $$O(n^3)$$
    - Sắp xếp mất $$O(n \log n)$$.
    - Các vòng lặp lồng nhau mất $$O(n^2)$$.
    - Mỗi lần lặp qua tìm kiếm hai con trỏ mất $$O(n)$$, nên độ phức tạp tổng thể là $$O(n^3)$$.

- Không gian: $$O(n)$$
    - Độ phức tạp không gian chủ yếu do việc lưu trữ kết quả trong một `Set`.

# Code

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[l] + (long) nums[r];

                    if (sum < target) {
                        l++;
                    } else if (sum > target) {
                        r--;
                    } else {
                        ans.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                    }
                }
            }
        }

        return new ArrayList<>(ans);
    }
}
```

# Link github

https://github.com/nguyenthuanit265/java-leetcode