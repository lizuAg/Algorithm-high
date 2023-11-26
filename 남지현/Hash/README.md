# 해시

## 개념
1. 입력 데이터를 해시 함수를 통해 고정된 길이의 값으로 변환하고 이 해시 값을 데이터의 인덱스로 하여 저장하는 자료구조다. ArrayList처럼 중간에 데이터를 추가하거나 삭제할 때 많은 양의 데이터들이 밀리지도 않고, LinkedList처럼 데이터를 검색할 때 모든 노드를 탐색할 필요도 없다는 장점이 있다.
2. Key와 value가 들어오면 key값을 해싱 알고리즘을 통해 변환한 해시코드를 인덱스로 하여 value를 저장한다.

## 해시 충돌
1. 해시 함수는 정의역이 무한집합이고 공역이 유한집합인 다대일대응함수이기 때문에 서로 다른 key값을 해시함수에 통과시켰을때 중복값이 나올 수 있다. 
2. 해결 방법으로는 Chaining기법과 Open-Addressing기법이 있다.
    - Chaining: 동일한 해시값을 가지는 새로운 데이터가 추가될 경우 새로운 데이터를 테이블에 넣고 그 다음에 기존 데이터를 연결한다. (Linked List의 형태)
    - Open-Addressing: 0부터 해시테이블크기-1까지의 인덱스를 사용한다. key값과 인덱스를 받는 해시함수를 사용하여 해시값을 구하고 해당 해시값의 공간에 다른 자료가 존재한다면 인덱스를 1증가시켜 같은 공간이 비어있을 때까지 과정을 반복한다.

## 시간 복잡도
1. 일반적으로 충돌이 발생하지 않을 경우 조회, 삽입, 삭제 모두 O(1)의 시간복잡도를 갖는다. 
2. 최악의 경우 N개의 모든 데이터가 모두 충돌하여 chaining되어 있으면 O(N)의 시간복잡도를 갖는다.

## 자바에서의 활용
1. 자바에서는 Hahsing을 사용하는 컬렉션에서는 Object 클래스에 정의된 hashCode()를 해시 메서드로 사용한다.
2. hashCode()는 기본적으로 객체의 주소를 사용하고, String 클래스의 경우 Object로부터 상속받은 hashCode() 메서드를 오버라이딩해서 문자열의 내용으로 해시코드를 얻는다.
3. 문자열의 내용이 같으면 해시코드 값도 같기 때문에 자바의 HashMap에서는 이미 존재하는 key값에 다른 value를 넣을 경우, 해당 key값의 기존 value는 새로운 값으로 덮어씌워진다.
4. 자바 HashMap 알아보기
    - 초기화  
        ```java
        Map<String, Object> h1 = new HashMap<>();
        // 기본 capcity: 16, load factor: 0.75
        // capacity 단독 설정 가능, capacity&load factor 설정 가능 
        // capcity: 저장 용량, load factor: 저장공간 추가 확보해야 하는 시점
        
        Map<String, Object> h2 = new HashMap<>(h1);
        // h2 맵을 h1과 동일하게 초기화
        ```
        
    - 삽입
        ```java
        V put(K key, V value);
        void putAll(Map<? extends K, ? extends V> m)
        V putIfAbsent(K key, V value)
        ```
        
    - 삭제 
        ```java
        void clear() 
        V remove(Object key)
        boolean remove(Object key, Object value)
        ```
        
    - 수정 
        ```java
        V replace(K key, V value)
        V replace(K key, V oldValue, V newValue)
        ```
        
    - 조회    
        ```java
        V get(Object key) 
        V getOrDefault(Object key, V defaultValue)
        Set<Map.Entry<K, V>> entrySet()
        Set<K> keySet()
        Collection<V> values()
        ```
        
    - 기타      
        ```java
        boolean containsKey(Object key)
        boolean containsValue(Object value)
        boolean isEmpty()
        int size()
        ```      
    - key가 사용자 정의 객체일 경우, equals() 메서드를 오버라이딩해서 같은 key값이라고 판단할 기준을 정해줄 수 있다.
