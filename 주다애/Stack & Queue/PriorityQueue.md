### 🎈 Queue

<aside>
💡 들어간 순서와 상관없이 우선순위가 높은 데이터가 먼저 나오는 자료구조. 일반적으로 힙(Heap)을 이용해서 구현한다.

</aside>

삽입(add/offer), 삭제(poll/remove/clear), 가장 끝 데이터(rear), 가장 앞 데이터(front), 우선순위가 가장 높은 값 반환(peek)

내부 요소는 힙으로 구성되어 이진트리 구조이다.

내부 구조가 힙이므로 시간 복잡도는 O(LogN)이다.

우선순위 정렬 기준에 따라 맨 앞 데이터(front)에 항상 최댓값 혹은 최솟갑이 위치한다.

우선순위가 중요한 문제에서 사용한다.

### 사용법

- 코드

    ```java
    import java.util.PriorityQueue;
    
    // 우선순위가 낮은 숫자 순
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    
    // 우선순위가 높은 숫자 순
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    
    // 1. 삽입 --> add(), offer()
    priorityQueue.offer(3);
    priorityQueue.offer(5); // 큐 용량이 초과되면 false 리턴
    priorityQueue.add(4);
    priorityQueue.add(1); // 큐 용량이 초과되면 예외 발생
    
    // 2. 삭제 --> poll(), clear()
    q.poll(); // 1 반환
    q.clear(); // 초기화
    
    // 3. 반환 --> peek() 우선순위가 가장 높은 원소 출력
    q.peek() // 1 반환(제거는 하지 않는다.)
    ```

- 비어있는지 확인, 크기, 원소 포함 여부

    ```java
    // 4. 비어있는 여부 확인 --> isEmpty() stack이 비었으면 true, 아니면 false를 반환한다.
    q.isEmpty();
    
    ****// 5. 크기 --> size()
    int size = q.size();
    System.out.println(size); // 4 출력
    
    // 6. 원소 포함 여부 --> contains(), containsAll()
    q.contains(20); // 5을 포함하므로 true 반환
    q.containsAll([collections 타입]); // collections 안의 값들이 모두 stack 안에 있으면 true, 아니면 false 반환
    ```


### 시간 복잡도

1️⃣ 삽입(add/offer) : O(LogN)

2️⃣ 삭제(poll/remove): O(LogN)

3️⃣ 읽기(peek) : O(1)

4️⃣ 크기(size) : O(1)