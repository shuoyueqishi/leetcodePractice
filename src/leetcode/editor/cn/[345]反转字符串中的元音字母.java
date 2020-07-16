package leetcode.editor.cn;
//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
//
// 示例 1: 
//
// 输入: "hello"
//输出: "holle"
// 
//
// 示例 2: 
//
// 输入: "leetcode"
//输出: "leotcede" 
//
// 说明: 
//元音字母不包含字母"y"。 
// Related Topics 双指针 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Test1{
    public static void main(String [] args){
        String str="I love zhoulujie.";
        Solution solution=new Solution();
        String res=solution.reverseVowels(str);
        System.out.println(res);
    }
}
class Solution {
    public String reverseVowels(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            int cnt=0;
            if(checkVowels(s.charAt(i))){
                cnt++;
            }else{
                i++;
            }
            if(checkVowels(s.charAt(j))){
                cnt++;
            }else{
                j--;
            }
            if(cnt==2){
                s=swap(s,i,j);
                i++;
                j--;
            }
        }
        return s;
    }
    private boolean checkVowels(char c){
        String vowels="aeiouAEIOU";
        return vowels.contains(String.valueOf(c));
    }
    private String swap(String s,int l,int r) {
        char[] arr=s.toCharArray();
        char tmp=arr[l];
        arr[l]=arr[r];
        arr[r]=tmp;
        return new String(arr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
