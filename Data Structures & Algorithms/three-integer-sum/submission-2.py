class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        num = sorted(nums)
        c = set()
        for k in range(len(num)-2):
            if k > 0 and num[k] == num[k-1]:
                continue
            i = k+1
            j = len(num)-1
            while i < j:
                n = num[i]+ num[k] + num[j]
                if n == 0:
                    c.add((num[k],num[i],num[j]))
                    i += 1
                    j -= 1
                elif n > 0:
                    j -= 1
                else:
                    i += 1
        return [list(t) for t in c]