package dracocore;

import java.util.Random;

public class References 
{

	static Random rand = new Random();
	
	public static String[] errors = new String[]{"Something went wrong! we can't find the pixie stix!", "I'm giving it all she's got captain!", "Uh oh... was that my fault?", "I think something broke, quick, call the maintinence author!"};
	
	
	public static final String modid = "dracocore";
	public static final String modname = "Draco Core";
	public static final String modversion = "v1.0";
	public static final String texturelocation = "dracocore";
	public static final String channel = "DracoCore";
	public static final String clientproxy = "dracocore.proxies.ClientProxy";
	public static final String serverproxy = "dracocore.proxies.CommonProxy";
	
	public static String getErrorMessage()
	{
		return errors[rand.nextInt(errors.length)];
	}
}
