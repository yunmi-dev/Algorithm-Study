# [문자열 뒤집기](https://school.programmers.co.kr/learn/courses/30/lessons/120822)

## 📌 문제 설명
문자열 `my_string`이 매개변수로 주어집니다. `my_string`을 거꾸로 뒤집은 문자열을 return하도록 solution 함수를 완성해주세요.

### 제한사항
- 1 ≤ `my_string`의 길이 ≤ 1,000

### 입출력 예
|my_string|return|
|---------|------|
|"jaron"|"noraj"|
|"bread"|"daerb"|

### 입출력 예 설명
입출력 예 #1
- `my_string`이 "jaron"이므로 거꾸로 뒤집은 "noraj"를 return합니다.

입출력 예 #2
- `my_string`이 "bread"이므로 거꾸로 뒤집은 "daerb"를 return합니다.

## 🧰 풀이
이 문제는 Java의 StringBuilder 클래스를 활용하여 효율적으로 해결할 수 있습니다.

### 풀이 과정
1. StringBuilder 객체 생성
    - 입력받은 문자열을 StringBuilder의 생성자에 전달
    - `StringBuilder answer = new StringBuilder(my_string)`


2. 문자열 뒤집기
    - StringBuilder의 reverse() 메소드 사용
    - `answer.reverse()`


3. 결과 반환
    - StringBuilder를 String으로 변환하여 반환
    - `return answer.toString()`

### 시간복잡도
- O(n): 문자열 길이에 비례하여 한 번 순회

### 공간복잡도
- O(n): 입력 문자열 길이만큼의 공간 사용

## ✨ 새롭게 배운 점
1. StringBuilder 클래스의 활용
    - String은 불변(immutable)이지만 StringBuilder는 가변(mutable)
    - 문자열 조작 작업에서 StringBuilder가 더 효율적


2. reverse() 메소드
    - StringBuilder의 내장 메소드로 문자열을 쉽게 뒤집을 수 있음
    - 별도의 반복문이나 추가 자료구조 없이 구현 가능