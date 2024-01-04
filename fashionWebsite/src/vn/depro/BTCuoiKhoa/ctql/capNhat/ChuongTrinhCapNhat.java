package vn.depro.BTCuoiKhoa.ctql.capNhat;

import java.util.Scanner;

public class ChuongTrinhCapNhat {

	static Scanner sc = new Scanner(System.in);
	
	public  static void thucThi() {
		
		try {
			do {				
				System.out.println("\n********CHUONG TRINH CAP NHAT********");
				System.out.println("\tMoi ban lua chon 1 chuc nang");
				System.out.println("\t1. Cap nhat thong tin sinh vien");
				System.out.println("\t2. Cap nhat danh sach mon hoc");
				System.out.println("\t3. Cap nhat danh sach diem");
				System.out.println("\t0. Quay lai");
				
				System.out.print("\tLua chon cua ban: ");
				int chon = Integer.parseInt(sc.nextLine());
				
				switch (chon) {
				case 1: QuanLySinhVien.thucThi(); break;
				case 2: QuanLyMonHoc.thucThi(); break;
				case 3: QuanLyDiem.thucThi(); break;
				case 0: return;
				default: System.out.println("\tLua chon khong hop le");
				}
			} while (true);
		}
		catch (NumberFormatException e) {
			System.out.println("\tThong tin khong hop le");
		}
	}
}
