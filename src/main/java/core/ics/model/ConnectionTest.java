package core.ics.model;

import lombok.*;

import java.io.Serializable;
import java.net.InetAddress;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionTest implements Serializable {

    private InetAddress address;
    private String createAt;
}
