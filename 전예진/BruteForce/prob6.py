def solution(n, wires):
    graph = [[] for _ in range(n + 1)]

    # 그래프 생성
    for wire in wires:
        a, b = wire
        graph[a].append(b)
        graph[b].append(a)

    def dfs(node, parent):
        count = 1  # 현재 노드를 포함한 서브트리 크기
        for child in graph[node]:
            if child != parent:
                count += dfs(child, node)
        return count

    result = float('inf')  # 결과 초기값을 무한대로 설정

    for wire in wires:
        a, b = wire
        graph[a].remove(b)
        graph[b].remove(a)

        size1 = dfs(a, b)  # 첫 번째 전력망의 크기 계산
        size2 = n - size1  # 두 번째 전력망의 크기 계산
        result = min(result, abs(size1 - size2))

        # 그래프 복구
        graph[a].append(b)
        graph[b].append(a)

    return result
