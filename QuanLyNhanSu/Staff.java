package QuanLyNhanSu;

import java.util.Scanner;

import NgayThangNam.Ngay;

public class Staff extends Person {
    private double hsl;

    public Staff(String maSo, String fullName, Ngay date, String soCCCD, String phoneNum, double hsl) {
        super(maSo, fullName, date, soCCCD, phoneNum);
        this.hsl = hsl;
    }
    
    public Staff() {
    }

    public double getHsl() {
        return hsl;
    }

    public void setHsl(double hsl) {
        this.hsl = hsl;
    }

    
    @Override
    public void Nhap() {
        super.Nhap();
        System.out.print("Nhap he so luong: ");
        hsl = Double.parseDouble(new Scanner(System.in).nextLine());
    }

    @Override
    public String toString() {
        return "Nhan vien " + super.toString() + " + [he so luong: " + hsl + "]";
    }
}
