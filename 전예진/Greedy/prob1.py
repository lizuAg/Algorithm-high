def solution(n, lost, reserve):
    # 체육복을 도난당한 학생들 중에서 여벌 체육복을 가지고 있는 학생들에 대한 처리
    lost_set = set(lost) - set(reserve)
    reserve_set = set(reserve) - set(lost)

    # 여벌 체육복을 가지고 있는 학생들 중에서 앞번호나 뒷번호에게 빌려줄 수 있는지 확인하고 빌려줌
    for r in reserve_set:
        if r - 1 in lost_set:
            lost_set.remove(r - 1)
        elif r + 1 in lost_set:
            lost_set.remove(r + 1)

    answer = n - len(lost_set)
    
    return answer
