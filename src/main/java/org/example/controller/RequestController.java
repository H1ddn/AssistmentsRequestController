package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.model.Request;
import org.example.model.RequestAudit;
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
import java.time.LocalDate;
import java.util.List;


@RestController
public class RequestController {

    private static void doProblemRequest() {
        System.out.println("doProblemRequest");
    }

    private static void doQuestionRequest() {
        System.out.println("doQuestionRequest");
    }

    private final ProblemRequestStore prStore;
    private final RequestAuditStore raStore;
    private final RequestStore rStore;
    private final RequestTypeStore rtStore;
    private final RootRequestAuditStore rraStore;
    private final RootRequestStore rrStore;

    @Autowired
    public RequestController(
        final ProblemRequestStore prStore,
        final RequestAuditStore raStore,
        final RequestStore rStore,
        final RequestTypeStore rtStore,
        final RootRequestAuditStore rraStore,
        final RootRequestStore rrStore
    ) {
        this.prStore = prStore;
        this.raStore = raStore;
        this.rStore = rStore;
        this.rtStore = rtStore;
        this.rraStore = rraStore;
        this.rrStore = rrStore;
    }

    @GetMapping("/")
    public ResponseEntity<List<Request>> getAllRequests() {
        return ResponseEntity.ok(rStore.get_requests());
    }

    @PostMapping("/")
    public ResponseEntity<RootRequestAudit> processRequests(
        @RequestBody final List<Request> requests,
        final HttpServletRequest httpRequest
    ) throws UnknownHostException, URISyntaxException {
        final Long rootRequestId = rrStore.add_root_request();

        final RootRequestAudit rrAudit = new RootRequestAudit(
            URI.create(httpRequest.getRequestURI()),
            httpRequest.getMethod(),
            InetAddress.getByName(httpRequest.getRemoteAddr())
        );
        rrAudit.setRoot_request_id(rootRequestId);

        rrAudit.setDate_started(LocalDate.now());

        for(final Request request : requests) {
            final Long requestId = rStore.add_request(request);

            final RequestAudit requestAudit = new RequestAudit();
            requestAudit.setRequestId(requestId);
            requestAudit.setDate_started(LocalDate.now());

            final Long requestType = request.getRequest_type_id();

            if(requestType == 1) {
                doProblemRequest();
            } else if(requestType == 2) {
                doQuestionRequest();
            }

            requestAudit.setDate_ended(LocalDate.now());

            raStore.add_request_audit(requestAudit);
        }

        rrAudit.setDate_ended(LocalDate.now());

        final RootRequestAudit rrAudit_final = rraStore.add_root_request_audit(rrAudit);

        return ResponseEntity.ok(rrAudit_final);

    }
}
