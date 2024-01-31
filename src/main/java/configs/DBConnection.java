package configs;

import java.io.IOException;
import java.io.Reader;
import java.util.ResourceBundle;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBConnection {
	// 데이터베이스와의 세션을 생성하는 데 사용되는 팩토리 객체
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			// 설정
			ResourceBundle bundle = ResourceBundle.getBundle("configs.application");
			String env = bundle.getString("environment");
			String mode = env.equals("real") ? "real" : "dev";
			
			// MyBatis 설정파일 읽어오기
			Reader reader = Resources.getResourceAsReader("mybatis/config/config.xml");
			
			// 빌더를 통해 SqlSessionFactory 생성
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, mode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession() {
		// 새로운 SqlSession을 반환. 작업이 완료된 후 세션을 닫아야 한다.
		return sqlSessionFactory.openSession();
	}
}
