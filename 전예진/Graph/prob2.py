from collections import defaultdict

def solution(n, results):
    wins = defaultdict(set)
    loses = defaultdict(set)

    for winner, loser in results:
        wins[winner].add(loser)
        loses[loser].add(winner)

    for i in range(1, n + 1):
        for loser in wins[i]:
            loses[loser].update(loses[i])

        for winner in loses[i]:
            wins[winner].update(wins[i])

    count = 0
    for i in range(1, n + 1):
        if len(wins[i]) + len(loses[i]) == n - 1:
            count += 1

    return count
