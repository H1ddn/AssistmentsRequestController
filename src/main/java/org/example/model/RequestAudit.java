package org.example.model;

import java.time.LocalDate;

public class RequestAudit {
    private Long requestId;
    private LocalDate date_started;
    private LocalDate date_ended;

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(final Long requestId) {
        this.requestId = requestId;
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
