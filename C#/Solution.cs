public class Solution {
    public IList<IList<int>> ThreeSum(int[] nums) {
        Dictionary<int[],int> map = new Dictionary<int[],int>();
        for(int i = 0; i < nums.Length -1; i++){
             for(int j = i + 1; j < nums.Length; j++){
                map.Add(new int [] {i,j},nums[i] + nums[j]);
             }
        }
        IList<IList<int>> list = new List<IList<int>>();
        int[] k;
        
        foreach(int[] duos in map.Keys){
            //TODO Grab values not indexes
            k = nums.Select((b,i) => b + nums[duos[0]] + nums[duos[1]] == 0 ? i : -1).Where(i => i != -1 ).ToArray();
            foreach (int i in k){
                if(i != duos[0] && i != duos[1]){
                    list.Add(new List<int> {nums[duos[0]],nums[duos[1]],nums[i]} );
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