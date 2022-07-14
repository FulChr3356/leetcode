public class Solution {

    public int StrStr(string haystack, string needle) {
        return haystack.IndexOf(needle);
    }

    
    public int RemoveElement(int[] nums, int val) {
        int size = nums.Length;
        bool replace = false;
        Queue queue = new Queue();
        for(int i = 0; i < nums.Length; i++){
            if(nums[i] == val){
                queue.Enqueue(i);
                replace = true;
                size--;
                continue;
            }
            if(replace == true){
                nums[(int)queue.Dequeue()] = nums[i];
                queue.Enqueue(i);
            }
        }
        return size;
    }
}