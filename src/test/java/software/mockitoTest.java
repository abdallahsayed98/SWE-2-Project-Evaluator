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
		
		
		ArrayList<Quiz> result=obj.recommendQuizBySkills(1, 1); 
        Quiz q1=new Quiz(4,"JAVA");
        Quiz q2=new Quiz(5,"C++");
        ArrayList<Quiz> matcher=new ArrayList<Quiz>();
        matcher.add(q1);
        matcher.add(q2);
        //assertEquals(new HashSet<Quiz>(result), new HashSet<Quiz>(matcher));
        assertEquals(matcher.size(), result.size());
        for(int i=0;i<result.size();i++)
        {
        	assertEquals(matcher.get(i).Quiz_ID, result.get(i).Quiz_ID);
        	assertEquals(matcher.get(i).Quiz_Name, result.get(i).Quiz_Name);
        }	
	}
	
	@Test
	public void getInterestByIDtest() {
	    GetData obj=new GetData();
	    ArrayList<String> result=obj.getUserInterest(1, ""); 
        String s1="Back End";
        String s2="Front End";
        String s3="Game Development";
        String s4="Mobile Development";
        String s5="Testing";
        ArrayList<String> matcher=new ArrayList<String>();
        matcher.add(s1);
        matcher.add(s2);
        matcher.add(s3);
        matcher.add(s4);
        matcher.add(s5);
        assertEquals(matcher.size(), result.size());
        for(int i=0;i<result.size();i++)
        {
        	assertEquals(matcher.get(i), result.get(i));
        }
        
	}
	
}
