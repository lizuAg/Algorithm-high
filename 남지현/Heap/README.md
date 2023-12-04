# 힙
### 개념
1. 최댓값 또는 최솟값을 빠르게 찾을 수 있는 완전 이진 트리
2. Max Heap은 부모 노드가 두 자식 노드의 값보다 커야 하고, Min Heap은 부모 노드가 두 자식 노드의 값보다 작아야 한다.
3. 완전히 정렬되어 있지는 않지만 루트로 올라갈 수록 최댓값 또는 최솟값에 가까워지는 유사 정렬 상태이다.
4. 완전 이진 트리이므로 노드가 왼쪽부터 빠짐 없이 채워져야 한다.
    <img src="https://github.com/lizuAg/Algorithm-high/assets/87467801/4aed46aa-b957-40a8-a252-9a880b1a9baf" width=800>
    * 루트부터 리프 노드까지 왼쪽에서 오른쪽 방향으로 인덱스를 붙여서 배열로 구현하고 인덱스로 부모, 자식 노드를 계산하기 위함인 것 같습니다.
    * 예시: heap = [2, 8, 12, 23, 40]
    * 인덱스 i인 노드의 부모노드 인덱스는 floor((i-1)/2) (루트 인덱스가 0일 때)

### 연산
1. 삽입
   - 힙에 새로운 노드를 삽입하면 가장 마지막 자리에 노드가 추가되고 힙을 재구성하는 과정을 거친다.
   - 힙을 재구성하는 과정은 삽입된 노드와 부모노드를 비교하여 필요한 경우 swap하는 과정을 반복하는 것이다.
   - MaxHeap을 가정할 때 최댓값이 삽입되는 경우가 최악의 경우로, 힙을 재구성하는데 logN의 시간이 걸린다.
2. 삭제
   - 루트 노드를 삭제하려는 경우 루트 노드와 마지막 노드를 swap하고 마지막 노드 제거 후, 힙을 재구성하는 과정이 반복된다.

### 자바에서의 힙
1. 파이썬에서는 리스트를 힙처럼 사용할 수 있는 heapq 모듈 → heapify(), heappop(), heappush()
2. 자바에서는 PriorityQueue 클래스를 사용한다.
3. 기본적으로 Min Heap의 형태를 가진다.
4. 클래스를 새로 만들어서 Comparable 클래스를 상속해주고 compareTo() 메서드를 오버라이딩하면 PriorityQueue 객체 생성시 정렬 기준을 정의하지 않아도 된다.
5. 자바의 PriorityQueue
   ```java
   import java.util.PriorityQueue;

    PriorityQueue<Integer> ascQueue = new PriorityQueue<>();
    PriorityQueue<Integer> descQueue = new PriorityQueue<>(Collections.reverseOrder());

    // Queue 인터페이스를 구현한 클래스이므로 기본적으로 메서드는 동일
    // item 삽입 ()
    boolean add(T item); // 삽입 실패할 경우 IllegalStateException 발생
    boolean offer(T item); // 삽입 실패할 경우 false 반환

    // item 제거 후 반환
    T remove(); // 큐 비어있을 경우 NoSuchElementException 발생
    T poll(); // 큐 비어있을 경우 null 반환

    // item 제거하지 않고 반환
    T element(); // 큐 비어있을 경우 NoSuchElementException 발생
    T peek(); // 큐 비어있을 경우 null 반환
   ```
   
