from collections import deque

def solution(n, edge):
    graph = {i: [] for i in range(1, n+1)}

    for e in edge:
        a, b = e
        graph[a].append(b)
        graph[b].append(a)

    def bfs(start):
        visited = [False] * (n + 1)
        queue = deque([(start, 0)])
        max_distance = 0
        count = 0

        while queue:
            node, distance = queue.popleft()

            if not visited[node]:
                visited[node] = True

                if distance > max_distance:
                    max_distance = distance
                    count = 1
                elif distance == max_distance:
                    count += 1

                for neighbor in graph[node]:
                    if not visited[neighbor]:
                        queue.append((neighbor, distance + 1))

        return count

    return bfs(1)

