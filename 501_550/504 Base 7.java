//将一个十进制实数转换为7进制（注意正负号）

public String convertToBase7(int num) {
    if (num == 0)
		return "0";
    String res = "";
	int numTemp = Math.abs(num);
	while(numTemp>0){
		int temp = numTemp%7;
		res = res + ("" + temp);
		numTemp /= 7;
	}
	if (num<0) {
		res.append("-");
	}
    return new StringBuffer(res).reverse().toString();
}



//递归方法
public String convertToBase7(int num){
	if (num<0)
		return '-' + convertToBase7(-num);
	if (num<7)
		return num + "";
	return convertToBase7(num/7) + num%7;
}
