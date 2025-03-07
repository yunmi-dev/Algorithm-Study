# [큰 수 A+B](https://www.acmicpc.net/problem/10757)

## 📌 문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

### 입력
첫째 줄에 A와 B가 주어진다. (0 < A,B < 10^10000)

### 출력
첫째 줄에 A+B를 출력한다.

### 예제 입력 1

      9223372036854775807 9223372036854775808

### 예제 출력 1

      18446744073709551615



### 🧰 풀이 과정

1. 입력 처리
    - BigInteger 클래스 사용 (입력 범위가 10^10000까지)


2. BigInteger 변환
    - StringTokenizer로 분리한 문자열을 BigInteger로 변환
    - BigInteger는 생성자에 문자열을 전달하여 생성 (new BigInteger())


3. 계산 및 출력
    - BigInteger의 add() 메소드로 두 수 덧셈
    - 결과값 출력



### 시간복잡도와 공간복잡도

      
      시간복잡도: O(N)
         - 입력 문자열 처리: O(N), N은 입력 숫자의 자릿수
         - BigInteger 덧셈: O(N)
         - 전체적으로 O(N)의 시간복잡도
      
      공간복잡도: O(N)
         - 입력 문자열 저장: O(N)
         - BigInteger 객체 저장: O(N)
         - N은 입력 숫자의 자릿수


### ✨ 새롭게 배운 점
1. BigInteger 클래스 활용
    - long 범위(약 ±922경)를 넘어가는 정수 처리
    - 문자열을 통한 BigInteger 객체 생성
    - add() 메소드를 통한 덧셈 연산


2. 큰 수의 범위 이해
    - int: 약 ±21억 (10^9)
    - long: 약 ±922경 (10^18)
    - BigInteger: 사실상 제한 없음

