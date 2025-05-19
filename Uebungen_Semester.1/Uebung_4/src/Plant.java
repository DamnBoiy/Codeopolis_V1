public class Plant {

    double height;
    String type;
    int waterLevel;

    public void grow(int sunlightHours)
    {
        height = 0.5 * sunlightHours;
    }

}
