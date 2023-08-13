package bridge;

import java.util.Collections;
import java.util.List;

public final class Bridge {
    private final List<String> directions;

    private Bridge(final List<String> directions) {
        this.directions = Collections.unmodifiableList(directions);
    }

    public static Bridge create(final List<String> directions) {
        return new Bridge(directions);
    }
}
