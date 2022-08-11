package Tenis;

public class Player {

    private final String name ;
    private final Integer probabilityOfWining ;
    private Integer points ;
    private Integer tieBreakPoints ;
    private Integer sets ;

    public Player(String name, Integer probabilityOfWining) {
        this.name = name;
        this.probabilityOfWining = probabilityOfWining;
        this.points = 0 ;
        this.sets = 0 ;
        this.tieBreakPoints = 0 ;
    }

    public String getName() {
        return name;
    }

    public Integer getProbabilityOfWining() {
        return probabilityOfWining;
    }

    public Integer getTieBreakPoints() {
        return tieBreakPoints;
    }

    public void setTieBreakPoints(Integer tieBreakPoints) {
        this.tieBreakPoints = tieBreakPoints;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public void resetPoints(){
        points = 0 ;
        tieBreakPoints = 0 ;
    }

}
