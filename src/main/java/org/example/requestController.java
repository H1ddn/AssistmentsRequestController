package org.example;
import Objects.request;
import Stores.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class requestController {

    @Autowired
    private final problem_request_store problemRequestStore;
    @Autowired
    private final request_audit_store requestAuditStore;
    @Autowired
    private final request_store requestStore;
    @Autowired
    private final request_type_store requestTypeStore;
    @Autowired
    private final root_request_audit_store rootRequestAuditStore;
    @Autowired
    private final root_request_store rootRequestStore;


    public requestController(problem_request_store problemRequestStore,
                             request_audit_store requestAuditStore,
                             request_store requestStore,
                             request_type_store requestTypeStore,
                             root_request_audit_store rootRequestAuditStore,
                             root_request_store rootRequestStore) {
        this.problemRequestStore = problemRequestStore;
        this.requestAuditStore = requestAuditStore;
        this.requestStore = requestStore;
        this.requestTypeStore = requestTypeStore;
        this.rootRequestAuditStore = rootRequestAuditStore;
        this.rootRequestStore = rootRequestStore;
    }


    @PostMapping("/")
    public void processRequests(@RequestBody request[] requests) {
        // Process the array of requests
        for (request request : requests) {
            // Do something with each request object

            // ...
        }
    }
}