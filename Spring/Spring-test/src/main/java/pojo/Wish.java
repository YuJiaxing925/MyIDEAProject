package pojo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.orm.jpa.JpaDialect;

@Aspect
public class Wish {
    @Before("execution(public void updateEquip(Equip))")
    public void Upgrade(JoinPoint jp){
        //接受参数
        Object[] params = jp.getArgs();
        Equip ring = (Equip) params[0];
        String type = ring.getType();
        if("指环".equals(type)){
            ring.setName("紫色梦幻"+ring.getName());
            ring.setAttackPlus(ring.getAttackPlus()+6);
            ring.setDefencePlus(ring.getDefencePlus()+12);
        }
    }
}
