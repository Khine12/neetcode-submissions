class Solution:
    def minimumCost(self, n: int, connections: List[List[int]]) -> int:
        parent = [i for i in range(n+1)]
        rank = [1]*(n+1)
        def find(node):
            while node != parent[node]:
                parent[node] = parent[parent[node]]
                node = parent[node]
            return node

        def union(a,b):
            ra,rb = find(a),find(b)
            if ra == rb:
                return False
            if rank[ra] > rank[rb]:
                rank[ra] += rank[rb]
                parent[rb] = ra
            else:
                rank[rb] += rank[ra]
                parent[ra] = rb
            return True
        connections.sort(key=lambda c:c[2])
        total = 0
        edges = 0
        for a,b,cost in connections:
            if union(a,b):
                total += cost
                edges += 1
                if edges == n-1:
                    return total
        return total if edges == n-1 else -1