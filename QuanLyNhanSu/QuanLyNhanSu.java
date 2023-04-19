package QuanLyNhanSu;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import Interface.ThemSuaXoa;

public class QuanLyNhanSu implements ThemSuaXoa{
    List<Person> personList = new ArrayList<Person>();
    static final String FName = "QuanLyNhanSu.bin";

    public void Start() throws ClassNotFoundException, IOException {
        personList = ReadFile();
    }
    
    //Hien danh sach
    public void HienDS() throws ClassNotFoundException, IOException {
        List<Person> kq = ReadFile();
        for (Person person : kq) {
            System.out.println(person);
        }
    }

    //ghi du lieu nhan su vao file 
    public void WriteFile() throws IOException {
		FileOutputStream fout =null;
		ObjectOutputStream out = null;
		try {
			fout = new FileOutputStream(FName);
			out = new ObjectOutputStream(fout);
			out.writeInt(personList.size());
			for (Person comp : personList) {
				out.writeObject(comp);
			}
            System.out.println("Ghi file thanh cong");
		} finally {
			if(fout != null) fout.close();
			if(out != null) out.close();
		}
	}

    //Doc du lieu nhan su tu file 
    public List<Person> ReadFile() throws IOException, ClassNotFoundException{
		List<Person> kq = new ArrayList<>();
		FileInputStream fin =null;
		ObjectInputStream in = null;
		try {
			fin = new FileInputStream(FName);
			in = new ObjectInputStream(fin);
			int sl = in.readInt();
			while(true) {
				Person a = (Person) in.readObject();
				kq.add(a);
				sl--;
				if(sl==0)break;
			}
		} finally {
			if(fin !=null) fin.close();
			if(in!=null) in.close();
		}
		return kq;
	}
    
    //Tim kiem theo ma so
    public Person TimKiem() throws ClassNotFoundException, IOException {
        List<Person> kq = ReadFile();
        System.out.print("Nhap ma so: ");
        String id = new Scanner(System.in).nextLine();
        if (kq != null) {
            for (Person person : kq) {
                if (person.getMaSo().equals(id)) {
                    return person;
                }
            }
        }
        return null;
    }

    //Them nha phan phoi moi vao danh dach tu hoa don
    public void addNPP(Provider npp) {
        int check = 0;
        for (Person person : personList) {
            if (person.getSoCCCD().equals(npp.getSoCCCD())) {
                ++check;
                break;
            }
        }
        if (check == 0) {
            personList.add(npp);
        }
    }

    //Them khach hang moi vao danh dach tu hoa don
    public void addKH(Customer kh) {
        int check = 0;
        for (Person person : personList) {
            if (person.getSoCCCD().equals(kh.getSoCCCD())) {
                ++check;
                break;
            }
        }
        if (check == 0) {
            personList.add(kh);
        }
    }
    
    //Them/sua/xoa
    @Override
    public void Them() {
        Scanner scan = new Scanner(System.in);
        System.out.println("- Them nhan vien");
        System.out.println("Nhap so nhan vien muon them: ");
        int sl = Integer.parseInt(scan.nextLine());

        List<Person> people = new ArrayList<Person>();
        for (int i = 0; i < sl; i++) {
            Staff a = new Staff();
            a.Nhap();
            people.add(a);
        }
    }
    
    @Override
    public void Sua() {
        Scanner scan = new Scanner(System.in);
        int check = 0;
        System.out.print("Nhap ma so doi tuong muon sua: ");
        String ms = scan.nextLine();
        for (Person person : personList) {
            if (person.getMaSo().equals(ms)) {
                person.Nhap();
                ++check;
            }
        }
        if (check == 0) {
            System.out.println("Doi tuong khong ton tai");
        }
    }

    @Override
    public void Xoa() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap ma so doi tuong muon xoa: ");
        String ms = scan.nextLine();
        int check = 0;
        for (Person person : personList) {
            if (person.getMaSo().equals(ms)) {
                personList.remove(person);
                ++check;
                break;
            } 
        }
        if (check == 0) {
            System.out.println("Doi tuong khong ton tai");
        }
    }

    public void Sapxep() throws ClassNotFoundException, IOException {
        List<Person> computers = ReadFile();   
        Collections.sort(computers, new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFullName().compareTo(o2.getFullName());
            }
        });
        for (Person person : computers) {
            System.out.println(person);
        }
    }
}
