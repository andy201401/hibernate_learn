
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import com.hibernate.model.Student;


public class Session {
	String tableName = "student";
	Map<String, String> cfs = new HashMap<String, String>();
	
	String[] methodNames;
	
	//假设数据已经从配置文件被读取
	public Session(){
		cfs.put("id", "id");
		cfs.put("name", "name");
		cfs.put("age", "age");
		methodNames = new String[cfs.size()];
	}
	
	
	public void save(Student s) throws Exception {
		// TODO Auto-generated method stub
		String sql = CreateSQL();
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hibernate", "root", "111111");
		PreparedStatement ps = conn.prepareStatement(sql);
		for(int i = 0; i < methodNames.length; i++){
			//通过方法的名字映射到这个方法从而获取方法取得的数据类型进行判断
			Method m = s.getClass().getMethod(methodNames[i]);
			Class r = m.getReturnType();
			System.out.println(m.getName() + "|" + r.getName());
			System.out.println(methodNames[i]);
			if(r.getName().equals("java.lang.String")){
				String returnValue = (String)m.invoke(s);
				ps.setString(i+1, returnValue);
			}
			if(r.getName().equals("int")){
				Integer returnValue = (Integer)m.invoke(s);
				ps.setInt(i+1, returnValue);
			}
			if(r.getName().equals("int")){
				Integer returnValue = (Integer)m.invoke(s);
				ps.setInt(i+1, returnValue);
			}
		}
		 ps.executeUpdate();
		ps.close();
		conn.close();
	}

	//自动拼接SQL语句
	public String CreateSQL(){
		String str1 = "";
		String str2 = "";
		int index = 0;
		
		//得到数据库中的元素名称并在前面加上get
		for (String s : cfs.keySet()){
			String v = cfs.get(s);
			//首字母大写
			v = Character.toUpperCase(v.charAt(0)) + v.substring(1);
			//拼接方法的名字并存入数据库
			methodNames[index] = "get"+v;
			index++;
			//拼接数据表字段 id,age,name,
			str1 += s+",";
		}
		
		str1 = str1.substring(0,str1.length()-1);
		System.out.println(str1);
		
		for(int i = 0; i < cfs.size(); i++){
			str2 += "?,";
		}
		str2 = str2.substring(0,str2.length()-1);
		System.out.println(str2);
		String sql = "insert into " + tableName + "(" + str1 + ")" + " values (" + str2 + ");";
		System.out.println(sql);
		return sql;
	}
	
}
