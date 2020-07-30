package cn.stevekung.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable{
    private Integer code; // 状态码
    private String msg; // 消息描述
    private T data; // 响应数据

    // error 时 使用
    private Result(CodeMsg codeMsg){
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }

    // success 时 使用
    private Result(CodeMsg codeMsg, T data){
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
        this.data = data;
    }

    // 请求成功时，只给数据即可
    public static <T>Result<T> success(T data){
        return new Result<T>(CodeMsg.SUCCESS, data);
    }
    public static <T>Result<T> success(){
        return new Result<T>(CodeMsg.SUCCESS);
    }


    // 失败时, 传个codeMsg即可 知道错误类型
    public static <T>Result<T> error(CodeMsg codeMsg){
        return new Result<T>(codeMsg);
    }

}
