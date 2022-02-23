# 형변환 issue

# 실습과제

# **연산자와 형 변환**

> 여러분이 국어(**`koreanScore`**) 86점, 수학(**`mathScore`**) 94점, 과학(**`scienceScore`**) 87점, 컴퓨터(**`computerScore`**) 100점을 맞았다고 합시다. 이 값들을 사용하여 평균 점수(**`average`**)를 구하고 소수로 출력해보세요.
> 

```java
public class Main {
    public static void main(String[] args) {
        int koreanScore=86;
        int mathScore=94;
        int scienceScore=87;
        int computerScore=100;
        
        double average;
        average = (koreanScore+mathScore+scienceScore+computerScore)/4;
        System.out.println(average);
    }
```

> 답은 91.75 이지만, 91.0이 나온다.
> 

## 이유는

> 4(int)로 나누어 준 
(koreanScore+mathScore+scienceScore+computerScore) 값들이 모두 int 이기에
수치는 91.75 이지만 이 값의 int 값인 91이 되고
double 형인 average에 대입될 때 91.0으로 바뀌는 것
> 

## 해결방법

- [ ]  (koreanScore+mathScore+scienceScore+computerScore) / 4
의 수치가 int 값으로 대입되기 전에 명시적 형변환(type casting)을 해주어 바꿔준다.

```java
public class Main {
    public static void main(String[] args) {
        int koreanScore=86;
        int mathScore=94;
        int scienceScore=87;
        int computerScore=100;
        
        double average;
        average = (double)(koreanScore+mathScore+scienceScore+computerScore)/4;
        System.out.println(average);
    }
```