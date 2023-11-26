# Prob3. 전화번호 목록
# 알게된 점 - 문자열1.startswith('문자열2')을 사용하면, 어떤 문자열1이 문자열2로 시작하는지 확인함 

def solution(phone_book):
    answer = True
    
    phone_book.sort()
    for i in range(0, len(phone_book)-1):
        if phone_book[i+1].startswith(phone_book[i]):
            answer = False
            
    return answer

