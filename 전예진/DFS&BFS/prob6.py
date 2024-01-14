def solution(tickets):
    answer = []
    graph = {}
    
    # 그래프 생성
    for ticket in tickets:
        if ticket[0] not in graph:
            graph[ticket[0]] = []
        graph[ticket[0]].append(ticket[1])
    
    # 출발지를 기준으로 정렬
    for key in graph:
        graph[key].sort(reverse=True)
    
    def dfs(start):
        nonlocal answer
        answer.append(start)
        
        # 모든 티켓을 사용한 경우 종료
        if len(answer) == len(tickets) + 1:
            return True
        
        # 현재 위치에서 이동 가능한 공항이 있는지 확인
        if start in graph:
            for _ in range(len(graph[start])):
                destination = graph[start].pop()
                if dfs(destination):
                    return True
                graph[start].insert(0, destination)  # backtracking

        # 이동 가능한 공항이 없는 경우 이전 공항으로 돌아감
        answer.pop()
        return False
    
    dfs("ICN")
    
    return answer
