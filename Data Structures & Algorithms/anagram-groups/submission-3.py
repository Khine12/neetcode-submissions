class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        collections = {}
        for s in strs:
            l = ''.join(sorted(s))
            if l not in collections.keys():
                collections[l] = [s]
            else:
                collections[l].append(s)

        return list(collections.values())