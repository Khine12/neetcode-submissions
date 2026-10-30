class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        result = []
        store = {c:[] for c in range(numCourses)}
        for cur,prev in prerequisites:
            store[cur].append(prev)
        visited = set()
        visiting = set()
        def dfs(course):
            if course in visited:
                return True
            if course in visiting:
                return False
            visiting.add(course)
            for prev in store[course]:
                if not dfs(prev):
                    return False
            visiting.remove(course)
            visited.add(course)
            result.append(course)
            return True
        for i in range(numCourses):
            if not dfs(i):
                return []
        return result