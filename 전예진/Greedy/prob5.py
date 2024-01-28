def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

def solution(n, costs):
    answer = 0
    
    # 비용이 작은 순으로 정렬
    costs.sort(key=lambda x: x[2])
    
    # 각 섬의 부모 노드 초기화
    parent = [i for i in range(n)]
    
    for cost in costs:
        a, b, c = cost
        # 사이클이 발생하지 않는 경우에만 연결
        if find_parent(parent, a) != find_parent(parent, b):
            union_parent(parent, a, b)
            answer += c
    
    return answer
