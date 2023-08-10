package bridge.model;

public class LocationConverter {

    private static final int LOWER_CASE = 0;

    public static String convert(int position) {
        if (position == LOWER_CASE) {
            return Constant.LOWER_CHAR.toString();
        }
        return Constant.UPPER_CHAR.toString();
    }
}
