package core.ics.dto;

import core.ics.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ClientDTO implements Serializable {

    Long id;
    String name;
    Account account;
    Card card;
    Address address;
    Pix pixKey;
    String status;
    LocalDateTime createAt;

    public ClientDTO(Client client) {
        this.id       = client.getId();
        this.name     = client.getName();
        this.status   = client.getStatus();
        this.createAt = client.getCreateAt();
    }
}
