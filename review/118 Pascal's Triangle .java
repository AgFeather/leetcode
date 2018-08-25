/*
返回杨辉三角的前n行
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 */

public List<List<Integer>> generate(int numRows){
    List<List<Integer>> res = new ArrayList<>();
    if (numRows == 0) return res;
    List<Integer> temp = new ArrayList<>();
    temp.add(1);
    res.add(temp);
    if (numRows == 1) return res;
    for (int i = 1; i<numRows; i++) {
        temp = new ArrayList<Integer>();
        temp.add(1);
        List<Integer> prev_list = res.get(i-1);
        for (int j = 1;j<i;j++ ) {
            temp.add(prev_list.get(j-1)+prev_list.get(j));
        }
        temp.add(1);
        res.add(temp);
    }
    return res;
}
