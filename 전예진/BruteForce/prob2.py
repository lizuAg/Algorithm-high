def solution(answers):
    answer = []
    
    a = [1, 2, 3, 4, 5]
    b = [2, 1, 2, 3, 2, 4, 2, 5]
    c = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    cnt = [0, 0, 0]
    
    for i in range(len(answers)):
        ans = answers[i]
        
        if a[i % len(a)] == ans:
            cnt[0] += 1
        
        if b[i % len(b)] == ans:
            cnt[1] += 1
        
        if c[i % len(c)] == ans:
            cnt[2] += 1
        
      
    # 최대값 구하기
    max_value = max(cnt)
    for i in range(3):
        if max_value == cnt[i]:
            answer.append(i+1)
    
    return answer
