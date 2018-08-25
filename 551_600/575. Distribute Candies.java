//Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.

//将糖果映射到map中，统计一共有多少种糖果，以及每种糖果个数，
//如果糖果个数的一半仍然大于糖果总数，则返回糖果种类数
//否则则返回糖果总数的一半
 public int distributeCandies(int[] candies) {
        Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < candies.length; i++) {
			if (map.get(candies[i])==null) {
				map.put(candies[i], 1);
			}
			else {
				map.put(candies[i], map.get(candies[i])+1);
			}
		}
		int y = map.keySet().size();
		int x = candies.length;
		if ((x/2)>y||(x/2)==y) {
			
			return y;
		}
		else
			return x/2;
    }


//他人优化方案：使用Set代替Map，因为我们只需要统计糖果种类，并不需要统计每种糖果的个数
for(int candy:candies) set.add(candy)
