package softpro;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.ArrayList;
public class recommendQuiz extends recommend{
	public static ArrayList<Quiz> quiz= new ArrayList<Integer>();
	
	public void getQuiz(int QuizID)
	{
		Client client = ClientBuilder.newClient();
    	WebTarget target =client.target("http://localhost:8080/QuizAPI?ID='"+QuizID+"'");
    	System.out.println(target.request().get(String.class));
    	Quiz q = new ObjectMapper().readValue(jsonString, Quiz.class);
    	quiz.add(q);
	}
	public String recommendQuiz(int UserID)
	{
		for(int i=0;i<users.size();i++)
		{
			if(users.get(i).userID==UserID)
			{
				UserInterest user=users.get(i);
				for(int j=0;j<user.interest.size();j++)
				{
					getQuiz(user.interest.get(j));
				}	
			}
			quiz.clear();
		}
	}
	
	

}
