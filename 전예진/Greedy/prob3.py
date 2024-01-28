def solution(number, k):
    answer = ''
    stack = []

    # 스택의 맨 위의 숫자가 현재 숫자보다 작을 때는 스택에서 해당 숫자를 제거
    for i, digit in enumerate(number):
        while k > 0 and stack and stack[-1] < digit:
            stack.pop()
            k -= 1

        if k == 0:
            answer += number[i:]
            break

        stack.append(digit)

    stack = stack[:-k] if k > 0 else stack
    answer = ''.join(stack) + answer

    return answer
