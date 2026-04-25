package ghjih.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NhapSoNguyenLuu {

	public static void main(String[] args) {
		// Khai báo ArrayList lưu số nguyên (Slide 37)
		ArrayList<Integer> dsSo = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int chon;

		do {
			System.out.println("\n===== MENU QUẢN LÝ ARRAYLIST =====");
			System.out.println("1. Thêm số nguyên");
			System.out.println("2. Xem danh sách");
			System.out.println("3. Sửa (Thay đổi giá trị theo vị trí)");
			System.out.println("4. Xóa (Theo vị trí)");
			System.out.println("5. Tìm kiếm");
			System.out.println("6. Sắp xếp tăng dần");
			System.out.println("0. Thoát");
			System.out.print("Mời bạn chọn: ");
			chon = sc.nextInt();

			switch (chon) {
			case 1: // THÊM (Slide 36)
				System.out.print("Nhập số nguyên cần thêm: ");
				int soVuaNhap = sc.nextInt();
				dsSo.add(soVuaNhap);
				System.out.println("Đã thêm thành công.");
				break;

			case 2: // XUẤT (Slide 37)
				System.out.println("Danh sách hiện tại: " + dsSo);
				break;

			case 3: // SỬA
				if (dsSo.isEmpty()) {
					System.out.println("Danh sách trống!");
				} else {
					System.out.print("Nhập vị trí (index) cần sửa: ");
					int indexSua = sc.nextInt();
					if (indexSua >= 0 && indexSua < dsSo.size()) {
						System.out.print("Nhập giá trị mới: ");
						int giaTriMoi = sc.nextInt();
						dsSo.set(indexSua, giaTriMoi); // Dùng set để sửa
						System.out.println("Đã cập nhật.");
					} else {
						System.out.println("Vị trí không hợp lệ.");
					}
				}
				break;

			case 4: // XÓA (Slide 36)
				if (dsSo.isEmpty()) {
					System.out.println("Danh sách trống!");
				} else {
					System.out.print("Nhập vị trí (index) cần xóa: ");
					int indexXoa = sc.nextInt();
					if (indexXoa >= 0 && indexXoa < dsSo.size()) {
						dsSo.remove(indexXoa); // Xóa theo vị trí
						System.out.println("Đã xóa.");
					} else {
						System.out.println("Vị trí không hợp lệ.");
					}
				}
				break;

			case 5: // TÌM KIẾM (Slide 36)
				System.out.print("Nhập số cần tìm: ");
				int soTim = sc.nextInt();
				if (dsSo.contains(soTim)) {
					System.out.println("Tìm thấy số " + soTim + " tại vị trí " + dsSo.indexOf(soTim));
				} else {
					System.out.println("Không tìm thấy trong danh sách.");
				}
				break;

			case 6: // SẮP XẾP
				Collections.sort(dsSo); // Sử dụng thư viện Collections để sắp xếp ArrayList
				System.out.println("Đã sắp xếp tăng dần: " + dsSo);
				break;

			case 0:
				System.out.println("Tạm biệt!");
				break;
			default:
				System.out.println("Chọn sai, vui lòng chọn lại.");
			}
		} while (chon != 0);

	}

}