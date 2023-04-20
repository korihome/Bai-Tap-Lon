package QuanLySanPham;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import Interface.ThemSuaXoa;

public class QuanLySanPham implements ThemSuaXoa{
    List<Computer> computersList = new ArrayList<Computer>();
    static final String FName="QuanLySanPham.bin";

    public void Start() throws ClassNotFoundException, IOException {
        computersList = ReadFile();
    }

    //Hien danh sach
    public void HienDS() throws ClassNotFoundException, IOException {
        List<Computer> kq = ReadFile();
        for (Computer computer : kq) {
            System.out.println(computer);
        }
    }

    //ghi du lieu san pham vao file 
    public void WriteFile() throws IOException {
		FileOutputStream fout =null;
		ObjectOutputStream out = null;
		try {
			fout = new FileOutputStream(FName);
			out = new ObjectOutputStream(fout);
			out.writeInt(computersList.size());
			for (Computer comp : computersList) {
				out.writeObject(comp);
			}
        System.out.println("Ghi file thanh cong");
		} finally {
			if(fout!=null) fout.close();
			if(out!=null) out.close();
		}
	}
    
    //Doc du lieu san pham tu file
    public List<Computer> ReadFile() throws IOException, ClassNotFoundException{
		List<Computer> kq = new ArrayList<>();
		FileInputStream fin =null;
		ObjectInputStream in = null;
		try {
			fin = new FileInputStream(FName);
			in = new ObjectInputStream(fin);
			int sl = in.readInt();
			while(true) {
				Computer kh = (Computer) in.readObject();
				kq.add(kh);
				sl--;
				if(sl==0)break;
			}
		} finally {
			if(fin !=null) fin.close();
			if(in!=null) in.close();
		}
		return kq;
	}

    //Them san pham vao danh sach sau khi nhap
    public void addSP(List<Computer> computer) {
        if (computersList.isEmpty() == false) {
            for (Computer comp1 : computer) {
                int check = 0;
                for (Computer comp2 : computersList) {
                    if (comp1.getNameComputer().equals(comp2.getNameComputer())) {
                        comp2.setSoLuong(comp2.getSoLuong() + comp1.getSoLuong());
                        ++check;
                        break;
                    } 
                }
                if (check == 0) {
                    Computer comp3 = new Computer();
                    comp1.SaoChepTT(comp3);
                    computersList.add(comp3);
                }
            }
        } else {
            for (Computer comp1 : computer) {
                Computer comp3 = new Computer();
                comp1.SaoChepTT(comp3);
                computersList.add(comp3);
            }
        }
    }
    
    //Cap nhat lai so luong tung san pham sau khi ban
    public void removeSP(List<Computer> computer) {
        int check1 = 0;
        for (Computer comp2 : computer) {
            for (Computer comp1 : computersList) {
                if (comp2.getMaSo().equals(comp1.getMaSo())) {
                    comp1.setSoLuong(comp1.getSoLuong() - comp2.getSoLuong());
                    break;
                }
            }
        }
    }

    //Tim kiem theo ma so
    public Computer TimKiem() throws ClassNotFoundException, IOException {
        List<Computer> kq = ReadFile();
        System.out.print("Nhap ma may tinh: ");
        String maso = new Scanner(System.in).nextLine();
        for (Computer comp : kq) {
            if (comp.getMaSo().equals(maso)) {
                return comp;
            }
        }
        return null;
    }

    //Them/sua/xoa
    @Override
    public void Them() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap so loai san pham muon them: ");
        int soLoai = Integer.parseInt(scan.nextLine());

        List<Computer> Comp = new ArrayList<Computer>();
        for (int i = 0; i < soLoai; i++) {
            Computer mt = new Computer();
            mt.Nhap();  
            Comp.add(mt);
        }

        if (computersList.isEmpty() == false) {
            for (Computer comp1 : Comp) {
                int check = 0;
                for (Computer comp2 : computersList) {
                    if (comp1.getNameComputer().equals(comp2.getNameComputer())) {
                        comp2.setSoLuong(comp2.getSoLuong() + comp1.getSoLuong());
                        ++check;
                        break;
                    }
                }
                if (check == 0) {
                    computersList.add(comp1);
                }
            }
        } else {
            for (Computer comp1 : Comp) {
                computersList.add(comp1);
            }
        }
    }

    @Override
    public void Sua() {
        Scanner scan = new Scanner(System.in);
        int check = 0;
        System.out.print("Nhap ma so san pham muon sua: ");
        String ms = scan.nextLine();
        for (Computer comp : computersList) {
            if (comp.getMaSo().equals(ms)) {
                comp.Nhap();
                ++check;
            }
        }
        if (check == 0) {
            System.out.println("San pham khong ton tai");
        }
    }

    @Override
    public void Xoa() {
        Scanner scan = new Scanner(System.in);
        int check = 0;
        System.out.print("Nhap ma so san pham muon xoa: ");
        String ms = scan.nextLine();
        for (Computer comp : computersList) {
            if (comp.getMaSo().equals(ms)) {
                computersList.remove(comp);
                ++check;
                break;
            }
        }
        if (check == 0) {
            System.out.println("San pham khong ton tai");
        }
    }

    //làm tương tự với người và hóa đơn
    //dòng return đang chạy là từ bé đến lớn
    //dòng return comment là từ lớn đến bé
    //đây là sắp xếp theo số lượng, muốn sắp xếp theo cái khác thì thay getSoluong bằng get cái muốn xếp nhé
    //tớ lấy danh sách trong file ra sắp xếp, nên nhớ lưu file trước khi thao tác nha
    public void Sapxep() throws ClassNotFoundException, IOException {
        List<Computer> computers = ReadFile();   
        Collections.sort(computers, new Comparator<Computer>() {

            @Override
            public int compare(Computer o1, Computer o2) {
                return o1.getNameComputer().compareTo(o2.getNameComputer());
            }
        });
        for (Computer computer : computers) {
            System.out.println(computer);
        }
    }
}
