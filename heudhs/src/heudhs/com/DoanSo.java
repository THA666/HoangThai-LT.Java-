package heudhs.com;

import java.util.Random;
import java.util.Scanner;

public class DoanSo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String choice = "";

        do {
            int secretNum = random.nextInt(101); // Máy chọn số từ 0-100
            int attempts = 0;
            int maxAttempts = 7;
            boolean isWin = false;

            System.out.println("\n--- CHÀO MỪNG BẠN ĐẾN VỚI GAME ĐOÁN SỐ ---");
            System.out.println("Máy đã chọn 1 số ngẫu nhiên. Bạn có 7 lượt để thử vận may!");

            while (attempts < maxAttempts) {
                System.out.print("Lượt " + (attempts + 1) + " - Bạn đoán số mấy: ");
                
                // --- BẮT ĐẦU KHỐI XỬ LÝ BIỆT LỆ (EXCEPTION) ---
                try {
                    String input = scanner.next();
                    int guess = Integer.parseInt(input); // Chuyển chuỗi sang số, dễ lỗi nếu nhập chữ
                    
                    attempts++; 

                    if (guess == secretNum) {
                        System.out.println("Đỉnh quá bạn ơi! Trúng phóc số " + secretNum + " rồi.");
                        isWin = true;
                        break;
                    } else if (guess < secretNum) {
                        System.out.println("Số bạn đoán hơi THẤP rồi, máy chọn số cao hơn.");
                    } else {
                        System.out.println("Số bạn đoán hơi CAO rồi, máy chọn số thấp hơn.");
                    }
                    
                } catch (Exception ex) {
                    // Nếu nhập chữ hoặc ký tự lạ, catch sẽ "hứng" lỗi ở đây
                    System.out.println("Lỗi rồi: Nhập số nguyên thôi bạn ơi! Đừng nhập chữ.");
                    // ex.printStackTrace();
                } finally {
                    
                }
                // --- KẾT THÚC KHỐI XỬ LÝ BIỆT LỆ ---
            }

            if (!isWin) {
                System.out.println("Hết lượt rồi bạn ơi! Game Over. Số đúng là: " + secretNum);
            }

            System.out.print("\nBạn có muốn phục thù không? (C để tiếp tục): ");
            choice = scanner.next();

        } while (choice.equalsIgnoreCase("C"));

        System.out.println("Tạm biệt bạn! Hẹn gặp lại nhé.");
        scanner.close();
    }
}
