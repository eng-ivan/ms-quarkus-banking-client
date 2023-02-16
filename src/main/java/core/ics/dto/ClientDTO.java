package core.ics.dto;

import core.ics.model.Address;
import core.ics.model.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ClientDTO {

    Long id;
    String name;
    String birthDay;
    Address address;
    String pixKey;
    String status;
    LocalDateTime createAt;

    public ClientDTO(Client client) {

        this.id       = client.getId();
        this.name     = client.getName();
        this.birthDay = client.getBirthDay();
        this.pixKey   = client.getPixKey();
        this.status   = client.getStatus();
    }
}
