class StudentManagement {
    private static Student[] students = new Student[1000];
    private static int index = 0;

    public static int getIndex() {
        return index;
    }

    // Thêm sinh viên
    public static void addStudent(Student student) {
        if (index == 1000) {
            System.out.println("\nThem khong thanh cong\n");
        }
        students[index] = student;
        index++;
        System.out.println("\nThem sinh vien thanh cong\n");
    }

    // Tìm kiếm theo ID
    public static Student findById(String id) {
        for (int i = 0; i < index; i++) {
            if (students[i].getStudentId().equals(id)) {
                return students[i];
            }
        }
        return null;
    }

    // Kiểm tra trùng ID
    public static boolean isDuplicateId(String id) {
        return findById(id) != null;
    }

    // Tìm kiếm sinh viên theo tên hoặc id
    public static void findStudent(String keyword) {
        if (index == 0) {
            System.out.println("\nDanh sach sinh vien trong\n");
            return;
        }
        boolean flag = false;
        System.out.printf("| %-15s | %-20s | %-8s | %-15s | %-20s | %-10s |\n",
                "Ma sinh vien", "Ho ten", "Tuoi", "Gioi tinh", "Diem trung binh", "Xep loai");
        for (int i = 0; i < index; i++) {
            if (students[i].getStudentId().equals(keyword)
                    || students[i].getStudentName().toLowerCase().contains(keyword.toLowerCase())) {
                students[i].display();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("\nKhong tim thay sinh vien nao\n");
        }
    }

    // Xóa sinh viên
    public static void deleteStudent(String studentId) {
        if (index == 0) {
            System.out.println("\nDanh sach sinh vien trong\n");
            return;
        }
        boolean flag = false;
        for (int i = 0; i < index; i++) {
            // Nếu tìm thấy sinh viên
            if (students[i].getStudentId().equals(studentId)) {
                flag = true;
                for (int j = i; j < index - 1; j++) {
                    students[i] = students[i + 1];
                }
            }
        }
        if (!flag) {
            System.out.println("\nKhong tim thay sinh vien\n");
        } else {
            System.out.println("\nXoa sinh vien thanh cong\n");
            index--;
        }
    }

    // Cập nhật thông tin sinh viên
    public static void updateStudent(Student student, String studentName, int age, String gender, double math,
                                     double physis, double chemical) {
        student.setStudentName(studentName);
        student.setAge(age);
        student.setGender(gender);
        student.setMathScore(math);
        student.setPhysisScore(physis);
        student.setChemicalScore(chemical);
        student.calculateAverage();
        System.out.println("\nCap nhat sinh vien thanh cong\n");
    }

    // In ra da sach sinh vien
    public static void printListStudent() {
        if (index == 0) {
            System.out.println("\nDanh sach sinh vien trong\n");
            return;
        }
        System.out.printf("| %-15s | %-20s | %-8s | %-15s | %-20s | %-10s |\n",
                "Ma sinh vien", "Ho ten", "Tuoi", "Gioi tinh", "Diem trung binh", "Xep loai");
        for (int i = 0; i < index; i++) {
            students[i].display();
        }
        System.out.println();
    }

    // Sắp xếp theo điểm trung bình giảm dần
    public static void sortByAvgDesc() {
        if (index == 0) {
            System.out.println("\nDanh sach sinh vien trong\n");
            return;
        }

        for (int i = 0; i < index - 1; i++) {
            for (int j = 0; j < index - i - 1; j++) {
                if (students[j].calculateAverage() < students[j + 1].calculateAverage()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        System.out.println("\nSap xep thanh cong\n");
    }

    // Sắp xếp theo tên từ A-Z
    public static void sortByStudentNameAsc() {
        if (index == 0) {
            System.out.println("\nDanh sach sinh vien trong\n");
            return;
        }

        for (int i = 0; i < index - 1; i++) {
            for (int j = 0; j < index - i - 1; j++) {
                if (students[j].getStudentName().compareTo(students[j + 1].getStudentName()) > 0) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        System.out.println("\nSap xep thanh cong\n");
    }

    // Tìm sinh viên có điểm trung bình cao nhất
    public static Student findStudentMaxAvg() {
        if (index == 0) {
            return null;
        }

        double max = students[0].calculateAverage();
        Student student = students[0];
        for (int i = 1; i < index; i++) {
            double avg = students[i].calculateAverage();
            if (avg > max) {
                max = avg;
                student = students[i];
            }
        }
        return student;
    }

    // Tìm sinh viên có điểm trung bình thấp nhất
    public static Student findStudentMinAvg() {
        if (index == 0) {
            return null;
        }

        double min = students[0].calculateAverage();
        Student student = students[0];
        for (int i = 1; i < index; i++) {
            double avg = students[i].calculateAverage();
            if (avg < min) {
                min = avg;
                student = students[i];
            }
        }
        return student;
    }

    // Tính điểm trung bình của tất cả sinh viên
    public static double calculateAllAverage() {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += students[i].calculateAverage();
        }
        return sum / index;
    }

    // Thống kê
    public static void statics() {
        if (index == 0) {
            System.out.println("\nDanh sach sinh vien trong\n");
            return;
        }

        int goodCount = 0;
        int underGoodCount = 0;
        int mediumCount = 0;
        int weakCount = 0;

        // Đếm số lượng sinh viên giỏi, khá, trung bình, yếu
        for (int i = 0; i < index; i++) {
            String rank = students[i].getRank();
            if (rank.equals("Gioi")) {
                goodCount++;
            } else if (rank.equals("Kha")) {
                underGoodCount++;
            } else if (rank.equals("Trung binh")) {
                mediumCount++;
            } else {
                weakCount++;
            }
        }

        // Sinh viển có điểm trung bình cao nhất
        Student studentAvgMax = StudentManagement.findStudentMaxAvg();
        // Sinh viển có điểm trung bình thấp nhất
        Student studentAvgMin = StudentManagement.findStudentMinAvg();

        // In kết quả
        System.out.println("\nSo sinh vien gioi: " + goodCount);
        System.out.println("So sinh vien kha: " + underGoodCount);
        System.out.println("So sinh vien trung binh: " + mediumCount);
        System.out.println("So sinh vien yeu: " + weakCount);
        System.out.printf("Sinh vien co diem trung binh cao nhat: %s (%.2f)\n", studentAvgMax.getStudentName(),
                studentAvgMax.calculateAverage());
        System.out.printf("Sinh vien co diem trung binh thap nhat: %s (%.2f)\n", studentAvgMin.getStudentName(),
                studentAvgMin.calculateAverage());
        System.out.printf("Diem trung binh cua tat ca sinh vien: %.2f\n\n", calculateAllAverage());
    }
}