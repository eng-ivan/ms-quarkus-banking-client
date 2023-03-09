package core.ics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "client_tb")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "birth_day")
    String birthDay;

    @Column(name = "address_cep")
    String address;

    @Column(name = "email")
    String email;

    @Column(name = "status")
    String status;

    @Column(name = "create_at")
    @CreationTimestamp
    LocalDateTime createAt;

}
