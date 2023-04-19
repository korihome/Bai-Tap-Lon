package QuanLyHoaDon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

import Interface.ThemSuaXoa;
import NgayThangNam.Ngay;


public class QuanLyHoaDon implements ThemSuaXoa {
    List<HoaDon> hdList = new ArrayList<HoaDon>();
    static final String FName="QuanLyHoaDon.bin";

    public void Start() throws ClassNotFoundException, IOException {
        hdList = ReadFile();
    }

    //Hien danh sach
    public void HienDS() throws ClassNotFoundException, IOException {
        List<HoaDon> kq = ReadFile();
        System.out.println("--------Xuat danh sach Hoa Don--------");
        for (HoaDon hoaDon : kq) {
            System.out.println(hoaDon);
        }
    }

    //Them hoa don nhap/ban vao danh sach hoa don
    public void addHDN(HDNhap hdn) {                
        hdList.add(hdn);
    }

    public void addHDB(HDBan hdb) {
        hdList.add(hdb);
    }

    //ghi du lieu hoa don vao file 
    public void WriteFile() throws IOException {
		FileOutputStream fout =null;
		ObjectOutputStream out = null;
		try {
			fout = new FileOutputStream(FName);
			out = new ObjectOutputStream(fout);
			out.writeInt(hdList.size());
			for (HoaDon hd : hdList) {
				out.writeObject(hd);
			}
        System.out.println("Ghi file thanh cong");
		} finally {
			if(fout != null) fout.close();
			if(out != null) out.close();
		}
	}

    //Doc du lieu hoa don tu file
    public List<HoaDon> ReadFile() throws IOException, ClassNotFoundException{
		List<HoaDon> kq = new ArrayList<>();
		FileInputStream fin = null;
		ObjectInputStream in = null;
		try {
			fin = new FileInputStream(FName);
			in = new ObjectInputStream(fin);
			int sl = in.readInt();
			while(true) {
				HoaDon a = (HoaDon) in.readObject();
				kq.add(a);
				sl--;
				if(sl == 0) break;
			}
		} finally {
			if(fin != null) fin.close();
			if(in != null) in.close();
		}
		return kq;
	}


    //Tim kiem theo ma so
    public void XuatTheoMaso() throws ClassNotFoundException, IOException {
        List<HoaDon> kq = ReadFile();
        System.out.print("Nhap ma so hoa don: ");
        String maso = new Scanner(System.in).nextLine();
        int check = 0;
        for (HoaDon hoaDon : kq) {
            if (hoaDon.getMaHD().equals(maso)) {
                System.out.println("--------Xuat Hoa Don--------");
                System.out.println(hoaDon);
                ++check;
            }
        }
        if (check == 0) {
            System.out.println("Hoa don khong ton tai");
        }
    }


    //Them/sua/xoa
    @Override
    public void Them() {
        System.out.println("Them hoa don nam trong chuc nang Nhap hang va Ban hang");
    }

    @Override
    public void Sua() {
        Scanner scan = new Scanner(System.in);
        int check = 0;
        System.out.print("Nhap ma so hoa don muon sua: ");
        String ms = scan.nextLine();
        for (HoaDon hd : hdList) {
            if (hd.getMaHD().equals(ms)) {
                System.out.print("Ma hoa don moi: ");
                ms = scan.nextLine();
                hd.setMaHD(ms);
                System.out.print("Ngay lap hoa don moi: ");
                Ngay a = new Ngay();
                a.Nhap();
                hd.setNgayLapHD(a); 
                ++check;
            }
        }
        if (check == 0) {
            System.out.println("Hoa don khong ton tai");
        }
    }

    @Override
    public void Xoa() {
        System.out.println("Nhap ma so hoa don muon xoa: ");
        String maso = new Scanner(System.in).nextLine();
        int check = 0;
        for (HoaDon hd : hdList) {
            if (hd.getMaHD().equals(maso)) {
                hdList.remove(hd);
                ++check;
                break;
            }
        }
        if (check == 0) {
            System.out.println("Hoan don khong ton tai");
        }
    }

}
