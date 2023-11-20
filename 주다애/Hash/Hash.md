### 🎈 Hash

<aside>
💡 key : value로 이루어진 자료구조

</aside>

모든 데이터 타입으로 접근이 가능하다. → 배열보다 편리하다.

자바에서는 주로  **HashMap** 자료구조를 사용한다.

Map 인터페이스를 구현한 Map Collections 중 하나로 Map 인터페이스를 상속하고 있어서 Map이 성질을 그대로 가지고 있다.

Key는 중복을 허용하지 않지만 Value는 중복이 허용된다.

### 사용법

- 코드
    
    ```java
    import java.util.HashMap;
    
    // Key가 String이고 Value가 Integer 타입의 Entry를 가지는 HashMap 선언
    HashMap<String, Integer> map = new HashMap<>();
    
    // 삽입 --> map.put(Key값, Value값)
    map.put("apple", 1);
    map.put("melon", 2);
    
    // 삭제 --> map.remove(Key값)
    map.remove("apple");
    map.clear(); --> 모든 값 제거
    
    // 출력 --> map.get(Key값)
    map.get("apple");
    ```
    
- Key값, Value값, Key : Value값을 가져올 수 있다.
    
    ```java
    // 1. Key값 가져오기 --> keySet()
    for(String k : map.keySet()) {
    	System.out.println(k);
    } // "apple", "melon"
    
    // 2. Value값 가져오기 --> values()
    Collections<Integer> values = map.values(); // [10, 2]
    
    // 3. Key : Value값 가져오기 --> entrySet() (빠름)
    for(Map.Entry<String, Integer> entry : map.entrySet()) {
    	System.out.println(entry.getKey() + " : " + entry.getValue());
    } // apple : 1, melon : 2
    
    // 4. Key : Value값 가져오기 --> forEach() Java 8 버전 이후부터 가능
    map.forEach((k, v) -> {
    		System.out.println(k + " : " + v)
    }); // apple : 1, melon : 2
    ```
    
- **getOrDefault()**
    
    get(key) 사용 시 key가 존재하지 않으면 null을 반환한다. 
    
    👉 이 때 null 대신 기본 반환 값을 반환하게 해주는 메소드 : **getOrDefault()**
    
    `getOrDefault**(**Object key, V defaultValue**)**`
    
    👉 key : 값을 가져와야 하는 요소의 Key 값
    
    👉 defaultValue : 지정된 key로 매핑된 값이 없을 경우 반환하는 기본 값
    
    ```java
    // map에 apple이라는 key가 있으면 apple의 value를 반환 / 없으면 0 반환
    getOrDefault("apple", 0);
    
    // nums배열의 각 원소가 map에 Key로 있으면 해당 value + 1을 해주고 없으면 0으로 하고 +1
    for(Integer num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
    }
    ```
    

### 시간 복잡도

1️⃣ 삽입 : O(1)

2️⃣ 삭제 : O(1)

3️⃣ 탐색 : O(1)

### 문제 유형

<aside>
💡 String을 기반으로 정보를 기록하고 관리해야 할 때

</aside>
