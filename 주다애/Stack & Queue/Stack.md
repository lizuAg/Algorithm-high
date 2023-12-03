### 🎈 Stack

<aside>
💡 배열에서 발전된 형태의 자료구조. LIFO(후입선출)로 이루어져서 삽입과 삭제가 한 쪽에서만 일어난다.

</aside>

삽입(pusth), 삭제(pop), top 위치의 데이터 확인(peek)

DFS나 백트리킹 종류의 문제에 효과적이다.

재귀 함수의 원리와 일맥상통하는 부분이 있다.

### 사용법

- 코드

    ```java
    import java.util.stack;
    
    Stack<Integer> stack = new Stack<>();
    
    // 1. 삽입 --> push()
    stack.push(10);
    stack.push(20);
    
    // 2. 삭제 --> pop(), clear()
    stack.pop(); // 20 반환 및 제거
    stack.pop(); // 10 반환 및 제거
    
    stack.clear() // 20,10 모두 제거(반환 값은 없다.)
    
    // 3. 반환 --> peek() stack의 마지막 요소를 반환하며, **stack에 변화를 주지 않는다.**
    stack.peek() // 20 반환(제거는 하지 않는다.)
    ```

- 비어있는지 확인, 위치 반환, 원소 포함 여부

    ```java
    // 4. 비어있는 여부 확인 --> isEmpty() stack이 비었으면 true, 아니면 false를 반환한다.
    stack.isEmpty() // 20, 10이 stack에 **인자로 있으므로 false 반환**
    stack.clear();
    stack.isEmpty(); // clear()를 통해 인자를 모두 제거했으므로 **stack이 비었다. --> true 반환**
    
    // 5. 위치 반환 --> search()
    stack.search(20); // 20의 위치인 1 반환
    stack.search(10); // 10이 위치인 2 반환
    stack.search(30); // 30은 stack에 없으므로 -1 반환
    
    // 6. 원소 포함 여부 --> contains(), containsAll()
    stack.contains(20); // 20을 포함하므로 true 반환
    stack.containsAll([collections 타입]); // collections 안의 값들이 모두 stack 안에 있으면 true, 아니면 false 반환
    ```


### 시간 복잡도

1️⃣ 삽입(push) : O(1)

2️⃣ 삭제(pop): O(1)

3️⃣ 탐색(search) : O(n) → 위부터 하나씩 찾아야 하기 때문

4️⃣ 읽기(peek) : O(1)