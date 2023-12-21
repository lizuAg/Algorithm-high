def solution(sizes):
    answer = 0
    
    # (더큰것, 작은것)으로 바꿔주기
    for i in range(len(sizes)):
        if sizes[i][0] < sizes[i][1]:
            tmp = sizes[i][0]
            sizes[i][0] = sizes[i][1]
            sizes[i][1] = tmp
    
    # x[0]을 기준으로 최댓값
    max1 = max(sizes, key=lambda x: x[0])[0]
    
    # x[1]을 기준으로 최댓값
    max2 = max(sizes, key=lambda x: x[1])[1]
    
    # 두 최댓값의 곱
    answer = max1 * max2

    return answer
