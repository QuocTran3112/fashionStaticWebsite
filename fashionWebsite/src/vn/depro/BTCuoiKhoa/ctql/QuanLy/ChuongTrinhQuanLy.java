package vn.depro.BTCuoiKhoa.ctql.QuanLy;

import java.util.Scanner;

import vn.depro.BTCuoiKhoa.ctql.capNhat.ChuongTrinhCapNhat;
import vn.depro.BTCuoiKhoa.ctql.capNhat.QuanLyDiem;
import vn.depro.BTCuoiKhoa.ctql.capNhat.QuanLyMonHoc;
import vn.depro.BTCuoiKhoa.ctql.capNhat.QuanLySinhVien;
import vn.depro.BTCuoiKhoa.ctql.hienThi.ChuongTrinhHienThi;
import vn.depro.BTCuoiKhoa.ctql.timKiem.ChuongTrinhTimKiem;

public class ChuongTrinhQuanLy {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		QuanLySinhVien.init();
		QuanLyDiem.init();
		QuanLyMonHoc.init();
		
		try {
			do {				
				System.out.println("\n********CHUONG TRINH QUAN LY SINH VIEN********");
				System.out.println("\tMoi ban lua chon 1 chuc nang");
				System.out.println("\t1. Quan ly cap nhat");
				System.out.println("\t2. Quan ly hien thi");
				System.out.println("\t3. Quan ly tim kiem");
				System.out.println("\t0. Thoat");
				
				System.out.print("\tLua chon cua ban: ");
				int chon = Integer.parseInt(sc.nextLine());
				
				switch (chon) {
				case 1: ChuongTrinhCapNhat.thucThi(); break;
				case 2: ChuongTrinhHienThi.thucThi(); break;
				case 3: ChuongTrinhTimKiem.thucThi(); break;
				case 0: 
					System.out.println("\tDa thoat chuong trinh");
					System.exit(0);
				default: System.out.println("\tLua chon khong hop le");
				}
			} while (true);
		}
		catch (NumberFormatException e) {
			System.out.println("\tThong tin khong hop le");		}
	}
}
