public class Stone implements Comparable<Stone> {

    String name;
    String type;
    byte karat;
    float karatCost;
    Float stonePrice;
    String transparency;

    public Stone(String name, String type, byte karat, float karatCost, String transparency) {
        this.name = name;
        this.type = type;
        this.karat = karat;
        this.karatCost = karatCost;
        this.transparency = transparency;

        this.stonePrice = this.karat * this.karatCost;
    }

    public String getName() {
        return name;
    }

    public byte getKarat() {
        return karat;
    }

    public Float getStonePrice() {
        return stonePrice;
    }

    @Override
    public String toString() {
        return "Stone: " + name +
                ", type: " + type +
                ", karat = " + karat +
                ", karatCost = " + karatCost +
                ", stonePrice =" + stonePrice +
                ", transparency: " + transparency + "\n";
    }

    @Override
    public int compareTo(Stone s) {
        return stonePrice.compareTo(s.getStonePrice());
    }
}


