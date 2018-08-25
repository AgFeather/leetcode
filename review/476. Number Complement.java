//Given a positive integer, output its complement number. The complement strategy is to
//flip the bits of its binary representation.




public int findComplement(int num){
    return ~num&((Integer.highestOneBit(num)<<1)-1;
   // highestOneBit会返回参数最高位的数值。
}


//找到最小大于num的位全为1的值，然后做减法
public int findComplement(int num){
    int i=0,j=0;
    while(i<num){
        i+=Math.pow(2,j);
        j++;
    }
    return i-num;
}
