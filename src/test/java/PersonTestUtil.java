import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.List;

public class PersonTestUtil
{

    public static List<Person> listPeople() {
        Session session = getSession();
        List<Person> persons = session.createQuery("from Person").list();
        session.close();
        return persons;
    }

    public static Person read(int id) {
        Session session = getSession();
        Person person = (Person) session.get(Person.class, id);
        session.close();
        return person;
    }

    public static Person save(Person person) {
        Session session = getSession();
        session.beginTransaction();
        Integer id = (Integer)session.save(person);
        person.setId(id);
        session.getTransaction().commit();
        session.close();
        return person;
    }

    public static Person update(Person person) {
        Session session = getSession();
        session.beginTransaction();
        session.merge(person);
        session.getTransaction().commit();
        session.close();
        return person;

    }

    public static void delete(Person person) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(person);
        session.getTransaction().commit();
        session.close();
    }

    private static Session getSession()
    {
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
        return sf.openSession();
    }

}
