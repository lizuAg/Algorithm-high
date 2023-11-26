from collections import Counter

def solution(participant, completion):    
    dic = dict(Counter(participant))
    
    for i in completion:
        dic[i] -= 1
        
    answer = list(filter(lambda value: dic[value] != 0, dic))[0]
    
    return answer
