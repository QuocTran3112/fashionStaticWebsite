package vn.depro.BTCuoiKhoa.ctql.capNhat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLySinhVien {
	
	static int autoNumber = 101; 
	
	static Scanner sc = new Scanner(System.in);
	
	static ArrayList<SinhVien> list_student = new ArrayList<SinhVien>();
	
	public static void init() {
		list_student.add(new SinhVien(autoNumber++, "Nguyen Van", "A", 2000, "nam"));
		list_student.add(new SinhVien(autoNumber++, "Nguyen Van", "a", 2000, "nam"));
		list_student.add(new SinhVien(autoNumber++, "Nguyen Thi", "C", 2000, "nu"));
		list_student.add(new SinhVien(autoNumber++, "Nguyen Van", "a", 2000, "nam"));
	}
	
	public static void thucThi() {
		try {
			do {				
				System.out.println("\n********CAP NHAT THONG TIN SINH VIEN********");
				System.out.println("\tMoi ban lua chon 1 chuc nang");
				System.out.println("\t1. Them moi sinh vien");
				System.out.println("\t2. Sua thong tin sinh vien");
				System.out.println("\t3. Xoa thong tin sinh vien");
				System.out.println("\t4. Xem danh sach sinh vien");
				System.out.println("\t5. Sap xep sinh vien theo ten");
				System.out.println("\t0. Quay lai");
				
				System.out.print("\tLua chon cua ban: ");
				int chon = Integer.parseInt(sc.nextLine());
				
				switch (chon) {
				case 1: them(); break;
				case 2: sua(); break;
				case 3: xoa(); break;
				case 4: xem(); break;
				case 5: sapXep(); break;
				case 0: return;
				default: System.out.println("\tLua chon khong hop le");
				}
			} while (true);
		}
		catch (NumberFormatException e) {
			System.out.println("\tCo loi, xin thu lai");
		}
	}

	private static void them() {
		try {
			System.out.println("\t-----Them thong tin sinh vien-----");
			System.out.print("\tNhap ma sinh vien: ");
			int code = Integer.parseInt(sc.nextLine());
			if (code<101) {
				System.out.println("\tMa khong hop le");
				return;
			}
			
			int index = indexOf(code);
			if (index!=-1) {
				System.out.println("\tSinh vien nay da co trong danh sach");
				return;
			}
			
			System.out.print("\tNhap ho dem: ");
			String hoDem = sc.nextLine();
			if (hoDem.length()==0) {
				System.out.println("\tHo dem khong duoc de trong");
				return;
			}
			
			System.out.print("\tNhap ten: ");
			String ten = sc.nextLine();
			if (ten.length()==0) {
				System.out.println("\tTen khong duoc de trong");
				return;
			}
			
			System.out.print("\tNhap nam sinh: ");
			int namSinh = Integer.parseInt(sc.nextLine());
			if (namSinh<1900) {
				System.out.println("\tNam sinh khong hop le");
				return;
			}
			
			System.out.print("\tNhap gioi tinh: ");
			String gioiTinh = sc.nextLine();
			if (gioiTinh.length()==0) {
				System.out.println("\tGioi tinh khong duoc de trong");
				return;
			}
			
			list_student.add(new SinhVien(code, hoDem, ten, namSinh, gioiTinh));
			System.out.println("\tThem moi thanh cong");
		}
		catch (NumberFormatException e) {
			System.out.println("\tThong tin khong hop le");		}
	}

	private static void sua() {
		try {
			System.out.print("\tNhap ma sinh vien: ");
			int code = Integer.parseInt(sc.nextLine());
			if (code<101) {
				System.out.println("\tMa khong hop le");
				return;
			}
			int index = indexOf(code);
			if (index==-1) {
				System.out.println("\tSinh vien chua co trong danh sach, quay lai(0)->an 1 de them vao danh sach");
				return;
			}
			
			do {				
				System.out.println("\n-----Sua thong tin sinh vien-----");
				System.out.println("\tMoi ban lua chon 1 chuc nang");
				System.out.println("\t1. Sua ho dem");
				System.out.println("\t2. Sua ten");
				System.out.println("\t3. Sua nam sinh");
				System.out.println("\t4. Sua gioi tinh");
				System.out.println("\t0. Quay lai");
				
				System.out.print("\tLua chon cua ban: ");
				int chon = Integer.parseInt(sc.nextLine());
				switch (chon) {
				case 1: 
					System.out.print("\tNhap ho dem: ");
					String hoDem = sc.nextLine();
					if (hoDem.length()==0) {
						System.out.println("\tHo dem khong duoc de trong");
						return;
					}
					list_student.get(indexOf(code)).setHoDem(hoDem);
					System.out.println("\tSua thanh cong");
					break;
				case 2:
					System.out.print("\tNhap ten: ");
					String ten = sc.nextLine();
					if (ten.length()==0) {
						System.out.println("\tTen khong duoc de trong");
						return;
					}
					list_student.get(indexOf(code)).setTen(ten);
					System.out.println("\tSua thanh cong");
					break;
				case 3: 
					System.out.print("\tNhap nam sinh: ");
					int namSinh = Integer.parseInt(sc.nextLine());
					if (namSinh<1900) {
						System.out.println("\tNam sinh khong hop le");
						return;
					}
					list_student.get(indexOf(code)).setNamSinh(namSinh);
					System.out.println("\tSua thanh cong");
					break;
				case 4: 
					System.out.print("\tNhap gioi tinh: ");
					String gioiTinh = sc.nextLine();
					if (gioiTinh.length()==0) {
						System.out.println("\tGioi tinh khong duoc de trong");
						return;
					}
					list_student.get(indexOf(code)).setGioiTinh(gioiTinh);
					System.out.println("\tSua thanh cong");
					break;
				case 0: return;
				default: System.out.println("\tLua chon khong hop le");
				}
			} while (indexOf(code)!=-1);
		}
		catch (NumberFormatException e) {
			System.out.println("\tThong tin khong hop le");		}
	}

	private static void xoa() {
		try {
			System.out.println("\t-----Xoa thong tin sinh vien-----");
			System.out.print("\tNhap ma sinh vien: ");
			int code = Integer.parseInt(sc.nextLine());
			if (code<101) {
				System.out.println("\tMa khong hop le");
				return;
			}
			
			int index = indexOf(code);
			if (index==-1) {
				System.out.println("\tSinh vien chua co trong danh sach, an 1 de them vao danh sach");
				return;
			}
			
			int dem =QuanLyDiem.indexOfDemSV(code);
			if (dem !=0) {
				System.out.println("\tSinh vien da co diem, khong duoc xoa");
				return;
			}
			
			list_student.remove(indexOf(code));
			System.out.println("\tXoa thanh cong");
		}
		catch (NumberFormatException e) {
			System.out.println("\tThong tin khong hop le");		}
	}

	private static void xem() {
		System.out.println("\t-----DANH SACH SINH VIEN-----");
		System.out.printf("%-3s %-5s %-25s %-8s %-9s%n",
				"STT", "Ma SV", "Ho ten", "Nam sinh", "Gioi tinh");
		int stt = 1;
		for (int i = 0; i<list_student.size();i++) {
			System.out.printf("%-4d", stt++);
			list_student.get(i).hienThi();
		}
		if (stt ==1) {
			System.out.println("\tDanh sach trong");
		}
	}

	private static void sapXep() {
		Collections.sort(list_student, new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getTen().trim().compareToIgnoreCase(o2.getTen().trim());
			}
		});
		
	}
	
	//Ham nhan ma sinh vien tra ve id
	public static int indexOf(int code) {
		for (int i = 0; i<list_student.size(); i++) {
			if (list_student.get(i).getMa_sv()==code) {
				return i;
			}
		}
		return -1;
	}
	
	//Ham nhan ma sinh vien tra ve ho ten sinh vien
	public static String indexOfName(int code) {
		for (int i = 0; i<list_student.size(); i++) {
			if (list_student.get(i).getMa_sv()==code) {
				return list_student.get(i).getHoDem() + " " +list_student.get(i).getTen();
			}
		}
		return null;
	}
	
	//Ham nhan index tra ve ho ten sinh vien
	public static String indexOfNameByID(int id) {
		for (int i = 0; i<list_student.size(); i++) {
			if (id == i) {
				return list_student.get(id).getHoDem() + " " +list_student.get(id).getTen();
			}
		}
		return null;
	}
	
	//Ham nhan SinhVien tra ve ho ten sinh vien
	public static String indexOfNameBySV(SinhVien s) {
		for (int i = 0; i<list_student.size(); i++) {
			if (list_student.get(i)==s) {
				return list_student.get(i).getHoDem() + " " +list_student.get(i).getTen();
			}
		}
		return null;
	}
	
	//Ham nhan SinhVien tra ve ma sinh vien
	public static int indexOfIDByCode(int code) {
		for (int i = 0; i<list_student.size(); i++) {
			if (list_student.get(i).getMa_sv()==code) {
				return list_student.get(i).getMa_sv();
			}
		}
		return -1;
	}

	public static ArrayList<SinhVien> getList_student() {
		return list_student;
	}

	public static void setList_student(ArrayList<SinhVien> list_student) {
		QuanLySinhVien.list_student = list_student;
	}
}
