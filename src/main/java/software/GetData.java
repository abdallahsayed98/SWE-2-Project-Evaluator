package software;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetData {
	public static ArrayList<String> Interest=new ArrayList<String>();
	public static ArrayList<Skill> Skills=new ArrayList<Skill>();
    public String getJsonFromApi(String link)
    {
    	String inline="";
    	try {
		    URL url = new URL(link);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			Scanner sc = new Scanner(url.openStream());	
			while(sc.hasNext())
			{
			inline+=sc.nextLine();
			}
			System.out.println("\nJSON data in string format");
			System.out.println(inline);
			sc.close();
    	}
    	catch (IOException e) {
			e.printStackTrace();
		}
    	return inline;
    }
    public void getInterest(String link) 
	{
		try {
			//String inline=getJsonFromApi(link);
			JSONParser parse = new JSONParser();
			FileReader reader = new FileReader("1.json");////test
			//JSONObject jobj = (JSONObject)parse.parse(inline);
			Object obj = parse.parse(reader);///test
			//JSONArray jsonarr_1 = (JSONArray) jobj.get("");
			JSONArray jsonarr_1 = (JSONArray) obj;///test
			System.out.println("Elements under results array");
			for(int i=0;i<jsonarr_1.size();i++)
			{
			JSONObject jsonobj_1 = (JSONObject)jsonarr_1.get(i);
			System.out.println("Interest: " +jsonobj_1.get("Interest"));
			Interest.add((String) jsonobj_1.get("Interest"));
			}
		} 
		catch (ParseException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	/*public void getSkills(String link)
	{
		try {
			String inline=getJsonFromApi(link);
			JSONParser parse = new JSONParser();
			JSONObject jobj = (JSONObject)parse.parse(inline);
			JSONArray jsonarr_1 = (JSONArray) jobj.get("");
			for(int i=0;i<jsonarr_1.size();i++)
			{
			JSONObject jsonobj_1 = (JSONObject)jsonarr_1.get(i);
			System.out.println("Elements under results array");
			System.out.println("\nName: " +jsonobj_1.get("Name"));
			String name=(String) jsonobj_1.get("Name");
			System.out.println("\nID: " +jsonobj_1.get("ID"));
			String ID=(String) jsonobj_1.get("ID");
			Skill skill=new Skill(name, ID);
			Skills.add(skill);
			}
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}	
	}*/
	public ArrayList<String> getUserInterest(int UserID,String link)
	{
		ArrayList<String> Interest=new ArrayList<String>();
		try {
			//String inline=getJsonFromApi(link+UserID);
			JSONParser parse = new JSONParser();
			FileReader reader = new FileReader("1.json");///test
			Object obj = parse.parse(reader);///test
			JSONArray jsonarr_1 = (JSONArray) obj;///test
			//JSONObject jobj = (JSONObject)parse.parse(inline);
			//JSONArray jsonarr_1 = (JSONArray) jobj.get("");
			for(int i=0;i<jsonarr_1.size();i++)
			{
				JSONObject jsonobj_1 = (JSONObject)jsonarr_1.get(i);
				System.out.println("Interest: " +jsonobj_1.get("Interest"));
				String interest= (String)(jsonobj_1.get("Interest"));
				Interest.add(interest);
			}
		} 
		catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return Interest;
	}
	public static void main(String[] args) {
	GetData g=new GetData();
	g.getUserInterest(11, "");
	}

}
