class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        
        parent = list(range(len(edges)+1))
        rank = [1]*(len(edges)+1)

        def find(node):
            while node != parent[node]:
                parent[node] = parent[parent[node]]
                node = parent[node]
            return node

        def union(a,b):

            ra,rb = find(a),find(b)

            if ra == rb:
                return False

            parent[rb] = ra
            rank[ra] += rank[rb]
            return True

        for a,b in edges:
            if not union(a,b):
                return [a,b]