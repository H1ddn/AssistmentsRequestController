package Stores;

import java.time.LocalDate;

import Objects.problem_request;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope("Singleton")
public class problem_request_store {

    private final List<problem_request> problem_requests = new ArrayList();

    /**
     * Adds a new problem request to the list of problem requests
     *
     * @return Uid of newly added problem request
     */
    public Long add_request_type(problem_request problemRequest){
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
    public List<problem_request> get_request_types() {
        return Collections.unmodifiableList(this.problem_requests);
    }

}
