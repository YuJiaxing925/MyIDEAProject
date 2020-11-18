package pojo;

public class Player {
    private Equip armet;//头盔
    private Equip loricae;//铠甲
    private  Equip boot;//鞋子
    private Equip ring;//指环

    @Override
    public String toString() {
        return "Player{" +
                "armet=" + armet +"\n"+
                ", loricae=" + loricae +"\n"+
                ", boot=" + boot +"\n"+
                ", ring=" + ring +"\n"+
                '}';
    }

    public void updateEquip(Equip equip) {
        if ("头盔".equals(equip.getType())){
            System.out.println(armet.getName()+"升级未"+equip.getName());
            this.armet = equip;
        }

        if ("铠甲".equals(equip.getType())){
            System.out.println(loricae.getName()+"升级未"+equip.getName());
            this.loricae = equip;
        }

        if ("靴子".equals(equip.getType())){
            System.out.println(boot.getName()+"升级未"+equip.getName());
            this.boot = equip;
        }

        if ("指环".equals(equip.getType())){
            System.out.println(ring.getName()+"升级未"+equip.getName());
            this.ring = equip;
        }

    }

    public Equip getArmet() {
        return armet;
    }

    public void setArmet(Equip armet) {
        this.armet = armet;
    }

    public Equip getLoricae() {
        return loricae;
    }

    public void setLoricae(Equip loricae) {
        this.loricae = loricae;
    }

    public Equip getBoot() {
        return boot;
    }

    public void setBoot(Equip boot) {
        this.boot = boot;
    }

    public Equip getRing() {
        return ring;
    }

    public void setRing(Equip ring) {
        this.ring = ring;
    }

    public Player() {
    }

    public Player(Equip armet, Equip loricae, Equip boot, Equip ring) {
        this.armet = armet;
        this.loricae = loricae;
        this.boot = boot;
        this.ring = ring;
    }
}
