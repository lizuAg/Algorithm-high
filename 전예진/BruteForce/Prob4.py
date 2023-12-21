def solution(brown, yellow):
    answer = []
     
    add = brown // 2 + 2
    mul = yellow + brown
    
    x, y = 0, 0
    
    for i in range(3, add):
        y = add - i
        
        if y * i == mul:
            answer.append(y)
            answer.append(i)
            break
    
    return answer
