package oaphone.jpmorgan;

import java.time.LocalDateTime;

/**
 * @Description
 * @Author Jeff
 * @Date 2019/3/28 02:18
 * @Version V1.0
 */
public class Record {
    private int serverName;
    private boolean result;
    private LocalDateTime timestamp;

    public Record() {
    }

    public Record(int serverName, boolean result, LocalDateTime timestamp) {
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

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Record{" +
                "serverName=" + serverName +
                ", result=" + result +
                ", timestamp=" + timestamp +
                '}';
    }
}
