### 🎈 정렬(Sotring)

<aside>
💡 오름차순, 내림차순으로 데이터를 줄 세우는 방법

</aside>

주로 **배열(Array)**을 정렬한다.

자바에서 제공하는 메소드를 활용하거나 오버라이딩해서 사용할 수 있다.

Arrays.sort() → 단일 기준 배열 정렬

Comparable 인터페이스 → 다중 기준 정렬

Collections.sort() → 컬렉션 정렬

### 사용법

- **Arrays.sort()**
    
    ```java
    import java.util.Arrays;
    
    int[] arr = new int[] {1, 3, 5, 2, 4}
    
    // 오름차순 정렬
    Arrays.sort(arr); // {1, 2, 3, 4, 5}
    
    // 내림차순 정렬 --> 객체형으로 만들어주어야함
    **Integer**[] arr = {1, 3, 5, 2, 4}
    Arrays.sort(arr, Collections.reverseOrder()); // {5, 4, 3, 2, 1}
    
    // 내림차순 정렬 --> -1을 곱해서 오름차순으로 정렬하고 --> 다시 -1을 곱해서 출력하자
    
    // 부분정렬 --> 시작과 끝 index 전달이 필요함
    Arrays.sort(arr, 0, 3); // {1, 2, 3, 5, 4}
    ```
    
- **Comparable**
    
    ```java
    // 영어 점수로 정렬하되, 점수가 동일하면 수학 점수로 정렬(내림차순)
    class Score implements Comparable<Score> {
    	int en;
    	int math;
    
    	Score(int en, int math) {
    		this.en = en;
    		this.math = math;
    	}
    
    	@Override
    	public int compareTo(Score o) {
    		if (this.en != o.en) {
    			return o.en - this.en;
    		}
    		return o.math - this.math;
    	}
    }
    
    ArrayList<Score> arr = new ArrayList<>();
    
    arr.add(new Score(100, 80));
    arr.add(new Score(100, 90));
    arr.add(new Score(80, 80));
    
    Collections.sort(arr); // (100, 90) (100, 80) (80, 80) 순서로 정렬됨
    ```
    

### 시간 복잡도
