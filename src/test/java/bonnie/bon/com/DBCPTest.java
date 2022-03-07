package bonnie.bon.com;

import static org.junit.Assert.fail;
import java.sql.Connection;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.somebody.db.MapperBon;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) //root.context에서 데베연결한 거 강제실행
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//@conTextConfiguration: runwith 실행해서 메모리에 올려줌
@Log4j

//테스트는 서버 안돌려도됨
public class DBCPTest {
	@Setter(onMethod = @__({@Autowired}))//메모리에 올라온 데이터타입찾아서 대입시킴
	//private DataSource ds; // 변수를 통해 커넥션됐는지 확인후 만들어줌 , session도 
	//@Setter(onMethod = @__({@Autowired}))
	//private SqlSessionFactory ssf;
	private MapperBon om;
	
	@Test //@걸려있는애들을 실행
	public void dbcpTest() {
		try {
		//Connection conn = this.ds.getConnection();
		//SqlSession session = ssf.openSession();
		//log.info(session);//롬복이가지고있음로그4
		log.info(om.getClass().getField("isId")+"요기당"); 
	
		
		}catch(Exception e) {
			fail(e.getMessage());
			}
		
	}
	

}


