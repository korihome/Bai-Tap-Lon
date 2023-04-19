package NgayThangNam;

import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Ngay implements Serializable {
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();

    public void setDate(Date date) {
            this.date = date;
    }
    
    public void Nhap() {
        Scanner scan = new Scanner(System.in);
            try {
                date = df.parse(scan.nextLine());
            } catch (Exception e) {}
    }
 
    @Override
    public String toString() {
        return df.format(date);
    }
}

