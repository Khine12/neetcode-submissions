class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        fleets = 0
        max_time = 0.0
        pairs = sorted(zip(position,speed),reverse=True)

        for (pos,spd) in pairs:
            time = (target-pos)/spd
            if time > max_time:
                fleets += 1
                max_time = time
        return fleets