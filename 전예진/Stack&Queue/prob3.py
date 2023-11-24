def solution(s):
    answer = True
    
    tmp = []
    for i in s:
        if i == '(':
            tmp.append(i)
        else:
            if len(tmp) == 0:
                answer = False
                break
            tmp.pop()
    
    if len(tmp) != 0:
        answer = False
            
    return answer
