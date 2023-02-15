package core.ics.dto;

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
    String address;
    String pixKey;
    String status;
    LocalDateTime createAt;
}
