class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int low=matrix[0][0];
        int high=0;
        for(int []row :matrix){
            for(int num :row){
                high=Math.max(num,high);
            }
            
            while(low<=high){
                int mid=low+(high-low)/2;
                boolean res=checkmid(matrix,mid);
                if(res &&mid==target){
                    return true;
                }
                else if(mid<target){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return false;
        
    }
    public static boolean checkmid(int[][] matrix,int mid){
        
        for(int []row : matrix){
            for(int num : row){
                if(num==mid){
                   return true;
                }
            }
        }
        return false;
    }
    public static void main(String []args){
        int [][]matrix={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean res=searchMatrix(matrix,3);
        System.out.println(res);
    }
}
