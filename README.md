项目示例地址：https://github.com/Blankwhiter/schedule

# 一、cron表达式
*在线生成cron表达式：http://cron.qqe2.com/ 读者可根据需要进行选择，得出cron表达式*

Cron表达式是一个字符串，字符串以5或6个空格隔开，分为6或7个域，每一个域代表一个含义，Cron有如下两种语法格式： 
```xml
Seconds Minutes Hours DayofMonth Month DayofWeek Year或 
Seconds Minutes Hours DayofMonth Month DayofWeek
```
*注：corn从左到右（用空格隔开）：秒 分 小时 月份中的日期 月份 星期中的日期 年份*
**字段取值：**
<table border="1" align="left"><caption>&nbsp;</caption>
<tbody>
<tr>
<td>字段</td>
<td>允许值</td>
<td>允许的特殊字符</td>
</tr>
<tr>
<td>秒（Seconds）</td>
<td>0~59的整数</td>
<td>, - * / &nbsp; &nbsp;四个字符</td>
</tr>
<tr>
<td>分（<em id="__mceDel">Minutes</em>）</td>
<td>0~59的整数</td>
<td>, - * / &nbsp; &nbsp;四个字符</td>
</tr>
<tr>
<td>小时（<em id="__mceDel">Hours</em>）</td>
<td>0~23的整数</td>
<td>, - * / &nbsp; &nbsp;四个字符</td>
</tr>
<tr>
<td>日期（<em id="__mceDel">DayofMonth</em>）</td>
<td>1~31的整数（但是你需要考虑你月的天数）</td>
<td>,- * ? / L W C &nbsp; &nbsp; 八个字符</td>
</tr>
<tr>
<td>月份（<em id="__mceDel">Month</em>）</td>
<td>1~12的整数或者 JAN-DEC</td>
<td>, - * / &nbsp; &nbsp;四个字符</td>
</tr>
<tr>
<td>星期（<em id="__mceDel">DayofWeek</em>）</td>
<td>1~7的整数或者 SUN-SAT （1=SUN）</td>
<td>, - * ? / L C # &nbsp; &nbsp; 八个字符</td>
</tr>
<tr>
<td>年(可选，留空)（<em id="__mceDel">Year</em>）</td>
<td>1970~2099</td>
<td>, - * / &nbsp; &nbsp;四个字符</td>
</tr>
</tbody>
</table>
**特殊字符含义：**
- （1）*：表示匹配该域的任意值。假如在Minutes域使用*, 即表示每分钟都会触发事件。

- （2）?：只能用在DayofMonth和DayofWeek两个域。它也匹配域的任意值，但实际不会。因为DayofMonth和DayofWeek会相互影响。例如想在每月的20日触发调度，不管20日到底是星期几，则只能使用如下写法： 13 13 15 20 * ?, 其中最后一位只能用？，而不能使用*，如果使用*表示不管星期几都会触发，实际上并不是这样。

- （3）-：表示范围。例如在Minutes域使用5-20，表示从5分到20分钟每分钟触发一次 

- （4）/：表示起始时间开始触发，然后每隔固定时间触发一次。例如在Minutes域使用5/20,则意味着5分钟触发一次，而25，45等分别触发一次. 

- （5）,：表示列出枚举值。例如：在Minutes域使用5,20，则意味着在5和20分每分钟触发一次。 

- （6）L：表示最后，只能出现在DayofWeek和DayofMonth域。如果在DayofWeek域使用5L,意味着在最后的一个星期四触发。 

- （7）W:表示有效工作日(周一到周五),只能出现在DayofMonth域，系统将在离指定日期的最近的有效工作日触发事件。例如：在 DayofMonth使用5W，如果5日是星期六，则将在最近的工作日：星期五，即4日触发。如果5日是星期天，则在6日(周一)触发；如果5日在星期一到星期五中的一天，则就在5日触发。另外一点，W的最近寻找不会跨过月份 。

- （8）LW:这两个字符可以连用，表示在某个月最后一个工作日，即最后一个星期五。 

- （9）#:用于确定每个月第几个星期几，只能出现在DayofMonth域。例如在4#2，表示某月的第二个星期三。

**常用表达式例子：**

　　（1）0 0 2 1 * ? *   表示在每月的1日的凌晨2点调整任务

　　（2）0 15 10 ? * MON-FRI   表示周一到周五每天上午10:15执行作业

　　（3）0 15 10 ? 6L 2002-2006   表示2002-2006年的每个月的最后一个星期五上午10:15执行作

　　（4）0 0 10,14,16 * * ?   每天上午10点，下午2点，4点 

　　（5）0 0/30 9-17 * * ?   朝九晚五工作时间内每半小时 

　　（6）0 0 12 ? * WED    表示每个星期三中午12点 

　　（7）0 0 12 * * ?   每天中午12点触发 

　　（8）0 15 10 ? * *    每天上午10:15触发 

　　（9）0 15 10 * * ?     每天上午10:15触发 

　　（10）0 15 10 * * ? *    每天上午10:15触发 

　　（11）0 15 10 * * ? 2005    2005年的每天上午10:15触发 

　　（12）0 * 14 * * ?     在每天下午2点到下午2:59期间的每1分钟触发 

　　（13）0 0/5 14 * * ?    在每天下午2点到下午2:55期间的每5分钟触发 

　　（14）0 0/5 14,18 * * ?     在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发 

　　（15）0 0-5 14 * * ?    在每天下午2点到下午2:05期间的每1分钟触发 

　　（16）0 10,44 14 ? 3 WED    每年三月的星期三的下午2:10和2:44触发 

　　（17）0 15 10 ? * MON-FRI    周一至周五的上午10:15触发 

　　（18）0 15 10 15 * ?    每月15日上午10:15触发 

　　（19）0 15 10 L * ?    每月最后一日的上午10:15触发 

　　（20）0 15 10 ? * 6L    每月的最后一个星期五上午10:15触发 

　　（21）0 15 10 ? * 6L 2002-2005   2002年至2005年的每月的最后一个星期五上午10:15触发 

　　（22）0 15 10 ? * 6#3   每月的第三个星期五上午10:15触发

*注：cron表达式主要参考网上资料*


 # 二、springboot集成定时任务
1.在Spring Boot的主类中加入**@EnableScheduling**注解，启用定时任务的配置
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //启动定时任务
public class ScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleApplication.class, args);
    }
}

```
2.在需要做定时任务的方法上使用 **@Scheduled** 注解
```java
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AsyncService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     *  周一至周五 每两秒执行一次任务
     */
    @Scheduled(cron = "*/2 * * * * MON-FRI")
    public void testAsyncJob(){
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}

```
启动项目后，可以看到控制台打印：
```
现在时间：09:31:20
现在时间：09:31:22
现在时间：09:31:24
现在时间：09:31:26
现在时间：09:31:28
现在时间：09:31:30
```
其他cron 请读者根据自行测试。
