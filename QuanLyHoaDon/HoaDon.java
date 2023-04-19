package QuanLyHoaDon;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

import NgayThangNam.*;
import QuanLyNhanSu.Person;
import QuanLyNhanSu.QuanLyNhanSu;
import QuanLyNhanSu.Staff;

public class HoaDon implements Serializable{
    private String maHD; 
    private Ngay ngayLapHD;
    private double tongBill;
    private Person nhanVien;
    
    public HoaDon(String maHD, Ngay ngayLapHD, double tongBill) {
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.tongBill = tongBill;
    }
    
    
    public HoaDon(){}
    
    public String getMaHD() {
        return maHD;
    }
    
    public Ngay getNgayLapHD() {
        return ngayLapHD;
    }
    
    public double getTongBill() {
        return tongBill;
    }

    public Person getNhanVien() {
        return nhanVien;
    }
    
    
    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setTongBill(double tongBill) {
        this.tongBill = tongBill;
    }

    public void setNgayLapHD(Ngay ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }


    public Ngay LayTTngay() {
        Ngay n = new Ngay();
        n.Nhap();
        return n;
    }

    public Staff LayTTnv() {
        Staff nv = new Staff();
        nv.Nhap();
        return nv;
    }

    public void Nhap() throws ClassNotFoundException, IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("-- Nhan vien lap hoa don");
        while (true) {
            nhanVien = new QuanLyNhanSu().TimKiem();
            if (nhanVien != null) break;
            System.out.println("Khong ton tai nhan vien");
        }
        System.out.println("-- Nhap thong tin hoa don");
        System.out.print("Nhap ma hoa don: ");
        maHD = scan.nextLine();
        System.out.print("Nhap ngay lap hoa don (dd/mm/yyyy): ");
        ngayLapHD = LayTTngay();
    }

    @Override
    public String toString() {
        return "HoaDon [maHD: " + maHD + ", ho ten nhan vien lap hoa don: "+ nhanVien.getFullName()+ 
        ", ma so nhan vien: " + nhanVien.getMaSo() + ", ngayLapHD: " + ngayLapHD.toString() + 
        ", Tong gia tri Hoa Don: " + tongBill + "]";
    }
}
