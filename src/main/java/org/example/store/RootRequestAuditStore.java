package org.example.store;

import org.example.model.RootRequestAudit;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope("singleton")
public class RootRequestAuditStore {
    private final List<RootRequestAudit> root_request_audits = new ArrayList();

    /**
     * Adds a request audit to the list of root_request_audits
     *
     * @return Uid of new root request audit
     */
    public RootRequestAudit add_root_request_audit(RootRequestAudit rrAudit){
        root_request_audits.add(rrAudit);

        return rrAudit;
    }

    /**
     * @return unmodifiable list of all current root_request_audits
     */
    public List<RootRequestAudit> get_root_request_audits() {
        return Collections.unmodifiableList(this.root_request_audits);
    }

}
