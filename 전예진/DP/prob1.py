def solution(N, number):
    if N == number: # N과 number가 같으면 1회로 표현 가능
        return 1
    
    # DP를 위한 집합 초기화
    dp = [set() for _ in range(9)]
    
    # 각 집합에 각각의 N을 연속해서 나열한 경우 초기화
    for i in range(1, 9):
        dp[i].add(int(str(N) * i))
    
    # DP 진행
    for i in range(1, 9):
        for j in range(1, i):
            for num1 in dp[j]:
                for num2 in dp[i - j]:
                    dp[i].add(num1 + num2)
                    dp[i].add(num1 - num2)
                    dp[i].add(num1 * num2)
                    if num2 != 0:
                        dp[i].add(num1 // num2)
        
        if number in dp[i]:
            return i
    
    return -1 
