package io.github.talelin.latticy.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("lin_order_info")
public class SaleEntity {

    private Long id;
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
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer withdrawalStatus;
}
