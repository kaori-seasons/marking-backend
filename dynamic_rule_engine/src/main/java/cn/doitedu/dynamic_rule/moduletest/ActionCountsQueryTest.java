package cn.doitedu.dynamic_rule.moduletest;

import cn.doitedu.dynamic_rule.pojo.LogBean;
import cn.doitedu.dynamic_rule.pojo.RuleAtomicParam;
import cn.doitedu.dynamic_rule.service.UserActionCountQueryServiceStateImpl;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 行为次数查询服务功能测试
 */
public class ActionCountsQueryTest {
    public static void main(String[] args) {


        UserActionCountQueryServiceStateImpl service = new UserActionCountQueryServiceStateImpl(null);

        // 构造几个明细事件
        LogBean logBean1 = new LogBean();
        logBean1.setEventId("000010");
        HashMap<String, String> props1 = new HashMap<>();
        props1.put("p1","v1");
        logBean1.setProperties(props1);


        LogBean logBean2 = new LogBean();
        logBean2.setEventId("000010");
        HashMap<String, String> props2 = new HashMap<>();
        props2.put("p1","v2");
        logBean2.setProperties(props2);


        LogBean logBean3 = new LogBean();
        logBean3.setEventId("000020");
        HashMap<String, String> props3 = new HashMap<>();
        props3.put("p2","v3");
        logBean3.setProperties(props3);


        LogBean logBean4 = new LogBean();
        logBean4.setEventId("000020");
        HashMap<String, String> props4 = new HashMap<>();
        props4.put("p2","v3");
        props4.put("p3","v4");
        logBean4.setProperties(props4);


        ArrayList<LogBean> eventList = new ArrayList<>();
        eventList.add(logBean1);
        eventList.add(logBean2);
        eventList.add(logBean3);
        eventList.add(logBean4);


        // 构造2个规则原子条件
        RuleAtomicParam param1 = new RuleAtomicParam();
        param1.setEventId("000010");
        HashMap<String, String> paramProps1 = new HashMap<>();
        paramProps1.put("p1","v1");
        param1.setProperties(paramProps1);
        param1.setCnt(2);

        RuleAtomicParam param2 = new RuleAtomicParam();
        param2.setEventId("000020");
        HashMap<String, String> paramProps2 = new HashMap<>();
        paramProps2.put("p2","v3");
        param2.setProperties(paramProps2);
        param2.setCnt(2);

        ArrayList<RuleAtomicParam> ruleParams = new ArrayList<>();
        ruleParams.add(param1);
        ruleParams.add(param2);

        service.queryActionCountsHelper(eventList,ruleParams);

        for (RuleAtomicParam ruleParam : ruleParams) {
            System.out.println(ruleParam.getEventId()+","+ruleParam.getCnt() + "," + ruleParam.getRealCnt());
        }


    }
}
