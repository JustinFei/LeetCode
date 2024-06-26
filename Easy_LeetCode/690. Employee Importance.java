/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
         Map<Integer, Employee> emap = new HashMap();
        for (Employee e: employees) emap.put(e.id, e);
        return dfs(id, emap);
    }
    public int dfs(int eid, Map<Integer, Employee> emap) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates)
            ans += dfs(subid, emap);
        return ans;
    }
}