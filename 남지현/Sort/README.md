# 정렬

## 정렬 알고리즘

1. Insertion Sort
    - tmp를 이전 인덱스의 값들과 비교하며 알맞은 위치에 삽입
    - tmp 이전의 배열은 이미 정렬된 상태
    - 이미 정렬이 되어 있는 상태일 경우 tmp ≥ numbers[j]이기 때문에 내부 for문을 돌지 않음 → O(N)
    - 역순 정렬이 되어 있는 경우 pivot 이하의 모든 원소를 돌아야 하기 때문에 O(N^2)
    
    ```
    n = numbers.length
    for (i = 1 : i < n : i++) {
        tmp = numbers[i]
        for (j=i-1 : j>=0 && tmp < numbers[j] : j--) {
            numbers[j+1] = numbers[j]
        }
        numbers[j+1] = tmp
    }
    ```
    
2. Merge Sort
    - 분할 정복 방식을 사용하는 정렬 알고리즘
    - 먼저 분할한 후 합치는 과정에서 정렬이 일어나는 방식
    
    ```
    function mergeSort(numbers, l, r) {
        if (l < r) {
            m = floor((l+r)/2)
            // Divide, 배열을 반으로 분할해 나감
            mergeSort(numbers, l, m)
            mergeSort(numbers, m+1, r)
            // Combine
            merge(numbers, l, m ,r)
        }
    }
    
    function merge(numbers, l, m ,r) {
        // original 배열의 l부터 m까지의 부분배열(L)과 m+1부터 r까지의 부분배열(R) 각각 복사
        // L과 R은 이미 정렬된 상태
        i=0, j=0
        while(i < L배열 크기 || j < R배열 크기) {
            // L[i]과 R[j]의 값을 비교하여 더 작은 값을 original 배열에 삽입 후 해당 인덱스 증가
            if (L[i] < R[j]) {
                numbers[l+i+j] = L[i]
                i++
            }
            else {
                numbers[l+i+j] = R[j]
                j++
            }
        }
    }
    ```
    
3. Quick Sort
    - 분할정복 방식을 사용하되, 분할과 정렬을 같이 수행하는 방식
    - 가장 마지막에 있는 값을 pivot으로 하여 pivot보다 작은 값은 pivot의 왼쪽에, 큰 값은 오른쪽에 배치하고 이동된 pivot의 인덱스를 기준으로 배열을 두 부분으로 나눈 후 같은 과정을 반복.
    
    ```
    function quickSort(numbers, l, r) {
        if (l < r) {
            pivot = numbers[r]
            i = p-1
            for (j=p: r-1 : j++) {
                if (numbers[j] <= pivot) {
                    i++
                    swap(numbers[i], numbers[j])
                }
            }
            swap(numbers[i+1], numbers[i])
            m = i+1
            quickSort(numbers, l, m-1)
            quickSort(numbers, m+1, r)
        }
    }
    ```
    
4. Heap Sort
    
    ```
    n = numbers.length
    makeMaxHeap(numbers)    // 기존 배열을 max heap으로 만든다 -> NlogN
    for (n-1번 반복) {
        root와 leaf의 자리를 exchange
        현재 마지막 인덱스에는 max값이 있는 상태
        힙의 사이즈를 하나 줄이고
        root부터 마지막 인덱스를 제외한 나머지 부분에 대해 max heap을 다시 만든 후 동일 과정 반복
    }     // -> NlogN
    ```
    

## 자바의 정렬 메서드

1. Arrays.sort
    - 예시
        
        ```java
        // 가장 큰 수
        int[] numbers = {6, 10, 2};
        Arrays.sort(numbers);
        ```
        
    - 내부
        
        ```java
        public class Arrays {
            public static void sort(int[] a) {
                DualPivotQuicksort.sort(a, 0, 0, a.length);
            }
        }
        ```
        
    - 배열의 크기에 따라 추가배열 생성여부를 고려하여 InsertionSort, MergeSort, DualPivotQuickSort 등을 채택.
    - DualPivotQuickSort
        - 두개의 pivot을 사용하여 3개의 구간으로 나누어 수행하는 quick sort
2. Collections.sort
    - 예시
        
        ```java
        List<Integer> numbers = Arrays.asList(6, 10, 2);
        Collections.sort(numbers);
        ```
        
    - 내부
        
        ```java
        public static <T> void sort(T[] a, Comparator<? super T> c) {
            if (c == null) {
                sort(a);
            } else {
                if (LegacyMergeSort.userRequested)
                    legacyMergeSort(a, c);
                else
                    TimSort.sort(a, 0, a.length, c, null, 0, 0);
            }
        }
        ```
        
    - TimSort
      
        <img src= "https://prod-files-secure.s3.us-west-2.amazonaws.com/3bb0ce80-a7af-4bfe-90fe-7eccbc252c92/465b2a01-b025-404a-9296-30f9cfacf8dd/timSort.png" width=200/>
        - MergeSort와 InsertionSort를 합친 형태
        - MergeSort처럼 컬렉션을 분할하되, 일정 크기 이상 작아진 컬렉션에 대해서는 이진삽입정렬을 수행, 이진삽입정렬은 삽입정렬에서 원소가 삽입될 위치를 선형탐색이 아닌 이진탐색으로 찾는 형태.
3. 차이점
    - 자바 Collection의 경우 산발적으로 데이터가 저장되는 반면, 배열은 데이터들이 메모리상의 연속된 주소에 저장되어 있기 때문에 Cache의 hit rate가 높은 편. 따라서 Arrays.sort는 교환횟수가 적고 참조지역성이 좋은 QuickSort를 사용.
    - 반면에 Collections.sort는 참조지역성이 좋지 않고, 크기가 큰 객체를 비교할 때의 비교비용이 비쌀 경우가 많기 때문에 Stable Sort이면서 어떤 상황에도 O(NlogN)을 유지하는 MergeSort를 사용.

## 객체 정렬

1. Comparable
    - 객체를 비교 가능하도록 해주는 인터페이스
    - 우선순위 큐에서와 마찬가지로 compareTo() 메서드를 구현하면 객체간 비교 가능
    - 자기자신과 다른 객체를 비교하는 메서드를 오버라이딩
    - 정렬 대상이 되는 객체가 사용자 정의 객체이거나 수정 가능할 때 사용하면 sort()메서드에 정렬 기준을 따로 명시하지 않아도 됨.
    
    ```java
    class Job implements Comparable<Job>{
        int requestTime;
        int processTime;
        int startTime;
    		
    		@Override
        public int compareTo(Job job) {
            return this.processTime - job.processTime;
        }
    }
    ```
    
2. Comparator
    - 정렬 대상 객체를 수정할 수 없거나, 자주 사용하지 않는 정렬 기준일 경우, sort() 메서드의 추가 인자로 넘기는 타입.
    - 두 객체를 비교하는 메서드를 오버라이딩
    - 객체 내부에 compare()함수를 오버라이딩하거나, 람다로 구현 가능
        
        ```java
        Collections.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Player a, Player b) {
                return a.processTime() - b.processTime();
            }
        });
        Collections.sort(jobs, (job1, job2)-> job1.processTime-job2.processTime);
        ```
        
    - stream의 sorted() 메서드에 comparator를 넘겨도 정렬 가능
        
        ```java
        List<Job> list = jobs.stream()
            .sorted((job1, job2)-> job1.processTime-job2.processTime)
            .collect(Collectors.toList());
        ```
        

## 코테에서 정렬. 어디까지 알아야 할까?

1. 일반적으로 언어의 정렬 라이브러리는 어떤 상황에서도 최대한 일정 성능을 유지하도록 개발되었기 때문에 단순히 문제풀이 과정중 정렬된 컬렉션이 필요하다면 정렬 라이브러리를 사용하는 것이 좋음.
2. 다만, 가끔 특정 정렬 알고리즘을 응용해서 푸는 유형의 문제도 나온다고 하므로 NlogN 복잡도를 가지는 몇몇의 알고리즘은 아이디어를 알고 있는 것이 좋을 것이라 생각.

