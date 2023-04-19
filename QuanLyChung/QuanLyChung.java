package QuanLyChung;

import java.io.IOException;
import java.util.Scanner;

import QuanLyHoaDon.*;
import QuanLyNhanSu.*;
import QuanLySanPham.*;
import hoten_lop.BLL;

public class QuanLyChung {
    QuanLyNhanSu qlns = new QuanLyNhanSu();
    QuanLySanPham qlsp = new QuanLySanPham();
    QuanLyHoaDon qlhd = new QuanLyHoaDon();
    BLL a = new BLL();
    
    public void Sapxep() throws ClassNotFoundException, IOException {
        qlsp.Sapxep();
        qlns.Sapxep();
    }

    public void Start() throws ClassNotFoundException, IOException {
        qlsp.Start();
        qlns.Start();
        qlhd.Start();
    }

    
    public void NhapHang() throws ClassNotFoundException, IOException {
        System.out.println("-----Nhap thong tin hoa don-----");
        HDNhap hdn = new HDNhap();
        hdn.Nhap();
        qlhd.addHDN(hdn);
        qlns.addNPP(hdn.getNhaPP());
        qlsp.addSP(hdn.getComputers());
    }

    public void BanHang() throws ClassNotFoundException, IOException {
        System.out.println("-----Nhap thong tin hoa don-----");
        HDBan hdb = new HDBan();
        hdb.Nhap();
        qlhd.addHDB(hdb);
        qlns.addKH(hdb.getKhachHang());
        qlsp.removeSP(hdb.getComputers()); 
    }

    public void ChucNangComputer() throws IOException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        int choose;
        do {
            MenuChucNang();
            System.out.print("Lua chon: ");
            choose = Integer.parseInt(scan.nextLine());
            switch (choose) {
                case 1:
                    qlsp.Them();
                    break;
                case 2:
                    qlsp.Xoa();
                    break;
                case 3:
                    qlsp.Sua();
                    break;
                case 4:
                    qlsp.HienDS();
                    break;
                case 5:
                    while (true) {
                        Computer a = qlsp.TimKiem();
                        if (a == null) {
                            System.out.println("San pham khong ton tai. Nhap lai!!!");
                        } else {
                            System.out.println(a);
                            break;
                        }
                    }
                    break;
                case 6:
                    qlsp.WriteFile();
                    break;
                default:
                    break;
            }
        } while (choose != 7);
    }

    public void ChucNangPerson() throws ClassNotFoundException, IOException {
        Scanner scan = new Scanner(System.in);
        int choose;
        do {
            MenuChucNang();
            System.out.print("Lua chon: ");
            choose = Integer.parseInt(scan.nextLine());
            switch (choose) {
                case 1:
                    qlns.Them();
                    break;
                case 2:
                    qlns.Xoa();
                    break;
                case 3:
                    qlns.Sua();
                    break;
                case 4:
                    qlns.HienDS();
                    break;
                case 5:
                    while (true) {
                        Person a = qlns.TimKiem();
                        if (a == null) {
                            System.out.println("Doi tuong khong ton tai. Nhap lai!!!");
                        } else {
                            System.out.println(a);
                            break;
                        }
                    }
                    break;
                case 6:
                    qlns.WriteFile();
                    break;
                default:
                    break;
            }
        } while (choose != 7);
    }

    public void ChucNangHoaDon() throws ClassNotFoundException, IOException {
        Scanner scan = new Scanner(System.in);
        int choose;
        do {
            MenuChucNang();
            System.out.print("Lua chon: ");
            choose = Integer.parseInt(scan.nextLine());
            switch (choose) {
                case 1:
                    qlhd.Them();
                    break;
                case 2:
                    qlhd.Xoa();
                    break;
                case 3:
                    qlhd.Sua();
                    break;
                case 4:
                    qlhd.HienDS();
                    break;
                case 5:
                    qlhd.XuatTheoMaso();
                    break;
                case 6:
                    qlhd.WriteFile();
                    break;
                default:
                    break;
            }
        } while (choose != 7);
    }

    public void CacYeuCauThi() throws IOException {
        Scanner scan = new Scanner(System.in);
        int choose;
        do {
            System.out.println("1. Nhap danh sach");
            System.out.println("2. Hien danh sach sap xep theo ten");
            System.out.println("3. Tim gia tri thoa man x");
            System.out.println("4. Ghi file");
            System.out.println("5. Thoat");
            System.out.print("Lua chon: ");
            choose = Integer.parseInt(scan.nextLine());
            switch (choose) {
                case 1:
                    a.Nhap();
                    break;
                case 2:
                    a.SapxepTheoTen();
                    break;
                case 3:
                    a.TimGiaTriThoaManX();
                    break;
                case 4:
                    a.WriteFile();
                    break;
                default:
                    break;
            }
        } while (choose != 5);
    }

    public void MenuChucNang() {
        System.out.println("1. Them");
        System.out.println("2. Xoa");
        System.out.println("3. Sua thong tin");
        System.out.println("4. Hien danh sach");
        System.out.println("5. Tim kiem theo ma so");
        System.out.println("6. Luu du lieu vao file");
        System.out.println("7. Thoat");
    }
}
