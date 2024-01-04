from itertools import permutations

def is_prime(num):  
    num = int(num)
    
    if num == 0 or num == 1:
        return False
    
    for i in range(2, num):
        if num % i == 0:
            return False
    
    return True


def solution(numbers):
    num_lst = list(map(int, numbers))
    answer = []
    
    for i in range(1, len(num_lst)+1):
        tmp = list(permutations(num_lst, i))
        #print(tmp)
        
        for t in tmp:
            pm = ''.join(map(str, t))
 
            if is_prime(pm):
                answer.append(int(pm))
    
    
    tmp = list(set(answer))
    print(tmp)
    
    
    return len(tmp)
