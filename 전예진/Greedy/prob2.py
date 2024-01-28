def solution(name):
    answer = 0
    
    # A에서부터 각 알파벳까지 위아래 이동 횟수 계산
    move_up_down = [min(ord(char) - ord('A'), ord('Z') - ord(char) + 1) for char in name]
    
    # 현재 커서 위치
    current_position = 0
    
    while True:
        # 현재 위치의 알파벳을 만들기 위한 조이스틱 조작 횟수 더하기
        answer += move_up_down[current_position]
        # 현재 위치의 알파벳을 A로 만들기
        move_up_down[current_position] = 0
        
        # 모든 알파벳을 만들었다면 종료
        if sum(move_up_down) == 0:
            break
        
        # 다음으로 이동할 위치를 찾기
        left, right = 1, 1
        while move_up_down[(current_position - left) % len(name)] == 0:
            left += 1
        while move_up_down[(current_position + right) % len(name)] == 0:
            right += 1
        
        # 왼쪽으로 이동할지 오른쪽으로 이동할지 결정하여 현재 위치 업데이트
        if left < right:
            answer += left
            current_position = (current_position - left) % len(name)
        else:
            answer += right
            current_position = (current_position + right) % len(name)
    
    return answer
