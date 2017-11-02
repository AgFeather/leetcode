You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.

For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.

public int getImportance(List<Employee> employees, int id) {
        Employee tEmployee = findEmployee(employees, id);
        List<Employee> employeelist = new ArrayList<>();
        employeelist.add(tEmployee);
        int res = 0;
        while(!employeelist.isEmpty()) {
        	tEmployee = employeelist.get(0);
        	employeelist.remove(0);
        	res+=tEmployee.importance;
        	List<Integer> templist = tEmployee.subordinates;
        	for (Integer integer : templist) {
				employeelist.add(findEmployee(employees, integer));
			}
        }
        return res;
    }
    
    public Employee findEmployee(List<Employee> employees,int id) {
		for (Employee employee : employees) {
			if (employee.id == id) {
				return employee;
			}
		}
		return null;
	}
