package QuanLySanPham;

import java.io.Serializable;
import java.util.Scanner;

import NgayThangNam.Ngay;

public class Computer implements Serializable{
    private String maSo;
    private String nameBrand;
    private String nameCountry;
    private String nameComputer;
    private Ngay dateSX;
    private double price;
    private int soLuong;
    private int thoiGianBaoHanh;

    public Computer(String maSo, String nameBrand, String nameCountry, String nameComputer, 
                    Ngay dateSX, double price, int soLuong, int thoiGianBaoHanh) 
    {
        this.maSo = maSo;
        this.nameBrand = nameBrand;
        this.nameCountry = nameCountry;
        this.nameComputer = nameComputer;
        this.dateSX = dateSX;
        this.price = price;
        this.soLuong = soLuong;
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public Computer(){}

    public String getMaSo() {
        return maSo;
    }

    public String getNameBrand() {
        return nameBrand;
    }
    public String getNameCountry() {
        return nameCountry;
    }
    public String getNameComputer() {
        return nameComputer;
    }
    public Ngay getDateSX() {
        return dateSX;
    }
    public double getPrice() {
        return price;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }
    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }
    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }
    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }
    public void setNameComputer(String nameComputer) {
        this.nameComputer = nameComputer;
    }
    public void setDateSX(Ngay dateSX) {
        this.dateSX = dateSX;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public boolean setSoLuong(int soLuong) {
        if (soLuong >= 0 ) {
            this.soLuong = soLuong;
            return true;
        } else return false;
    }
    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }
    
    public void SaoChepTT(Computer a) {
        a.setMaSo(getMaSo());
        a.setNameBrand(getNameBrand());
        a.setNameCountry(getNameCountry());
        a.setDateSX(getDateSX());
        a.setNameComputer(getNameComputer());
        a.setThoiGianBaoHanh(getThoiGianBaoHanh());
        a.setSoLuong(getSoLuong());
        a.setPrice(getPrice());
    }

    public Ngay LayTTngay() {
        Ngay n = new Ngay();
        n.Nhap();
        return n;
    }


    public void Nhap() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap ma so san pham: ");
        maSo = scan.nextLine();
        System.out.print("Nhap ten hang san xuat: ");
        nameBrand = scan.nextLine();
        System.out.print("Nhap ten nuoc xuat xu: ");
        nameCountry = scan.nextLine();
        System.out.print("Ten san pham: ");
        nameComputer = scan.nextLine();
        System.out.print("Nhap ngay san xuat (dd/mm/yyyy): ");
        dateSX = LayTTngay();
        System.out.print("Nhap gia ban: ");
        price = Double.parseDouble(scan.nextLine());
        System.out.print("Nhap so luong: ");
        soLuong = Integer.parseInt(scan.nextLine());
        System.out.print("Nhap thoi gian bao hanh (theo thang): ");
        thoiGianBaoHanh = Integer.parseInt(scan.nextLine());
    }

    @Override
    public String toString() {
        return "Computer [Ma so: " + maSo + ", nameBrand: " + nameBrand + ", nameCountry: " + nameCountry
                + ", nameComputer: " + nameComputer + ", dateSX: " + dateSX + ", price/san pham: " + price + ", soLuong: " + soLuong
                + ", thoiGianBaoHanh: " + thoiGianBaoHanh + "]";
    }
}
