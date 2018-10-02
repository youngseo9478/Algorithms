package aa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Pick {
	int distance;
	String shopName;
	int c;

}

public class Main {

	/**
	 * Time complexity: Space complexity:
	 */
	public static void main(String[] args) throws Exception {
		/*
		 * Pick best = new Pick(); best.c=0; best.distance=9999;
		 * best.shopName="";
		 */ try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer tokens = new StringTokenizer(br.readLine().trim());
			int userX = Integer.parseInt(tokens.nextToken());
			int userY = Integer.parseInt(tokens.nextToken());
			userX = (int) Math.floor(userX / 100) * 100;
			userY = (int) Math.floor(userY / 100) * 100;
			int shopCount = Integer.parseInt(tokens.nextToken());
			Pick[] shops;
			shops = new Pick[shopCount];
			for (int i = 0; i < shopCount; i++) {
				tokens = new StringTokenizer(br.readLine().trim());
				int shopX = Integer.parseInt(tokens.nextToken());
				int shopY = Integer.parseInt(tokens.nextToken());
				shopX = (int) Math.floor(shopX / 100) * 100;
				shopY = (int) Math.floor(shopY / 100) * 100;
				String name = tokens.nextToken();
				int coupon = Integer.parseInt(tokens.nextToken());
				shops[i].c = coupon;
				shops[i].distance = (int) (Math.sqrt(Math.pow(userX - shopX, 2) + Math.pow(userY - shopY, 2)));
				shops[i].shopName = name;
			}
			Pick tmp = new Pick();
			ArrayList<Pick> list = new ArrayList<>();
			list.
			for (int i = 0; i < shops.length; i++) {
				if (shops[i].distance > shops[i + 1].distance) {
						tmp.c = shops[i].c;
						tmp.distance = shops[i].distance;
						tmp.shopName = shops[i].shopName;
						shops[i].distance = shops[i + 1].distance;
						shops[i].shopName = shops[i + 1].shopName;
						shops[i].c = shops[i + 1].c;
						shops[i + 1].c = tmp.c;
						shops[i + 1].distance = tmp.distance;
						shops[i + 1].shopName = tmp.shopName;

				} else if(shops[i].distance == shops[i + 1].distance) {
					if (shops[i].c < shops[i + 1].c) {
						tmp.c = shops[i].c;
						tmp.distance = shops[i].distance;
						tmp.shopName = shops[i].shopName;
						shops[i].distance = shops[i + 1].distance;
						shops[i].shopName = shops[i + 1].shopName;
						shops[i].c = shops[i + 1].c;
						shops[i + 1].c = tmp.c;
						shops[i + 1].distance = tmp.distance;
						shops[i + 1].shopName = tmp.shopName;
					} else if (shops[i].c == shops[i + 1].c) {

					}
				}
			}
			
			
		}
	}
}
