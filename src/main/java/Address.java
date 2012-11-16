import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@GenericGenerator(name="person-primarykey", strategy="foreign",
                                            parameters={@Parameter(name="property", value="person")})
@Table(name = "ADDRESS")
public class Address
{

    @OneToOne
    @PrimaryKeyJoinColumn
    private Person person;

    @Id
    @GeneratedValue(generator = "person-primarykey")
    @Column(name = "person_id")
    private int personId;

    @Column(name = "street")
    private String street;

    @Column(name = "town")
    private String town;

    @Column(name = "postcode")
    private String postcode;

    public Address()
    {
    }

    public Address(final String street, final String town, final String postcode)
    {
        this.street = street;
        this.town = town;
        this.postcode = postcode;
    }

    @Override
    public String toString()
    {
        return "Address{" +
               "personId=" + personId +
               ", street='" + street + '\'' +
               ", town='" + town + '\'' +
               ", postcode='" + postcode + '\'' +
               '}';
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(final String postcode)
    {
        this.postcode = postcode;
    }

    public String getTown()
    {
        return town;
    }

    public void setTown(final String town)
    {
        this.town = town;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(final String street)
    {
        this.street = street;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(final Person person)
    {
        this.person = person;
    }
}