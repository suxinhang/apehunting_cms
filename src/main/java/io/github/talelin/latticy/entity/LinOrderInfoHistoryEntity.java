package io.github.talelin.latticy.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.security.Timestamp;
import java.util.Date;


@Data
@TableName("lin_order_info_history")
public class LinOrderInfoHistoryEntity {

//    private Long id;
    private Integer inviteId;
    private String invite;
    private String orderNo;
    private String userId;
    private Long productId;
    private Integer totalFee;
    private String orderStatus;
    private Integer pointsStatus;
    private Integer commissionRatio;
    private Integer commission;
    private Timestamp createTime;
    private Date updateTime;
    private Integer withdrawalStatus;

    public Integer getInviteId() {
        return inviteId;
    }

    public void setInviteId(Integer inviteId) {
        this.inviteId = inviteId;
    }

    public String getInvite() {
        return invite;
    }

    public void setInvite(String invite) {
        this.invite = invite;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPointsStatus() {
        return pointsStatus;
    }

    public void setPointsStatus(Integer pointsStatus) {
        this.pointsStatus = pointsStatus;
    }

    public Integer getCommissionRatio() {
        return commissionRatio;
    }

    public void setCommissionRatio(Integer commissionRatio) {
        this.commissionRatio = commissionRatio;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getWithdrawalStatus() {
        return withdrawalStatus;
    }

    public void setWithdrawalStatus(Integer withdrawalStatus) {
        this.withdrawalStatus = withdrawalStatus;
    }
}
