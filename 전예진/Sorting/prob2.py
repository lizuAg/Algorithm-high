def solution(numbers):
    answer = ''
    
    # 맨 앞 자리를 크게 만들기 위해 문자열로 변환하여 정렬
    # ex ) 30 과 3의 비교시 333 vs 303030 -> 문자열이니까 333이 먼저옴
    sort_lst = sorted(map(str, numbers), key=lambda x: x*3, reverse=True)

    # 붙이기
    answer = ''.join(sort_lst)

    # 0이 맨 앞에 나오는 경우 삭제
    answer = str(int(answer))

    return answer
