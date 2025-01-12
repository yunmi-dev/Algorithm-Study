# [연결 요소의 개수](https://www.acmicpc.net/problem/11724)

## 📌 문제
방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

### 입력
첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

### 출력
첫째 줄에 연결 요소의 개수를 출력한다.

### 예제 입력 1

     6 5
     1 2
     2 5
     5 1
     3 4
     4 6


### 예제 출력 1

     2

### 예제 입력 2

     6 8
     1 2
     2 5
     5 1
     3 4
     4 6
     5 4
     2 4
     2 3


### 예제 출력 2

     1


### 🧰 풀이 과정

핵심 알고리즘: DFS (깊이 우선 탐색)
DFS를 선택한 이유:
- 각 노드에서 연결된 모든 노드를 순차적으로 방문하며 하나의 연결 요소를 완벽하게 탐색할 수 있음 (연결된 덩어리를)
- 재귀를 통한 구현이 직관적이고 간단함


1. 입력 처리
   - 컴퓨터 수(n), 연결된 쌍의 수(m) 입력받고
   - 2차원 배열로 그래프 표현 (인접 행렬로, 양방향이기 때문에 2차원 배열로)
   - visited 배열로 방문 처리


2. 연결 요소 찾기
   - 1번 노드부터 N번 노드까지 순회하며 방문하지 않은 노드 확인
   - 방문하지 않은 노드 발견 시 result 증가 (새로운 연결 요소 발견)
   - DFS로 해당 노드와 연결된 모든 노드 방문 처리


3. 발견된 연결 요소의 개수(result) 출력



### 시간복잡도와 공간복잡도


    시간복잡도: O(N²)
      - 각 노드마다 인접 행렬을 통해 모든 노드와의 연결 확인
      - DFS에서 모든 노드를 한 번씩만 방문

    공간복잡도: O(N²)
      - graph 배열: N × N
      - visited 배열: N
      - 재귀 호출 스택: 최대 N


### 경계 케이스
- 모든 노드가 서로 연결된 경우 → 1 출력 (하나의 연결 요소)
- 모든 노드가 독립적인 경우 → N 출력 (N개의 연결 요소)
- 일부 노드들만 연결된 경우 → 연결된 덩어리 개수 출력


### ✨ 새롭게 배운 점
1. DFS를 이용한 연결 요소 카운팅
   - 노드 순회 범위 설정의 중요성 (1부터 N까지)
   - 처음에 ```for (int i = 0; i < N; i++)```로 했다가 N번 노드를 체크하지 못하는 실수를 함
   - 올바른 방법은 ```for (int i = 1; i < N+1; i++)```로 1부터 N까지 모든 노드 확인
   - 1-based 인덱싱을 위해 배열 크기를 N+1로 설정한 걸 중간에 잊으면 안됨


2. 방문 처리를 잊지 말자
   - 연결 요소를 정확히 구분하기 위해 방문 여부 확인 필수