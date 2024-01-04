package vn.depro.BTCuoiKhoa.ctql.capNhat;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyDiem {
	
	static int autoNumber = 301; 
	
	static Scanner sc = new Scanner(System.in);
	
	static ArrayList<Diem> list_mark = new ArrayList<Diem>();
	
	public static void init() {
		list_mark.add(new Diem(101, 201, 10));
		list_mark.add(new Diem(102, 201, 8));
		list_mark.add(new Diem(103, 201, 0));
		list_mark.add(new Diem(101, 202, 5));
		list_mark.add(new Diem(102, 202, 6));
		list_mark.add(new Diem(104, 202, 6));
	}
	
	public static void thucThi() {
		try {
			do {				
				System.out.println("\n********CAP NHAT BANG DIEM********");
				System.out.println("\tMoi ban lua chon 1 chuc nang");
				System.out.println("\t1. Them moi diem");
				System.out.println("\t2. Sua diem");
				System.out.println("\t3. Xoa diem");
				System.out.println("\t0. Quay lai");
				
				System.out.print("\tLua chon cua ban: ");
				int chon = Integer.parseInt(sc.nextLine());
				
				switch (chon) {
				case 1: them(); break;
				case 2: sua(); break;
				case 3: xoa(); break;
				case 0: return;
				default: System.out.println("\tLua chon khong hop le");
				}
			} while (true);
		}
		catch (NumberFormatException e) {
			System.out.println("\tThong tin khong hop le"); 		}
	}

	private static void them() {
		System.out.println("\t------THEM DIEM SINH VIEN------");
		try {
			System.out.print("\tNhap ma sinh vien: ");
			int ma_sv = Integer.parseInt(sc.nextLine());
			if (ma_sv<101) {
				System.out.println("\tMa khong hop le");
			}
			
			int index_sv = QuanLySinhVien.indexOf(ma_sv);
			if (index_sv==-1) {
				System.out.println("\tSinh vien chua co trong danh sach");
			}
			
			System.out.print("\tNhap ma mon hoc: ");
			int ma_mh = Integer.parseInt(sc.nextLine());
			if (ma_mh<201) {
				System.out.println("\tMa mon hoc khong hop le");
				return;
			}
			
			int index_mh = QuanLyMonHoc.indexOf(ma_mh);
			if (index_mh==-1) {
				System.out.println("\tMon hoc chua co trong danh sach");
			}
			
			for (int i = 0; i< list_mark.size();i++) {
				if (list_mark.get(i).getMa_mh()==ma_mh && list_mark.get(i).getMa_sv()==ma_sv) {
					System.out.println("\tSinh vien da co diem mon nay");
					return;
				}
			}
			
			System.out.print("\tNhap diem: ");
			double diem = Double.parseDouble(sc.nextLine());
			if (diem >10 && diem <0) {
				System.out.println("\tDiem phai trong khoang tu 0-10");
				return;
			}
			else {
				if (index_sv!=-1&&index_mh!=-1) {
					list_mark.add(new Diem(ma_sv, ma_mh, diem));
					System.out.println("\tThem moi thanh cong");
				}
			}
		}
		catch (NumberFormatException e) {
			System.out.println("\tThong tin khong hop le");		}
	}

	private static void sua() {
		try {
			System.out.print("\tNhap ma sinh vien: ");
			int ma_sv = Integer.parseInt(sc.nextLine());
			if (ma_sv<101) {
				System.out.println("\tMa khong hop le");
				return;
			}
			
			int index_sv = QuanLySinhVien.indexOf(ma_sv);
			if (index_sv==-1) {
				System.out.println("\tSinh vien chua co trong danh sach");
				return;
			}
			
			System.out.print("\tNhap ma mon hoc: ");
			int ma_mh = Integer.parseInt(sc.nextLine());
			if (ma_mh<201) {
				System.out.println("\tMa mon hoc khong hop le");
				return;
			}
			
			int index_mh = QuanLyMonHoc.indexOf(ma_mh);
			if (index_mh==-1) {
				System.out.println("\tMon hoc chua co trong danh sach");
				return;
			}
			
			for (int i = 0; i<list_mark.size();i++) {
				if (list_mark.get(i).getMa_sv()==ma_sv && list_mark.get(i).getMa_mh()==ma_mh) {
					System.out.print("\tNhap diem moi: ");
					double mark = Double.parseDouble(sc.nextLine());
					if (mark <=10 && mark >=0) {
						list_mark.get(index_sv).setDiem(mark);
						System.out.println("\tSua thanh cong");
						return;
					}
					else {
						System.out.println("\tDiem phai trong khoang tu 0-10");
						return;
					}
				}
			}
			System.out.println("\tSinh vien chua co diem mon nay");
			return;
		}
		catch (NumberFormatException e) {
			System.out.println("\tThong tin khong hop le");		}
	}

	private static void xoa() {
		try {
			System.out.print("\tNhap ma sinh vien: ");
			int ma_sv = Integer.parseInt(sc.nextLine());
			if (ma_sv<101) {
				System.out.println("\tMa khong hop le");
				return;
			}
			
			int index_sv = QuanLySinhVien.indexOf(ma_sv);
			if (index_sv==-1) {
				System.out.println("\tSinh vien chua co trong danh sach");
				return;
			}
			
			System.out.print("\tNhap ma mon hoc: ");
			int ma_mh = Integer.parseInt(sc.nextLine());
			if (ma_mh<201) {
				System.out.println("\tMa mon hoc khong hop le");
				return;
			}
			
			int index_mh = QuanLyMonHoc.indexOf(ma_mh);
			if (index_mh==-1) {
				System.out.println("\tMon hoc chua co trong danh sach");
				return;
			}
			
			for (int i = 0; i<list_mark.size();i++) {
				if (list_mark.get(i).getMa_sv()==ma_sv && list_mark.get(i).getMa_mh()==ma_mh) {
						list_mark.remove(i);
						System.out.println("\tXoa thanh cong");
						return;
					}
				}
			System.out.println("\tSinh vien chua co diem mon nay");
			return;
		}
		catch (NumberFormatException e) {
			System.out.println("\tThong tin khong hop le");		}
	}
	
	//Ham nhan ma sinh vien tra ve id
	public static int indexOfMaSV(int code) {
		for (int i = 0; i<list_mark.size(); i++) {
			if (list_mark.get(i).getMa_sv()==code) {
				return i;
			}
		}
		return -1;
	}
		
	//Ham nhan ma mon hoc tra ve id
	public static int indexOfMaMH(int code) {
		for (int i = 0; i<list_mark.size(); i++) {
			if (list_mark.get(i).getMa_mh()==code) {
				return i;
			}
		}
		return -1;
	}	
	
	//Ham nhan ma mon hoc tra ve dem
	public static int indexOfDem(int code) {
		int dem = 0;
		for (int i = 0; i<list_mark.size(); i++) {
			if (list_mark.get(i).getMa_mh()==code) {
				if (list_mark.get(i).getDiem()>=0 && list_mark.get(i).getDiem()<=10) {
					dem++;
				}
			}
		}
		return dem;
	}	
	
	//Ham nhan ma sinh vien -> dem sinh vien
	public static int indexOfDemSV(int code) {
		int dem = 0;
		for (int i = 0; i<list_mark.size(); i++) {
			if (list_mark.get(i).getMa_sv()==code) {
				if (QuanLyMonHoc.indexOf(list_mark.get(i).getMa_mh())!=-1) {
					dem++;
				}
			}
		}
		return dem;
	}
	
	
	public static ArrayList<Diem> getList_mark() {
		return list_mark;
	}

	public static void setList_mark(ArrayList<Diem> list_mark) {
		QuanLyDiem.list_mark = list_mark;
	}
}
