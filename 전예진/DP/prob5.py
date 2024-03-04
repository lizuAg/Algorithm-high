def solution(money):
    if len(money) == 3:
        return max(money)

    def dp(start, end):
        # 첫 집을 털었을 경우
        stole = [money[start], max(money[start], money[start + 1])]
        
        for i in range(start + 2, end):
            stole.append(max(stole[-1], stole[-2] + money[i]))
        
        return stole[-1]

    # 첫 집을 털었을 때와 안 털었을 때를 나눠서 최댓값 구하기
    return max(dp(0, len(money) - 1), dp(1, len(money)))
