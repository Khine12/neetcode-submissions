class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:

        adj = {c:[] for c in range(numCourses)}

        for a,b in prerequisites:
            adj[a].append(b)
        
        visited = set()
        visiting = set()
        result = []

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
            result.append(course)
            return True

        for c in range(numCourses):
            if not dfs(c):
                return []
        return result