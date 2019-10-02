
public class ExceptionHandling{

	
	public static void main(String[] args) {
		
		//todo:
		//1.) Execute the following program. It will throw Exceptions.
		//Catch the Exceptions using their proper Names till no further
		//exceptions occur.
		//
		//2.) Taking the square root of a negative number won't cause
		//the exception. Write your own Exception for this case and 
		//write a method which throws this exception

		int a = 5;
		int b = 0;
		try{
			int div = a/b;
		}catch(ArithmeticException e){
			e.printStackTrace();
		}
		
		int[] arr = new int[5];
		try{
			arr[5] = 7;
		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}
		
		String one = "one";
		try{
			int i = Integer.parseInt(one);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		
		try{
			
			double d = negativeNumber(-25);
		}catch(NegativeSquareRootException e){
			e.printStackTrace();
		}
		
	}

	public static double negativeNumber(double x) throws NegativeSquareRootException{
		if(x<0){
			throw new NegativeSquareRootException("NaN");
		}
		else{
			return Math.sqrt(x);
		}
	}

}
