## 우선순위 큐

- 가장 우선순위가 높은 데이터가 삭제되는, 우선순위의 개념이 큐에 도입된 자료구조.
- 우선순위 큐는 배열, 연결리스트, 힙 으로 구현이 가능하다. 이 중에서 힙(heap)으로 구현하는 것이 가장 효율적이다.

| 표현방법 | 삽입 | 삭제 |
| --- | --- | --- |
| 순서 없는 배열 | O(1) | O(n) |
| 순서 없는 연결 리스트 | O(1) | O(n) |
| 정렬된 배열 | O(n) | O(1) |
| 정렬된 연결 리스트 | O(n) | O(1) |
| 힙(heap) | O(logn) | O(long) |

## 힙(heap)

- 완전 이진 트리의 일종으로 우선순위 큐를 위하여 만들어진 자료구조이다.
- 여러 개의 값들 중에서 최댓값이나 최솟값을 빠르게 찾아내도록 만들어진 자료구조이다.
- 힙은 일종의 반정렬 상태(느슨한 정렬 상태) 를 유지한다.
    - 큰 값이 상위 레벨에 있고 작은 값이 하위 레벨에 있다는 정도
    - 간단히 말하면 부모 노드의 키 값이 자식 노드의 키 값보다 항상 큰(작은) 이진 트리를 말한다.
- 힙 트리에서는 중복된 값을 허용한다. (이진 탐색 트리에서는 중복된 값을 허용하지 않는다.)

### 힙의 종류
- 최대 힙(max heap)
    - 부모 노드의 키 값이 자식 노드의 키 값보다 크거나 같은 완전 이진 트리
    - key(부모 노드) >= key(자식 노드) : 루트가 max 값이다.
- 최소 힙(min heap)
    - 부모 노드의 키 값이 자식 노드의 키 값보다 작거나 같은 완전 이진 트리
    - key(부모 노드) <= key(자식 노드) : 루트가 min 값이다.

### 힙의 삽입/삭제

- 삽입
    - 새로운 노드를 마지막 노드에 이어서 삽입한다.
    - 새로운 노드를 부모 노드들과 교환해서 힙의 성질을 만족시킨다.
- 삭제
    - 루느 노드가 삭제된다.
    - 삭제된 루트 노드에는 힙의 마지막 노드를 가져온다.
    - 힙을 재구성한다.

## Priority Queue - JAVA
    
    //생성
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    
    //삽입
    minHeap.add(1);
    maxHeap.offer(2);

    //참조
    minHeap.peek();

    //삭제
    minHeap.poll();

    //특정값 삭제
    minHeap.remove(1);
    ...

### 참고

[[자료구조] 힙(heap)이란 - Heee's Development Blog](https://gmlwjd9405.github.io/2018/05/10/data-structure-heap.html)

[☕ 자바 split / StringTokenizer - 문자열 자르기 비교](https://inpa.tistory.com/entry/JAVA-☕-Split-StringTokenizer-문자열-자르기-비교하기)

[PriorityQueue (Java Platform SE 8 )](https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html)
