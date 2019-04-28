package software;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class mockitoTest {
	@Autowired
	RecommendQuiz obj;
	
	@Test
	public void recommedQuizBySkillTest() {
		
		
		ArrayList<Quiz> result=new ArrayList<Quiz>(); 
		when(obj.recommendQuizBySkills(1, 1)).thenReturn(result);
		Quiz q1=new Quiz(4,"JAVA");
		Quiz q2=new Quiz(5,"C++");
		ArrayList<Quiz> matcher=new ArrayList<Quiz>();
		matcher.add(q1);
		matcher.add(q2);
		
		assertEquals(result, matcher);
		
	}

}
