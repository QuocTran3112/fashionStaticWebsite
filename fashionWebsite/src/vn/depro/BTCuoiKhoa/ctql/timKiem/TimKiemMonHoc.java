package vn.depro.BTCuoiKhoa.ctql.timKiem;

import java.util.ArrayList;
import java.util.Scanner;
import vn.depro.BTCuoiKhoa.ctql.capNhat.MonHoc;
import vn.depro.BTCuoiKhoa.ctql.capNhat.QuanLyDiem;
import vn.depro.BTCuoiKhoa.ctql.capNhat.QuanLyMonHoc;
import vn.depro.BTCuoiKhoa.ctql.capNhat.QuanLySinhVien;

public class TimKiemMonHoc {
	
	static Scanner  sc = new Scanner(System.in);
	
	static ArrayList<MonHoc> list_bySubject = new ArrayList<MonHoc>();
	
	public static void thucThi() {
		try {
			do {				
				System.out.println("\n********TIM KIEM THONG TIN MON HOC********");
				System.out.println("\tMoi ban lua chon 1 chuc nang");
				System.out.println("\t1. Tim kiem theo ten mon hoc");
				System.out.println("\t2. Tim kiem theo ma mon hoc");
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
			System.out.print("\tNhap ten mon hoc can tim: ");
			String ten = sc.nextLine();
			if (ten.trim().length()==0) {
				System.out.println("\tTen khong duoc de trong");
				return;
			}
			
			if (QuanLyMonHoc.indexOfByName(ten)==-1) {
				System.out.println("\tMon hoc chua co trong danh sach");
				return;
			}
			
			double heSo =0;
			double tongDiem = 0;
			int i =0;
			while (i < QuanLyMonHoc.getList_mh().size()) {
				if (QuanLyMonHoc.getList_mh().get(i).getTen().compareToIgnoreCase(ten)==0) {
					System.out.println("Ma mon hoc: "+QuanLyMonHoc.getList_mh().get(i).getMa_mh());
					System.out.println("Ten mon hoc: " + QuanLyMonHoc.getList_mh().get(i).getTen());
					System.out.printf("%-4s %-5s %-25s %-4s%n", 
							"STT", "Ma SV","Ten SV", "Diem");
					int stt =1;
					for (int j =0; j<QuanLyDiem.getList_mark().size();j++) {
						if (QuanLyMonHoc.getList_mh().get(i).getMa_mh()==QuanLyDiem.getList_mark().get(j).getMa_mh()) {
							tongDiem += QuanLyDiem.getList_mark().get(j).tongDiem();
							heSo += QuanLyMonHoc.indexOfHeSo(QuanLyDiem.getList_mark().get(j).getMa_mh());	
							System.out.printf("%-5d", stt++);
							System.out.printf("%-5d %-25s %-4.1f%n", 
									QuanLySinhVien.getList_student().get(j).getMa_sv(), 
									QuanLySinhVien.getList_student().get(j).getHoDem()+" "+QuanLySinhVien.getList_student().get(i).getTen(), 
									QuanLyDiem.getList_mark().get(j).getDiem());
						}
					}
					i++;
					if (Double.isNaN(tongDiem/ heSo)) {
						System.out.println("\tMon hoc chua co diem");
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
			System.out.println("\tThong tin khong hop le");		}
	}

	private static void timKiemTheoMa() {
		try {
			System.out.print("\tNhap ma mon hoc can tim: ");
			int code = Integer.parseInt(sc.nextLine());
			if (code <201) {
				System.out.println("\tMa mon hoc khong hop le");
				return;
			}
			
			System.out.println("\t---Ket qua tm kiem---");
			
			if (QuanLyMonHoc.indexOf(code)==-1) {
				System.out.println("\tMon hoc chua co trong danh sach");
				return;
			}

			double heSo =0;
			double tongDiem = 0;
			
			System.out.println("Ma mon hoc: "+code);
			System.out.println("Ten mon hoc: " + QuanLyMonHoc.indexOfName(code));
			System.out.printf("%-4s %-5s %-25s %-4s%n", 
						"STT", "Ma SV","Ten SV", "Diem");
			int stt =1;
			for (int j =0; j<QuanLyDiem.getList_mark().size();j++) {
				if (code==QuanLyDiem.getList_mark().get(j).getMa_mh()) {
					tongDiem += QuanLyDiem.getList_mark().get(j).tongDiem();
					heSo += QuanLyMonHoc.indexOfHeSo(QuanLyDiem.getList_mark().get(j).getMa_mh());	
					System.out.printf("%-5d", stt++);
					System.out.printf("%-5d %-25s %-4.1f%n", 
							QuanLyDiem.getList_mark().get(j).getMa_sv(), QuanLySinhVien.indexOfName(QuanLyDiem.getList_mark().get(j).getMa_sv()),
							QuanLyDiem.getList_mark().get(j).getDiem());
				}
			}
			if (Double.isNaN(tongDiem/ heSo)) {
				System.out.println("\tMon hoc chua co diem");
			}
			else {
			System.out.println("Diem tong ket: "+(tongDiem/ heSo));
			}
			heSo =0;
			tongDiem = 0;
			System.out.println("--------------------------------");		
			return;
		}
		catch (NumberFormatException e) {
			System.out.println("\tThong tin khong hop le");		}
	}
}
