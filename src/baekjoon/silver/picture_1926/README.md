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

1. 2차원 배열로 그림 정보를 입력받고


2. BFS를 활용하여 연결된 그림의 영역을 너비 우선 탐색
   - 방문하지 않은 1을 발견하면 BFS 시작
   - 상하좌우 네 방향으로 탐색하며 연결된 1들을 모두 방문
   - 방문할 때마다 area 크기를 증가시켜 현재 그림의 넓이 계산


3. 모든 그림의 넓이를 ArrayList에 저장하고
   - ArrayList의 size로 그림의 개수 파악
   - Collections.max()로 가장 큰 넓이 찾기

4. 예외처리: 그림이 하나도 없는 경우(ArrayList가 비어있는 경우) 최대 넓이 0 출력

### 시간복잡도와 공간복잡도


   
      시간복잡도: O(N×M)
         - 2차원 배열의 모든 칸을 한 번씩 방문
         - BFS에서 각 칸은 최대 한 번만 방문됨
         - 전체적으로 모든 칸을 상수 시간 내에 처리

      공간복잡도: O(N×M)
        - 입력 그래프: N×M
        - 방문 배열: N×M
        - BFS 큐: 최악의 경우 N×M
        - 그림 넓이 저장 ArrayList: 최악의 경우 (N×M)/4 (모든 칸이 체스판처럼 1일 경우)



### ✨ 새롭게 배운 점
1. BFS에서 방문 처리 타이밍의 중요성
   - 큐에 넣을 때 방문 처리를 해야 중복 방문을 막을 수 있음
   - 처음에는 poll 후에 방문 처리를 했다가 같은 칸이 큐에 중복해서 들어가는 문제 발생


2. ArrayList가 비어있을 때의 예외 처리
   - Collections.max()는 빈 컬렉션에 대해 NoSuchElementException을 발생시킴 (런타임 에러)
   - 그림이 없는 경우(ArrayList가 비어있는 경우)를 반드시 먼저 처리해야 함


3. 입력값 검증의 중요성
   - n, m이 0 이하인 경우에 대한 early return 처리로 예외 상황 방지
   - 문제의 제약조건(1 ≤ n,m ≤ 500)을 코드에 반영하는 습관의 중요성