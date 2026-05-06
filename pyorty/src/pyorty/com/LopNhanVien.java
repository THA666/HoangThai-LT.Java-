package pyorty.com;

import java.util.Scanner;
class NhanVien {
    private String ho;
    private String ten;
    private int soSP;

    // Hàm khởi tạo (Constructor) theo yêu cầu
    public NhanVien(String ho, String ten, int soSP) {
        this.ho = ho;
        this.ten = ten;
        // Kiểm tra nếu số sản phẩm âm thì gán bằng 0
        if (soSP < 0) {
            this.soSP = 0;
        } else {
            this.soSP = soSP;
        }
    }

    // Các hàm lấy và gán giá trị (get/set)
    public String getHo() { return ho; }
    public void setHo(String ho) { this.ho = ho; }

    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }

    public int getSoSP() { return soSP; }
    public void setSoSP(int soSP) {
        if (soSP < 0) this.soSP = 0;
        else this.soSP = soSP;
    }

    // Hàm tính lương dựa theo đơn giá trong ảnh
    public double getLuong() {
        double donGia = 0;
        if (soSP >= 1 && soSP <= 199) {
            donGia = 0.5;
        } else if (soSP >= 200 && soSP <= 399) {
            donGia = 0.55;
        } else if (soSP >= 400 && soSP <= 599) {
            donGia = 0.6;
        } else if (soSP >= 600) {
            donGia = 0.65;
        }
        return soSP * donGia;
    }

    // Hàm LonHon để so sánh với nhân viên khác
    public boolean lonHon(NhanVien nv2) {
        return this.soSP > nv2.soSP;
    }
}

public class LopNhanVien {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập liệu nhân viên 1
        System.out.println("Nhập thông tin nhân viên 1:");
        System.out.print("Họ: "); String ho1 = sc.nextLine();
        System.out.print("Tên: "); String ten1 = sc.nextLine();
        System.out.print("Số sản phẩm: "); int sp1 = sc.nextInt();
        NhanVien nv1 = new NhanVien(ho1, ten1, sp1);
        
        sc.nextLine(); // Xóa bộ nhớ đệm để nhập chuỗi tiếp theo

        // Nhập liệu nhân viên 2
        System.out.println("\nNhập thông tin nhân viên 2:");
        System.out.print("Họ: "); String ho2 = sc.nextLine();
        System.out.print("Tên: "); String ten2 = sc.nextLine();
        System.out.print("Số sản phẩm: "); int sp2 = sc.nextInt();
        NhanVien nv2 = new NhanVien(ho2, ten2, sp2);

        // 1. Xuất lương của từng nhân viên
        System.out.println("\n--- KẾT QUẢ TÍNH LƯƠNG ---");
        System.out.println("Lương " + nv1.getHo() + " " + nv1.getTen() + ": " + nv1.getLuong());
        System.out.println("Lương " + nv2.getHo() + " " + nv2.getTen() + ": " + nv2.getLuong());

        // 2. So sánh bằng cách 1: Dùng hàm LonHon
        System.out.println("\nSo sánh cách 1 (Dùng hàm LonHon):");
        if (nv1.lonHon(nv2)) {
            System.out.println(nv1.getTen() + " làm nhiều hơn " + nv2.getTen() + " là " + (nv1.getSoSP() - nv2.getSoSP()) + " SP.");
        } else if (nv2.lonHon(nv1)) {
            System.out.println(nv2.getTen() + " làm nhiều hơn " + nv1.getTen() + " là " + (nv2.getSoSP() - nv1.getSoSP()) + " SP.");
        } else {
            System.out.println("Cả hai nhân viên có số sản phẩm bằng nhau.");
        }

        // 3. So sánh bằng cách 2: Không dùng hàm LonHon
        System.out.println("\nSo sánh cách 2 (Không dùng hàm LonHon):");
        if (nv1.getSoSP() > nv2.getSoSP()) {
            System.out.println(nv1.getTen() + " nhiều sản phẩm hơn.");
        } else if (nv1.getSoSP() < nv2.getSoSP()) {
            System.out.println(nv2.getTen() + " nhiều sản phẩm hơn.");
        } else {
            System.out.println("Số sản phẩm bằng nhau.");
        }

        sc.close();
    }
}