package Test;
import java.util.Scanner;

public class khoahoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã khóa học: ");
        String maKhoaHoc = sc.nextLine();

        System.out.print("Nhập tên khóa học: ");
        String tenKhoaHoc = sc.nextLine();

        System.out.print("Nhập tên giảng viên: ");
        String giangVien = sc.nextLine();

        System.out.print("Nhập số tiết: ");
        int soTiet = sc.nextInt();

        System.out.print("Nhập học phí: ");
        double hocPhi = sc.nextDouble();

      
        Khoahocclass kh = new Khoahocclass(maKhoaHoc, tenKhoaHoc, giangVien, soTiet, hocPhi);
        System.out.println("\n== Thông tin khóa học vừa nhập ==");
        kh.hienThiThongTin();

        sc.close();
	}

}
