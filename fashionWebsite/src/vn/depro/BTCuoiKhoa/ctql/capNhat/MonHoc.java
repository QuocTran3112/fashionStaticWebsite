package vn.depro.BTCuoiKhoa.ctql.capNhat;

public class MonHoc {
	
	private int ma_mh;
	private String ten;
	private double heso;
	
	public void hienThi() {
		System.out.printf("%-5d %-12s %-5.1f%n",
				this.ma_mh, this.ten, this.heso);
	}
	
	public MonHoc() {
		super();
	}
	
	public MonHoc(int ma_mh, String ten, double heso) {
		super();
		this.ma_mh = ma_mh;
		this.ten = ten;
		this.heso = heso;
	}
	
	public int getMa_mh() {
		return ma_mh;
	}
	public void setMa_mh(int ma_mh) {
		this.ma_mh = ma_mh;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public double getHeso() {
		return heso;
	}
	public void setHeSo(double heso) {
		this.heso = heso;
	}
	
}
