package QuanLyNhanSu;

import java.io.Serializable;
import java.util.Scanner;

import NgayThangNam.Ngay;

public class Person implements Serializable {
    private String maSo;
    private String fullName;
    private Ngay ngaySinh;
    private String soCCCD;
    private String phoneNum;

    public Person(String maSo, String fullName, Ngay ngaySinh, String soCCCD, String phoneNum) {
        this.maSo = maSo;
        this.fullName = fullName;
        this.ngaySinh = ngaySinh;
        this.soCCCD = soCCCD;
        this.phoneNum = phoneNum;
    }

    public Person(){}

    public String getMaSo() {
        return maSo;
    }

    public String getFullName() {
        return fullName;
    }

    public Ngay getNgaySinh() {
        return ngaySinh;
    }

    public String getSoCCCD() {
        return soCCCD;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setNgaySinh(Ngay ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setSoCCCD(String soCCCD) {
        this.soCCCD = soCCCD;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Ngay LayTTngaySinh() {
        Ngay n = new Ngay();
        n.Nhap();
        return n;
    }

    public void Nhap() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap ma so: ");
        maSo = scan.nextLine();
        System.out.print("Nhap ten: ");
        fullName = scan.nextLine();
        System.out.print("Nhap so CCCD: ");
        soCCCD = scan.nextLine();
        System.out.print("Nhap so dien thoai: ");
        phoneNum = scan.nextLine();
        System.out.print("Nhap ngay sinh (dd/mm/yyyy): ");
        ngaySinh = LayTTngaySinh();
    }

    @Override
    public String toString() {
        return "[maSo: " + maSo + ", fullName: " + fullName + ", ngaySinh: " + ngaySinh.toString() + ", soCCCD: " + soCCCD
                + ", phoneNum: " + phoneNum + "]";
    }
}
