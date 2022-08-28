package dat3.cars.entity;

import dat3.security.dto.UserWithRolesRequest;
import dat3.security.entity.UserWithRoles;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Member extends UserWithRoles {

    //Attributes
    private String firstname;

    private String lastname;

    private String street;

    private String city;

    private int zip;

    private boolean approved;

    private int ranking;


    //Constructors
        //Default
    public Member() {
    }

        //Custom
    public Member(UserWithRolesRequest body, String firstname, String lastname, String street, String city, int zip) {
        super(body);
        this.firstname = firstname;
        this.lastname = lastname;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }
}
