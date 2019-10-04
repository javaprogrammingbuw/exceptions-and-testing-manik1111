public class Person{
	private String owner;

	public Person(String owner){
		this.owner= owner;
	}
	public String getName(){
		return owner;
	}
	public void setName(String owner){
		this.owner=owner;
	}
}