class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        store = {c:[] for c in range(numCourses)}
        for current,pre in prerequisites:
            store[current].append(pre)

        visited = set()
        visiting = set()

        def dfs(course):
            if course in visited:
                return True
            if course in visiting:
                return False
            visiting.add(course)
            for pre in store[course]:
                if not dfs(pre):
                    return False
            visiting.remove(course)
            visited.add(course)
            return True
        for n in range(numCourses):
            if not dfs(n):
                return False
        return True