import java.util.ArrayList;
import java.util.*;

public class Album {
    private String title;
    private String artist;
    private List<Song> songList;

    public Album(String title, String artist, List<Song> songList) {
        this.title = title;
        this.artist = artist;
        this.songList = songList;
    }

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.songList=new ArrayList<>();
    }

    public boolean findSong(Song song){
        for(Song song1:songList){
            if(song.getTitle().equals(song1.getTitle()) && song.getArtist().equals(song1.getArtist())
                return true;
        }
        return false;
    }

    public String addSong(Song song){
        if(findSong(song)){
            //don't add the song
            return "Song already exists";
        }
        songList.add(song);
        return "Song added Successfully"
    }
}
