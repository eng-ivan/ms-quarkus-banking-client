package core.ics.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@SuperBuilder
@Getter
public class ConnectionTest {

    InetAddress address;
    String createAt;

    public static ConnectionTest test() throws UnknownHostException {
        ConnectionTest test = ConnectionTest
                .builder()
                .address(InetAddress.getLocalHost())
                .createAt(new Date().toString())
                .build();

        return test;
    }
}
