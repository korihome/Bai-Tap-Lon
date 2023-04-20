package QuanLyHoaDon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import NgayThangNam.Ngay;
import QuanLyNhanSu.Provider;
import QuanLySanPham.Computer;

public class HDNhap extends HoaDon {
    private Provider nhaPP;
    List<Computer> computers1 = new ArrayList<Computer>(); 


    public HDNhap(String maHD, Ngay ngayLapHD, double tongBill) {
        super(maHD, ngayLapHD, tongBill);
    }

    public HDNhap() {
    }

    public Provider getNhaPP() {
        return nhaPP;
    }
    
    public Provider LayTTnpp() {
        Provider a = new Provider();
        a.Nhap();
        return a; 
    }

    public List<Computer> getComputers() {
        return computers1;
    }

    @Override
    public void Nhap() throws ClassNotFoundException, IOException {
        Scanner scan = new Scanner(System.in);
        super.Nhap();
        System.out.println("-- Nhap thong tin nha phan phoi");
        nhaPP = LayTTnpp();
        System.out.println("-- Nhap thong tin san pham");
        System.out.print("Nhap so loai san pham: ");
        int soLoai = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < soLoai; i++) {
            Computer mt1 = new Computer();
            mt1.Nhap();
            setTongBill(getTongBill() + mt1.getSoLuong() * mt1.getPrice());
            computers1.add(mt1);
        }
    }

    @Override
    public String toString() {
        for (Computer computer : computers1) {
            System.out.println(computer);
        }
        return super.toString() + "\n" + nhaPP.toString()  + "\n";
    }
}
