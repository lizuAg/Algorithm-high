def solution(routes):
    answer = 0
    
    # 차량의 진출 지점을 기준으로 정렬
    routes.sort(key=lambda x: x[1])
    
    # 카메라 위치 초기화
    camera = -30001
    
    for route in routes:
        if camera < route[0]:
            # 카메라가 현재 차량의 진입 지점보다 이전에 있으면
            # 현재 차량을 만나지 않았으므로 카메라 설치
            camera = route[1]
            answer += 1
    
    return answer
