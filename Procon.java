import java.io.*;
import java.util.*;

public class Procon
{
		public static void main(String[] args)throws IOException{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			int L;
			int N;
			L = Integer.parseInt(br.readLine());
			N = Integer.parseInt(br.readLine());
			Map<Integer,Integer> map = new HashMap<Integer,Integer>();
			
			int[] arrbuf = new int[N];
			int inputbuf;
			int m = L-2;
			for(int i = 0;i < N;i++){
				inputbuf = Integer.parseInt(br.readLine());
				if(inputbuf > m){
					continue;
				}
				arrbuf[i] = inputbuf;
				map.put(inputbuf,inputbuf);
			}
			
			int cnt = map.size();
			int[] arr = new int[cnt];
			System.arraycopy(arrbuf, 0, arr, 0, cnt);
			
			int pat=0;
			int iend = L/3;
			int jend = L/2;
			int tmp;
			
			for(int i = 0 ; i < cnt && arr[i] < iend ; i++){
				for(int j = i+1 ; j < cnt && arr[j] <= jend ; j++){
					tmp = (L-(arr[i]+arr[j]));
					if(map.containsKey(tmp) && map.get(tmp)  > arr[j]){
						pat++;
					}
				}
			}
			
			System.out.println(pat);
		}
}