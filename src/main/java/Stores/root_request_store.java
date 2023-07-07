package Stores;

import java.time.LocalDate;

import Objects.root_request;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope("Singleton")
public class root_request_store {
    private final List<root_request> root_requests = new ArrayList();

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

        root_requests.add(new root_request(nextUid,dateCreated));

        return nextUid;
    }

    /**
     * @return unmodifiable list of all current root_requests
     */
    public List<root_request> get_root_requests() {
        return Collections.unmodifiableList(this.root_requests);
    }

}
