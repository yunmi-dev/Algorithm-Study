# [로프](https://www.acmicpc.net/problem/2217)

## 📌 문제
N(1 ≤ N ≤ 100,000)개의 로프가 있다. 이 로프를 이용하여 이런 저런 물체를 들어올릴 수 있다. 각각의 로프는 그 굵기나 길이가 다르기 때문에 들 수 있는 물체의 중량이 서로 다를 수도 있다.

하지만 여러 개의 로프를 병렬로 연결하면 각각의 로프에 걸리는 중량을 나눌 수 있다. k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때, 각각의 로프에는 모두 고르게 w/k 만큼의 중량이 걸리게 된다.

각 로프들에 대한 정보가 주어졌을 때, 이 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량을 구해내는 프로그램을 작성하시오. 모든 로프를 사용해야 할 필요는 없으며, 임의로 몇 개의 로프를 골라서 사용해도 된다.


### 입력
첫째 줄에 정수 N이 주어진다. 다음 N개의 줄에는 각 로프가 버틸 수 있는 최대 중량이 주어진다. 이 값은 10,000을 넘지 않는 자연수이다.

### 출력
첫째 줄에 답을 출력한다.

### 예제 입력 1

     2
     10
     15

### 예제 출력 1

     20


### 🧰 풀이 과정

그리디 알고리즘을 사용하여 해결
- 각 로프의 최대 중량을 정렬한 후, 사용할 로프의 개수를 조절하며 최대 중량 계산
- 이 문제가 그리디인 이유: 매 순간 가장 많은 중량을 들 수 있는 조합을 선택하면서 최적해를 찾음


1. 입력
   - BufferedReader를 사용하여 로프의 개수(N)와 각 로프의 최대 중량 입력
   - ArrayList에 각 로프의 중량 저장


2. 정렬 및 계산
   - Collections.sort()로 로프 중량 오름차순 정렬
   - 각 로프를 기준으로 (현재 로프의 중량 × 사용 가능한 로프 수) 계산
   - 계산된 값들 중 최대값이 정답


3. 계산된 최대 중량 출력



### 시간복잡도와 공간복잡도

      
      시간복잡도: O(N log N)
         - 입력 처리: O(N)
         - 정렬: O(N log N) (Collections.sort 사용)
         - 최대값 계산을 위한 순회: O(N)
         - 전체 시간복잡도는 가장 큰 차수인 O(N log N)
      
      공간복잡도: O(N)
         - ArrayList에 N개의 로프 중량 저장: O(N)
         - 정렬 시 사용되는 추가 공간: O(N)
         - 그 외 변수(maxSum 등): O(1)



### ✨ 새롭게 배운 점
1. 그리디 알고리즘 적용하게 되는 생각 과정
   - 각 단계에서 가능한 최대 중량을 계산하여 최적해를 찾는 방식
   - 모든 경우를 계산할 필요 없이, 정렬 후 순차적 계산으로 해결 가능
   - 직관적임


2. ArrayList 정렬 활용
   - Collections.sort()를 사용한 ArrayList 정렬
   - 오름차순 정렬로 순차적 계산 용이

### 💡 성능 개선 포인트
1. 불필요한 반복문 제거
   #### 현재 코드는 두 번의 반복문을 사용하지만,

   ```java
   for (int i = 0; i < weightList.size(); i++) {
       maxSum = Math.max(maxSum, weightList.get(i) * (weightList.size() - i));
   }
   ```
   
   #### 이렇게 하나의 반복문으로 통합하여 처리 가능
   
   ```java
   if (sum > maxSum) {
       maxSum = sum;
   }
   ```
   
   #### 이 코드도 Math.max() 사용하면,
   
   ```java
   maxSum = Math.max(maxSum, sum);
   ```

   #### 한 줄로 더 깔끔하게 표현 가능함.

2. 자료구조 최적화
   - ArrayList 대신 기본 배열 사용 가능
   - Arrays.sort() 활용하여 정렬하면 됨
   

3. 입출력 최적화
   - BufferedWriter 사용으로 출력 성능 향상 가능
   - StringBuilder 활용하여 문자열 연산 최적화 가능