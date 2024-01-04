package vn.depro.BTCuoiKhoa.ctql.hienThi;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.depro.BTCuoiKhoa.ctql.capNhat.QuanLyDiem;
import vn.depro.BTCuoiKhoa.ctql.capNhat.QuanLyMonHoc;
import vn.depro.BTCuoiKhoa.ctql.capNhat.QuanLySinhVien;
import vn.depro.BTCuoiKhoa.ctql.capNhat.SinhVien;

public class HienThiTheoSinhVien {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void sapXepTheoId() {
		Collections.sort(QuanLySinhVien.getList_student(), new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getMa_sv() - o2.getMa_sv();
			}
		});
	}
	
	public static void hienThi() {
		sapXepTheoId();
		double heSo =0;
		double tongDiem = 0;
		int i =0;
		while (i < QuanLySinhVien.getList_student().size()) {
			System.out.println("Ma sinh vien: "+QuanLySinhVien.getList_student().get(i).getMa_sv());
			System.out.println("Ho ten: " + QuanLySinhVien.indexOfNameByID(i));
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
			System.out.printf("Diem tong ket: %4.1f%n",(tongDiem/ heSo));
			}
			heSo =0;
			tongDiem = 0;
			System.out.println("--------------------------------");
		}
	}
}
