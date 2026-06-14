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

        old_to_new = {}

        def dbf(current):

            if current in old_to_new:

                return old_to_new[current]

            copy = Node(current.val)

            old_to_new[current] = copy

            for nei in current.neighbors:

                copy.neighbors.append(dbf(nei))
            return copy

        return dbf(node)