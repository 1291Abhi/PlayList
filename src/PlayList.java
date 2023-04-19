import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class PlayList {
    private String title;
    private List<Song> songs;
    private ListIterator<Song> itr;
    private boolean isNext;

    public PlayList(String title) {
        this.title = title;
        this.songs=new ArrayList<>();
        this.itr= songs.listIterator();
    }
    public Optional<Song> findSong(String songTitle) {
        for(Song song:songs){
            if(songTitle.equals(song.getTitle()))
                return Optional.of(song);
        }
        return Optional.empty();
    }

    public Optional<Song> findSong(int trackNo) {
        if(trackNo>0 && trackNo<=songs.size()){
                return Optional.of(songs.get(trackNo-1));
        }
        return Optional.empty();
    }

    public String addSongFromAlbum(Album album,String songTitle){
        Optional<Song> optionalSongInAlbum=album.findSong(songTitle);
        Optional<Song> optionalSongInPlayList=findSong(songTitle);
        if(optionalSongInAlbum.isEmpty()) {
            return "Song not found in Album";
        }
        if(optionalSongInPlayList.isPresent()) {
            return "Song already present in the playlist";
        }
        songs.add(optionalSongInAlbum.get());
        itr= songs.listIterator();
        return "Song added successfully";

    }
    public String addSongFromAlbum(Album album,int trackNo){
        Optional<Song> optionalSongInAlbum=album.findSong(trackNo);
        if(optionalSongInAlbum.isEmpty()) {
            return "Song not found in Album";
        }
       Optional<Song> optionalSongInPlayList=findSong(optionalSongInAlbum.get().getTitle());

        if(optionalSongInPlayList.isPresent()) {
            return "Song already present in the playlist";
        }
        songs.add(optionalSongInAlbum.get());
        itr= songs.listIterator();
        return "Song added successfully";

    }

    public String playNextSong(){
        if(!isNext){
            itr.next();
            isNext=true;
        }
        if(itr.hasNext()){
            isNext=true;
            return "Next song to play is:"+ itr.next();
        }
        return "You have reached to end of playlist.There is no song after this";

    }

    public String playPreviousSong(){
        if(isNext){
            isNext=false;
            itr.previous();
        }
        if(itr.hasPrevious()){
            isNext=false;
            return "Previous song to play is:"+ itr.previous();
        }
        return "You have reached to start of the playlist. There is no song before this";
    }

    public String playCurrentSong(){
        if(isNext){
            isNext=false;
            return "Current song is :"+ itr.previous();
        }
        isNext=true;
        return "Current song is:"+ itr.next();
    }
}
