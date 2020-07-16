package leetcode.editor.cn.DP.ZeroOnePack;

class Good{
    int weight;
    int value;
    Good(int w,int v) {
        this.weight=w;
        this.value=v;
    }
    Good(){
        this.weight=0;
        this.value=0;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
