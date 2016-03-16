import com.mind.weixin.pay.Application;
import com.mind.weixin.pay.service.TestServiceImpl;
import com.mind.weixin.pay.service.WxPaymentServiceImpl;
import com.mind.weixin.pay.vo.SendRedPackVo;
import com.mind.weixin.pay.vo.TradeVo;
import com.mind.weixin.pay.vo.Transaction;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by lrh on 2015/12/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TestU {


    @Autowired
    TestServiceImpl testService;

    @Autowired
    WxPaymentServiceImpl wxPaymentService;

    @Test
    public void  test() throws InterruptedException {
//        System.out.println("###############");
//        SendRedPackVo sendRedPackVo = new SendRedPackVo();
//        sendRedPackVo.setCompanyId("1");
//        sendRedPackVo.setWishing("恭喜发财");
//        sendRedPackVo.setTotalAmount(100*300);
//        sendRedPackVo.setActName("测试发红包");
//        sendRedPackVo.setAppId("wxceb458b73fd40711");
//        sendRedPackVo.setBusinessId(StringUtils.remove(UUID.randomUUID().toString(), "-"));
//        sendRedPackVo.setOpenId("oCbiiv-TyKmFjhTLRETk8D49HyRs");
//        sendRedPackVo.setAppCode("activty");
//        sendRedPackVo.setRemark("测试发红包");
//
//        Transaction transaction = wxPaymentService.sendRedPack(sendRedPackVo);
//        System.out.println("######################");
//        System.out.println("######################");
//        System.out.println("######################");
//        System.out.println("######################");
//        System.out.println("######################");

        List<SendRedPackVo> morePack = createMorePack(25);
        System.out.println("#########发放红包开始#############");
        int i =0;
        long s =8;
        for (SendRedPackVo sendPack : morePack) {
            i++;
            System.out.println("发送第一个红包");
            Transaction transaction = wxPaymentService.sendRedPack(sendPack);

            System.out.println("红包金额:"+sendPack.getTotalAmount());
            System.out.println("第"+i+"个红包发放成功,休息一下");
            System.out.println("-------------------------------------------");

          //  s = s * i;
            Thread.sleep(1000*s);

            System.out.println("休息" +s+"秒完毕");

        }
        System.out.println("#########红包发送完毕#############");



//        TradeVo tradeVo = new TradeVo();
//        tradeVo.setAppCode("hd");
//        tradeVo.setTradeType("JSAPI");
//        tradeVo.setShopId("1");
//        tradeVo.setOpenId("oCbiiv-TyKmFjhTLRETk8D49HyRs");
//        tradeVo.setTotalFee(110);
//        tradeVo.setBody("测试商品");
//        tradeVo.setBusinessSystemId(StringUtils.remove(UUID.randomUUID().toString(), "-").substring(0,31));
//        Transaction unifiedorder = wxPaymentService.unifiedorder(tradeVo);
//
//        System.out.println(unifiedorder.getPrepayId());

    }

    private List<SendRedPackVo> createMorePack(int num) {
        int m = 5;
        List<SendRedPackVo> reds =new ArrayList<SendRedPackVo>();
        int k = num;
        while (k != 0) {
            SendRedPackVo sendRedPackVo = new SendRedPackVo();
            sendRedPackVo.setCompanyId("1");
            sendRedPackVo.setWishing("恭喜发财");
            sendRedPackVo.setActName("测试发红包");
            sendRedPackVo.setAppId("wxceb458b73fd40711");
            sendRedPackVo.setBusinessId(StringUtils.remove(UUID.randomUUID().toString(), "-"));
            sendRedPackVo.setOpenId("oCbiiv-TyKmFjhTLRETk8D49HyRs");
            sendRedPackVo.setAppCode("activty");
            sendRedPackVo.setRemark("测试发红包");

            if (k > m) {
                sendRedPackVo.setTotalAmount(100 * m);
                k = k - m;
            } else {
                sendRedPackVo.setTotalAmount(100*k);
                k = 0;
            }
            reds.add(sendRedPackVo);
        }
        return reds;
    }


}















