## 해시 Hash

**해시 함수**는 임의의 길이의 데이터를 고정된 길이의 데이터로 매핑하는 함수이다. 해시 함수에 의해 얻어지는 값은 **해시 값**, **해시 코드**, 해시 체크섬 또는 간단하게 **해시**라고 한다. 그 용도 중 하나는 해시테이블이라는 자료구조에 사용되며, 매우 빠른 데이터 검색을 위해 사용된다. 해시 함수는 큰 파일에서 중복되는 레코드를 찾을 수 있기 때문에 데이터베이스 검색이나 테이블 검색의 속도를 가속할 수 있다

## 해시테이블 hash table

해시테이블은 키를 값에 매핑할 수 있는 자료구조이다. 즉, 키를 사용하여 그 키에 해당하는 값을 찾기 위해 빠른 속도로 키를 검색할 수 있는 자료구조이다. 해시 테이블은 해시함수를 사용하여 index를 버킷이나 슬롯의 배열로 계산한다.

## 맵 Map

- 맵은 다른 언어에도 있는 자료형, associative array 또는 hash라고 불린다.
- 맵은 키(key)와 값(value)을 한 쌍으로 갖는 자료형이다.
- 자바에서 맵 자료형에는 HashMap, LinkedHashMap, TreeMap 등이 있다.

## HashMap in JAVA

### 1️⃣ HashMap 선언

```java
HashMap<String,String> map1 = new HashMap<String,String>();//HashMap생성
HashMap<String,String> map2 = new HashMap<>();//new에서 타입 파라미터 생략가능
HashMap<String,String> map3 = new HashMap<>(map1);//map1의 모든 값을 가진 HashMap생성
HashMap<String,String> map4 = new HashMap<>(10);//초기 용량(capacity)지정
HashMap<String,String> map5 = new HashMap<>(10, 0.7f);//초기 capacity,load factor지정
HashMap<String,String> map6 = new HashMap<String,String>(){{//초기값 지정
put("a","b");
}};
```

### 2️⃣ put / get

```java
HashMap<String, String> map = new HashMap<>();
        map.put("people", "사람");
        map.put("baseball", "야구");
        System.out.println(map.get("people")); // "사람" 출력
```

- put(key, value)
    - Key, Value 설정타입과 같은 타입의 값을 넣어야 함. (당연함)
    - 동일한 키 값이 이미 존재 → 기존의 값은 새로운 입력 값으로 대치
- get(key)
    
    맵에 key에 해당하는 value가 없으면 → null
    
    map.getOrDefault(”java”, “자바”)); null 대신 리턴값을 정해주는 메소
    

### 3️⃣ 그 외

```java
map.size(); // 맵 요소 개수를 리턴
map.remove(key); // 맵의 항목 삭제, 해당 key의 항목 삭제 후 value 값 리턴
map.clear(); //모든 값 제
map.containsKey(key); //해당 key가 존재하는지 true/false 리턴
map.keySet(); // 모든 key의 배열 리턴
ArrayList<String> keyList = new ArrayList<>(map.keySet());
```

### 4️⃣ 전체 값 조회

```java
//1. entrySet + for문 이용
for (Entry<Integer, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ", " + entry.getValue());
}

//2. entrySet + Iterator 이용
Iterator<Entry<Integer, String>> entries = map.entrySet().iterator();
while(entries.hasNext()){
    Map.Entry<Integer, String> entry = entries.next();
    System.out.println("[Key]:" + entry.getKey() + " [Value]:" +  entry.getValue());
}

//3. keySet + for 문
for(Integer i : map.keySet()){
    System.out.println(i + ", " + map.get(i));
}
```

- KeySet을 이용하면, key값으로 value를 조회하면서 성능저하 → entrySet 이용

## Reference

[03-08 맵](https://wikidocs.net/208#hashmap)

[Java HashMap은 어떻게 동작하는가?](https://d2.naver.com/helloworld/831311)

[[Java] 자바 HashMap 사용법 & 예제 총정리](https://coding-factory.tistory.com/556)

[Array.sort(), Collection.sort(), Comparable, Comparator 사용법](https://stir.tistory.com/124)

[[Java] HashMap 메소드 및 사용법](https://gre-eny.tistory.com/97)
