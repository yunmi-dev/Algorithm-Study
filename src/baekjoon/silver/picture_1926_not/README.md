# [그림](https://www.acmicpc.net/problem/1926)

## 📌 문제
어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라. 단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자. 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 그림의 넓이란 그림에 포함된 1의 개수이다.

### 입력
첫째 줄에 도화지의 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)이 차례로 주어진다. 두 번째 줄부터 n+1 줄 까지 그림의 정보가 주어진다. (단 그림의 정보는 0과 1이 공백을 두고 주어지며, 0은 색칠이 안된 부분, 1은 색칠이 된 부분을 의미한다)

### 출력
첫째 줄에는 그림의 개수, 둘째 줄에는 그 중 가장 넓은 그림의 넓이를 출력하여라. 단, 그림이 하나도 없는 경우에는 가장 넓은 그림의 넓이는 0이다.

### 예제 입력 1

    6 5
    1 1 0 1 1
    0 1 1 0 0
    0 0 0 0 0
    1 0 1 1 1
    0 0 1 1 1
    0 0 1 1 1

### 예제 출력 1
   
    4
    9


### 🧰 풀이 과정

1차 시도 (시간 초과)
1. 이중 for문을 사용해 모든 쌍을 직접 확인
2. 두 수의 합이 x인 경우 카운팅
```java
for(int i = 0; i < n-1; i++) {
    for(int j = i+1; j < n; j++) {
        if(arr[i] + arr[j] == x) count++;
    }
}
```

2차 시도 (성공)
1. HashSet을 사용하여 모든 수를 저장 (단일 반복문 사용을 위해 HashSet 선택)
2. 각 수에 대해 x에서 뺀 값(complement)이 Set에 존재하는지 확인 
3. 자기 자신과의 쌍을 제외 (x - num != num)
4. 각 쌍이 두 번씩 카운트되므로 최종 결과를 2로 나눔

### 시간복잡도와 공간복잡도

* 1차 시도


    시간복잡도: O(n²)

    공간복잡도: O(n)

* 2차 시도


    시간복잡도: O(n)

    공간복잡도: O(n)



### ✨ 새롭게 배운 점
1. HashSet를 사용할 수 있게 됐다.
    - O(1) 시간만에 원소 존재 여부 확인 가능!
    - 중복을 허용하지 않는 특성 활용


2. 시간 복잡도의 중요성 실감
    - n ≤ 100,000인 경우 O(n²)은 시간 초과
    - 적절한 자료구조 선택으로 시간복잡도 개선 필요 
   
3. BufferedReader 사용
    - Scanner 대신 BufferedReader 사용으로 입력 처리 시간 단축