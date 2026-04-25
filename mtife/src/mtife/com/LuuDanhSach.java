package mtife.com;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LuuDanhSach {

	public static void main(String[] args) {
		// Khai báo HashMap: Key là mã sách (Integer), Value là tên sách (String)
		HashMap<Integer, String> dsSach = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int chon;

		do {
			System.out.println("\n===== QUẢN LÝ DANH SÁCH SÁCH (HASHMAP) =====");
			System.out.println("1. Thêm sách mới");
			System.out.println("2. Xuất danh sách sách");
			System.out.println("3. Sửa tên sách theo mã");
			System.out.println("4. Xóa sách theo mã");
			System.out.println("5. Tìm kiếm sách theo mã");
			System.out.println("0. Thoát");
			System.out.print("Mời bạn chọn: ");
			chon = sc.nextInt();
			sc.nextLine(); // Xử lý trôi lệnh sau khi nhập số

			switch (chon) {
			case 1: // THÊM (Slide 41)
				System.out.print("Nhập mã sách (số nguyên): ");
				int maThem = sc.nextInt();
				sc.nextLine();
				System.out.print("Nhập tên sách: ");
				String tenThem = sc.nextLine();
				dsSach.put(maThem, tenThem); // put dùng để thêm mới
				System.out.println("Đã thêm thành công.");
				break;

			case 2: // XUẤT DANH SÁCH (Slide 42)
				System.out.println("Danh sách sách trong kho:");
				for (Map.Entry<Integer, String> item : dsSach.entrySet()) {
					System.out.println("Mã: " + item.getKey() + " - Tên: " + item.getValue());
				}
				if (dsSach.isEmpty()) System.out.println("(Trống)");
				break;

			case 3: // SỬA (Slide 41)
				System.out.print("Nhập mã sách cần sửa tên: ");
				int maSua = sc.nextInt();
				sc.nextLine();
				if (dsSach.containsKey(maSua)) {
					System.out.print("Nhập tên mới cho sách: ");
					String tenMoi = sc.nextLine();
					dsSach.put(maSua, tenMoi); // put đè lên Key cũ để sửa
					System.out.println("Đã cập nhật thành công.");
				} else {
					System.out.println("Mã sách " + maSua + " không tồn tại.");
				}
				break;

			case 4: // XÓA (Slide 41)
				System.out.print("Nhập mã sách cần xóa: ");
				int maXoa = sc.nextInt();
				if (dsSach.containsKey(maXoa)) {
					dsSach.remove(maXoa);
					System.out.println("Đã xóa sách có mã " + maXoa);
				} else {
					System.out.println("Không tìm thấy mã sách để xóa.");
				}
				break;

			case 5: // TÌM KIẾM (Slide 42)
				System.out.print("Nhập mã sách cần tìm: ");
				int maTim = sc.nextInt();
				if (dsSach.containsKey(maTim)) {
					String tenTim = dsSach.get(maTim);
					System.out.println("Kết quả: Mã " + maTim + " là sách: " + tenTim);
				} else {
					System.out.println("Không tìm thấy sách có mã " + maTim);
				}
				break;

			case 0:
				System.out.println("kết thúc bài!");
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ.");
			}
		} while (chon != 0);

	}

}