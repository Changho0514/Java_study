public class Main {
    public static void main(String[] args) {
        GradeCalculator gradeCalc = new GradeCalculator("김신의", 4.0, 100);

        //인스턴스 생성 없이 접근 => static이겠고, 상수를 사용하는것 같으니 final을 사용하면 되겠다.
        gradeCalc.addCourse(new Course("OOP", Course.CREDIT_MAJOR, "A+"));
        gradeCalc.addCourse(new Course("신호와시스템", Course.CREDIT_MAJOR, "A"));
        gradeCalc.addCourse(new Course("해석학", Course.CREDIT_MAJOR, "B+"));
        gradeCalc.addCourse(new Course("확률", Course.CREDIT_MAJOR, "A+"));
        gradeCalc.addCourse(new Course("스포츠댄스", Course.CREDIT_GENERAL, "A"));

        gradeCalc.print();
    }
}