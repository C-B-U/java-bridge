package bridge;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final List<ResultStatus> resultStatusList;

    public Result() {
        this.resultStatusList = new ArrayList<>();
    }

    public void addResultStatus(final ResultStatus resultStatus) {
        this.resultStatusList.add(resultStatus);
    }
}
