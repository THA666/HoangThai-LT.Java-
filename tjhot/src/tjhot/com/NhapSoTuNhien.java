package tjhot.com;

import java.util.Scanner;

public class NhapSoTuNhien {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Nhập số lượng phần tử
		System.out.print("Nhập số lượng phần tử của mảng: ");
		int n = sc.nextInt();
		int[] M = new int[n];

		// Nhập giá trị cho mảng
		for (int i = 0; i < n; i++) {
			System.out.print("M[" + i + "] = ");
			M[i] = sc.nextInt();
		}

		//Liệt kê số lẻ và đếm
		System.out.print("\nDòng 1: Các số lẻ: ");
		int demLe = 0;
		for (int x : M) {
			if (x % 2 != 0) {
				System.out.print(x + " ");
				demLe++;
			}
		}
		System.out.println("-> Tổng cộng có " + demLe + " số lẻ.");

		//Liệt kê số chẵn và đếm
		System.out.print("Dòng 2: Các số chẵn: ");
		int demChan = 0;
		for (int x : M) {
			if (x % 2 == 0) {
				System.out.print(x + " ");
				demChan++;
			}
		}
		System.out.println("-> Tổng cộng có " + demChan + " số chẵn.");

		//Liệt kê các số nguyên tố
		System.out.print("Dòng 3: Các số nguyên tố: ");
		for (int x : M) {
			if (checkSNT(x)) {
				System.out.print(x + " ");
			}
		}
		System.out.println();

		//Liệt kê các số KHÔNG phải số nguyên tố
		System.out.print("Dòng 4: Các số không phải là số nguyên tố: ");
		for (int x : M) {
			if (!checkSNT(x)) {
				System.out.print(x + " ");
			}
		}
		System.out.println();
	}

	/**
	 * Hàm kiểm tra số nguyên tố
	 */
	public static boolean checkSNT(int n) {
		if (n < 2) return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) return false;
		}
		return true;
	}

}