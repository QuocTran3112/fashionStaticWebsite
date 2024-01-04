package vn.depro.BTCuoiKhoa.ctql.timKiem;

import java.util.ArrayList;
import java.util.Scanner;

import vn.depro.BTCuoiKhoa.ctql.capNhat.QuanLyDiem;
import vn.depro.BTCuoiKhoa.ctql.capNhat.QuanLyMonHoc;
import vn.depro.BTCuoiKhoa.ctql.capNhat.QuanLySinhVien;
import vn.depro.BTCuoiKhoa.ctql.capNhat.SinhVien;

public class TimKiemSinhVien {
	
	static ArrayList<SinhVien> list_byName = new ArrayList<SinhVien>();
	
	//Tim kiem theo ma
	
	//Tim kiem theo ten **Chu y truong hop trung ten
	
	static Scanner sc = new Scanner(System.in);
	
	public static void thucThi() {
		try {
			do {				
				System.out.println("\n********TIM KIEM THONG TIN SINH VIEN********");
				System.out.println("\tMoi ban lua chon 1 chuc nang");
				System.out.println("\t1. Tim kiem theo ten sinh vien");
				System.out.println("\t2. Tim kiem theo ma sinh vien");
				System.out.println("\t0. Quay lai");
				
				System.out.print("\tLua chon cua ban: ");
				int chon = Integer.parseInt(sc.nextLine());
				
				switch (chon) {
				case 1: timKiemTheoTen(); break;
				case 2: timKiemTheoMa(); break;
				case 0: return;
				default: System.out.println("\tLua chon khong hop le");
				}
			} while (true);
		}
		catch (NumberFormatException e) {
			System.out.println("\tThong tin khong hop le");		}
	}

	private static void timKiemTheoTen() {
		try {
			System.out.print("\tNhap ho ten sinh vien can tim: ");
			String hoTen = sc.nextLine();
			if (hoTen.trim().length()==0) {
				System.out.println("\tTen khong duoc de trong");
				return;
			}
			
			//Kiem tra xem sinh vien co chua, neu co thi add

			for (int i = 0; i<QuanLySinhVien.getList_student().size();i++) {
				if (QuanLySinhVien.indexOfNameByID(i).compareToIgnoreCase(hoTen)!=0) {
					System.out.println("\tSinh vien chua co trong danh sach");
					return;
				}
				else {
					list_byName.add(QuanLySinhVien.getList_student().get(i));
				}
			}
			
			double heSo =0;
			double tongDiem = 0;
			int i =0;
			while (i < list_byName.size()) {
				if (QuanLySinhVien.indexOfNameBySV(list_byName.get(i)).compareToIgnoreCase(hoTen)==0) {
					System.out.println("Ma sinh vien: "+list_byName.get(i).getMa_sv());
					System.out.println("Ho ten: " + QuanLySinhVien.indexOfNameBySV(list_byName.get(i)));
					System.out.printf("%-4s %-12s %-4s%n", 
							"STT", "Ten mon hoc", "Diem");
					int stt =1;
					for (int j =0; j<QuanLyDiem.getList_mark().size();j++) {
						if (QuanLySinhVien.getList_student().get(i).getMa_sv()==QuanLyDiem.getList_mark().get(j).getMa_sv()) {
							tongDiem += QuanLyDiem.getList_mark().get(j).tongDiem();
							heSo += QuanLyMonHoc.indexOfHeSo(QuanLyDiem.getList_mark().get(j).getMa_mh());	
							System.out.printf("%-5d", stt++);
							System.out.printf("%-12s %-4.1f%n", 
									QuanLyMonHoc.indexOfName(QuanLyDiem.getList_mark().get(j).getMa_mh()), QuanLyDiem.getList_mark().get(j).getDiem());
						}
					}
					i++;
					if (Double.isNaN(tongDiem/ heSo)) {
						System.out.println("\tSinh vien chua co diem");
					}
					else {
					System.out.println("Diem tong ket: "+(tongDiem/ heSo));
					}
					heSo =0;
					tongDiem = 0;
					System.out.println("--------------------------------");
					return;
				}
			}
		}
		catch (NumberFormatException e) {
			System.out.println("\tThong tin khong hop le");
		}
	}

	private static void timKiemTheoMa() {
		try {
			System.out.print("\tNhap ma sinh vien can tim: ");
			int code = Integer.parseInt(sc.nextLine());
			if (code <101) {
				System.out.println("\tMa sinh vien khong hop le");
				return;
			}
			
			int index = QuanLySinhVien.indexOf(code);
			if (index==-1) {
				System.out.println("\tSinh vien chua co trong danh sach");
				return;
			}
			
			System.out.println("\t---Ket qua tim kiem---");
			
			int stt =1;
			double heSo =0;
			double tongDiem = 0;
			
			System.out.println("Ma sinh vien: "+code);
			System.out.println("Ho ten: " + QuanLySinhVien.indexOfName(code));

			System.out.printf("%-4s %-12s %-4s%n", 
					"STT", "Ten mon hoc", "Diem");
			for (int j =0; j<QuanLyDiem.getList_mark().size();j++) {
				if (QuanLyDiem.getList_mark().get(j).getMa_sv()==code) {
					tongDiem += QuanLyDiem.getList_mark().get(j).tongDiem();
					heSo += QuanLyMonHoc.indexOfHeSo(QuanLyDiem.getList_mark().get(j).getMa_mh());	
					System.out.printf("%-5d", stt++);
					System.out.printf("%-12s %-4.1f%n", 
							QuanLyMonHoc.indexOfName(QuanLyDiem.getList_mark().get(j).getMa_mh()), QuanLyDiem.getList_mark().get(j).getDiem());
				}
			}
			if (Double.isNaN(tongDiem/ heSo)) {
				System.out.println("\tSinh vien chua co diem");
			}
			else {
				System.out.printf("Diem tong ket: %4.1f%n",(tongDiem/ heSo));
			}
			System.out.println("-------------------------------------------");
			return;
		}
		catch (NumberFormatException e) {
			System.out.println("\tThong tin khong hop le");
		}
	}
}
