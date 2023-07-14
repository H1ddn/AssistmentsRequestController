package org.example.store;

import org.example.model.ProblemRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope("singleton")
public class ProblemRequestStore {

    private final List<ProblemRequest> problem_requests = new ArrayList();

    /**
     * Adds a new problem request to the list of problem requests
     *
     * @return Uid of newly added problem request
     */
    public Long add_request_type(ProblemRequest problemRequest){
        final Long nextUid;
        final LocalDate dateCreated = LocalDate.now();

        if(!this.problem_requests.isEmpty()){
            nextUid = problem_requests.get(problem_requests.size() - 1).getUid() + 1L;
        } else {
            nextUid = 1L;
        }

        problemRequest.setUid(nextUid);
        problemRequest.setDate_created(dateCreated);

        problem_requests.add(problemRequest);

        return nextUid;
    }

    /**
     * @return unmodifiable list of all current problem requests
     */
    public List<ProblemRequest> get_request_types() {
        return Collections.unmodifiableList(this.problem_requests);
    }

}
