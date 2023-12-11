from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0  # 총 걸린 시간
    trucks = deque((truck, 0) for truck in truck_weights)  # 남은 트럭들의 무게와 시작 시간을 저장한 큐
    tmp_bridge = deque()  # 다리 위에 올라간 트럭을 저장한 큐. 각 트럭은 (무게, 올라간 시간)의 튜플로 표현됨
    curr_weight = 0  # 현재 다리 위에 있는 트럭들의 무게 합

    while trucks or tmp_bridge:
        # 다리를 건넌 트럭이 있고, 다리를 다 건넌 경우 해당 트럭을 빼내고 현재 무게에서 빼줌
        if tmp_bridge and answer - tmp_bridge[0][1] == bridge_length:
            curr_weight -= tmp_bridge.popleft()[0]

        # 남은 트럭이 있고, 다음 트럭을 다리에 올리는 조건을 만족하는 경우
        if trucks and curr_weight + trucks[0][0] <= weight and len(tmp_bridge) < bridge_length:
            truck, start_time = trucks.popleft()  # 트럭과 시작 시간을 꺼내옴
            tmp_bridge.append((truck, answer))  # 현재 시간과 함께 튜플로 다리 위에 올라간 트럭을 저장
            curr_weight += truck  # 현재 무게에 올라간 트럭의 무게를 더해줌

        answer += 1  # 시간을 증가시킴

    return answer
