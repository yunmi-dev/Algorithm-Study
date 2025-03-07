# [과제 안 내신 분..?](https://www.acmicpc.net/problem/5597)

## 📌 문제
X대학 M교수님은 프로그래밍 수업을 맡고 있다. 교실엔 학생이 30명이 있는데, 학생 명부엔 각 학생별로 1번부터 30번까지 출석번호가 붙어 있다.

교수님이 내준 특별과제를 28명이 제출했는데, 그 중에서 제출 안 한 학생 2명의 출석번호를 구하는 프로그램을 작성하시오.

### 입력
입력은 총 28줄로 각 제출자(학생)의 출석번호 n(1 ≤ n ≤ 30)가 한 줄에 하나씩 주어진다. 출석번호에 중복은 없다.

### 출력
출력은 2줄이다. 1번째 줄엔 제출하지 않은 학생의 출석번호 중 가장 작은 것을 출력하고, 2번째 줄에선 그 다음 출석번호를 출력한다.

### 예제 입력 1

     3
     1
     4
     5
     7
     9
     6
     10
     11
     12
     13
     14
     15
     16
     17
     18
     19
     20
     21
     22
     23
     24
     25
     26
     27
     28
     29
     30

### 예제 출력 1

     2
     8


### 예제 입력 2

     9
     30
     6
     12
     10
     20
     21
     11
     7
     5
     28
     4
     18
     29
     17
     19
     27
     13
     16
     26
     14
     23
     22
     15
     3
     1
     24
     25

### 예제 출력 2

     2
     8



### 🧰 풀이 과정

1. ArrayList 초기화
   - 1부터 30까지의 모든 출석번호를 ArrayList에 추가
   - ArrayList를 사용해 동적으로 요소 삭제 가능


2. 제출된 출석번호 처리
   - 28명의 제출자 출석번호를 입력받아 처리
   - Integer.valueOf()를 사용해 해당 값을 ArrayList에서 삭제
     - int값을 받아 바로 ArrayList.remove()를 사용하니까 해당 index가 삭제됨 (메소드의 오버로딩 때문)
     - Integer.valueOf()를 사용해 Integer 객체로 만들어 해당 객체가 삭제되도록 수정함


3. 결과 출력
   - ArrayList에 남은 2개의 미제출자 출석번호 출력
   - 자동으로 오름차순 정렬된 상태 유지



### 시간복잡도와 공간복잡도

      
      시간복잡도: O(N)
         - ArrayList 초기화: O(N), N=30
         - 제출자 처리: O(28 × N) ≈ O(N)
            - remove() 메소드가 O(N)의 시간복잡도
         - 결과 출력: O(1), 항상 2개 출력
      
      공간복잡도: O(N)
         - ArrayList 저장공간: O(N), N=30
         - 추가 변수: O(1)
         - N이 고정값(30)이므로 실질적으로는 O(1)


### ✨ 새롭게 배운 점
1. ArrayList의 remove() 메소드 특성
   - remove(int)와 remove(Object)의 차이 (메소드 오버로딩)
   - Integer.valueOf()를 통한 객체 기반 삭제



### 💡 성능 개선 포인트
1. 불리언 배열 방식으로 변경

```java
// 현재: ArrayList의 remove() 사용
ArrayList<Integer> submitted = new ArrayList<>();
// ... remove() 연산

// 개선: 불리언 배열 사용
boolean[] submitted = new boolean[31];
for (int i = 1; i <= 28; i++) {
    submitted[Integer.parseInt(br.readLine())] = true;
}
```
- 불리언 배열은 인덱스로 직접 접근하기 때문에 O(1)이고, ArrayList는 요소를 찾고 재정렬하는 과정이 필요해서 O(N)
- 그러나 전체 프로그램의 시간복잡도는 두 방식 모두 O(N) (28번의 입력을 처리해야 하기 때문)
  - 현재 방식: O(28 × N) = O(N)
  - 개선 방식: O(28 × 1) = O(N)
- 다만 실제 실행시간은 불리언 배열이 더 빠를 것