import lombok.Data;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sun.applet.Main;

@Data
public class People {

    int id;
    String name;
    String gender;
    String phone;
    String addr;
    String email;

    public static void main(String[] args) {

        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        People people = new People();
        people.setAddr("河南新乡");
        people.setGender("男");
        people.setEmail("1121@qq.com");
        people.setPhone("12334");
        people.setName("张三");

        session.save(people);


        transaction.commit();
    }
}
