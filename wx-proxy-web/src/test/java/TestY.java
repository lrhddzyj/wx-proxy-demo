import com.mind.config.service.WxConfigService;
import com.mind.config.service.WxPayConfigService;
import com.mind.config.vo.WxPayConfigVo;
import com.mind.weixin.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lrh on 2015/12/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TestY {

    @Autowired
    WxPayConfigService wxPayConfigService;

    @Test
    public void test() {
        WxPayConfigVo wxPayConfig = wxPayConfigService.getWxPayConfig("1");
        System.out.println(wxPayConfig.getAppId());

    }
}
