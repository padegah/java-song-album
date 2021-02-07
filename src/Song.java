public class Song 
{
	//Class variable declaration
	private String title;
	private double duration;
	
	//constructor to intialize the class variables
	public Song(String title, double duration) 
	{
		this.title = title;
		this.duration = duration;
	}

	//getter method for class variable title
	public String getTitle() {
		return this.title;
	}

	//overriding the to_String method so we can return an instance of the song, else it will return the memory location on the instance
	@Override
	public String toString() {
		return this.title + ": " + this.duration;
	}
	
}
