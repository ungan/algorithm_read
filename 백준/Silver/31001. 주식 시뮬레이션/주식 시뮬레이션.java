import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {
	static class company
	{
		int group;
		String name;
		Long price;
		
		company(int group, String name, Long price)
		{
			this.group = group;
			this.name = name;
			this.price = price;
		}
	}
	
	static HashMap<String, company> hash_company = new HashMap<>();
	static HashMap<String, Long> juju_company = new HashMap<>();
	static List<company> companys[] = new ArrayList[101];
	static Long money;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		money = Long.parseLong(st.nextToken());
		Long t= Long.parseLong(st.nextToken());
		
		
		for(int i=0; i<101; i++)
		{
			companys[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			int group = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			Long price = Long.parseLong(st.nextToken());
			
			company c = new company(group, name, price);
			
			hash_company.put(name, c);
			companys[group].add(c);
		}
		
		for(int T=0; T<t; T++)
		{
			//System.out.println("t : " + T);
			input();
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	static void input() throws IOException
	{
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =Integer.parseInt(st.nextToken());
		
		String name;
		Long count;
		int id;
		Long change;
		Long percent;
		
		switch(n)
		{
		case 1:
			name = st.nextToken();
			count =Long.parseLong(st.nextToken());
			buy(name,count);
			break;
			
		case 2:
			name = st.nextToken();
			count =Long.parseLong(st.nextToken());
			sell(name,count);
			break;
			
		case 3:
			name = st.nextToken();
			change =Long.parseLong(st.nextToken());
			price_change(name,change);
			break;
			
		case 4:
			id = Integer.parseInt(st.nextToken());
			change =Long.parseLong(st.nextToken());
			price_changeGroup(id,change);
			break;
			
		case 5:
			id = Integer.parseInt(st.nextToken());
			percent =Long.parseLong(st.nextToken());
			percent_changeGroup(id,percent);
			break;
			
		case 6:
			cur_money();
			break;
			
		case 7:
			cur_Assets_all();
			break;
			
		}
	}
	
	static void buy(String name, Long count) {
	    company c = hash_company.get(name);
	    if(c == null) return; // 안전 장치 (사실 입력 상 항상 존재)

	    Long totalPrice = c.price * count;
	    if(totalPrice <= money) {
	        money -= totalPrice;
	        juju_company.put(name, juju_company.getOrDefault(name, (long) 0) + count);
	    }
	}

	static void sell(String name, Long count) {
	    company c = hash_company.get(name);
	    if(c == null) return; // 안전 장치

	    Long stocks = juju_company.getOrDefault(name, 0L);
	    
	    if (stocks == 0L) return; // 보유 수량이 없으면 매도할 수 없음
	    
	    Long sellCount;
	    
	    // 실제 팔 수 있는 수량 결정 (요청 수량 vs 보유 수량)
	    if (stocks <= count) { 
	        sellCount = stocks; // 전부 판매
	    } else { 
	        sellCount = count; // 요청 수량만큼 판매
	    }
	    
	    // 금액 정산
	    money += sellCount * c.price;
	    
	    // 보유 주식 수량 업데이트
	    Long remainingStocks = stocks - sellCount;
	    
	    if (remainingStocks == 0L) {
	        juju_company.remove(name); // 0이 되면 맵에서 제거 (메모리 효율)
	    } else {
	        juju_company.put(name, remainingStocks); // 남은 수량 업데이트
	    }
	}

	static void cur_Assets_all() throws IOException {
	    // 주식 가치 합계는 Long 범위를 초과할 수 있으므로 Long을 사용해야 합니다.
	    Long totalStockValue = 0L; 
	    
	    for(Entry<String, Long> entry : juju_company.entrySet()) {
	        String name = entry.getKey();
	        Long cnt = entry.getValue();
	        company c = hash_company.get(name);
	        
	        if(c != null && cnt > 0) { 
	            // 주식 가치 = 주식 수량 * 현재 가격
	            // Long * Long = Long (오버플로우 방지를 위해 Long 사용)
	            totalStockValue += c.price * cnt;
	        }
	    }
	    // 현금과 주식 가치의 합계 출력
	    bw.write(Long.toString(money + totalStockValue)+ "\n");
	}
	
	static void price_change(String name, Long change)
	{
		company c = hash_company.get(name);
		c.price += change;
		
	}
	
	static void price_changeGroup(int id, Long change)
	{
		for(company c : companys[id])
		{
			c.price += change;
		}
	}
	
	static void percent_changeGroup(int id, Long percent)
	{
		for(company c : companys[id])
		{
			c.price = (long) (c.price + (c.price*1.0/100*percent))/10*10;
		}
	}
	
	static void cur_money() throws IOException
	{
		bw.write(Long.toString(money) + "\n");
	}
}
