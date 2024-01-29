def solution(n, times):
    left, right = 1, max(times) * n
    
    while left <= right:
        mid = (left + right) // 2
        count = 0
        
        # mid 시간 동안 처리 가능한 인원 수 계산
        for time in times:
            count += mid // time
        
        # 처리 가능한 인원 수가 n보다 작으면 시간을 늘려야 함
        if count < n:
            left = mid + 1
        
        # 처리 가능한 인원 수가 n보다 크거나 같으면 시간을 줄여도 됨
        else:
            right = mid - 1
    
    return left
