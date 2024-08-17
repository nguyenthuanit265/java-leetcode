# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Để tìm phần tử xuất hiện nhiều hơn n/2 lần trong mảng (phần tử đa số), ta có thể sử dụng một Map để đếm số lần xuất hiện của mỗi phần tử, sau đó tìm phần tử có số lần xuất hiện lớn nhất và thỏa mãn điều kiện.

# Approach
<!-- Describe your approach to solving the problem. -->

Sử dụng HashMap để đếm số lần xuất hiện của mỗi phần tử trong mảng.
Khởi tạo biến ans với giá trị là phần tử đầu tiên của mảng.
Duyệt qua Map để tìm phần tử có số lần xuất hiện lớn hơn n/2 và lớn nhất.
Cập nhật ans nếu tìm thấy phần tử thỏa mãn điều kiện.

# Complexity

Time complexity:

<!-- Add your time complexity here, e.g. $$O(n)$$ -->
$$O(n)$$, trong đó n là số phần tử của mảng đầu vào.

Space complexity:

<!-- Add your space complexity here, e.g. $$O(n)$$ -->
$$O(n)$$, trong trường hợp xấu nhất khi tất cả các phần tử đều khác nhau.
# Code
```
class Solution {
    public int majorityElement(int[] nums) {
       Map<Integer, Integer> map = new HashMap<>();
        int ans = nums[0];
        for (int e : nums) {
            if (map.containsKey(e)) {
                map.put(e, map.get(e) + 1);
            } else {
                map.put(e, 1);
            }
        }

        int temp = map.get(nums[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (nums.length / 2) && entry.getValue() > temp) {
                ans = entry.getKey();
            }
        }

        return ans; 
    }
}
```