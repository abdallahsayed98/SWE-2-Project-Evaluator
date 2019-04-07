package softpro;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.ArrayList;

public class recommend {
	public static ArrayList<UserInterest> users=new ArrayList<UserInterest>();
	//Call User API to get the Interest
	public void getInerst(int userID)
	{
		Client client = ClientBuilder.newClient();
    	WebTarget target =client.target("http://localhost:8080/userAPI?ID='"+userID+"'");
    	System.out.println(target.request().get(String.class));
    	ObjectMapper objectMapper = new ObjectMapper();
    	ArrayList<Integer> arr= objectMapper.readValue(jsonString,objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Integer.class));
    	
    	UserInterest user= new UserInterest();
 	    user.userID=userID;
    	for(int i=0;i<arr.size();i++)
    	{
    		user.interest.add(arr.get(i));
    	}
    	users.add(user);
    	
	}
	

}
