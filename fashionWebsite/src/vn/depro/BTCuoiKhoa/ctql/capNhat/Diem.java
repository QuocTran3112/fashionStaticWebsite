package vn.depro.BTCuoiKhoa.ctql.capNhat;

public class Diem {
	
	private int ma_sv;
	private int ma_mh;
	private double diem;
	
	public void hienThi() {
		System.out.printf("%-25s %-12s %-4.1f%n",
				QuanLySinhVien.indexOfName(this.ma_sv), QuanLyMonHoc.indexOfName(this.ma_mh), this.diem);
	}
	
	public double tongDiem() {
		return this.diem* QuanLyMonHoc.indexOfHeSo(this.ma_mh);
	}
	
	public Diem() {
		super();
	}
	
	public Diem(int ma_sv, int ma_mh, double diem) {
		super();
		this.ma_sv = ma_sv;
		this.ma_mh = ma_mh;
		this.diem = diem;
	}
	public int getMa_sv() {
		return ma_sv;
	}
	public void setMa_sv(int ma_sv) {
		this.ma_sv = ma_sv;
	}
	public int getMa_mh() {
		return ma_mh;
	}
	public void setMa_mh(int ma_mh) {
		this.ma_mh = ma_mh;
	}
	public double getDiem() {
		return diem;
	}
	public void setDiem(double diem) {
		this.diem = diem;
	}
}
