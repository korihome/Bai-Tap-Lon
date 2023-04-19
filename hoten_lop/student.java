package hoten_lop;

import java.util.Scanner;

import NgayThangNam.Ngay;
import QuanLyNhanSu.Person;

public class student extends Person{
    private String nameClass;
    private double diemtb;

    public student(String maSo, String fullName, Ngay ngaySinh, String soCCCD, String phoneNum, String nameClass, double diemtb) {
        super(maSo, fullName, ngaySinh, soCCCD, phoneNum);
        this.nameClass = nameClass;
        this.diemtb = diemtb;
    }

    public student() {
        
    }
    
    public String getNameClass() {
        return nameClass;
    }
    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
    public double getDiemtb() {
        return diemtb;
    }
    public void setDiemtb(double diemtb) {
        this.diemtb = diemtb;
    }

    @Override
    public void Nhap() {
        Scanner scan = new Scanner(System.in);
        super.Nhap();
        System.out.println("Nhap ten lop");
        nameClass = scan.nextLine();
        System.out.println("Nhap diem trung binh");
        diemtb = Double.parseDouble(scan.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + "student [nameClass=" + nameClass + ", diemtb=" + diemtb + "]";
    }
}
