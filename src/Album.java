import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    public String name;
    public String artist;
    private ArrayList<Song> songs = new ArrayList<>();

    public Album(String name , String artist){
        this.name = name;
        this.artist = artist;
    }
    public Album(){

    }
    public Song findSong(String title){
        for(Song checkingSong : songs){
            if(checkingSong.getTitle().equals(title)) return checkingSong;
        }
        return null;   
    }
    public boolean addSong(String title , double duration){
        if(findSong(title) == null){
            songs.add(new Song(title , duration));
            //System.out.println(""+title+"successful");
            return true;
        }
        //System.out.println(title+" Song already present");
        return false;
    }
    public boolean addToPlayList(String title , LinkedList<Song> PlayList){
        for(Song checkedSong : songs){
            if(checkedSong.getTitle().equals(title)){
                PlayList.add(checkedSong);
                return true;
            }
        }
        System.out.println(title+" there is no such song in the album");
        return false;
    }
    
}
