public class Course {

    public static final int CREDIT_MAJOR = 3;
    public static final int CREDIT_GENERAL = 2;

    public final String name;
    public final int credit;
    public final String grade;

    public Course(String name, int credit, String grade) {
        this.name = name;
        this.credit = credit;
        this.grade = grade;
    }

    public double getScore() {
        switch (grade){
            case "A+":
                return 4.5;
            case "A":
                return 4;
            case "B+":
                return 3.5;
            case "B":
                return 3.0;
            case "C+":
                return 2.5;
            case "C":
                return 2;
            case "D+":
                return 1.5;
            case "D":
                return 1;
            case "F":
                return 0;
        }
        return -1;
    }
}

//인스턴스 생성 없이 접근 => static이겠고, 상수를 사용하는것 같으니 final을 사용하면 되겠다.