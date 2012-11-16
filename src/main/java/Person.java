
import org.hibernate.engine.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person", optional = false)
    private Address address;

    public Person(final String firstName, final String lastName, final Address address)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    //Required by hibernate
    public Person()
    {
    }

    public int getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setId(final int id)
    {
        this.id = id;
    }

    public void setFirstName(final String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(final String lastName)
    {
        this.lastName = lastName;
    }

    public void setAddress(final Address address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Person{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", address=" + address +
               '}';
    }
}
