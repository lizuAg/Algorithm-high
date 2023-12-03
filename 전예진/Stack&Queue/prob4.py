from collections import deque

def solution(priorities, location):
    answer = 0
    
    queue = deque()
    for i in range(len(priorities)):
        queue.append([i, priorities[i]]) # (index, value)
        
    m = max(queue, key=lambda x : x[1])[1]

    count = 1
    while queue:
        tmp = queue.popleft()
        index = tmp[0]
        value = tmp[1]
        
        # pop한게 max값이라면 max를 다시 갱신해주기
        if value == m:
            # 만약 location이랑 같으면 반복문 종료
            if index == location:
                answer = count
                break
            
            else:
                m = max(queue, key=lambda x : x[1])[1]
                count += 1
            
        # max값이 아니라면 큐에 다시 넣어주기
        elif value != m:
            queue.append([index, value])
                
    return answer
