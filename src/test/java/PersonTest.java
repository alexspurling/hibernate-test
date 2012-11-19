import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class PersonTest
{

    @Before
    public void deleteAllPeople() {
        List<Person> people = PersonTestUtil.listPeople();
        for (Person person : people)
        {
            PersonTestUtil.delete(person);
        }
    }

    private Person insertPerson() {
        return insertPerson(new Address("123 Fake Street", "Springfield", "SP1F 123"));
    }
    private Person insertPerson(Address address) {
        Person person = new Person("Jack", "Bauer", address);
        if (address != null) {
            person.getAddress().setPerson(person);
        }
        person = PersonTestUtil.save(person);
        return PersonTestUtil.read(person.getId());
    }

    @Test
    public void testWritePerson() {
        Person storedPerson = insertPerson();

        assertFalse(storedPerson.getId() == 0);
        assertEquals("Jack", storedPerson.getFirstName());
        assertEquals("Bauer", storedPerson.getLastName());
        assertEquals("123 Fake Street", storedPerson.getAddress().getStreet());
        assertEquals("Springfield", storedPerson.getAddress().getTown());
    }

    @Test
    public void testUpdatePerson() {
        Person storedPerson = insertPerson();

        Person person = PersonTestUtil.read(storedPerson.getId());
        person.setFirstName("James");
        PersonTestUtil.update(person);  // save the updated Person details

        Person personAfterUpdate = PersonTestUtil.read(storedPerson.getId());

        assertEquals("James", personAfterUpdate.getFirstName());
    }

    @Test
    public void testDeletePerson() {
        Person storedPerson = insertPerson();

        Person person = PersonTestUtil.read(storedPerson.getId());
        PersonTestUtil.delete(person);
        Person deletedPerson = PersonTestUtil.read(person.getId());
        assertNull("Expected deleted person object to be null but was: " + deletedPerson, deletedPerson);
    }

    @Test
    public void testWritePersonWithoutAddress() {
        Person storedPerson = insertPerson(null);

        assertFalse(storedPerson.getId() == 0);
        assertEquals("Jack", storedPerson.getFirstName());
        assertEquals("Bauer", storedPerson.getLastName());
        assertNull(storedPerson.getAddress());
    }
}