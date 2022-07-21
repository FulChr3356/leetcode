public class Solution {

    public ListNode RemoveNthFromEnd(ListNode head, int n) {
        Dictionary<int,ListNode> nodes = new Dictionary<int,ListNode>();
        ListNode currHead = head;
        ListNode currNode;
        int i = 1;
        int nullInt;
        while(head != null){
          nodes.Add(i,head);
          head = head.next;  
          i++;  
        }
        
        currNode = nodes[i - n];
        if(currNode.next == null){
            if(i - n == 1)
                return null;
            else
                nodes[i - n - 1].next = nodes[i - n].next;
        }
        else{
            if(i - n == 1){
                currHead = nodes[i - n + 1];
            }
            else{
                nodes[i - n - 1].next = nodes[i - n + 1];
            }
        }
            return currHead;
    }
    public int Search(int[] nums, int target) {
        return Array.IndexOf(nums,target);
    }
    public int[] PlusOne(int[] digits) {
        int i = digits.Length - 1;
        while(i >= 0){
            if(digits[i] < 9){
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
            if(i == 0){
            int [] newArray = new int[digits.Length + 1];
            newArray[0] = 1;
            return newArray;
            }
            i--;
                
        }
            
        return digits;
        
    }
public int LengthOfLastWord(string s) {
        String [] strings = s.Split(' ', StringSplitOptions.RemoveEmptyEntries);
        return strings[strings.Length -1].Length;
    }

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