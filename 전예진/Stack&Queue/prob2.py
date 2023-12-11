from math import ceil

def solution(progresses, speeds):
    answer = []

    time = []
    for i in range(len(progresses)):
        time.append(ceil((100 - progresses[i]) / speeds[i]))

    stack = []   
    for i in range(len(time)):
        while stack and time[i] > time[stack[0]]:
            top = stack.pop()
        
            if not stack:
                answer.append(i - top)
        
        stack.append(i)
    
    if stack:
        answer.append(len(stack))
    
    return answer
