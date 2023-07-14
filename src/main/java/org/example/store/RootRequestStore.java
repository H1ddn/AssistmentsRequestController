package org.example.store;

import org.example.model.RootRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope("singleton")
public class RootRequestStore {
    private final List<RootRequest> root_requests = new ArrayList();

    /**
     * Creates a new root request and adds it to the list of root_requests
     *
     * @return Uid of new root request
     */
    public Long add_root_request(){
        Long nextUid;
        LocalDate dateCreated = LocalDate.now();

        if(!this.root_requests.isEmpty()){
            nextUid = root_requests.get(root_requests.size() - 1).getUid() + 1L;
        } else {
            nextUid = 1L;
        }

        root_requests.add(new RootRequest(nextUid,dateCreated));

        return nextUid;
    }

    /**
     * @return unmodifiable list of all current root_requests
     */
    public List<RootRequest> get_root_requests() {
        return Collections.unmodifiableList(this.root_requests);
    }

}
