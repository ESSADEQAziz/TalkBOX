import java.sql.Time;

public class tstatus {
    private int status_id;
    private String status;
    private int status_userid;
    private Time last_connection;

    public Time getLast_connection() {
        return last_connection;
    }

    public void setLast_connection(Time last_connection) {
        this.last_connection = last_connection;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatus_userid() {
        return status_userid;
    }

    public void setStatus_userid(int status_userid) {
        this.status_userid = status_userid;
    }
}
