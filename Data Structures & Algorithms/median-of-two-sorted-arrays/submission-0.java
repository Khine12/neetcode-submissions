class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] A = nums1;

        int[] B = nums2;

        if(A.length > B.length){

            A = nums2;

            B = nums1;
        }

        int m = A.length, n = B.length, total = m + n, half = total/2;

        int left = 0, right = m;

        while(left <= right){

            int mid = left + (right-left)/2;

            int rest = half-mid;

            int A_left = (mid==0) ? Integer.MIN_VALUE : A[mid-1];

            int A_right = (mid==m) ? Integer.MAX_VALUE : A[mid];

            int B_left = (rest==0) ? Integer.MIN_VALUE : B[rest-1];

            int B_right = (rest==n) ? Integer.MAX_VALUE : B[rest];

            if(A_left <= B_right && B_left <= A_right){

                if(total%2 == 1){

                    return Math.min(A_right,B_right);
                }
                else{

                    int a = Math.min(A_right,B_right);

                    int b = Math.max(A_left,B_left);

                    return (a+b)/2.0;
                }
            }
            else if(A_left > B_right){

                right = mid -1;
            }
            else{

                left = mid +1;
            }
        }
        return 0.0;
    }
}
