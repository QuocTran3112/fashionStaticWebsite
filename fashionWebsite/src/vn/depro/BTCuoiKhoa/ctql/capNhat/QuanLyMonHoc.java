package vn.depro.BTCuoiKhoa.ctql.capNhat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLyMonHoc {
	
	static int autoNumber = 201; 
	
	static Scanner sc = new Scanner (System.in);
	
	static ArrayList<MonHoc> list_mh = new ArrayList<MonHoc>();
	
	public static void init() {
		list_mh.add(new MonHoc(autoNumber++, "Toan", 1.5));
		list_mh.add(new MonHoc(autoNumber++, "Van", 1.5));
		list_mh.add(new MonHoc(autoNumber++, "Anh", 2));
	}
	
	public static void thucThi() {
		try {
			do {				
				System.out.println("\n********CAP NHAT DANH SACH MON HOC********");
				System.out.println("\tMoi ban lua chon 1 chuc nang");
				System.out.println("\t1. Them moi mon hoc");
				System.out.println("\t2. Sua mon hoc");
				System.out.println("\t3. Xoa mon hoc");
				System.out.println("\t4. Xem danh sach mon hoc");
				System.out.println("\t5. Sap xep danh sach mon hoc");
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
			System.out.println("\tThong tin khong hop le");		}
	}

	private static void them() {
		try {
			System.out.println("\t-----Them thong tin mon hoc-----");
			System.out.print("\tNhap ma mon hoc: ");
			int code = Integer.parseInt(sc.nextLine());
			if (code<201) {
				System.out.println("\tMa mon hoc khong hop le");
				return;
			}
			
			int index = indexOf(code);
			if (index!=-1) {
				System.out.println("\tMon hoc nay da co trong danh sach");
				return;
			}
			
			System.out.print("\tNhap ten mon hoc: ");
			String tenMH = sc.nextLine();
			if (tenMH.length()==0) {
				System.out.println("\tTen mon hoc khong duoc de trong");
				return;
			}
			
			System.out.print("\tNhap he so mon hoc: ");
			double heso = Double.parseDouble(sc.nextLine());
			if (heso<=0) {
				System.out.println("\tHe so mon hoc phai lon hon 0");
				return;
			}
			
			list_mh.add(new MonHoc(code, tenMH, heso));
			System.out.println("\tThem thanh cong");
		}
		catch (NumberFormatException e) {
			System.out.println("\tThong tin khong hop le");		}
	}

	private static void sua() {
		try {
			System.out.print("\tNhap ma mon hoc: ");
			int code = Integer.parseInt(sc.nextLine());
			if (code<201) {
				System.out.println("\tMa mon hoc khong hop le");
				return;
			}
			
			int index = indexOf(code);
			if (index==-1) {
				System.out.println("\tMon hoc chua co trong danh sach, quay lai(0)->an 1 de them vao danh sach");
				return;
			}
			
			do {				
				System.out.println("\n-----Sua thong tin mon hoc-----");
				System.out.println("\tMoi ban lua chon 1 chuc nang");
				System.out.println("\t1. Sua ten mon hoc");
				System.out.println("\t2. Sua he so mon hoc");
				System.out.println("\t0. Quay lai");
				
				System.out.print("\tLua chon cua ban: ");
				int chon = Integer.parseInt(sc.nextLine());
				
				switch (chon) {
				case 1: 
					System.out.print("\tNhap ten mon hoc: ");
					String tenMH = sc.nextLine();
					if (tenMH.length()==0) {
						System.out.println("\tTen mon hoc khong duoc de trong");
						return;
					}
					list_mh.get(indexOf(code)).setTen(tenMH);
					System.out.println("\tSua thanh cong");
					break;
				case 2:
					System.out.print("\tNhap he so mon hoc: ");
					double heso = Double.parseDouble(sc.nextLine());
					if (heso<=0) {
						System.out.println("\tHe so mon hoc phai lon hon 0");
						return;
					}
					list_mh.get(indexOf(code)).setHeSo(heso);
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
			System.out.print("\tNhap ma mon hoc: ");
			int code = Integer.parseInt(sc.nextLine());
			if (code<201) {
				System.out.println("\tMa mon hoc khong hop le");
				return;
			}
			
			int index = indexOf(code);
			if (index==-1) {
				System.out.println("\tMon hoc khong co trong danh sach");
				return;
			}
			
			int dem = QuanLyDiem.indexOfDem(code);
			if (dem>0) {
				System.out.println("\tMon hoc nay da co sinh vien hoc, khong duoc xoa");
			}
			else {
				list_mh.remove(index);
				System.out.println("\tXoa thanh cong");
			}
		}
		catch (NumberFormatException e) {
			System.out.println("\tThong tin khong hop le");		}
	}

	private static void xem() {
		System.out.println("\t-----Danh sach mon hoc-----");
		System.out.printf("%-4s %-5s %-12s %-5s%n",
				"STT", "Ma MH", "Ten MH", "He so");
		int stt =1;
		for (int i = 0; i< list_mh.size(); i++) {
			System.out.printf("%-4d", stt++);
			list_mh.get(i).hienThi();
		}
		if (stt ==1) {
			System.out.println("\tDanh sach trong");
		}
	}

	private static void sapXep() {
		Collections.sort(list_mh, new Comparator<MonHoc>() {
			@Override
			public int compare(MonHoc o1, MonHoc o2) {
				return o1.getTen().trim().compareToIgnoreCase(o2.getTen().trim());
			}
		});
	}
	
	//Ham  nhan code tra ve id mon hoc
	public static int indexOf(int code) {
		for (int i = 0; i<list_mh.size(); i++) {
			if (list_mh.get(i).getMa_mh()==code) {
				return i;
			}
		}
		return -1;
	}
	
	//Ham nhan ma mon hoc tra ve ten mon hoc
	public static String indexOfName(int code) {
		for (int i = 0; i<list_mh.size(); i++) {
			if (list_mh.get(i).getMa_mh()==code) {
				return list_mh.get(i).getTen();
			}
		}
		return null;
	}
	
	//Ham nhan ma mon hoc tra ve he so
	public static double indexOfHeSo(int code) {
		for (int i = 0; i<list_mh.size(); i++) {
			if (list_mh.get(i).getMa_mh()==code) {
				return list_mh.get(i).getHeso();
			}
		}
		return 0;
	}
	
	
	//ham nhan ten mon hoc tra ve index
	public static int indexOfByName(String name) {
		for (int i = 0; i<list_mh.size();i++) {
			if (list_mh.get(i).getTen().compareToIgnoreCase(name)==0) {
				return i;
			}
		}
		return -1;
	}
		
	//Ham nhan MonHoc tra ve ten mon hoc
	public static String indexOfNameByMH(MonHoc s) {
		for (int i = 0; i<list_mh.size(); i++) {
			if (list_mh.get(i)==s) {
				return list_mh.get(i).getTen();
			}
		}
		return null;
	}

	public static ArrayList<MonHoc> getList_mh() {
		return list_mh;
	}

	public static void setList_mh(ArrayList<MonHoc> list_mh) {
		QuanLyMonHoc.list_mh = list_mh;
	}
}
