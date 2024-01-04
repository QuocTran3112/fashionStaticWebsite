package vn.depro.BTCuoiKhoa.ctql.capNhat;

public class SinhVien {
	
	private int ma_sv;
	private String hoDem;
	private String ten;
	private int namSinh;
	private String gioiTinh;
	
	public void hienThi() {
		System.out.printf("%-5d %-25s %-8d %-9s%n",
				this.ma_sv, this.hoDem +" "+ this.ten, this.namSinh, this.gioiTinh);
	}
	
	public SinhVien() {
		super();
	}
	
	public SinhVien(int ma_sv, String hoDem, String ten, int namSinh, String gioiTinh) {
		super();
		this.ma_sv = ma_sv;
		this.hoDem = hoDem;
		this.ten = ten;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
	}
	
	public int getMa_sv() {
		return ma_sv;
	}
	public void setMa_sv(int ma_sv) {
		this.ma_sv = ma_sv;
	}
	public String getHoDem() {
		return hoDem;
	}
	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
}
