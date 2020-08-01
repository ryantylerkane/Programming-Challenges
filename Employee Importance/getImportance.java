/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        HashMap<Integer, Employee> lookupSub = new HashMap<>();
        
       for(Employee emp: employees)
       {
            lookupSub.put(emp.id, emp);
       }
        
        
        return getTotal(lookupSub, id);
        
    }
    
    private int getTotal(HashMap<Integer, Employee> lookupSub, int id)
    {
        Employee current = lookupSub.get(id);
        int total = 0;
        total+=current.importance;
        
        for(Integer i: current.subordinates)
        {
            total+=getTotal(lookupSub, i);
        }
        
        return total;
    }
}