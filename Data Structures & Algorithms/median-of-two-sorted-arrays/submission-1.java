class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] A = nums1;

        int[] B = nums2;

        if(A.length > B.length){

            A = nums2;

            B = nums1;
        }

        int m = A.length;

        int n = B.length;

        int total = m + n, half = total/2;

        int left = 0, right = m;

        while(left <= right){

            int A_cut = left + (right-left)/2;

            int B_cut = half - A_cut;

            int A_left = (A_cut == 0) ? Integer.MIN_VALUE : A[A_cut-1];

            int A_right = (A_cut == m) ? Integer.MAX_VALUE : A[A_cut];

            int B_left = (B_cut == 0) ? Integer.MIN_VALUE : B[B_cut-1];

            int B_right = (B_cut == n) ? Integer.MAX_VALUE : B[B_cut];

            if(A_left <= B_right && B_left <= A_right){

                if(total%2 == 1){

                    return Math.min(A_right,B_right);
                }
                else{

                    return (Math.min(A_right,B_right) + Math.max(A_left,B_left))/2.0;
                }
            }
            else if(A_left > B_right){

                right = A_cut - 1;
                
            }
            else{

                left = A_cut + 1;
            }
        }
        return 0.0;
    }
}
