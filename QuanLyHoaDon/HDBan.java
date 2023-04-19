package QuanLyHoaDon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import NgayThangNam.Ngay;
import QuanLyNhanSu.Customer;
import QuanLySanPham.Computer;
import QuanLySanPham.QuanLySanPham;
 
public class HDBan extends HoaDon {
    private Customer khachHang;
    List<Computer> computers1 = new ArrayList<Computer>(); 

    public HDBan(String maHD, Ngay ngayLapHD, double tongBill) {
        super(maHD, ngayLapHD, tongBill);
    }

    public HDBan() {
    }
    
    public Customer getKhachHang() {
        return khachHang;
    }

    public Customer LayTTkh() {
        Customer a = new Customer();
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
        System.out.println("-- Nhap thong tin khach hang");
        khachHang = LayTTkh();
        System.out.print("-- Nhap so loai san pham: ");
        int soLoai = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < soLoai; i++) {
            while (true) {
                Computer a = new QuanLySanPham().TimKiem();
                if (a != null) {
                    System.out.print("Nhap so luong mua: ");
                    while (true) {
                        int soluong = Integer.parseInt(scan.nextLine());
                        if (a.setSoLuong(a.getSoLuong() - soluong)) {
                            setTongBill(getTongBill() + soluong * a.getPrice());
                            a.setSoLuong(soluong);
                            computers1.add(a);
                            break;
                        }
                        System.out.println("So luong trong kho khong du");
                    }
                    break;
                }
                System.out.println("San pham khong ton tai. Nhap lai!!!");
            }
        }
    }

    @Override
    public String toString() {
        for (Computer computer : computers1) {
            System.out.println(computer);
        }
        return super.toString() + "\n" +khachHang.toString() + "\n";
    }
}
