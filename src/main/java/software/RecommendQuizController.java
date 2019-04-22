package software;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendQuizController {
	public static String getInterestAPI=""; 
	@RequestMapping("/getUserInterest")
    public ArrayList<String> getUserInter(@RequestParam(value="UserID") int UserID) {
        GetData g=new GetData();
		ArrayList<String >interests=g.getUserInterest(UserID, getInterestAPI);
		return interests;
    }
	@RequestMapping("/recommendByQuizSkill")
	public ArrayList<String> getRecommendQuizBySkill(@RequestParam(value="UserID") int UserID /*,@RequestParam(value="SkillID") int SkillID*/)
	{
		RecommendQuiz r=new RecommendQuiz();
		ArrayList<String> strquizs=new ArrayList<String>() ; 
		ArrayList<Quiz>Quizs= r.recommendQuizBySkills(1, UserID);
		for(int i=0;i<Quizs.size();i++)
		{
			strquizs.add(Quizs.get(i).Quiz_ID+" "+Quizs.get(i).Quiz_Name);
		}
		return strquizs;
	}
    
}
