class Solution:
    def minimumFuelCost(self, roads: List[List[int]], seats: int) -> int:
        sys.setrecursionlimit(200000)
        n = len(roads)+1
        store = {i:[] for i in range(n)}
        for a,b in roads:
            store[a].append(b)
            store[b].append(a)
        
        total_fuel = 0
        def dfs(node,parent):
            nonlocal total_fuel
            people = 1
            for nei in store[node]:
                if nei!= parent:
                    people += dfs(nei,node)
            if node != 0:
                total_fuel += math.ceil(people/seats)
            return people
        dfs(0, -1)
        return total_fuel