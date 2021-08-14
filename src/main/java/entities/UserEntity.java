package entities;

import entities.base.EntityModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity

public class UserEntity extends EntityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String fullName;

    private String userName;

    private String userPassword;
    @OneToMany(targetEntity = ActivityEntity.class)
    @JoinColumn(name = "user_id")
    private Set<ActivityEntity> userActivities= new HashSet<>();

    public UserEntity() {
    }

    public UserEntity(String fullName, String userName, String userPassword) {
        this.fullName = fullName;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public UserEntity(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(userId, that.userId) && Objects.equals(fullName, that.fullName) && Objects.equals(userName, that.userName) && Objects.equals(userPassword, that.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, fullName, userName, userPassword);
    }

    public Set<ActivityEntity> getUserActivities() {
        return userActivities;
    }

    public void setUserActivities(Set<ActivityEntity> userActivities) {
        this.userActivities = userActivities;
    }
}
