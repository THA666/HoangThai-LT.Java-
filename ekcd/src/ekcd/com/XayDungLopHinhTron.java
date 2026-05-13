package ekcd.com;

import java.util.Scanner;

abstract class Hinh {
	protected String mau;
	public Hinh(String mau) { this.mau = mau; }
	public abstract double TinhDienTich();
	public abstract double TinhChuVi();
	public String LayThongTin() { return "Màu sắc: " + mau; }
}

class HinhChuNhat extends Hinh {
	protected double chieudai, chieurong;
	public HinhChuNhat(String mau, double chieudai, double chieurong) {
		super(mau);
		this.chieudai = chieudai;
		this.chieurong = chieurong;
	}
	@Override
	public double TinhDienTich() { return chieudai * chieurong; }
	@Override
	public double TinhChuVi() { return (chieudai + chieurong) * 2; }
	@Override
	public String LayThongTin() {
		return super.LayThongTin() + " | Hình Chữ Nhật [Dài: " + chieudai + ", Rộng: " + chieurong + "]"
				+ "\n   => Diện tích: " + TinhDienTich() + " | Chu vi: " + TinhChuVi();
	}
}

class HinhTron extends Hinh {
	private double bankinh;
	public HinhTron(String mau, double bankinh) {
		super(mau);
		this.bankinh = bankinh;
	}
	@Override
	public double TinhDienTich() { return Math.PI * bankinh * bankinh; }
	@Override
	public double TinhChuVi() { return 2 * Math.PI * bankinh; }
	@Override
	public String LayThongTin() {
		return super.LayThongTin() + " | Hình Tròn [Bán kính: " + bankinh + "]"
				+ "\n   => Diện tích: " + String.format("%.2f", TinhDienTich()) 
				+ " | Chu vi: " + String.format("%.2f", TinhChuVi());
	}
}

class HinhVuong extends HinhChuNhat {
	public HinhVuong(String mau, double bankinh) { super(mau, bankinh, bankinh); }
	@Override
	public String LayThongTin() {
		return "Màu sắc: " + mau + " | Hình Vuông [Cạnh: " + chieudai + "]"
				+ "\n   => Diện tích: " + TinhDienTich() + " | Chu vi: " + TinhChuVi();
	}
}

public class XayDungLopHinhTron {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int luonChon;

		do {
			System.out.println("\n========= MENU TÍNH TOÁN HÌNH HỌC =========");
			System.out.println("1. Tính Hình Chữ Nhật");
			System.out.println("2. Tính Hình Tròn");
			System.out.println("3. Tính Hình Vuông");
			System.out.println("0. Thoát chương trình");
			System.out.print("Mời bạn chọn hình muốn tính (0-3): ");
			
			luonChon = sc.nextInt();
			sc.nextLine(); 

			switch (luonChon) {
				case 1:
					System.out.println("\n--- Đang tính Hình Chữ Nhật ---");
					System.out.print("Nhập màu sắc: ");
					String mHCN = sc.nextLine();
					System.out.print("Nhập chiều dài: ");
					double d = sc.nextDouble();
					System.out.print("Nhập chiều rộng: ");
					double r = sc.nextDouble();
					HinhChuNhat hcn = new HinhChuNhat(mHCN, d, r);
					System.out.println("KẾT QUẢ: " + hcn.LayThongTin());
					break;

				case 2:
					System.out.println("\n--- Đang tính Hình Tròn ---");
					System.out.print("Nhập màu sắc: ");
					String mHT = sc.nextLine();
					System.out.print("Nhập bán kính: ");
					double bk = sc.nextDouble();
					HinhTron ht = new HinhTron(mHT, bk);
					System.out.println("KẾT QUẢ: " + ht.LayThongTin());
					break;

				case 3:
					System.out.println("\n--- Đang tính Hình Vuông ---");
					System.out.print("Nhập màu sắc: ");
					String mHV = sc.nextLine();
					System.out.print("Nhập độ dài cạnh: ");
					double canh = sc.nextDouble();
					HinhVuong hv = new HinhVuong(mHV, canh);
					System.out.println("KẾT QUẢ: " + hv.LayThongTin());
					break;

				case 0:
					System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
					break;

				default:
					System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
			}
			
			if(luonChon != 0) {
				System.out.println("\nNhấn Enter để quay lại Menu...");
				sc.nextLine(); 
				sc.nextLine();
			}

		} while (luonChon != 0);

		sc.close();
	}
}