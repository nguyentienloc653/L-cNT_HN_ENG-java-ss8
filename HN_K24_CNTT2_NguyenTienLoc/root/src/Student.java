public class Student {
    private String id;
    private String name;
    private double score;

    public Student() {

    }

    public  Student(String id, String name, double score){
        setId(id);
        this.name = name;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public  void setId(String id) {
        if (id != null && id.matches("^SV\\d{3}$")) {
            this.id = id;
        } else {
            System.out.println("Ma sinh vien khong hop le");
        }
    }

    public void setScore(double score) {
        if (score >= 0 && score <= 10) {
            this.score = score;
        } else {
            System.out.println("Diem khong hop le");
        }
    }

    public String getRank(){
        if (score >= 8.0) {
            return "gioi";
        } else if (score >= 6.5) {
            return  "kha";
        }else {
            return "Trung Binh";
        }
    }

    public String toString(){
        return id + " | " + name + " | " + score + " | " + getRank();
    }
}
