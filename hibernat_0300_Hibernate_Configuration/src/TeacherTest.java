import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Teacher;


@SuppressWarnings("deprecation")
public class TeacherTest {
	public static void main(String[] args){
		Teacher t = new Teacher();
		t.setId(1);
		t.setName("andy");
		t.setTitle("ÖÐ¼¶");
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
