"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        
        if not node:
            return None

        map = {}

        def helper(node: 'Node')-> 'Node':

            if node in map:
                return map[node]

            copy = Node(node.val)

            map[node] = copy

            for curr in node.neighbors:
                copy.neighbors.append(helper(curr))

            return copy
        return helper(node)
