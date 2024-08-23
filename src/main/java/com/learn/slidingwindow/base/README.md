Giải thích đoạn mã
1. Khởi tạo và Kiểm Tra Đầu Vào
   if (nums == null || nums.length < k): Kiểm tra điều kiện đầu vào, nếu mảng rỗng hoặc có độ dài nhỏ hơn k, ném một ngoại lệ IllegalArgumentException.
2. Tính Tổng Cửa Sổ Ban Đầu
   int windowSum = 0;: Khởi tạo biến để lưu tổng của cửa sổ hiện tại.
   for (int i = 0; i < k; i++) { windowSum += nums[i]; }: Tính tổng của cửa sổ đầu tiên gồm k phần tử.
3. Cập Nhật Tổng Cửa Sổ và Tính Toán Kết Quả Tối Ưu
   int ans = windowSum;: Khởi tạo giá trị tối ưu với tổng của cửa sổ đầu tiên.
   for (int i = k; i < nums.length; i++): Lặp qua các phần tử từ vị trí k đến hết mảng:
   windowSum = windowSum + nums[i] - nums[i - k];: Cập nhật tổng của cửa sổ bằng cách cộng thêm phần tử mới vào và trừ phần tử cũ ra khỏi cửa sổ.
   ans = Math.max(ans, windowSum);: Cập nhật giá trị tối ưu nếu tổng của cửa sổ hiện tại lớn hơn ans.
4. Trả Về Kết Quả
   return ans;: Trả về giá trị tối ưu nhất (tổng lớn nhất của các cửa sổ).
5. Phương Thức main
   System.out.println(maxSubArraySum(new int[]{2, 1, 5, 1, 3, 2}, 3));: Gọi phương thức maxSubArraySum với mảng [2, 1, 5, 1, 3, 2] và kích thước cửa sổ 3, và in kết quả ra màn hình.