![image](https://github.com/lizuAg/Algorithm-high/assets/68546023/46fc7c14-17ad-4a22-86cf-b1336ddafd88)


## 스택 Stack

- 후입선출, LIFO(Last In First Out) 특성을 가지는 자료구조.
- 입력은 Push, 출력은 Pop (+조회는 Peek)
- 포인터는 Top

```yaml
Stack<Integer> st = new Stack<Integer>(); // 스택의 생성

//Deque<Integer> st = new ArrayDeque<Integer>();
```

## 큐 Queue

- 선입선출, FIFO(First In First Out)의 자료구조
- 입력은 Enqueue, 출력은 Dequeue
- 포인터는 Read/Back, Front

```yaml
Queue<Integer> queue = new LinkedList<>();
```

## 시간복잡도 Big O

- Insertion O(1)
- Deletion O(1)
- Search O(n)

`왜?` 삭제/삽입은 양끝 데이터에서 일어나기 때문. 

## 덱 Deque

- Deque라는 이름은 double ended queue의 줄임말이고 주로 "deck"으로 발음된다.
- Queue interface 상속, FIFO로 사용한다면…
    
    
    | Queue Method | Equivalent Deque Method |
    | --- | --- |
    | add(E) | addLast(E) |
    | offer(E) | offerLast(E) |
    | remove() | removeFirst() |
    | poll() | pollFirst() |
    | element() | getFirst() |
    | peek() | peek() |
- LIFO Stack으로도 사용 가능 (stack 대신사용하세요!)
    
    
    | Stack Method | Equivalent Deque Method |
    | --- | --- |
    | push(E) | addFirst(E) |
    | pop() | removeFirst() |
    | peek() | peekFirst() |

## Deque의 구현체, 뭘 쓰나요 ..?

![image](https://github.com/lizuAg/Algorithm-high/assets/68546023/323fcb34-95cd-48ca-86aa-e729c6371930)


- 인덱스로 데이터에 접근하고 끝에 삽입, 삭제만 할 경우에는 ArrayList를 사용하라
- stack, queue, 혹은 deque로 ArrayDeque를 사용하라
- 리스트를 순회할때 삽입, 삭제하거나 O(1)인 최악의 경우에 마지막에 삽입시 LinkedList를 사용하라

## Reference

[Deque, LinkedList 와 ArrayDeque](https://tech-monster.tistory.com/159)

[[Java] Priority Queue(우선 순위 큐)](https://velog.io/@gillog/Java-Priority-Queue우선-순위-큐)

[Java Platform SE 7](https://docs.oracle.com/javase/7/docs/api/)
