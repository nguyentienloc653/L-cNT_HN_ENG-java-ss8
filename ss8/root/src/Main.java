import java.util.Scanner;

class Main {
    // Thêm sinh viên
    public static void addStudent(Scanner sc) {
        String studentId;
        do {
            System.out.print("Nhap ma sinh vien: ");
            studentId = sc.nextLine();
            if (studentId.isBlank()) {
                System.out.println("\nMa sinh vien khong duoc de trong\n");
            } else if (StudentManagement.isDuplicateId(studentId)) {
                System.out.println("\nMa sinh vien da ton tai\n");
            }
        } while (studentId.isBlank() || StudentManagement.isDuplicateId(studentId));

        String studentName;
        do {
            System.out.print("Nhap ten sinh vien: ");
            studentName = sc.nextLine();
            if (studentName.isBlank()) {
                System.out.println("\nTen sinh vien khon duoc de trong\n");
            }
        } while (studentName.isBlank());

        int age;
        do {
            System.out.print("Nhap tuoi: ");
            age = Integer.parseInt(sc.nextLine());
            if (age < 18 || age > 30) {
                System.out.println("\nTuoi khong hop le\n");
            }
        } while (age < 18 || age > 30);

        String gender;
        do {
            System.out.print("Nhap gioi tinh: ");
            gender = sc.nextLine();
            if (!gender.equalsIgnoreCase("Nam") && !gender.equalsIgnoreCase("Nu")) {
                System.out.println("\nGioi tinh khong hop le\n");
            }
        } while (!gender.equalsIgnoreCase("Nam") && !gender.equalsIgnoreCase("Nu"));

        double mathScore;
        do {
            System.out.print("Nhap diem toan: ");
            mathScore = Double.parseDouble(sc.nextLine());
            if (mathScore < 0 || mathScore > 10) {
                System.out.println("\nDiem toan khong hop le\n");
            }
        } while (mathScore < 0 || mathScore > 10);

        double physisScore;
        do {
            System.out.print("Nhap diem ly: ");
            physisScore = Double.parseDouble(sc.nextLine());
            if (physisScore < 0 || physisScore > 10) {
                System.out.println("\nDiem ly khong hop le\n");
            }
        } while (physisScore < 0 || physisScore > 10);

        double chemicalScore;
        do {
            System.out.print("Nhap diem hoa: ");
            chemicalScore = Double.parseDouble(sc.nextLine());
            if (chemicalScore < 0 || chemicalScore > 10) {
                System.out.println("\nDiem hoa khong hop le\n");
            }
        } while (chemicalScore < 0 || chemicalScore > 10);

        Student student = new Student(studentId, studentName, age, gender, mathScore, physisScore, chemicalScore);
        StudentManagement.addStudent(student);
    }

    // Tìm kiếm sinh viên
    public static void findStudent(Scanner sc) {
        System.out.print("Nhap ten hoa ma sinh vien: ");
        String keyword = sc.nextLine();
        StudentManagement.findStudent(keyword);

    }

    // Xóa sinh viên
    public static void deleteStudent(Scanner sc) {
        System.out.print("Nhap ID sinh vien can xoa: ");
        String studentId = sc.nextLine();
        StudentManagement.deleteStudent(studentId);
    }

    // Cập nhật thông tin sinh viên
    public static void updateStudent(Scanner sc) {
        System.out.print("Nhap ma sinh vien muon cap nhat: ");
        String studentId = sc.nextLine();
        Student student = StudentManagement.findById(studentId);

        if (student == null) {
            System.out.println("\nKhong tim thay sinh vien\n");
            return;
        }

        String studentName;
        do {
            System.out.print("Nhap ten sinh vien: ");
            studentName = sc.nextLine();
            if (studentName.isBlank()) {
                System.out.println("\nTen sinh vien khon duoc de trong\n");
            }
        } while (studentName.isBlank());

        int age;
        do {
            System.out.print("Nhap tuoi: ");
            age = Integer.parseInt(sc.nextLine());
            if (age < 18 || age > 30) {
                System.out.println("\nTuoi khong hop le\n");
            }
        } while (age < 18 || age > 30);

        String gender;
        do {
            System.out.print("Nhap gioi tinh: ");
            gender = sc.nextLine();
            if (!gender.equalsIgnoreCase("Nam") && !gender.equalsIgnoreCase("Nu")) {
                System.out.println("\nGioi tinh khong hop le\n");
            }
        } while (!gender.equalsIgnoreCase("Nam") && !gender.equalsIgnoreCase("Nu"));

        double mathScore;
        do {
            System.out.print("Nhap diem toan: ");
            mathScore = Double.parseDouble(sc.nextLine());
            if (mathScore < 0 || mathScore > 10) {
                System.out.println("\nDiem toan khong hop le\n");
            }
        } while (mathScore < 0 || mathScore > 10);

        double physisScore;
        do {
            System.out.print("Nhap diem ly: ");
            physisScore = Double.parseDouble(sc.nextLine());
            if (physisScore < 0 || physisScore > 10) {
                System.out.println("\nDiem ly khong hop le\n");
            }
        } while (physisScore < 0 || physisScore > 10);

        double chemicalScore;
        do {
            System.out.print("Nhap diem hoa: ");
            chemicalScore = Double.parseDouble(sc.nextLine());
            if (chemicalScore < 0 || chemicalScore > 10) {
                System.out.println("\nDiem hoa khong hop le\n");
            }
        } while (chemicalScore < 0 || chemicalScore > 10);

        StudentManagement.updateStudent(student, studentName, age, gender, mathScore, physisScore, chemicalScore);
    }

    // Tính điểm trung bình và xếp loại
    public static void calculateAverage(Scanner sc) {
        System.out.print("Nhap na sinh vien: ");
        String studentId = sc.nextLine();
        Student student = StudentManagement.findById(studentId);
        if (student == null) {
            System.out.println("\nSinh vien khong ton tai\n");
            return;
        }

        System.out.println("\nSinh vien: " + student.getStudentName());
        System.out.println("Diem trung binh: " + student.calculateAverage());
        System.out.println("Xep loai: " + student.getRank() + "\n");
    }

    // Sắp xếp sinh viên
    public static void sortStudents(Scanner sc) {
        int choice;
        do {
            System.out.println("1. Sap xep theo diem TB giam dan");
            System.out.println("2. Sap xep theo ten A-Z");
            System.out.println("3. Thoat");
            System.out.print("Chon chuc nang: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    StudentManagement.sortByAvgDesc();
                    return;
                case 2:
                    StudentManagement.sortByStudentNameAsc();
                    return;
                case 3:
                    break;
                default:
                    System.out.println("\nChuc nang khong hop le\n");
                    break;
            }
        } while (choice != 3);
    }

    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Them sinh vien moi");
            System.out.println("2. Hien thi tat ca sinh vien");
            System.out.println("3. Tim kiem sinh vien");
            System.out.println("4. Cap nhat thong tin sinh vien");
            System.out.println("5. Xoa sinh vien");
            System.out.println("6. Tinh diem trung binh va xep loai");
            System.out.println("7. Sap xep sinh vien");
            System.out.println("8. Thong ke");
            System.out.println("9. Thoat");
            System.out.print("Chon chuc nang: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    StudentManagement.printListStudent();
                    break;
                case 3:
                    findStudent(sc);
                    break;
                case 4:
                    updateStudent(sc);
                    break;
                case 5:
                    deleteStudent(sc);
                    break;
                case 6:
                    calculateAverage(sc);
                    break;
                case 7:
                    sortStudents(sc);
                    break;
                case 8:
                    StudentManagement.statics();
                    break;
                case 9:
                    System.out.println("\nThoat thanh cong\n");
                    break;
                default:
                    System.out.println("\nChuc nang khong ton tai\n");
                    break;
            }
        } while (choice != 9);
        sc.close();
    }
}