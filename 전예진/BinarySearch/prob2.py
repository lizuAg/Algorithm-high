def solution(distance, rocks, n):
    rocks.sort()
    left, right = 1, distance
    
    while left <= right:
        mid = (left + right) // 2
        removed_rocks = 0
        prev_rock = 0
        
        2 11 14 17 21 
        for rock in rocks:
            # 현재 바위와 이전 바위 간의 거리가 mid보다 작으면 바위 제거
            if rock - prev_rock < mid:
                removed_rocks += 1
            # mid보다 큰 거리를 가진 바위는 남기고, 이를 이전 바위로 설정
            else:
                prev_rock = rock
        
        # 마지막 바위부터 도착지점까지의 거리가 mid보다 작으면 바위 제거
        if distance - prev_rock < mid:
            removed_rocks += 1
        
        if removed_rocks > n:
            right = mid - 1
        
        else:
            left = mid + 1
    
    return right
