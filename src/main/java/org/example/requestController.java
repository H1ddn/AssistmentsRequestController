package org.example;

import Enum.Method;
import Objects.request;
import Objects.request_type;
import Objects.root_request_audit;
import Stores.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class requestController {

    @Autowired
    private problem_request_store prStore;
    @Autowired
    private request_audit_store raStore;
    @Autowired
    private request_store rStore;
    @Autowired
    private request_type_store rtStore;
    @Autowired
    private root_request_audit_store rraStore;
    @Autowired
    private root_request_store rrStore;

    @GetMapping("/")
    public ResponseEntity<List<request>> getAllRequests() {
        return ResponseEntity.ok(rStore.get_requests());
    }

    @PostMapping("/")
    public void processRequests(@RequestBody final request[] requests) throws UnknownHostException, URISyntaxException {


        StringBuilder requestTypes = new StringBuilder();
        final List<request_type> rtList = rtStore.get_request_types();
        // Process the array of requests
        for (final request request : requests) {
            rStore.add_request(request);
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

        final request request = rStore.get_requests().get(0);
        final String remoteAddress = "example.com";
        final InetAddress address = InetAddress.getByName(remoteAddress);
        final String host = address.getHostAddress();
        final URI uri = new URI("http", null, host, -1, "/resource", null, null);
        final root_request_audit rrAudit = new root_request_audit(
                request.getRoot_request_id(),
                uri,
                method,
                address,
                request.getDate_created());
        rraStore.add_root_request_audit(rrAudit);
        rrAudit.printRootRequestAudit();

    }
}