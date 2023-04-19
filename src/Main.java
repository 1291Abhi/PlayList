public class Main {
    public static void main(String[] args) {
        Album  album1=new Album("Aap ka Surroor","Himesh Reshammiya");
        album1.addSong(new Song("Naam hai tera","Himesh Reshammiya",4));
        album1.addSong(new Song("Tera Surroor","Himesh Reshammiya",5));
        album1.addSong(new Song("Samjho Na","Himesh Reshammiya",6));
        album1.addSong(new Song("Tu Yaad Na Aaye","Himesh Reshammiya",3));

        Album album2=new Album("Purpose","Justin Bieber");
        album2.addSong(new Song("Mark my word", "Justin Bieber",2));
        album2.addSong(new Song("Sorry", "Justin Bieber",3));
        album2.addSong(new Song("I'll show you", "Justin Bieber",3));

        PlayList myPlayList=new PlayList("myPlayList");
        myPlayList.addSongFromAlbum(album2,3);//i'll show you
        myPlayList.addSongFromAlbum(album2,1);//mark my word
        myPlayList.addSongFromAlbum(album1,3);//samjho na
        myPlayList.addSongFromAlbum(album1,2);//tera surror
        myPlayList.addSongFromAlbum(album1,"Naam hai tera");
        myPlayList.addSongFromAlbum(album2,"I'll show you");
        myPlayList.addSongFromAlbum(album2,3);


        System.out.println(myPlayList.playCurrentSong());
        System.out.println(myPlayList.playNextSong());
        System.out.println(myPlayList.playNextSong());
        System.out.println(myPlayList.playNextSong());
        System.out.println(myPlayList.playNextSong());
        System.out.println(myPlayList.playNextSong());
        System.out.println(myPlayList.playPreviousSong());
        System.out.println(myPlayList.playPreviousSong());
        System.out.println(myPlayList.playNextSong());

    }
}