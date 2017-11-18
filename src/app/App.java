package app;
import stack.Stack;
import stack.StackEmptyException;
import stack.StackFullException;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Stack <String> names = new Stack <String> (String.class,5);
		Stack<String> names = new Stack<String>();
		
		try{
			names.push("Kike");
			names.push("Gustavo");
			names.push("Ana");
			names.push("Andrik");
			names.push("Ricardo 2");
			System.out.println(names.pop());
			names.push("KoroSensei");
			names.Search("Andrik");
			System.out.println("Imprimiendo la pila...");
			for (String string : names) {
				System.out.println(string);
				
				
			}
		}
			catch(StackFullException | StackEmptyException f){
				f.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			//e.printStackTrace();
		}
	}
}
