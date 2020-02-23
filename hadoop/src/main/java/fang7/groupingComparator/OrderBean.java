package fang7.groupingComparator;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class OrderBean implements WritableComparable<OrderBean> {
    private int id;
    private int amount;

    public OrderBean() {
    }

    public OrderBean(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }


    @Override
    public int compareTo(OrderBean o) {
        if(this.id>o.id){
            return 1;
        }else if(this.id<o.id){
            return -1;
        }else {
            if(this.amount>o.amount){
                return -1;
            }else if(this.amount<o.amount){
                return 1;
            }else{
                return 0;
            }
        }
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(id);
        dataOutput.writeInt(amount);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        id=dataInput.readInt();
        amount=dataInput.readInt();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
