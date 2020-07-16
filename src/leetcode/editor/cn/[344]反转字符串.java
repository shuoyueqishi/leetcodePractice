package leetcode.editor.cn;//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
//
// 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。 
//
// 
//
// 示例 1： 
//
// 输入：["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 
//
// 示例 2： 
//
// 输入：["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
// Related Topics 双指针 字符串


//leetcode submit region begin(Prohibit modification and deletion)

class Test{
    public static void main(String[] args) {
        Solution1 solution=new Solution1();
        char[] str=new char[]{'a','b','c','d','e','f','g'};
        System.out.println(str);
        solution.reverseString(str);
        System.out.println(str);
    }
}
class Solution1 {
    public void reverseString(char[] s) {
        int p1=0;
        int p2=s.length-1;
        for(;p1<p2;p1++,p2--){
            swap(s,p1,p2);
        }
    }
    public void swap(char[] str, int i,int j){
        char tmp=str[i];
        str[i]=str[j];
        str[j]=tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
