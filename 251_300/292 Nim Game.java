//You are playing the following Nim Game with your friend: 
//There is a heap of stones on the table, each time one
//of you take turns to remove 1 to 3 stones. The one who
//removes the last stone will be the winner. You will
//take the first turn to remove the stones.

//Both of you are very clever and have optimal
//strategies for the game. Write a function to
//determine whether you can win the game given
//the number of stones in the heap.

//For example, if there are 4 stones in the heap,
//then you will never win the game: no matter 1,
//2, or 3 stones you remove, the last stone will
//always be removed by your friend.

//解题思路：最开始发现这个题可以用递归完成，但当输入数据过大时会stackoverflow，后来一直在思考如何把递归转换为循环。忽略了
//题目本身的数学特性--只要是可以被4整除的数都一定false，其它数一定true。
//今后遇到类似可以进行数学归纳的试题，先试着将数据向后推演几步，看看能否发现数学特性
public boolean conWinNim(int n){
  return !(n%4 == 0);
}


//看到了一个成功将递归转换为循环的解决方法！！，在此列出
public boolean canWinNim(int n){
  if(n<0){
    return false;
  }
  boolean[] res = boolean[n+1];
  res[0] = true;
  res[1] = true;
  res[2] = true;
  res[3] = true;
  for(int i = 4;i<n+1;i++){
    res[i] = !(res[i-1]&&res[i-2]&&res[i-3]);
  }
  return res[n];
}
