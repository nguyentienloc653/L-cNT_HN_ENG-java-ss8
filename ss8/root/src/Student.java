class Student {
    private String studentId;
    private String studentName;
    private int age;
    private String gender;
    private double mathScore;
    private double physisScore;
    private double chemicalScore;
    private String rank;

    public Student(String studentId, String studentName, int age, String gender, double mathScore, double physisScore,
                   double chemicalScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.gender = gender;
        this.mathScore = mathScore;
        this.physisScore = physisScore;
        this.chemicalScore = chemicalScore;
        calculateAverage();
    }

    // Getter và Setter
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getChemicalScore() {
        return chemicalScore;
    }

    public void setChemicalScore(double chemicalScore) {
        this.chemicalScore = chemicalScore;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public double getPhysisScore() {
        return physisScore;
    }

    public void setPhysisScore(double physisScore) {
        this.physisScore = physisScore;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    // Tính điểm trung bình
    public double calculateAverage() {
        double avg = (mathScore + physisScore + chemicalScore) / 3;
        if (avg >= 8 && mathScore >= 6.5 && physisScore >= 6.5 && chemicalScore >= 6.5) {
            rank = "Gioi";
        } else if (avg >= 6.5 && mathScore >= 5 && physisScore >= 5 && chemicalScore >= 5) {
            rank = "Kha";
        } else if (avg >= 5 && mathScore >= 3.5 && physisScore >= 3.5 && chemicalScore >= 3.5) {
            rank = "Trung binh";
        } else {
            rank = "Yeu";
        }
        return avg;
    }

    // Hiển thị thông tinh sinh viên
    public void display() {
        System.out.printf("| %-15s | %-20s | %-8d | %-15s | %-20.2f | %-10s |\n",
                studentId, studentName, age, gender, calculateAverage(), rank);

    }

}