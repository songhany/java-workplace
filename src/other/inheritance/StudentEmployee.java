package other.inheritance;

public class StudentEmployee extends Student {

    private double rateOfPayPerHour;
    private String employeeId;

    public StudentEmployee(String firstName, String lastName, String studentId, String employeeId, double rateOfPayPerHour) {
        super(firstName, lastName, studentId);
        this.rateOfPayPerHour = rateOfPayPerHour;
        this.employeeId = employeeId;
    }

    public double getRateOfPayPerHour() {
        return rateOfPayPerHour;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setRateOfPayPerHour(double rateOfPayPerHour) {
        this.rateOfPayPerHour = rateOfPayPerHour;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return super.toString() + " employee ID " + employeeId + " pay " + rateOfPayPerHour;
    }
}
