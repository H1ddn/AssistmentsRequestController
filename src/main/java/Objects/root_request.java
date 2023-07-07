package Objects;

import java.time.LocalDate;

public class root_request {

    private final Long uid;
    private final LocalDate date_created;

    public root_request(final Long uid, final LocalDate date_created) {
        this.uid = uid;
        this.date_created = date_created;
    }

    public Long getUid() {
        return uid;
    }

    public LocalDate getDate_created() {
        return date_created;
    }

}
