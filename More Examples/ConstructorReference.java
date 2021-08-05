@FunctionalInterface
interface Messageable {  
    Message getMessage(String msg);				// method returning object of class (Message)
}

class Message {									// Class NOT implementing interface
    Message(String msg){  
        System.out.print("\nHello, "+msg);  
    }
}

public class ConstructorReference
{
    public static void main(String[] args)
	{
        Messageable hello = Message::new;		// Able to create and assign Object of a class to interface
        hello.getMessage("Mrudula\n");
    }
}