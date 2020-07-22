/**
 *
 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。

 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。

 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。

 示例 1:

 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 输出: 11
 解释:
 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
 注意:

 一个员工最多有一个直系领导，但是可以有多个直系下属
 员工数量不超过2000。
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
    public Employee(int _id,int _importance,List<Integer> _sub){
        id=_id;
        importance=_importance;
        subordinates=_sub;
    }
    public Employee(){
    }
}
public class ImportanceOfEmployee {
    public static void main(String[] args) {
        List<Integer> sub1 = new ArrayList<>();
        sub1.add(2);
        sub1.add(3);
        Employee employee1=new Employee(1, 5, sub1);

        List<Integer> sub2 = new ArrayList<>();
        Employee employee2=new Employee(2, 3, sub2);

        List<Integer> sub3 = new ArrayList<>();
        Employee employee3=new Employee(3, 3, sub3);
         List<Employee> employees= new ArrayList<>();
         employees.add(employee1);
         employees.add(employee2);
         employees.add(employee3);
         int importance =getImportance(employees,1);
    }

    public static int getImportance(List<Employee> employees, int id) {
        Employee targetEmployee = findTargetEmployee(employees,id);
        int importance = 0;
        Queue<Employee> queue = new ArrayDeque<>();
        queue.add(targetEmployee);
        while (!queue.isEmpty()) {
            Employee pollEmployee = queue.poll();
            importance += pollEmployee.importance;
            List<Integer> subordinates=pollEmployee.subordinates;
            for (int i=0;i<subordinates.size();i++) {
                Employee sub = findTargetEmployee(employees,subordinates.get(i));
                queue.add(sub);
            }
        }
        return importance;
    }
     private static Employee findTargetEmployee(List<Employee> employees, int id) {
         Employee targetEmployee = new Employee();
         for (Employee employee : employees) {
             if(employee.id == id) {
                 targetEmployee = employee;
                 break;
             }
         }
         return targetEmployee;
     }
}
