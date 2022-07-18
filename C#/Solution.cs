public class Solution {
    public IList<IList<int>> ThreeSum(int[] nums) {
        IList<IList<int>> list = new List<IList<int>>();
        List<int> newList;
        bool isEqual = false;
        for(int i = 0; i < nums.Length -1; i++){
             for(int j = i + 1; j < nums.Length; j++){
                for(int k = j; k <nums.Length; k++){
                    if(i != j && k!= i && j!=k )
                        if(nums[i] + nums[j] + nums[k] == 0){
                            newList = new List<int> {nums[i], nums[j], nums[k]};
                            foreach (List<int> subList in list){
                                if(Enumerable.SequenceEqual(subList.OrderBy(e => e), newList.OrderBy(e => e))){
                                    isEqual = true;
                                    break;
                                }
                                }
                            
                            if(!isEqual)
                                list.Add(newList);
                            isEqual = false;
                        }
                }
             }
        }
        return list;
    }


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