package QuanLyNhanSu;

import NgayThangNam.Ngay;

public class Provider extends Person {

    public Provider(String maSo, String fullName, Ngay date, String soCCCD, String phoneNum) {
        super(maSo, fullName, date, soCCCD, phoneNum);
    }

    public Provider() {
    }
    
    @Override
    public void Nhap() {
        super.Nhap();
    }

    @Override
    public String toString() {
        return "Nha phan phoi " + super.toString();
    }
}
