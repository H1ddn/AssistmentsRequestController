package org.example.store;

import org.example.model.request_type;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope("singleton")
public class request_type_store {

    private final List<request_type> request_types = new ArrayList();

    public request_type_store() {
        this.add_request_type(new request_type(1L, "multiple_choice"));
        this.add_request_type(new request_type(1L+1, "short_answer"));
        this.add_request_type(new request_type(1L+2, "open-ended"));
    }

    /**
     * Adds a new request type to the list of request_types
     *
     * @return Uid of newly added request type
     */
    public Long add_request_type(request_type requestType){
        final Long nextUid;
        final LocalDate dateCreated = LocalDate.now();

        if(!this.request_types.isEmpty()){
            nextUid = request_types.get(request_types.size() - 1).getUid() + 1L;
        } else {
            nextUid = 1L;
        }

        requestType.setUid(nextUid);
        requestType.setDate_created(dateCreated);

        request_types.add(requestType);

        return nextUid;
    }

    /**
     * @return unmodifiable list of all current request types
     */
    public List<request_type> get_request_types() {
        return Collections.unmodifiableList(this.request_types);
    }


}
