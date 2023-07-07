package Objects;

import java.time.LocalDate;

public class request {

    private Long Uid;
    private Long root_request_id;
    private Long request_type_id;
    private LocalDate date_created;

    public Long getUid() {
        return Uid;
    }

    public void setUid(final Long uid) {
        Uid = uid;
    }

    public Long getRoot_request_id() {
        return root_request_id;
    }

    public void setRoot_request_id(final Long root_request_id) {
        this.root_request_id = root_request_id;
    }

    public Long getRequest_type_id() {
        return request_type_id;
    }

    public void setRequest_type_id(final Long request_type_id) {
        this.request_type_id = request_type_id;
    }

    public LocalDate getDate_created() {
        return date_created;
    }

    public void setDate_created(final LocalDate date_created) {
        this.date_created = date_created;
    }
}
