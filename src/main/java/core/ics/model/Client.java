package core.ics.model;

import javax.persistence.*;

@Entity
@Table(name = "client_tb")
public class Client extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pixKey;
    private String status;
    private String createAt;

}
