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
            if(song.getTitle().equals(song1.getTitle()) && song.getArtist().equals(song1.getArtist()))
                return true;
        }
        return false;
    }

    public Optional<Song> findSong(int trackNo) {
        if(trackNo>0 && trackNo<=songList.size()){
            return Optional.of(songList.get(trackNo-1));
        }
        return Optional.empty();
    }

    public Optional<Song> findSong(String titleToSearch, String artistToSearch){
        for(Song song:songList){
            if(titleToSearch.equals(song.getTitle()) && artistToSearch.equals(song.getArtist()))
                return Optional.of(song);
        }
        return Optional.empty();
    }
    public Optional<Song> findSong(String titleToSearch){
        for(Song song1:songList){
            if(titleToSearch.equals(song1.getTitle()))
                return Optional.of(song1);
        }
        return Optional.empty();

    }

    public String addSong(Song song){
        Optional<Song> optionalSong=findSong(song.getTitle());
        if(optionalSong.isPresent()){
            //don't add the song
            return "Song already exists";
        }
        songList.add(song);
        return "Song added Successfully";
    }
}
