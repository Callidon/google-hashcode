package fr.patounes.hashcode.cars.data;

public class Street {
    public int id;
    public int startIntersectionID;
    public int endIntersectionID;
    public String streetName;
    public int duration;

    public Street(int id, int startIntersectionID, int endIntersectionID, String streetName, int duration) {
        this.id = id;
        this.startIntersectionID = startIntersectionID;
        this.endIntersectionID = endIntersectionID;
        this.streetName = streetName;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Street{" +
                "id=" + id +
                ", startIntersectionID=" + startIntersectionID +
                ", endIntersectionID=" + endIntersectionID +
                ", streetName='" + streetName + '\'' +
                ", duration=" + duration +
                '}';
    }
}
