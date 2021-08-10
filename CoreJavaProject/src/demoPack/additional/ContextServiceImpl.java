package demoPack.additional;

public class ContextServiceImpl implements ContextService
{
	private String classProperty;

	public String getClassProperty() {
		return classProperty;
	}
	public void setClassProperty(String classProperty) {
		this.classProperty = classProperty;
	}

	public void printClassProperty() {
		System.out.println("Class Property : "+classProperty);
	}
}