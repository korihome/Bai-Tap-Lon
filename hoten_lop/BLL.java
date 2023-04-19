package hoten_lop;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BLL {
    List<student> studentList = new ArrayList<student>();

    public void Nhap() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap so luong student");
        int sl = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < sl; i++) {
            student a = new student();
            a.Nhap();
            studentList.add(a);
        }
    }

    public void Hien() {
        for (student student : studentList) {
            System.out.println(student);
        }
    }

    public void SapxepTheoTen() {
        Collections.sort(studentList, new Comparator<student>() {

            @Override
            public int compare(student o1, student o2) {
                return o1.getFullName().compareTo(o2.getFullName());
            }
            
        });
        Hien();
    }

    public void TimGiaTriThoaManX() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap diem trung binh: ");
        double diem = Double.parseDouble(scan.nextLine());
        for (student student : studentList) {
            if (student.getDiemtb() >= diem) {
                System.out.println(student);
            }
        }
    }

    public void WriteFile() throws IOException {
		FileOutputStream fout =null;
		ObjectOutputStream out = null;
		try {
			fout = new FileOutputStream("thijava.dat");
			out = new ObjectOutputStream(fout);
			out.writeInt(studentList.size());
			for (student student : studentList) {
				out.writeObject(student);
			}
        System.out.println("Ghi file thanh cong");
		} finally {
			if(fout != null) fout.close();
			if(out != null) out.close();
		}
	}
}
