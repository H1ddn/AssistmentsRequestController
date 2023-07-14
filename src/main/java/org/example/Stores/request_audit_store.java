package org.example.Stores;

import java.time.LocalDate;

import org.example.Objects.request_audit;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope("singleton")
public class request_audit_store {
    private final List<request_audit> requestAudits = new ArrayList();

    /**
     * Adds a new request audit to the list of request audits
     *
     * @return Uid of newly added request audit
     */
    public Long add_request_audit(request_audit requestAudit){
        final Long nextUid;
        final LocalDate dateCreated = LocalDate.now();

        if(!this.requestAudits.isEmpty()){
            nextUid = requestAudits.get(requestAudits.size() - 1).getUid() + 1L;
        } else {
            nextUid = 1L;
        }

        requestAudit.setUid(nextUid);
        requestAudit.setDate_started(dateCreated);

        requestAudits.add(requestAudit);

        return nextUid;
    }

    /**
     * @return unmodifiable list of all current request audits
     */
    public List<request_audit> get_request_types() {
        return Collections.unmodifiableList(this.requestAudits);
    }

}
