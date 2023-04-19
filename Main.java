import java.io.IOException;
import java.util.Scanner;
import QuanLyChung.QuanLyChung;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        QuanLyChung qlc = new QuanLyChung();

        Scanner scan = new Scanner(System.in);
        int choose;
        do {
            MENU();
            System.out.print("Lua chon: ");
            choose = Integer.parseInt(scan.nextLine());
            switch (choose) {
                case 1:
                    qlc.NhapHang();
                    break;
                case 2:
                    qlc.BanHang(); 
                    break;
                case 3:
                    qlc.ChucNangPerson();
                    break;
                case 4:
                    qlc.ChucNangComputer();
                    break;
                case 5:
                    qlc.ChucNangHoaDon();
                    break;
                case 6:
                    qlc.CacYeuCauThi();
                    break;
                default: 
                    break;
            }
        } while (choose != 7);
    }

    public static void MENU() {
        System.out.println("---------MENU---------");
        System.out.println("1. Nhap hang");
        System.out.println("2. Ban hang");
        System.out.println("3. Cac thao tac voi nhan su");
        System.out.println("4. Cac thao tac voi san pham");
        System.out.println("5. Cac thao tac voi hoa don");
        System.out.println("6. Cac yeu cau thi");
        System.out.println("7. Thoat chuong trinh");
    }
}
