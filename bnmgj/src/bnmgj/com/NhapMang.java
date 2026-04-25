package bnmgj.com;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class NhapMang {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        try {
            // 1. Nhập vào một mảng ngẫu nhiên N số
            System.out.print("Nhập số lượng phần tử N: ");
            int n = Integer.parseInt(sc.nextLine());
            Integer[] a = new Integer[n];

            for (int i = 0; i < n; i++) {
                a[i] = rd.nextInt(100); // Tạo số ngẫu nhiên từ 0-99 [cite: 154]
            }

            // 2. Xuất toàn bộ mảng
            System.out.println("Mảng vừa tạo: " + Arrays.toString(a));

            // 3. Tính tổng mảng
            int tong = 0;
            for (int x : a) tong += x;
            System.out.println("Tổng các phần tử trong mảng: " + tong);

            // 4. Với K nhập từ bàn phím, hỏi K xuất hiện bao nhiêu lần
            System.out.print("Nhập số K cần tìm: ");
            int k = Integer.parseInt(sc.nextLine());
            int countK = 0;
            for (int x : a) {
                if (x == k) countK++; // Dùng vòng lặp for và biến count [cite: 155]
            }
            System.out.println("Số " + k + " xuất hiện " + countK + " lần.");

            // 5. Tìm phần tử lớn nhất và nhỏ nhất
            int max = a[0], min = a[0];
            for (int x : a) {
                if (x > max) max = x;
                if (x < min) min = x;
            }
            System.out.println("Phần tử lớn nhất: " + max);
            System.out.println("Phần tử nhỏ nhất: " + min);

            // 6. Xuất các số nguyên tố trong mảng
            System.out.print("Các số nguyên tố trong mảng: ");
            for (int x : a) {
                if (laSoNguyenTo(x)) System.out.print(x + " ");
            }
            System.out.println();

            // 7. Sắp xếp mảng tăng dần
            Arrays.sort(a); // Dùng Arrays.sort [cite: 158]
            System.out.println("Mảng sắp xếp tăng dần: " + Arrays.toString(a));

            // 8. Sắp xếp mảng giảm dần
            Arrays.sort(a, Collections.reverseOrder()); // Dùng Collections.reverseOrder [cite: 158]
            System.out.println("Mảng sắp xếp giảm dần: " + Arrays.toString(a));

        } catch (NumberFormatException e) {
            // Bắt lỗi nếu nhập chữ thay vì nhập số[cite: 160, 215]
            System.out.println("Lỗi rồi Thái ơi! Vui lòng nhập số nguyên thôi nhé.");
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra: " + e.getMessage());
        } finally {
            // Luôn luôn đóng Scanner để giải phóng bộ nhớ[cite: 203, 222]
            sc.close();
            System.out.println("--- Kết thúc chương trình ---");
        }
    }

    // Hàm kiểm tra số nguyên tố (lớn hơn 1 và chỉ chia hết cho 1 và chính nó) [cite: 156, 157]
    public static boolean laSoNguyenTo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}