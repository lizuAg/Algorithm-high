# 스택/큐

## 스택
1. 한 쪽에서만 자료를 넣고 뺄 수 있는 자료구조
2. 가장 최근에 넣은 값이 먼저 나오는 구조이다.
3. push, pop, peek 모두 O(1), search는 O(N)
4. 자바의 Stack
   
    ```java
    import java.util.Stack;
    
    Stack<T> stack = new Stack<>();
    
    // item 삽입
    T push(T item);
    
    // item 제거 후 반환
    T pop();
    
    // item 제거하지 않고 반환
    T peek();
    
    // 스택이 비어있는지 확인
    boolean empty();
    
    // Object의 인덱스 반환 - O(N)
    int search(Object o);
    ```
    
## 큐
1. 한 쪽에서 자료를 넣으면 다른 쪽에서 자료를 뺄 수 있는 구조.
2. 가장 오래된 값이 먼저 나오는 구조이다.
3. 자바에서는 LinkedList를 사용하여 큐를 사용할 수 있다.
    
    ```java
    import java.util.Queue;
    import java.util.LinkedList;
    
    Queue<T> queue = new LinkedList<>();
    
    // item 삽입
    boolean add(T item); // 삽입 실패할 경우 IllegalStateException 발생
    boolean offer(T item); // 삽입 실패할 경우 false 반환
    
    // item 제거 후 반환
    T remove(); // 큐 비어있을 경우 NoSuchElementException 발생
    T poll(); // 큐 비어있을 경우 null 반환
    
    // item 제거하지 않고 반환
    T element(); // 큐 비어있을 경우 NoSuchElementException 발생
    T peek(); // 큐 비어있을 경우 null 반환
    ```
    
## 우선순위 큐
1. 일반적인 큐의 구조를 가지며 자료를 추가하되, 가중치를 우선순위로 하여 자료를 뺄 수 있는 구조.
2. 우선순위 큐에 저장할 객체는 기본적으로 Comparable 인터페이스를 구현한 객체여야 한다.
3. PriorityQueue는 Heap을 통해 구현하는 것이 일반적이다.
4. 데이터 삽입시, leaf 노드에 추가하고 부모노드와 비교해가며 heap의 특성을 유지하는 연산(heapify)을 진행한다. 
    e.g. 가중치가 큰 값을 우선순위로 둘 경우 Max Heap를 만드는 과정을 거침. 즉, 부모 노드와 자신을 비교하여 자신이 더 클 경우 부모노드와 swap.  
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
