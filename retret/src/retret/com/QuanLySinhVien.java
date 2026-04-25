package retret.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuanLySinhVien {

	public static void main(String[] args) {
		// Sử dụng ArrayList để lưu trữ tên sinh viên (Slide 37)
		ArrayList<String> dsSV = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int chon;

		do {
			System.out.println("\n========= MENU QUẢN LÝ SINH VIÊN =========");
			System.out.println("a) Thêm Sinh viên");
			System.out.println("b) Xuất danh sách sinh viên");
			System.out.println("c) Sửa Sinh Viên");
			System.out.println("d) Xóa Sinh viên theo tên");
			System.out.println("e) Tìm Sinh viên mà tên có chữ 'An'");
			System.out.println("f) Sắp xếp Sinh Viên");
			System.out.println("g) Xuất ra số lượng sinh viên");
			System.out.println("0) Thoát chương trình");
			System.out.print("Mời bạn chọn chức năng (bấm phím chữ cái hoặc số): ");
			
			// Đọc lựa chọn dưới dạng chuỗi để xử lý các phím a, b, c...
			String input = sc.next();
			chon = input.charAt(0); 
			sc.nextLine(); // Chống trôi lệnh

			switch (chon) {
			case 'a': case '1': // a) Thêm sinh viên
				System.out.print("Nhập tên sinh viên cần thêm: ");
				String tenMoi = sc.nextLine();
				dsSV.add(tenMoi);
				System.out.println("Đã thêm thành công.");
				break;

			case 'b': case '2': // b) Xuất danh sách
				System.out.println("--- Danh sách sinh viên ---");
				for (int i = 0; i < dsSV.size(); i++) {
					System.out.println((i) + ". " + dsSV.get(i));
				}
				break;

			case 'c': case '3': // c) Sửa sinh viên
				System.out.print("Nhập vị trí (số thứ tự) cần sửa: ");
				int indexSua = sc.nextInt();
				sc.nextLine();
				if (indexSua >= 0 && indexSua < dsSV.size()) {
					System.out.print("Nhập lại tên mới: ");
					String tenSua = sc.nextLine();
					dsSV.set(indexSua, tenSua);
					System.out.println("Đã sửa thành công.");
				} else {
					System.out.println("Vị trí không tồn tại.");
				}
				break;

			case 'd': case '4': // d) Xóa theo tên
				System.out.print("Nhập tên chính xác cần xóa: ");
				String tenXoa = sc.nextLine();
				if (dsSV.contains(tenXoa)) {
					dsSV.remove(tenXoa);
					System.out.println("Đã xóa sinh viên: " + tenXoa);
				} else {
					System.out.println("Không tìm thấy tên này trong danh sách.");
				}
				break;

			case 'e': case '5': // e) Tìm tên có chữ "An"
				System.out.println("Các sinh viên có tên chứa chữ 'An':");
				boolean timThay = false;
				for (String s : dsSV) {
					if (s.contains("An")) {
						System.out.println("- " + s);
						timThay = true;
					}
				}
				if (!timThay) System.out.println("Không có sinh viên nào.");
				break;

			case 'f': case '6': // f) Sắp xếp
				Collections.sort(dsSV);
				System.out.println("Đã sắp xếp danh sách theo bảng chữ cái (A-Z).");
				break;

			case 'g': case '7': // g) Xuất số lượng
				System.out.println("Tổng số lượng sinh viên hiện có: " + dsSV.size());
				break;

			case '0':
				System.out.println("Đang thoát...");
				chon = 0;
				break;
			default:
				System.out.println("Chức năng không hợp lệ!");
			}
		} while (chon != 0);
	}
}