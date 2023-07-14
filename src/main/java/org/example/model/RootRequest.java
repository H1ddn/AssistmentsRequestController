package org.example.model;

import java.time.LocalDate;

public class RootRequest {

    private final Long uid;
    private final LocalDate date_created;

    public RootRequest(final Long uid, final LocalDate date_created) {
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
