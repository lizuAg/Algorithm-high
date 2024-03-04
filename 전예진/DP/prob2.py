def solution(triangle):
    answer = 0
    
    length = len(triangle)

    dp = [[0] * length for _ in range(length)]
    
    dp[0][0] = triangle[0][0]
    
    # 첫번째 열 초기화
    for i in range(length):
        dp[i][0] = dp[i-1][0] + triangle[i][0]    
    
    # 대각선 초기화
    for i in range(1, length):
        dp[i][i] = dp[i-1][i-1] + triangle[i][i]
    
    # 나머지 초기화
    for i in range(2, length):
        for j in range(1, i):
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j] 
    
    # 정답 구하기
    for i in range(length):
        answer = max(answer, dp[length-1][i])
    
    return answer
