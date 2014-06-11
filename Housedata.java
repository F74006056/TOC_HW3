
public class Housedata {
	public int check(int com,String in)
	{
		switch(com)
		{
		case 33554432:
			if(in.equals("鄉鎮市區"))
				return 4;
		break;
		case 16777216:
			if(in.equals("交易標的"))
				return 5;
		break;
		case 8388608:
			if(in.equals("土地區段位置或建物區門牌"))
				return 6;
		break;
		case 4194304:
			if(in.equals("土地移轉總面積平方公尺"))
				return 7;
		break;
		case 2097152:
			if(in.equals("都市土地使用分區"))
				return 8;
		break;
		case 1048576:
			if(in.equals("非都市土地使用分區"))
				return 9;
		break;
		case 524288:
			if(in.equals("非都市土地使用編定"))
				return 10;
		break;
		case 262144:
			if(in.equals("交易年月"))
				return 11;
		break;
		case 131072:
			if(in.equals("交易筆棟數"))
				return 12;
		break;
		case 65536:
			if(in.equals("移轉層次"))
				return 13;
		break;
		case 32768:
			if(in.equals("總樓層數"))
				return 14;
		break;
		case 16384:
			if(in.equals("建物型態"))
				return 15;
		break;
		case 8172:
			if(in.equals("主要用途"))
				return 16;
		break;
		case 4096:
			if(in.equals("主要建材"))
				return 17;
		break;
		case 2048:
			if(in.equals("建築完成年月"))
				return 18;
		break;
		case 1024:
			if(in.equals("建物移轉總面積平方公尺"))
				return 19;
		break;
		case 512:
			if(in.equals("建物現況格局-房"))
				return 20;
		break;
		case 256:
			if(in.equals("建物現況格局-廳"))
				return 21;
		break;
		case 128:
			if(in.equals("建物現況格局-衛"))
				return 22;
		break;
		case 64:
			if(in.equals("建物現況格局-隔間"))
				return 23;
		break;
		case 32:
			if(in.equals("有無管理組織"))
				return 24;
		break;
		case 16:
			if(in.equals("總價元"))
				return 25;
		break;
		case 8:
			if(in.equals("單價每平方公尺"))
				return 26;
		break;
		case 4:
			if(in.equals("車位類別"))
				return 27;
		break;
		case 2:
			if(in.equals("車位移轉總面積平方公尺"))
				return 28;
		break;
		case 1:
			if(in.equals("車位總價元"))
				return 29;
		break;
		}
		System.out.println(in);
		return -1;
	}
	public String locate;//鄉鎮市區
	public String usage;//交易標的
	public String road;//土地區段位置或建物區門牌
	public float area;//土地移轉總面積平方公尺
	public String cityuse;//都市土地使用分區
	public String nocityuse;//非都市土地使用分區
	public String nocityschedule;//非都市土地使用編定
	public int tradedate;//交易年月
	public String soldnum;//交易筆棟數
	public String tradefloor;//移轉層次
	public String totalfloor;//總樓層數
	public String buildtype;//建物型態
	public String mainusage;//主要用途
	public String material;//主要建材
	public int builddate;//建築完成年月
	public int tradearea;//建物移轉總面積平方公尺
	public int room;//建物現況格局-房
	public int hall;//建物現況格局-廳
	public int methodist;//建物現況格局-衛
	public String divide;//建物現況格局-隔間
	public String manager;//有無管理組織
	public int price;//總價元
	public float priceperarea;//單價每平方公尺
	public String cartype;//車位類別
	public float cararea;//車位移轉總面積平方公尺
	public int carprice;//車位總價元
}
