package dev.thelunardi.client;

import dev.thelunardi.exception.DriverException;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import javax.annotation.Priority;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;

@Priority(4000)
public class ApiRequestMapper implements ResponseExceptionMapper<RuntimeException> {
    @Override
    public RuntimeException toThrowable(Response response) {
        int status = response.getStatus();
        String msg = getBody(response);

        RuntimeException re;
        switch (status) {
            case 400:
                re = new DriverException(msg);
                break;
            default:
                re = new WebApplicationException(msg, status);
        }
        return re;
    }

    private String getBody(Response response) {
        ByteArrayInputStream is = (ByteArrayInputStream) response.getEntity();
        byte[] bytes = new byte[is.available()];
        is.read(bytes, 0, is.available());
        return new String(bytes);
    }
}
