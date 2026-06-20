class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        visited = set()
        visiting = set()

        adj = {c: [] for c in range(numCourses)}

        for a,b in prerequisites:

            adj[a].append(b)

        def dfs(course):

            if course in visiting:
                
                return False

            if course in visited:

                return True
            
            visiting.add(course)

            for pre in adj[course]:

                if not dfs(pre):

                    return False

            visiting.remove(course)
            visited.add(course)
            return True

        for c in range(numCourses):

            if not dfs(c):

                return False

        return True