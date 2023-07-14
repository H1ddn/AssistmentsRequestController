package org.example.store;

import org.example.model.RequestAudit;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope("singleton")
public class RequestAuditStore {
    private final List<RequestAudit> requestAudits = new ArrayList();

    /**
     * Adds a new request audit to the list of request audits
     *
     * @return Uid of newly added request audit
     */
    public void add_request_audit(RequestAudit requestAudit){
        requestAudits.add(requestAudit);
    }

    /**
     * @return unmodifiable list of all current request audits
     */
    public List<RequestAudit> get_request_types() {
        return Collections.unmodifiableList(this.requestAudits);
    }

}
