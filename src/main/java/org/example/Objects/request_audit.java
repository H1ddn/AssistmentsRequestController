package org.example.Objects;

import java.time.LocalDate;

public class request_audit {
    private Long Uid;
    private LocalDate date_started;
    private LocalDate date_ended;

    public Long getUid() {
        return Uid;
    }

    public void setUid(final Long uid) {
        Uid = uid;
    }

    public LocalDate getDate_started() {
        return date_started;
    }

    public void setDate_started(final LocalDate date_started) {
        this.date_started = date_started;
    }

    public LocalDate getDate_ended() {
        return date_ended;
    }

    public void setDate_ended(final LocalDate date_ended) {
        this.date_ended = date_ended;
    }

}
