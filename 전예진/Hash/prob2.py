from collections import Counter

def solution(nums):
    num = len(nums) // 2
    dic = dict(Counter(nums))
    answer = len(dic) if len(dic) < num else num

    return answer
