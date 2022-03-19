import java.util.ArrayList;

public class Main {
    public static int getSurvivingIndex(int n, int k) {
        // 코드를 입력하세요.
        ArrayList<Integer> numList = new ArrayList<>();

        //숫자가 모두 ArrayList에 들어가게
        for (int i = 1; i <= n; i++) {
            numList.add(i);
        }
        int idx = -1; // index 는 더하는 즉시 0으로 시작해야하니까 -1로 시작
        int step = k; // 건너뛰어야 하는 수

        while (numList.size()>1) {
            // k만큼 돌기
            for (int j = 1; j <= k; j++) {
                if ((idx + 1) >= numList.size()) {
                    //마지막에 step이 numList.size()보다 많이 남으면 1바퀴 돌린 만큼 step을 줄인다.
                    // 예) step = 5, numList.size() = 4이면 step => 1로
                    while (step > numList.size()) {
                        step -= numList.size();
                    }
                    //한바퀴를 돌고나서 다시 인덱스 지정
                    idx = numList.indexOf(numList.get(step-1));
//                    System.out.println("순환된 index: "+ idx);

                    break;
                } else {
                    step--;
                    idx++;
//                    System.out.println(idx);
                }
            }
            step = k;
            System.out.println(numList.get(idx) + "번 군사가 죽습니다.");
            numList.remove(idx);
//            System.out.println(numList);
            idx--;
        }
        return numList.get(0);
    }

    public static void main(String[] args){
        System.out.println("김신은 " + getSurvivingIndex(20, 5) + "번 자리에 서있으면 됩니다.");
    }
}