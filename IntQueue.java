import java.util.EmptyStackException;

class IntQueue {

    private int[] arr; // Mang lưu trữ các phần tử
    private int front; // Vị trí phần tử đầu tiên
    private int rear; // Vị trí phần tử cuối cùng

    public IntQueue() {
        arr = new int[10]; // Khởi tạo mảng với kích thước ban đầu là 10
        front = 0;
        rear = 0;
    }

    // Kiểm tra hàng đợi rỗng hay không
    public boolean isEmpty() {
        return front == rear;
    }

    // Xóa tất cả phần tử trong hàng đợi
    public void clear() {
        front = rear = 0;
    }

    // Thêm phần tử vào cuối hàng đợi
    public void enqueue(int x) {
        if (rear == arr.length) {
            // Mở rộng mảng nếu cần thiết
            int[] newArr = new int[arr.length * 2];
            System.arraycopy(arr, front, newArr, 0, rear - front);
            arr = newArr;
            front = 0;
        }
        arr[rear++] = x;
    }

    // Lấy và loại bỏ phần tử đầu tiên trong hàng đợi
    public int dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int val = arr[front++];
        if (front == rear) {
            front = rear = 0; // Xóa hoàn toàn nếu chỉ còn 1 phần tử
        }
        return val;
    }

    // Lấy giá trị của phần tử đầu tiên trong hàng đợi
    public int first() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[front];
    }

    // Duyệt và hiển thị tất cả các giá trị trong hàng đợi
    public void traverse() {
        if (isEmpty()) {
            System.out.println("Hàng đợi rỗng!");
            return;
        }

        for (int i = front; i < rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Chuyển đổi số thực sang hệ nhị phân
    public String toBinary(double decimal) {
        IntQueue queue = new IntQueue();

        while (decimal > 0) {
            queue.enqueue((int) Math.floor(decimal % 2));
            decimal = Math.floor(decimal / 2);
        }

        StringBuilder binary = new StringBuilder();
        while (!queue.isEmpty()) {
            binary.append(queue.dequeue());
        }

        return binary.toString();
    }
}

// public class Main {
//     public static void main(String[] args) {
//         IntQueue queue = new IntQueue();

//         // Thêm một số phần tử vào hàng đợi
//         queue.enqueue(10);
//         queue.enqueue(20);
//         queue.enqueue(30);

//         // Hiển thị các phần tử trong hàng đợi
//         System.out.println("Hàng đợi:");
//         queue.traverse();

//         // Lấy và loại bỏ phần tử đầu tiên
//         System.out.println("Phần tử đầu tiên: " + queue.dequeue());

//         // Kiểm tra hàng đợi rỗng hay không
//         System.out.println("Hàng đợi rỗng? " + queue.isEmpty());

//         // Xóa tất cả phần tử trong hàng đợi
//         queue.clear();

//         // Chuyển đổi số thực sang hệ nhị phân
//         double decimal = 5.25;
//         String binary = queue.toBinary(decimal);
//         System.out.println(decimal + " trong hệ nhị phân: " + binary);
//     }
// }
