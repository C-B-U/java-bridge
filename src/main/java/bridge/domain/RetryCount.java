package bridge.domain;

import bridge.constant.RetryCommand;

public class RetryCount {

    private int tryCount = 1;

    public void increaseTryCount(RetryCommand command) {
        if (command.isRetry()){
            tryCount++;
        }
    }

    public int getRetryCount() {
        return tryCount;
    }
}
