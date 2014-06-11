import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class TocHW3 {

	public static void main(String[] args) 
	{
		URL url;
		char tempchar;
		int average=0;
		int state=1;
		int skip=42205200;//10100001000000000000010000
		int compare=33554432;
		int ts=skip;
		int tc=compare;
		int excep;
		Vector<Housedata> store=new Vector<Housedata>();
		Housedata tempHd=new Housedata();
		try
		{
			url=new URL(args[0]);
			URLConnection conn = url.openConnection();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			while(!br.ready());
			while(state!=33)
			{
				tempchar=(char)br.read();
				while(tempchar=='\n')tempchar=(char)br.read();
				switch(state)
				{
				case 1:
					if(tempchar=='[')
						state=2;
					else
						throw new Exception("parsing error1");
					break;
				case 2:
					if(tempchar=='{')
					{
						ts=skip;
						tc=compare;
						state=3;
					}
					else
						throw new Exception("parsing error2");
					break;
				case 3:
					if(tempchar=='"')
					{
						String t=new String();
						while((tempchar=(char)br.read())!='"')
							t+=tempchar;
						if((ts&tc)!=0)
						{
							if(t.equals("lvr_land"))
							{
								state=34;
								continue;
							}
							else if((state=tempHd.check(tc,t))==-1)
							{
								throw new Exception("variable name error");
							}
						}
						else
							state=30;
						while(tempchar!=':')tempchar=(char)br.read();
					}
					else
						throw new Exception("parsing error3");
					tc=tc>>1;
					break;
				case 4:
					if(tempchar=='"')
					{
						String t=new String();
						while((tempchar=(char)br.read())!='"')
							t+=tempchar;
						tempHd.locate=t;
						//System.out.println(t);
						if(!tempHd.locate.equals(args[1]))
						{
							state=34;
							continue;
						}
						state=31;
					}
					else
						throw new Exception("parsing error4");
					break;
				//case 5:
				case 6:
					if(tempchar=='"')
					{
						String t=new String();
						while((tempchar=(char)br.read())!='"')
							t+=tempchar;
						tempHd.road=t;
						//System.out.println(t);
						if(!tempHd.road.contains(args[2]))
						{
							state=34;
							continue;
						}
						state=31;
					}
					else
						throw new Exception("parsing error6");
					break;
				//case 7:
				//case 8:
				//case 9:
				//case 10:
				case 11:
					if(tempchar<='9'&&tempchar>='0')
					{
						int t=0;
						int targs=0;
						do
						{
							t*=10;
							t+=tempchar-'0';
							tempchar=(char)br.read();
						}
						while(tempchar!=','&&tempchar!='}');
						tempHd.tradedate=t;
						for(int i=0;i<args[3].length();++i)
						{
							targs*=10;
							targs+=args[3].charAt(i)-'0';
						}
						targs*=100;
						//System.out.println(t);
						if(tempHd.tradedate<targs)
						{
							state=34;
							continue;
						}
						
						if(tempchar==',')
							state=3;
						else
							state=32;
					}
					else
						throw new Exception("parsing error11");
					break;
				//case 12:
				//case 13:
				//case 14:
				//case 15:
				//case 16:
				//case 17:
				//case 18:
				//case 19:
				//case 20:
				//case 21:
				//case 22:
				//case 23:
				//case 24:
				case 25:
					if(tempchar<='9'&&tempchar>='0')
					{
						int t=0;
						do{
							t*=10;
							t+=tempchar-'0';
							tempchar=(char)br.read();
						}
						while(tempchar!=','&&tempchar!='}');
						tempHd.price=t;
						//System.out.println(t);
						if(tempchar==',')
							state=3;
						else
							state=32;
					}
					else
						throw new Exception("parsing error25");
					break;
				//case 26:
				//case 27:
				//case 28:
				//case 29:
				case 30:
					while(tempchar!=','&&tempchar!='}')tempchar=(char)br.read();
					if(tempchar==',')
						state=3;
					else
						state=32;
					break;
				case 31:
					if(tempchar==',')
					{
						state=3;
					}
					else
						throw new Exception("parsing error31");
					break;
				case 32:
					if(tempchar==',')
					{
						state=2;
						if(ts!=0)
						{
							store.add(tempHd);
							//System.out.printf("%s,%s,%d,%d\n",tempHd.locate,tempHd.road,tempHd.tradedate,tempHd.price);
							tempHd=new Housedata();
						}
					}
					else if(tempchar==']')
					{
						state=33;
					}
					else
						throw new Exception("parsing error32");
					break;
				case 33:
					break;
				case 34:
					excep=1;
					ts=0;
					while(excep!=0)
					{
						tempchar=(char)br.read();
						if(tempchar=='{')
							excep++;
						else if(tempchar=='}')
							excep--;
					}
					state=32;
					break;
				}
				while(!br.ready());
			}
			for(int i=0;i<store.size();++i)
				average+=store.elementAt(i).price;
			average=(int)((float)average/store.size());
			System.out.println(average);
			br.close();
		}
		catch(MalformedURLException e)
		{
			System.out.println("open url fail");
		}
		catch (IOException e) 
		{}
		catch (Exception e) 
		{
			System.out.println(e.toString());
		}
	}
}
