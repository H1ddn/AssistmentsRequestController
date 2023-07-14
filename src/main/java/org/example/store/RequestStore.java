package org.example.store;

import org.example.model.Request;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope("singleton")
public class RequestStore {

    private final List<Request> requests = new ArrayList();

    /**
     * Adds a new request to the list of requests
     *
     * @return Uid of newly added request
     */
    public Long add_request(Request requestObject){
        final Long nextUid;
        final LocalDate dateCreated = LocalDate.now();

        if(!this.requests.isEmpty()){
            nextUid = requests.get(requests.size() - 1).getUid() + 1L;
        } else {
            nextUid = 1L;
        }

        requestObject.setUid(nextUid);
        requestObject.setDate_created(dateCreated);

        requests.add(requestObject);

        return nextUid;
    }

    /**
     * @return unmodifiable list of all current requests
     */
    public List<Request> get_requests() {
        return Collections.unmodifiableList(this.requests);
    }

}
