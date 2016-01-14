package be.feesboek.managedbeans;

import be.feesboek.models.BirdVO;
import be.feesboek.models.CatVO;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author dimitridw
 */
@Named(value = "equalsBean")
@RequestScoped
public class EqualsBean {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(EqualsBean.class);

    private CatVO cat1;
    private CatVO cat2;
    private CatVO cat3;
    private CatVO cat4;
    private CatVO cat5;

    private BirdVO bird1;
    private BirdVO bird2;
    private BirdVO bird3;
    private BirdVO bird4;
    private BirdVO bird5;
    
    private HashSet hsCats;
    private HashSet hsBirds;

    /**
     * Creates a new instance of EqualsBean
     */
    public EqualsBean() {
    }

    @PostConstruct
    void initialize() {
        //Compare all to the first
        cat1 = new CatVO("Tijger", "gestreept", 1);         // reference cat
        cat2 = new CatVO("Snoepie", "wit", 3);              // other
        cat3 = new CatVO("Tijger", "zwart", 5);             // same name
        cat4 = new CatVO("Tijger", "gestreept", 1);         // All members ar the same
        cat5 = cat1;                                        // reference to the first

        //Compare all to the first
        bird1 = new BirdVO("Duif", null, 1, 5);             // reference bird
        bird2 = new BirdVO("Roodborstje", null, 1, 5);
        bird3 = new BirdVO("Duif", null, 2, 15);
        bird4 = new BirdVO("Duif", null, 1, 5);             // looks simular to the first
        bird5 = bird1;                                      // reference to the first
        
        hsCats = new HashSet();
        hsBirds = new HashSet();
    }

    public Boolean catEquals(CatVO catA, CatVO catB) {
        return catA.equals(catB);
    }

    public int catHashCode(CatVO cat) {
        return cat.hashCode();
    }

    public Boolean birdEquals(BirdVO birdA, BirdVO birdB) {
        return birdA.equals(birdB);
    }

    public int birdHashCode(BirdVO bird) {
        return bird.hashCode();
    }
    
    public void addCats() {
        hsCats.add(cat1);
        hsCats.add(cat2);
        hsCats.add(cat3);
        hsCats.add(cat4);
        hsCats.add(cat5);
        LOGGER.info("Cats {}", hsCats.size());
    }

    public void addBirds() {
        hsBirds.add(bird1);
        hsBirds.add(bird2);
        hsBirds.add(bird3);
        hsBirds.add(bird4);
        hsBirds.add(bird5);
        LOGGER.info("Birds {}", hsBirds.size());
    }
        
    public CatVO getCat1() {
        return cat1;
    }

    public void setCat1(CatVO cat1) {
        this.cat1 = cat1;
    }

    public CatVO getCat2() {
        return cat2;
    }

    public void setCat2(CatVO cat2) {
        this.cat2 = cat2;
    }

    public CatVO getCat3() {
        return cat3;
    }

    public void setCat3(CatVO cat3) {
        this.cat3 = cat3;
    }

    public CatVO getCat4() {
        return cat4;
    }

    public void setCat4(CatVO cat4) {
        this.cat4 = cat4;
    }

    public CatVO getCat5() {
        return cat5;
    }

    public void setCat5(CatVO cat5) {
        this.cat5 = cat5;
    }

    public BirdVO getBird1() {
        return bird1;
    }

    public void setBird1(BirdVO bird1) {
        this.bird1 = bird1;
    }

    public BirdVO getBird2() {
        return bird2;
    }

    public void setBird2(BirdVO bird2) {
        this.bird2 = bird2;
    }

    public BirdVO getBird3() {
        return bird3;
    }

    public void setBird3(BirdVO bird3) {
        this.bird3 = bird3;
    }

    public BirdVO getBird4() {
        return bird4;
    }

    public void setBird4(BirdVO bird4) {
        this.bird4 = bird4;
    }

    public BirdVO getBird5() {
        return bird5;
    }

    public void setBird5(BirdVO bird5) {
        this.bird5 = bird5;
    }

    public HashSet getHsCats() {
        return hsCats;
    }

    public void setHsCats(HashSet hsCats) {
        this.hsCats = hsCats;
    }

    public HashSet getHsBirds() {
        return hsBirds;
    }

    public void setHsBirds(HashSet hsBirds) {
        this.hsBirds = hsBirds;
    }

    
}
