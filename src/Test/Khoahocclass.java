package Test;

public class Khoahocclass {

	private String maKhoaHoc;
	private String tenKhoaHoc;
	private String giangVien;
	private int soTiet;

	public Khoahocclass(String maKhoaHoc, String tenKhoaHoc, String giangVien, int soTiet, double hocPhi) {
		super();
		this.maKhoaHoc = maKhoaHoc;
		this.tenKhoaHoc = tenKhoaHoc;
		this.giangVien = giangVien;
		this.soTiet = soTiet;
		this.hocPhi = hocPhi;
	}

	private double hocPhi;

	public String getMaKhoaHoc() {
		return maKhoaHoc;
	}

	public void setMaKhoaHoc(String maKhoaHoc) {
		this.maKhoaHoc = maKhoaHoc;
	}

	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}

	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}

	public String getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(String giangVien) {
		this.giangVien = giangVien;
	}

	public int getSoTiet() {
		return soTiet;
	}

	public void setSoTiet(int soTiet) {
		this.soTiet = soTiet;
	}

	public double getHocPhi() {
		return hocPhi;
	}

	public void setHocPhi(double hocPhi) {
		this.hocPhi = hocPhi;
	}
	 public void hienThiThongTin() {
	        System.out.println("Mã khóa học: " + maKhoaHoc);
	        System.out.println("Tên khóa học: " + tenKhoaHoc);
	        System.out.println("Giảng viên: " + giangVien);
	        System.out.println("Số tiết: " + soTiet);
	        System.out.println("Học phí: " + hocPhi + " VND");
	    }
}
