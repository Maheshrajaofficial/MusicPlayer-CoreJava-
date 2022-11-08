import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class App {
    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        Album album = new Album("Album1","PradheepKumar");
        album.addSong("Thozhli", 4);
        album.addSong("NeeKavithaigale" , 5);
        album.addSong("lifeOfRam" , 6);
        album.addSong("AagayamTheePidicha" , 7);
        album.addSong("KadhalManamae" , 8);

        albums.add(album);

        album = new Album("Album2" , "Yuvan");
        album.addSong("kaatrai pola" , 5);
        album.addSong("ey pulla pulla" , 6);
        album.addSong("ennai vitu pogathe" ,7);
        
        albums.add(album);

        LinkedList<Song> playList1 = new LinkedList<>();
        albums.get(0).addToPlayList("Thozhli", playList1);
        albums.get(0).addToPlayList("lifeOfRam", playList1);
        albums.get(1).addToPlayList("kaatrai pola", playList1);
        albums.get(1).addToPlayList("ennai vitu pogathe", playList1);

        play(playList1);
    }
     private static void play(LinkedList<Song> playList){
        printMenu();
        try (Scanner sc = new Scanner(System.in)) {
            boolean quit = false;
            boolean forward = true;

            ListIterator<Song> itr = playList.listIterator();
            if(playList.size() == 0){
                System.out.println("This playList has no Song");
            }
            else{
                System.out.println();
                System.out.println("Now playing "+itr.next().toString());
                //printMenu();
            }
            while(!quit){
                int action = sc.nextInt();
                sc.nextLine();

                switch(action){
                    case 0:
                        System.out.println("Playlist completed!");
                        quit = true;
                        break;
                    case 1:
                        if(!forward){
                            if(itr.hasNext()){
                                itr.next();
                            }
                            forward = true;
                        }
                        if(itr.hasNext()){
                            System.out.println("now playing:" + itr.next().toString());
                        }
                        else{
                            System.out.println("At the end of the list");
                            forward = false; 
                        }
                        break;
                    case 2:
                    if(forward){
                        if(itr.hasPrevious()){
                            itr.previous();
                        }
                        forward = false;    
                    }
                    if(itr.hasPrevious()){
                        System.err.println("now playing "+itr.previous().toString());
                    }
                    else{
                        System.out.println("we are at the first song");
                        forward = false;
                    }
                    break;
                    case 3:
                    if(forward){
                        if(itr.hasPrevious()){
                            System.out.println("now playing:"+itr.previous().toString());
                            forward = false;
                        }
                        else{
                            System.out.println("we are at the start of the song");

                        }
                    }
                    else{
                        if(itr.hasNext()){
                            System.out.println("now playing "+itr.next().toString());
                            forward = true;
                        }
                        else{
                            System.out.println("we have reached to the end of the list");
                        }
                    }
                    break;

                    case 4:
                    printList(playList);;
                    break;
                    case 5:
                    printMenu();;
                    break;
                    case 6:
                    if(playList.size() > 0){
                        itr.remove();
                        if(itr.hasNext()){
                            System.out.println("now playing :"+itr.next().toString());
                            forward = true;
                        }
                        else{
                            if(itr.hasPrevious()){
                                System.out.println("now playing:"+itr.previous());
                            }
                        }
                    }
                    else{
                        System.out.println("the playList is empty");
                    }
                    break;
                }
            }
        }
    }
    private static void printMenu(){
        System.out.print("0-to quit\n"+"1-to play next song\n"
        +"2-to play previous song"+"3-to replay current song\n"+"4- to list all songs\n"
        +"5-print all available options\n"+"6-delete current song");
    }
    static void printList(LinkedList<Song>playList){
        Iterator<Song> itr = playList.iterator();
        System.out.println("--------------------------");
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println("----------------------------------");
    }
}
