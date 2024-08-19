# Intuition

<!-- Describe your first thoughts on how to solve this problem. -->
Để giải quyết vấn đề loại bỏ các phần tử trùng lặp quá 2 lần trong mảng, ta có thể sử dụng một Map để đếm số lần xuất
hiện của mỗi phần tử và một List để lưu trữ các phần tử sau khi xử lý.

# Approach

<!-- Describe your approach to solving the problem. -->
Sử dụng HashMap để đếm số lần xuất hiện của mỗi phần tử trong mảng.
Sử dụng ArrayList để lưu trữ các phần tử của mảng.
Duyệt qua Map để loại bỏ các phần tử xuất hiện quá 2 lần khỏi ArrayList.
Cập nhật lại mảng gốc từ ArrayList đã xử lý.
Điền số 0 vào các vị trí cuối mảng tương ứng với số phần tử đã bị loại bỏ.

# Complexity

Time complexity:

<!-- Add your time complexity here, e.g. $$O(n)$$ -->
$$O(n)$$, trong đó n là số phần tử của mảng đầu vào.

Space complexity:

<!-- Add your space complexity here, e.g. $$O(n)$$ -->
$$O(n)$$, do sử dụng thêm HashMap và ArrayList để lưu trữ.

# Code

```
class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> listNums = new ArrayList<>();
        int ans = 0;
        int size = nums.length;
        for (int e : nums) {
            listNums.add(e);
            if (map.containsKey(e)) {
                map.put(e, map.get(e).intValue() + 1);
            } else {
                map.put(e, 1);
            }
        }


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 2) {
                for (int i = 1; i <= entry.getValue() - 2; i++) {
                    listNums.remove(entry.getKey());
                    ans += 1;
                }
            }
        }

        for (int i = 0; i < listNums.size(); i++) {
            nums[i] = listNums.get(i);
        }

        for (int i = 1, j = 0; i <= ans; i++) {
            nums[(size - 1) - j] = 0;
            j++;
        }

        return (size - ans);
    }
}
```

# Link github

https://github.com/nguyenthuanit265/java-leetcode