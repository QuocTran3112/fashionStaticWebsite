package vn.depro.BTCuoiKhoa.ctql.hienThi;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.depro.BTCuoiKhoa.ctql.capNhat.MonHoc;
import vn.depro.BTCuoiKhoa.ctql.capNhat.QuanLyDiem;
import vn.depro.BTCuoiKhoa.ctql.capNhat.QuanLyMonHoc;
import vn.depro.BTCuoiKhoa.ctql.capNhat.QuanLySinhVien;

public class HienThiTheoMonHoc {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void sapXepTheoId() {
		Collections.sort(QuanLyMonHoc.getList_mh(), new Comparator<MonHoc>() {
			@Override
			public int compare(MonHoc o1, MonHoc o2) {
				return o1.getMa_mh() - o2.getMa_mh();
			}
		});
	}
	
	public static void hienThi() {
		sapXepTheoId();
		double heSo =0;
		double tongDiem = 0;
		int i =0;
		while (i < QuanLyMonHoc.getList_mh().size()) {
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
							QuanLySinhVien.indexOfIDByCode(QuanLyDiem.getList_mark().get(j).getMa_sv()),
					QuanLySinhVien.indexOfName(QuanLyDiem.getList_mark().get(j).getMa_sv()), QuanLyDiem.getList_mark().get(j).getDiem());
				}
			}
			i++;
			if (Double.isNaN(tongDiem/ heSo)) {
				System.out.println("\tMon hoc chua co diem");
				return;
			}
			else {
				System.out.printf("Diem tong ket: %4.1f%n",(tongDiem/ heSo));
			}
			heSo =0;
			tongDiem = 0;
			System.out.println("--------------------------------");
		}
	}
}
