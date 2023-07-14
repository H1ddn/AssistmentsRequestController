package org.example.controller;

import org.example.model.Request;
import org.example.model.RequestType;
import org.example.model.RootRequestAudit;
import org.example.store.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
public class RequestController {

    @Autowired
    private ProblemRequestStore prStore;
    @Autowired
    private RequestAuditStore raStore;
    @Autowired
    private RequestStore rStore;
    @Autowired
    private RequestTypeStore rtStore;
    @Autowired
    private RootRequestAuditStore rraStore;
    @Autowired
    private RootRequestStore rrStore;

    @GetMapping("/")
    public ResponseEntity<List<Request>> getAllRequests() {
        return ResponseEntity.ok(rStore.get_requests());
    }

    @PostMapping("/")
    public ResponseEntity<RootRequestAudit> processRequests(@RequestBody final List<Request> requests) throws UnknownHostException, URISyntaxException {


        StringBuilder requestTypes = new StringBuilder();
        final List<RequestType> rtList = rtStore.get_request_types();
        // Process the array of requests
        for (final Request request : requests) {
            final String name = rtList.get((int) (request.getRequest_type_id()-1)).getName();
            switch (name) {
                case "multiple_choice" -> requestTypes.append("A");
                case "short_answer" -> requestTypes.append("B");
                case "open-ended" -> requestTypes.append("C");
            }
        }

        //Removing Duplicates and Sorting
        requestTypes = new StringBuilder(Stream.of(requestTypes.toString().split(""))
                .sorted()
                .distinct()
                .collect(Collectors.joining()));

        final Method method = Method.valueOf(String.valueOf(requestTypes));
        method.print();

        final String remoteAddress = "example.com";
        final InetAddress address = InetAddress.getByName(remoteAddress);
        final String host = address.getHostAddress();
        final URI uri = new URI("http", null, host, -1, "/resource", null, null);
        final RootRequestAudit rrAudit = new RootRequestAudit(
                uri,
                method,
                address);
        RootRequestAudit rrAudit_final = rraStore.add_root_request_audit(rrAudit);

        for (final Request request : requests) {
            request.setRoot_request_id(rrAudit.getRoot_request_id());
            rStore.add_request(request);
        }

        return ResponseEntity.ok(rrAudit_final);

    }
}
