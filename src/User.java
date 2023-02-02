public class User {
    int rank;
    int progress;
    int activity;

    public User(){
        rank = -8;
        progress = 0;
    }

    public int getRank(){
        return rank;
    }
    public int getProgress(){
        return progress;
    }
    public void incProgress(int prog){
        if (prog == 0 || prog > 8 || prog < -8)
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");

        if (prog < rank) progress++;
        else if(prog == rank) progress += 3;
        else{
            if (prog > 0 && rank < 0) progress += 10*(prog-rank-1)*(prog-rank-1);
            else progress += 10*(prog-rank)*(prog-rank);
        }

        while (progress >= 100){
            if(rank == -1) rank = 1;
            else rank++;
            progress -=100;
        }

    }
    public String toString(){
        return "User{" + "rank=" + rank + ", progress=" + progress + "}";
    }
}
