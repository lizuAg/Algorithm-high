import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    
    while scoville[0] < K:  
        if len(scoville) == 1:
            return -1
        
        # 제일 작은거 2개를 가져옴 
        tmp1 = heapq.heappop(scoville)
        tmp2 = heapq.heappop(scoville)

        # 섞은 음식의 스코빌 지수 계산
        new = tmp1 + (tmp2 * 2)

        # 다시 heap에 넣기
        heapq.heappush(scoville, new)
    
        # answer 하나 증가
        answer += 1
            
    return answer
