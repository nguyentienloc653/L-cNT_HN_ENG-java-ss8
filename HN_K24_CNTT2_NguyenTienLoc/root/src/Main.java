import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Student> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("===== QUAN LY DIEM SINH VIEN =====");
            System.out.println("1. Nhap danh sach sinh vien");
            System.out.println("2. Hien thi danh sach sinh vien");
            System.out.println("3. Tim kiem sinh vien theo hoc luc");
            System.out.println("4. Sap xep theo hoc luc giam dan");
            System.out.println("5. Thoat");
            System.out.println("==================================");
            System.out.print("Chon chuc nang: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    nhapDanhSach();
                    break;
                case 2:
                    hienThiDanhSach();
                    break;
                case 3:
                    timTheoHocLuc();
                    break;
                case 4:
                    sapXepTheoHocLuc();
                    break;
                case 5:
                    System.out.println("Thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (choice != 5);
    }
    static void nhapDanhSach() {
        System.out.print("Nhap so luong sinh vien: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Sinh vien thu " + (i + 1));

            String id;
            do {
                System.out.print("Ma SV: ");
                id = sc.nextLine();
                if (!id.matches("^SV\\d{3}$")) {
                    System.out.println("Ma sinh vien khong hop le");
                }
            } while (!id.matches("^SV\\d{3}$"));

            System.out.print("Ten: ");
            String name = sc.nextLine();

            System.out.print("Diem TB: ");
            double score = Double.parseDouble(sc.nextLine());

            list.add(new Student(id, name, score));
        }
    }
    static void hienThiDanhSach() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong");
            return;
        }

        System.out.println("Ma | Ten | Diem | Hoc luc");
        for (Student s : list) {
            System.out.println(s);
        }
    }
    static void timTheoHocLuc() {
        System.out.print("Nhap hoc luc (Gioi/Kha/Trung Binh): ");
        String rank = sc.nextLine();

        boolean found = false;
        for (Student s : list) {
            if (s.getRank().equalsIgnoreCase(rank)) {
                System.out.println(s);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay sinh vien phu hop");
        }
    }
    static void sapXepTheoHocLuc() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong");
            return;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getScore() < list.get(j + 1).getScore()) {
                    Student temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        System.out.println("Da sap xep theo hoc luc giam dan");
    }
}
