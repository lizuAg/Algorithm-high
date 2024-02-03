t = int(input())

for _ in range(t):
    n = int(input())
    lst = list(map(int, input().split()))

    answer = 0
    max_price = 0  # 현재까지의 최대 주가

    for i in range(n-1, -1, -1):
        # 현재 날의 주가가 최대 주가보다 크다면 최대 주가를 업데이트
        if lst[i] > max_price:
            max_price = lst[i]
        # 최대 주가와 현재 날의 주가 차이를 더하여 최대 이익 갱신
        else:
            answer += (max_price - lst[i])
    
    print(answer)
