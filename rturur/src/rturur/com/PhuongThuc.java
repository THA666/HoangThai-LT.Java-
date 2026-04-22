package rturur.com;

public class PhuongThuc {

	public static void main(String[] args) {
		String chuoiCanKiemTra = "madam";
		
		// Áp dụng try...catch...finally theo yêu cầu của thầy
		try {
			System.out.println("Kiểm tra chuỗi: " + chuoiCanKiemTra);
			
			// Gọi phương thức để kiểm tra
			boolean ketQua = Panlyndrome(chuoiCanKiemTra);
			
			if (ketQua) {
				System.out.println("=> Kết quả: Đây là chuỗi Panlyndrome!");
			} else {
				System.out.println("=> Kết quả: Đây KHÔNG PHẢI chuỗi Panlyndrome.");
			}
			
		} catch (Exception ex) {
			// Slide 8: In vết lỗi nếu có lỗi phát sinh (ví dụ chuỗi bị null)
			System.err.println("Đã có lỗi xảy ra!");
			ex.printStackTrace();
		} finally {
			// Slide 10: Luôn chạy thông báo kết thúc
			System.out.println("--- Hoàn tất tiến trình kiểm tra ---");
		}
	}

	/**
	 * Phương thức kiểm tra chuỗi đối xứng theo logic trong ảnh:
	 * So sánh ký tự ở vị trí i với ký tự ở vị trí (n - 1 - i)
	 */
	public static boolean Panlyndrome(String s) {
		// Nếu chuỗi null thì không phải Panlyndrome
		if (s == null) return false;
		
		int n = s.length();
		
		// Vòng lặp chạy đến n/2 theo mô tả trong ảnh (ví dụ 5 ký tự thì i chạy đến 2)
		for (int i = 0; i < n / 2; i++) {
			// Lấy ký tự tại i so sánh với ký tự đối diện tại n-1-i
			if (s.charAt(i) != s.charAt(n - 1 - i)) {
				// Nếu chỉ cần 1 cặp không bằng nhau thì trả về false ngay
				return false;
			}
		}
		
		// Nếu vượt qua vòng lặp thì là chuỗi đối xứng
		return true;
	}

}