package vn.depro.BTCuoiKhoa.ctql.hienThi;

import java.util.Scanner;

public class ChuongTrinhHienThi {
	static Scanner sc = new Scanner(System.in);

	public static void thucThi() {
		try {
			do {				
				System.out.println("\n********CHUONG TRINH HIEN THI********");
				System.out.println("\tMoi ban lua chon 1 chuc nang");
				System.out.println("\t1. Hien thi theo tung sinh vien");
				System.out.println("\t2. Hien thi theo tung mon hoc");
				System.out.println("\t0. Quay lai");
				
				System.out.print("\tLua chon cua ban: ");
				int chon = Integer.parseInt(sc.nextLine());
				
				switch (chon) {
				case 1: HienThiTheoSinhVien.hienThi(); break;
				case 2: HienThiTheoMonHoc.hienThi(); break;
				case 0: return;
				default: System.out.println("\tLua chon khong hop le");
				}
			} while (true);
		}
		catch (NumberFormatException e) {
			System.out.println("\tThong tin khong hop le");		}
	}
}
