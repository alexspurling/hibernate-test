import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class PersonTest
{

    @Test
    public void testReadPerson() {
        List people = PersonTestUtil.listPeople();
        assertTrue(people.isEmpty());
    }

    @Test
    public void testWritePerson() {
        Person person = new Person("Jack", "Bauer");
        person.setAddress(new Address("123 Fake Street", "Springfield", "SP1F 123"));
        person.getAddress().setPerson(person);

        person = PersonTestUtil.save(person);
        person = PersonTestUtil.read(person.getId());

        assertEquals("Jack", person.getFirstName());
        assertEquals("Bauer", person.getLastName());
        assertEquals("123 Fake Street", person.getAddress().getStreet());
        assertEquals("Springfield", person.getAddress().getTown());
    }

    @Test
    public void testUpdatePerson() {

        Person person = PersonTestUtil.read(1); // read Person with id 1
        person.setFirstName("James");
        PersonTestUtil.update(person);  // save the updated Person details

        Person personAfterUpdate = PersonTestUtil.read(1); // read again Person with id 1

        assertEquals("James", personAfterUpdate.getFirstName());
    }

    @Test
    public void testDeletePerson() {
        Person person = PersonTestUtil.read(1); // read Person with id 1
        PersonTestUtil.delete(person);
        Person deletedPerson = PersonTestUtil.read(person.getId());
        assertNull("Expected deleted person object to be null but was: " + deletedPerson, deletedPerson);
    }

}