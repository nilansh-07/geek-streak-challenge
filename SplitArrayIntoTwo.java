public class SplitArrayIntoTwo {
    public static boolean canSplit(int arr[]) {
        int arrSum=0, subArrSum=0;
        
        for(int i=0;i<arr.length;i++){
            arrSum+=arr[i];
        }
        for(int i=0;i<arr.length;i++){
            subArrSum+=arr[i];
            if(subArrSum*2==arrSum){
                return true;
            }
        }
        return false;
    }
}
