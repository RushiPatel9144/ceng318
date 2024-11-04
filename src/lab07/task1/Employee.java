package lab07.task1;
public class Employee {
    private int employeeID;
    private String name;
    private String position; // "Manager" or "Employee"
    private int managerID;

    public Employee(int employeeID, String name, String position, int managerID) {
        this.employeeID = employeeID;
        this.name = name;
        this.position = position;
        this.managerID = managerID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getManagerID() {
        return managerID;
    }
}
