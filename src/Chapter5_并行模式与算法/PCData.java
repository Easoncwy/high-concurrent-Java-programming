package Chapter5_并行模式与算法;

/**
 * Created by eason on 2017/7/1.
 */
public class PCData {
    private final int intData;
    public PCData(int d){
        intData = d;
    }
    public PCData(String d){
        intData = Integer.valueOf(d);
    }

    public int getData(){
        return intData;
    }

    @Override
    public String toString(){
        return "data:" + intData;
    }




}
