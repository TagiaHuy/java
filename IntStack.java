import java.util.EmptyStackException;

class IntStack {

    private int[] arr; // Mảng lưu trữ các phần tử
    private int top; // Vị trí phần tử đỉnh

    public IntStack() {
        arr = new int[10]; // Khởi tạo mảng với kích thước ban đầu là 10
        top = 0;
    }

    // Kiểm tra ngăn xếp rỗng hay không
    public boolean isEmpty() {
        return top == 0;
    }

    // Xóa tất cả phần tử trong ngăn xếp
    public void clear() {
        top = 0;
    }

    // Thêm phần tử vào đỉnh ngăn xếp
    public void push(int x) {
        if (top == arr.length) {
            // Mở rộng mảng nếu cần thiết
            int[] newArr = new int[arr.length * 2];
            System.arraycopy(arr, 0, newArr, 0, top);
            arr = newArr;
        }
        arr[top++] = x;
    }

    // Lấy và loại bỏ phần tử ở đỉnh ngăn xếp
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[--top];
    }

    // Lấy giá trị của phần tử ở đỉnh ngăn xếp
    public int top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top - 1];
    }

    // Duyệt và hiển thị tất cả các phần tử trong ngăn xếp
    public void traverse() {
        if (isEmpty()) {
            System.out.println("Ngăn xếp rỗng!");
            return;
        }

        for (int i = top - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Chuyển đổi số nguyên sang hệ nhị phân
    public String toBinary(int n) {
        IntStack stack = new IntStack();

        while (n > 0) {
            stack.push(n % 2);
            n /= 2;
        }

        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        return binary.toString();
    }

    // Đảo ngược chuỗi ký tự
    public String reverseString(String s) {
        IntStack stack = new IntStack();

        for (char c : s.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append((char) stack.pop());
        }

        return reversed.toString();
    }
}

