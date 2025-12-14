package com.learn2;

public class MainApp {
    /*
    * Giả sử bạn cần thiết kế một Bộ nhớ đệm (Cache) cho một dịch vụ có tần suất truy cập cao. Dung lượng bộ nhớ đệm là hạn chế (chỉ có thể chứa tối đa $M$ đối tượng).
Khi một yêu cầu truy cập đến, nếu dữ liệu đã có trong Cache (Cache Hit), ta trả về ngay. Nếu dữ liệu không có (Cache Miss), ta phải tải dữ liệu về, lưu vào Cache và trả về.
Yêu cầu: Thiết kế cấu trúc dữ liệu và thuật toán cho Bộ nhớ đệm này để nó có thể tự động ưu tiên những đối tượng thường xuyên được truy cập và những đối tượng có chi phí tải lại cao.
Mỗi đối tượng (Key) có hai thuộc tính quan trọng:
Chi phí Tải lại ($Cost$): Chi phí (ví dụ: thời gian mili giây, hoặc lượng tài nguyên) để tải lại đối tượng này từ nguồn chính khi nó bị trục xuất khỏi Cache.
Tần suất Truy cập Gần đây ($Frequency$): Số lần đối tượng này được truy cập trong một khoảng thời gian gần nhất (ví dụ: 5 phút qua).
Khi Cache đầy và có yêu cầu thêm một đối tượng mới, bạn phải quyết định đẩy đối tượng nào ra khỏi Cache để tối đa hóa hiệu suất chung của hệ thống.
    *
    *
    *
    * */

//    Class entry <V>: V value, reloadCost, frequency, lastAccessTime
    // Class cache: Map<K, CacheEntry<V>> cache
//    method: get, add,

    public static void main(String[] args) {

    }
}
