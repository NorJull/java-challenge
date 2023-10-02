package challenge.sorting;

public class PlayComparator {

    public int compare(Player a, Player b) {
        int result = 0;
        if(a.score < b.score ) {
            result = 1;
        } else if (a.score > b.score) {
            result = -1;
        } else {
            result = a.name.compareTo(b.name);
        }

        return result;
    }
    //Sort first descending by score, then ascending by name.
}

    class Player {
        String name;
        int score;

        Player(String name, int score) {
        this.name = name;
        this.score = score;
        }
        }
