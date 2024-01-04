package vn.depro.BTCuoiKhoa.ctql.timKiem;

import java.util.Scanner;

public class ChuongTrinhTimKiem {
	
	static Scanner sc = new Scanner(System.in);

	public static void thucThi() {
		try {
			do {				
				System.out.println("\n********TIM KIEM THONG TIN SINH VIEN********");
				System.out.println("\tMoi ban lua chon 1 chuc nang");
				System.out.println("\t1. Tim kiem thong tin sinh vien");
				System.out.println("\t2. Tim kiem thong tin mon hoc");
				System.out.println("\t0. Quay lai");
				
				System.out.print("\tLua chon cua ban: ");
				int chon = Integer.parseInt(sc.nextLine());
				
				switch (chon) {
				case 1: TimKiemSinhVien.thucThi();; break;
				case 2: TimKiemMonHoc.thucThi();; break;
				case 0: return;
				default: System.out.println("\tLua chon khong hop le");
				}
			} while (true);
		}
		catch (NumberFormatException e) {
			System.out.println("\tThong tin khong hop le");		}
	}

}
