def solution(array, commands):
    answer = []
    
    lst = []
    for n in range(len(commands)):  
        i = commands[n][0]
        j = commands[n][1]
        k = commands[n][2]

        lst = array[i-1:j]
        lst.sort()
        answer.append(lst[k-1])

    return answer
