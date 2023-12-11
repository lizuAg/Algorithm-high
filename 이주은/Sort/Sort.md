# 4주차 정렬

![image](https://github.com/lizuAg/Algorithm-high/assets/68546023/031addaf-5da6-49ef-92da-638d9e42e71b)


## Quick Sort

: 하나의 리스트를 피벗(pivot)을 기준으로 두 개의 **비균등한 크기로 분할**하고 분할된 부분 리스트를 정렬한 다음, 두 개의 정렬된 부분 리스트를 합하여 전체가 정렬된 리스트가 되게 하는 방법이다.

| 최선 | O(nlogn) |
| --- | --- |
| 평균 | O(nlogn) |
| 최악 | O(n^2) |

- Unstable Sort
- Array.sort()가 듀얼 피벗 알고리즘을 사용한다고

## Merge Sort

:  하나의 리스트를 두 개의 **균등한 크기**로 분할하고 분할된 부분 리스트를 정렬한 다음, 두 개의 정렬된 부분 리스트를 합하여 전체가 정렬된 리스트가 되게 하는 방법이다.

| 최선 | O(nlogn) |
| --- | --- |
| 평균 | O(nlogn) |
| 최악 | O(n^2) |

- stable sort
- 추가 메모리가 n만큼 필요
- LinkedList 링크인덱스만 변경됨. ↔ !Linked이면? 데이터 대이동 발생

## Tim sort

[Tim sort에 대해 알아보자](https://d2.naver.com/helloworld/0315536)

- Insertion sort와 Merge sort를 결합하여 만든 정렬이다.

| 최선 | O(n) |
| --- | --- |
| 평균 | O(nlogn) |
| 최악 | O(nlogn) |
- **참조 지역성**(Locality of reference)
    
    참조 지역성 원리란, CPU가 미래에 원하는 데이터를 예측하여 속도가 빠른 장치인 캐시 메모리에 담아 놓는데 이때의 예측률을 높이기 위하여 사용하는 원리이다. 쉽게 말하자면, **최근에 참조한 메모리나 그 메모리와 인접한 메모리를 다시 참조할 확률이 높다**는 이론을 기반으로 캐시 메모리에 담아놓는 것이다. 메모리를 연속으로 읽는 작업은 캐시 메모리에서 읽어오기에 빠른 반면, 무작위로 읽는 작업은 메인 메모리에서 읽어오기에 속도의 차이가 있다.
    
- 왜 O(n^2)인 삽입정렬을 사용했나요?
    - 삽입정렬은 참조지역성 원리를 매우 잘 만족
    - … 작은 n에 대하여 QuickSort보다 빠름. (상수배가 제일 작다고 하는)
    - 전체를 작은 덩어리로 잘라 삽입 정렬 후 병합정렬을 수행해보자.
- ****Collections.sort()에 사용****

## Java

### **[Interface Comparator<T>](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html)**

```jsx
class StringNumberComparator implements Comparator<String> {
    @Override
    public int compare(String str, String another) {
        String str1 = str+another;
        String str2 = another+str;
        return str1.compareTo(str2);
    }
}
...
list.sort(new StringNumberComparator());
list.sort(new StringNumberComparator().reversed());
```

```jsx
Collections.sort(list, (o1, o2) -> o1 - o2);
```

### **[Interface Comparable<T>](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html)**

```jsx
class Fruit implements Comparable<Fruit> {
	String name;
	int weight;

	Fruit(String name, int weight) {

	}

	@Override
	public int compareTo(Fruit o) {
			return this.weight - o.weight;
	}
}
```

- +) Interface는 정의된 메소드를 모두 구현해야 하는 것 아닌가요?
    
    가장 큰 수 문제에서 Comparator의 구현 클래스를 작성하고 compare() 메소드만 구현해서 풀었다. > Java 부터는 Interface에서 일반 메소드를 구현할 수 있도록 변경되었고, 추상메소드는 compare밖에 없다고 한다. 나머지는 default/static 메소드에 해당한다.
