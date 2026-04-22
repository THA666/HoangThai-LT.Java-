package weyeewu.com;

public class Tim {

	public static void main(String[] args) {
		String duongDan = "D:/music/bolero/longme.mp3";

		// Áp dụng try...catch...finally theo đúng bài học
		try {
			System.out.println("Đường dẫn gốc: " + duongDan);

			// 1. Hãy lấy longme.mp3 (Sử dụng lastIndexOf và substring 1 đối số)
			int viTriGachCheoCuoi = duongDan.lastIndexOf("/");
			String tenCoDuoi = duongDan.substring(viTriGachCheoCuoi + 1);
			System.out.println("- Lấy được tên có đuôi: " + tenCoDuoi);

			// 2. Hãy lấy longme (Sử dụng substring 2 đối số: từ sau dấu / đến trước dấu .)
			int viTriDauChamCuoi = duongDan.lastIndexOf(".");
			String tenKhongDuoi = duongDan.substring(viTriGachCheoCuoi + 1, viTriDauChamCuoi);
			System.out.println("- Lấy được tên bài hát: " + tenKhongDuoi);

		} catch (Exception ex) {
			// Xử lý lỗi nếu đường dẫn truyền vào sai định dạng (không có dấu / hoặc .)
			System.err.println("Lỗi: Không thể xử lý đường dẫn bài hát!");
			ex.printStackTrace(); // In vết lỗi
		} finally {
			// Thông báo hoàn tất
			System.out.println("=> Kết thúc tiến trình tách tên bài hát.");
		}
	}

}
