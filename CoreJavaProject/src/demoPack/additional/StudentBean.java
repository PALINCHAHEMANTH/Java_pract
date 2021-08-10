package demoPack.additional;

public class StudentBean 
{
	int studId;
	String studName;
	float marks;

	public StudentBean() {
		super();
	}
	
	public StudentBean(int studId, String studName, float marks) {
		this.studId = studId;
		this.studName = studName;
		this.marks = marks;
	}
}