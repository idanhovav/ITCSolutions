import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class Question2 {
	public class Song {
		private String title;

		public Song(String title) {
			this.title = title;
		}

		public String getTitle() {
			return this.title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

	}

	public static String[] createRandomPlaylist(Set<String> songs) {
		int numSongs = songs.size();
		Random gen = new Random();
		int index = gen.nextInt(numSongs);
		String[] songList = new String[numSongs];

		for (String song : songs) {
			while (songList[index] != null) {
				index = gen.nextInt(numSongs);
			}
			songList[index] = song;
		}
		return songList;
	}

	public static void main(String[] args) {
		System.out.println("The function asked for is within this program.");
		HashSet<String> songs = new HashSet<String>(Arrays.asList("a", "b", "c", "d", "e", "f", "g"));
		String[] order = createRandomPlaylist(songs);
		for (String song : order) {
			System.out.println(song);
		}
	}
 }