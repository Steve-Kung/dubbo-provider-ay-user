package cn.stevekung.service;

import cn.stevekung.api.AyUserDubboService;
import cn.stevekung.result.CodeMsg;
import cn.stevekung.result.Result;
import cn.stevekung.pojo.AyUser;
import cn.stevekung.repository.AyUserRepository;
import com.alibaba.dubbo.config.annotation.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


@Service(version = "1.0") // 使用@Service暴露服务  使用@Reference引用服务 使用@EnableDubbo开启注解Dubbo功能
public class AyUserServiceImpl implements AyUserDubboService {
    private static final Logger logger = LogManager.getLogger(AyUserServiceImpl.class);

    @Autowired
    AyUserRepository ayUserRepository;

    @Override
    public Result findByUserNameAndPassword(String name, String password) {
        Result result = Result.success();
        try {
            AyUser ayUser = ayUserRepository.findByNameAndPassword(name, password);
            result.setData(ayUser);
        } catch (Exception e) {
            logger.error(this.getClass() + "-findByUserNameAndPassword()-error", e.fillInStackTrace());
            result = Result.error(CodeMsg.SERVER_ERROR);
        }
        return result;
    }
}
