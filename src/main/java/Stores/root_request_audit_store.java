package Stores;

import java.time.LocalDate;

import Objects.root_request;
import Objects.root_request_audit;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope("singleton")
public class root_request_audit_store {
    private final List<root_request_audit> root_request_audits = new ArrayList();

    /**
     * Adds a request audit to the list of root_request_audits
     *
     * @return Uid of new root request audit
     */
    public root_request_audit add_root_request_audit(root_request_audit rrAudit){
        Long nextUid;
        LocalDate dateCreated = LocalDate.now();

        if(!this.root_request_audits.isEmpty()){
            nextUid = root_request_audits.get(root_request_audits.size() - 1).getRoot_request_id() + 1L;
        } else {
            nextUid = 1L;
        }

        rrAudit.setRoot_request_id(nextUid);
        rrAudit.setDate_started(dateCreated);

        root_request_audits.add(rrAudit);

        return rrAudit;
    }

    /**
     * @return unmodifiable list of all current root_request_audits
     */
    public List<root_request_audit> get_root_request_audits() {
        return Collections.unmodifiableList(this.root_request_audits);
    }

}
