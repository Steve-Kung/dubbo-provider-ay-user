package cn.stevekung.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeMsg {
    private Integer code; // 状态码
    private String msg; // 消息描述

    // 通用异常
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    // 登录模块
    // 商品模块
    // 订单模块
    // 秒杀模块
    // 其他模块

}
