public class Main {
    public static void main(String[] args) {
        IntStack stack = new IntStack();

        // Thêm một số phần tử vào ngăn xếp
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Hiển thị các phần tử trong ngăn xếp
        System.out.println("Ngăn xếp:");
        stack.traverse();

        // Lấy và loại bỏ phần tử đỉnh
        System.out.println("Phần tử đỉnh: " + stack.pop());

        // Kiểm tra ngăn xếp rỗng hay không
        System.out.println("Ngăn xếp rỗng? " + stack.isEmpty());

        // Xóa tất cả phần tử trong ngăn xếp
        stack.clear();

        // Chuyển đổi số nguyên sang hệ nhị phân
        int decimal = 2024;
        String binary = stack.toBinary(decimal);
        System.out.println(decimal + " trong hệ nhị phân: " + binary);

        // Đảo ngược chuỗi ký tự
        String str = "CNTT";
        String reversedStr = stack.reverseString(str);
        System.out.println("Chuỗi đảo ngược: " + reversedStr);
    }
}
