import heapq

def solution(operations):
    answer = []
    
    max_heap = []
    min_heap = []
    visited = [False] * 1000001
    
    for i in range(len(operations)):
        operation, number = operations[i].split()
        number = int(number)
        
        if operation == 'I':
            heapq.heappush(max_heap, (-number, i ))
            heapq.heappush(min_heap, (number, i))
            visited[i] = True

        elif operation == 'D' and number == 1:
            while max_heap and not visited[max_heap[0][1]]:
                heapq.heappop(max_heap)

            if max_heap:
                visited[max_heap[0][1]] = False
                heapq.heappop(max_heap)
              
        elif operation == 'D' and number == -1:
            while min_heap and not visited[min_heap[0][1]]:
                heapq.heappop(min_heap)
            
            if min_heap:
                visited[min_heap[0][1]] = False
                heapq.heappop(min_heap)

    while max_heap and not visited[max_heap[0][1]]:
        heapq.heappop(max_heap)      
    
    while min_heap and not visited[min_heap[0][1]]:
        heapq.heappop(min_heap)      
    
    if max_heap and min_heap:
        answer.append(-heapq.heappop(max_heap)[0])
        answer.append(heapq.heappop(min_heap)[0])
   
    else:
        answer.append(0)
        answer.append(0)
    
    return answer
