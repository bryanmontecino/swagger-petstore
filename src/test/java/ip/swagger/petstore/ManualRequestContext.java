package ip.swagger.petstore;

import io.swagger.oas.inflector.models.RequestContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.MultivaluedHashMap;

class ManualRequestContext extends RequestContext {
    private MultivaluedMap<String, String> headers = new MultivaluedHashMap<>();

    public ManualRequestContext() {
        super();
        headers.add("Content-Type", "application/json");
        // Default acceptable media types, you can add more as required
        this.setAcceptableMediaTypes(java.util.Collections.singletonList(MediaType.APPLICATION_JSON_TYPE));
    }

    @Override
    public MultivaluedMap<String, String> getHeaders() {
        return headers;
    }

    @Override
    public java.util.List<MediaType> getAcceptableMediaTypes() {
        return java.util.Collections.singletonList(MediaType.APPLICATION_JSON_TYPE);
    }
}
