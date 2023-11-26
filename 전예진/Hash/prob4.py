from collections import Counter

def solution(clothes):
    answer = 1
    
    # 리스트에 의상의 종류를 넣고 개수를 구한다.
    lst = []
    for name, type in clothes:
        lst.append(type)
    
    # wear_count[key] + 1은 해당 종류의 옷을 선택하지 않는 경우도 포함하여 개수를 계산한 것
    wear_count = Counter(lst)
    for key in wear_count:
        answer *= wear_count[key] + 1
    
    # 아무것도 입지 않는 경우"를 제외를 위해 - 1
    return answer - 1
