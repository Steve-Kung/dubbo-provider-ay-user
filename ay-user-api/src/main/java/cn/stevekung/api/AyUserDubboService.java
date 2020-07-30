package cn.stevekung.api;


import cn.stevekung.result.Result;

public interface AyUserDubboService {
    Result findByUserNameAndPassword(String name, String password);
}
