package demoPack.appContext;

public class HelloWorld 
{
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public void init() {
		System.out.println("Inside the Bean's init method....");
	}
	public void destroy() {
		System.out.println("Inside the Bean's destroy method....");
	}
}