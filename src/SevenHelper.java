

public class SevenHelper {

    private char first;

    private char second;

    private int rank = 0;

    public  SevenHelper(String s) {

        this.first = s.charAt(5);

        this.second = s.charAt(36);

    }

    public String getFirst() {
        return "" + this.first;
    }

    public String getSecond() {
        return "" + this.second;
    }

    public void increaseRank() {
        this.rank++;
    }

    public int getRank() {
        return this.rank;
    }

    public String toString() {
        return "Do " + first + " before " + second + ". Rank: " + rank;
    }
}
