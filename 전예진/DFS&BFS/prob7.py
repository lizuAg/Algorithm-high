import copy


d = [(-1,0),(0,1),(1,0),(0,-1)]
# 채울 칸과 놓을 조각을 찾는 함수
def dfs(graph, x, y, position, n, num):
    ret = [position]    
    for i in range(4):
        dx,dy = d[i]
        nx,ny = x + dx, y + dy                
        if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] == num:
            graph[nx][ny] = 2
            ret = ret + dfs(graph, nx, ny, [position[0]+dx, position[1]+dy], n, num)    
    return ret

# 조각을 돌리기 위한 함수
def rotate(lst):
    n = len(lst)
    ret = [[0]*n for _ in range(n)]
    
    for i in range(n):
        for j in range(n):
            ret[j][n-1-i] = lst[i][j]
    
    return ret

def solution(game_board, table):
    answer = 0
    game_board_copy = copy.deepcopy(game_board)    
    n = len(game_board)
    board_slots = []
    # 빈공간을 모아둠
    for i in range(n):
        for j in range(n):
            if game_board_copy[i][j] == 0:
                game_board_copy[i][j] = 2
                result = dfs(game_board_copy, i, j, [0, 0], n, 0)[1:]
                board_slots.append(result)
    # 조각을 돌림
    for r in range(4):
        table = rotate(table)
        table_rotate_copy = copy.deepcopy(table)

        for i in range(n):
            for j in range(n):
                if table_rotate_copy[i][j] == 1:
                    table_rotate_copy[i][j] = 2
                    # 딱 맞는 조각만 채울 수 있음
                    result = dfs(table_rotate_copy, i, j, [0, 0], n, 1)[1:]
                    if result in board_slots:
                        board_slots.pop(board_slots.index(result))
                        answer += (len(result) + 1)
                        
                        table = copy.deepcopy(table_rotate_copy)
                        
                    else:
                        table_rotate_copy = copy.deepcopy(table)
    return answer
