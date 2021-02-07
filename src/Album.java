import java.util.ArrayList;
import java.util.LinkedList;

public class Album 
{

	//class variable declarations
	private String name;
	private String artist;
	private ArrayList<Song> songs;
	
	//constructor to initialize the member variables
	public Album(String name, String artist) 
	{
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}
	
	//add song method adds the song title and duration to the songs array list
	public boolean addSong(String songTitle, double songDuration)
	{
		//check if there is a song with the same title, if yes don't add song, return false.
		if(findSong(songTitle) == null)
		{
			//if song title does not exist, add song to and return true
			this.songs.add(new Song(songTitle, songDuration));
			return true;
		}
		
		return false;
	}
	
	//actual checking to see if song exists based on the song title provided
	private Song findSong(String songTitle)
	{
		//loop through songs arrayList and compare the title with the song title provided
		for (int i=0; i<this.songs.size(); i++) 
		{
			//if found, return the song at that position (i), else return null
			if(this.songs.get(i).getTitle().equalsIgnoreCase(songTitle))
				return this.songs.get(i);
		}
		
		return null;
	}
	
	//add song to play list based on the track number provided
	public boolean addToPlayList(int trackNumber, LinkedList<Song> playList)
	{
		//since track number starts from 1 and Array List starts from index 0, we need to adjust the track number provided to take care of that
		int index = trackNumber - 1;
		
		//if track number provided is within the songs Array List index, it means song exists in the album
		if((index >= 0) && (index <= this.songs.size()))
		{
			//we add song at position index to the play list
			playList.add(this.songs.get(index));
			return true;
		}
		
		//if track number is not within the songs array list index, it means song does not exist in the album, we return false
		return false;
	}
	
	
	//add to play list based on song title
	public boolean addToPlayList(String songTitle, LinkedList<Song> playList)
	{
		//get the song based on the title using the findSong() method
		Song foundSong = findSong(songTitle);
		
		//if return value is not null, it means song exists, so we add to play list and return true, else we return false
		if(foundSong != null)
		{
			playList.add(foundSong);
			return true;
		}
		
		return false;
	}
}
