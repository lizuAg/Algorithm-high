### 🎈 Queue

<aside>
💡 배열에서 발전된 형태의 자료구조. FIFO(선입선출)로 이루어져서 삽입과 삭제가 양방향에서 이루어진다.

</aside>

삽입(add/offer), 삭제(poll/remove/clear), 가장 끝 데이터(rear), 가장 앞 데이터(front), 맨 앞 데이터 확인(peek)

BFS에서 자주 사용한다.

### 사용법

- 코드

    ```java
    import java.util.LinkedList;
    import java.util.Queue;
    
    Queue<Integer> q = new LinkedList<>();
    Queue<String> q = new LinkedList<>();
    
    // 1. 삽입 --> add(), offer()
    q.offer(3);
    q.offer(5); // 큐 용량이 초과되면 false 리턴
    q.add(4);
    q.add(1); // 큐 용량이 초과되면 예외 발생
    
    // 2. 삭제 --> poll(), clear()
    q.poll(); // 3 반환
    q.clear(); // 모두 삭제
    
    // 3. 반환 --> peek() queue의 마지막 요소를 반환하며, queue**에 변화를 주지 않는다.**
    q.peek() // 3 반환(제거는 하지 않는다.)
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

1️⃣ 삽입(add/offer) : O(1)

2️⃣ 삭제(poll/remove): O(1)

3️⃣ 읽기(peek) : O(1)

4️⃣ 읽기(peek) : O(1)

5️⃣ 포함 여부(contains) : O(n)