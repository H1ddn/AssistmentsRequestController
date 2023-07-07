package Objects;

import java.net.URI;
import Enum.Method;
import java.net.InetAddress;
import java.time.LocalDate;

public class root_request_audit {

    private Long root_request_id;
    private URI uri;
    private Method method;
    private InetAddress remote_address;
    private LocalDate date_started;
    private LocalDate date_ended;

    public Long getRoot_request_id() {
        return root_request_id;
    }

    public void setRoot_request_id(final Long root_request_id) {
        this.root_request_id = root_request_id;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(final URI uri) {
        this.uri = uri;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(final Method method) {
        this.method = method;
    }

    public InetAddress getRemote_address() {
        return remote_address;
    }

    public void setRemote_address(final InetAddress remote_address) {
        this.remote_address = remote_address;
    }

    public LocalDate getDate_started() {
        return date_started;
    }

    public void setDate_started(final LocalDate date_started) {
        this.date_started = date_started;
    }

    public LocalDate getDate_ended() {
        return date_ended;
    }

    public void setDate_ended(final LocalDate date_ended) {
        this.date_ended = date_ended;
    }
}
