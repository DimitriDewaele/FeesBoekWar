package be.feesboek.managedbeans;

import be.feesboek.business.user.boundary.UserBoundary;
import be.feesboek.entity.UserEntity;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class QueryBean {
    
    private UserEntity user1;
    private UserEntity user2;
    private UserEntity user3;
    private UserEntity user4;
    private UserEntity user5;
    
    private int count1;
    private int count2;
    private int count3;
    private int count4;
    private int count5;
    
    @Inject
    UserBoundary userBoundary;
    
    @PostConstruct
    public void initialize() {
        user1 = userBoundary.findByUserName("koekoek");
        user2 = userBoundary.findByQueryByUserName("koekoek");
        user3 = userBoundary.findByQueryUserWithMessages().get(0);
        
        count1 = userBoundary.findByQueryUserWithMessages().size();
    }

    /**
     * @return the user1
     */
    public UserEntity getUser1() {
        return user1;
    }

    /**
     * @param user1 the user1 to set
     */
    public void setUser1(UserEntity user1) {
        this.user1 = user1;
    }

    /**
     * @return the user2
     */
    public UserEntity getUser2() {
        return user2;
    }

    /**
     * @param user2 the user2 to set
     */
    public void setUser2(UserEntity user2) {
        this.user2 = user2;
    }

    /**
     * @return the user3
     */
    public UserEntity getUser3() {
        return user3;
    }

    /**
     * @param user3 the user3 to set
     */
    public void setUser3(UserEntity user3) {
        this.user3 = user3;
    }

    /**
     * @return the user4
     */
    public UserEntity getUser4() {
        return user4;
    }

    /**
     * @param user4 the user4 to set
     */
    public void setUser4(UserEntity user4) {
        this.user4 = user4;
    }

    /**
     * @return the user5
     */
    public UserEntity getUser5() {
        return user5;
    }

    /**
     * @param user5 the user5 to set
     */
    public void setUser5(UserEntity user5) {
        this.user5 = user5;
    }
    
    public int getCount1() {
        return count1;
    }

    public void setCount1(int count1) {
        this.count1 = count1;
    }

    public int getCount2() {
        return count2;
    }

    public void setCount2(int count2) {
        this.count2 = count2;
    }

    public int getCount3() {
        return count3;
    }

    public void setCount3(int count3) {
        this.count3 = count3;
    }

    public int getCount4() {
        return count4;
    }

    public void setCount4(int count4) {
        this.count4 = count4;
    }

    public int getCount5() {
        return count5;
    }

    public void setCount5(int count5) {
        this.count5 = count5;
    }
}
