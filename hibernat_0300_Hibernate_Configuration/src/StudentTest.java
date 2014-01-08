import org.hibernate.Session;

import com.hibernate.model.Student;
import com.hibernate.util.HibernateUtil;



public class StudentTest {
	public static void main(String[] args){
		Student s = new Student();
		s.setId(1);
		s.setName("andy");
		s.setAge(21);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
	}
}
