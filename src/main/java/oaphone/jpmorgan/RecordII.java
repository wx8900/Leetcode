package oaphone.jpmorgan;

import java.sql.Timestamp;

/**
 * @Description
 * @Author Jeff
 * @Date 2019/3/28 20:54
 * @Version V1.0
 */
public class RecordII {
    private int serverName;
    private boolean result;
    private Timestamp timestamp;

    public RecordII(int serverName, boolean result, Timestamp timestamp) {
        this.serverName = serverName;
        this.result = result;
        this.timestamp = timestamp;
    }

    public int getServerName() {
        return serverName;
    }

    public void setServerName(int serverName) {
        this.serverName = serverName;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "RecordII{" +
                "serverName=" + serverName +
                ", result=" + result +
                ", timestamp=" + timestamp +
                '}';
    }
}
