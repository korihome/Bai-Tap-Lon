package QuanLyNhanSu;

import NgayThangNam.Ngay;

public class Customer extends Person {

    public Customer(String maSo, String fullName, Ngay date, String soCCCD, String phoneNum) {
        super(maSo, fullName, date, soCCCD, phoneNum);
    }

    public Customer() {
    }

    @Override
    public void Nhap() { 
        super.Nhap();
    }

    @Override
    public String toString() {
        return "Khach hang " + super.toString();
    }
}