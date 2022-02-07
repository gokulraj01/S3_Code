/** @author Gokul Raj | 235 | R3A | CSE
 * 
 * AIM
 * A program to implement a custom exception
 * 
 * QUESTION
 * Implement a Java program to implement any User Defined Exception
*/
class EmptyStringException extends Exception{
    private String err = "An error occoured";
    EmptyStringException () {}
    EmptyStringException (String errmsg){
        err = errmsg;
    }
    public String toString(){
        return ("EmptyStringException: "+err);
    }
}

class ExcpHandling{
    public static void main(String[] args) {
        String s = "";
        try {
            if(s.equals(""))
                throw new EmptyStringException("Got an empty string");
        } catch (EmptyStringException e) {
            System.out.println(e);
        }
    }
}