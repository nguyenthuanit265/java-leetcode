# Intuition

Bài toán yêu cầu đồng bộ hóa việc thực thi ba phương thức để chúng luôn chạy theo thứ tự first, second, third. Sử dụng
một biến trạng thái và cơ chế chờ đợi tích cực (busy-waiting) có thể giải quyết vấn đề này.

# Approach

1. Sử dụng một biến flag volatile để đánh dấu trạng thái hiện tại của quá trình thực thi.
2. Phương thức first() thực thi ngay lập tức, in thông báo đang chạy, và sau đó đặt flag = 2.
3. Phương thức second() sử dụng vòng lặp while để chờ cho đến khi flag = 2, in thông báo đang chờ trong quá trình này.
   Khi điều kiện thỏa mãn, nó thực thi, in thông báo đang chạy, và đặt flag = 3.
4. Phương thức third() cũng sử dụng vòng lặp while để chờ cho đến khi flag = 3, in thông báo đang chờ. Khi điều kiện
   thỏa mãn, nó thực thi và in thông báo đang chạy.
5. Sử dụng volatile để đảm bảo tính nhất quán của biến flag giữa các luồng.

# Complexity

- Time Complexity:
    - $$O(1)$$ cho first()
    - $$O(n)$$ cho second() và third() trong trường hợp xấu nhất, với n là số lần lặp trong vòng lặp while
    - Trong trường hợp tốt nhất, tất cả đều là $$O(1)$$

- Space Complexity: $$O(1)$$
  Chỉ sử dụng một biến flag cố định, không phụ thuộc vào input.

# Mã nguồn

```java
class Foo {
    private volatile int flag = 1;

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        System.out.println("[first] Running");
        printFirst.run();
        flag = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (flag != 2) {
            System.out.println("[second] Waiting");
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        System.out.println("[second] Running");
        printSecond.run();
        flag = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (flag != 3) {
            System.out.println("[third] Waiting");
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        System.out.println("[third] Running");
        printThird.run();
    }
}
```

# Link github

https://github.com/nguyenthuanit265/java-leetcode