class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        
        if len(edges) != n-1:
            return False

        parent = list(range(n))
        mark = [1]*n

        def find(x):

            while x!= parent[x]:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x

        def union(a,b):

            ra,rb = find(a),find(b)

            if ra == rb:
                return False

            if mark[ra] < mark [rb]:

                ra,rb = rb,ra
            
            parent[rb] = ra
            mark[ra]+=mark[rb]
            
            return True

        for a,b in edges:

            if not union(a,b):
                return False

        return True