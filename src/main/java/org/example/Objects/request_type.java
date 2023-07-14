package org.example.Objects;

import java.time.LocalDate;
public class request_type {

    private Long Uid;
    private String name;
    private String description;

    private LocalDate date_created;

    public request_type(final Long uid, final String name) {
        Uid = uid;
        this.name = name;
        this.date_created = LocalDate.now();
    }

    public Long getUid() {
        return Uid;
    }

    public void setUid(final Long uid) {
        Uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public LocalDate getDate_created() {
        return date_created;
    }

    public void setDate_created(final LocalDate date_created) {
        this.date_created = date_created;
    }
}
