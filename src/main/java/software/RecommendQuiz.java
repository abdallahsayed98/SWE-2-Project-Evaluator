package software;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Service
public class RecommendQuiz {
	@Autowired
	public static String quiz_Skill="";
	public static String quiz_Skill_UserID="";
	public ArrayList<Quiz> recommendQuizBySkills(int Skill_ID,int UserID)
	{
		GetData g=new GetData();
		ArrayList<Quiz> quizs=new ArrayList<Quiz>();
	    ArrayList<Quiz> Skill_quiz=new ArrayList<Quiz>();
	    ArrayList<Quiz> Skill_quiz_pass=new ArrayList<Quiz>();
	    //String str1=g.getJsonFromApi(quiz_Skill+Skill_ID);
	    try {
			JSONParser parse = new JSONParser();
			FileReader reader = new FileReader("2.json");///test
			Object obj = parse.parse(reader);///test
			JSONArray jsonarr_1 = (JSONArray) obj;///test
//			JSONObject jobj = (JSONObject)parse.parse(str1);
//			JSONArray jsonarr_1 = (JSONArray) jobj.get("");
			for(int i=0;i<jsonarr_1.size();i++)
			{
			JSONObject jsonobj_1 = (JSONObject)jsonarr_1.get(i);
			//System.out.println("\nQuiz_ID: " +jsonobj_1.get("Quiz_id"));
			int ID=Integer.parseInt((String) jsonobj_1.get("Quiz_id"));
			//System.out.println("\nQuiz_Name: " +jsonobj_1.get("Quiz_Name"));
			String name=(String) jsonobj_1.get("Quiz_Name");
			Quiz q=new Quiz(ID, name);
			Skill_quiz.add(q);
			}
		} 
		catch (ParseException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	    //String str2=g.getJsonFromApi(quiz_Skill_UserID+Skill_ID+UserID);
	    try {
			JSONParser parse = new JSONParser();
			FileReader reader = new FileReader("3.json");///test
			Object obj = parse.parse(reader);///test
			JSONArray jsonarr_1 = (JSONArray) obj;///test
//			JSONObject jobj = (JSONObject)parse.parse(str2);
//			JSONArray jsonarr_1 = (JSONArray) jobj.get("");
			for(int i=0;i<jsonarr_1.size();i++)
			{
			JSONObject jsonobj_1 = (JSONObject)jsonarr_1.get(i);
			//System.out.println("\nQuiz_ID: " +jsonobj_1.get("Quiz_id"));
			int ID=Integer.parseInt((String) jsonobj_1.get("Quiz_id"));
			//System.out.println("\nQuiz_Name: " +jsonobj_1.get("Quiz_Name"));
			String name=(String) jsonobj_1.get("Quiz_Name");
			Quiz q=new Quiz(ID, name);
			Skill_quiz_pass.add(q);
			}
		} 
		catch (ParseException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    for(int i=0;i<Skill_quiz.size();i++)
	    {
//	    	if(Skill_quiz_pass.contains(Skill_quiz.get(i)))
//	    			{
//	    				quizs.add(Skill_quiz.get(i));
//	    			}
	    	for(int j=0;j<Skill_quiz_pass.size();j++)
	    	{
	    		if((Skill_quiz_pass.get(j).Quiz_ID==Skill_quiz.get(i).Quiz_ID))
	    		{
	    			break;
	    		}
	    		else
	    		{
	    			if(j+1==Skill_quiz_pass.size())
	    			{
	    				quizs.add(Skill_quiz.get(i));
	    			}
	    		}
	    	}
	    }
		return quizs;
	}
	public ArrayList<Quiz> recommendQuizByInterest(String UserID)
	{
		String link="";
		GetData g=new GetData();
		ArrayList<Quiz> quizs=new ArrayList<Quiz>();
		ArrayList<String> Interests=g.getUserInterest(Integer.parseInt(UserID), link);
		for(int i=0;i<Interests.size();i++)
		{
			ArrayList<Integer> skills=new ArrayList<Integer>();///replace by function 
			for(int j=0;j<skills.size();j++)
			{
				ArrayList<Quiz> recommendedquizes=recommendQuizBySkills(skills.get(i), Integer.parseInt(UserID));
				quizs.addAll(recommendedquizes.subList(0, recommendedquizes.size()));
			}
		}
		return quizs;
	}

}
